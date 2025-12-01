package cita;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import paciente.*;

public class GestorArchivosCitas {

    public static ArrayList<Paciente> leerPacientes(String nombreArchivo) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        
        try (ObjectInputStream ois = new ObjectInputStream(
             new FileInputStream(nombreArchivo))) {
            
            pacientes = (ArrayList<Paciente>) ois.readObject();
            
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + nombreArchivo);
        } catch (EOFException e) {
            System.out.println("Fin del archivo alcanzado");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return pacientes;
    }

   
    public static void crearCitasAutomaticas(ArrayList<Paciente> pacientes) {
    Set<String> fechasHorasUsadas = new HashSet<>();
    Random random = new Random();
    int pacientesProcesados = 0;
    int citasCreadas = 0;
    
    for (Paciente paciente : pacientes) {
        if (paciente.getCitasPaciente().isEmpty() && pacientesProcesados < 20) {
            crearCitaParaPaciente(paciente, fechasHorasUsadas, random);
            pacientesProcesados++;
            citasCreadas++;
        }
    }
    
    System.out.println("Se crearon " + citasCreadas + " citas para " + pacientesProcesados + " pacientes sin citas");
    
    if (citasCreadas > 0) {
        // Guardar la lista modificada directamente
        guardarPacientesEnArchivo(pacientes, "pacientes.dat");
        }
    }

    private static void guardarPacientesEnArchivo(ArrayList<Paciente> pacientes, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(archivo))) {
            
            oos.writeObject(pacientes);
            System.out.println(pacientes.size() + " pacientes guardados en " + archivo);
            
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    private static void crearCitaParaPaciente(Paciente paciente, Set<String> fechasHorasUsadas, Random random) {
        try {
            int maxIntentos = 100; 
            int intentos = 0;
            
            while (intentos < maxIntentos) {
                int dia = 10 + random.nextInt(21); 
                int mes = 12;
                int año = 2025;
                
                int horas = 9 + random.nextInt(8); 
                int minutos = random.nextInt(4) * 15; 
                
                String claveUnica = dia + "-" + mes + "-" + año + "-" + horas + "-" + minutos;
                
                if (!fechasHorasUsadas.contains(claveUnica)) {
                    fechasHorasUsadas.add(claveUnica);
                    
                    Fechamex fecha = new Fechamex(dia, mes, año);
                    LocalTime hora = LocalTime.of(horas, minutos);
                    double precio = 400.0 + (random.nextDouble() * 400.0);
                    
                    Cita nuevaCita = new Cita(paciente.getNombre(), fecha, hora, precio, paciente.getId());
                    paciente.agregarCitaPaciente(nuevaCita);
                    break;
                }
                
                intentos++;
            }
            
            if (intentos == maxIntentos) {
                System.out.println("No se pudo crear cita unica para " + paciente.getNombre());
            }
            
        } catch (Exception e) {
            System.out.println("Error creando cita para " + paciente.getNombre());
        }
    }
    
}