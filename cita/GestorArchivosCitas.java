package cita;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.time.LocalTime;
import java.util.ArrayList;

import paciente.Paciente;

public class GestorArchivosCitas {

    public static ArrayList<Paciente> leerPacientes(String nombreArchivo) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        
        try (ObjectInputStream ois = new ObjectInputStream(
             new FileInputStream(nombreArchivo))) {
            
            pacientes = (ArrayList<Paciente>) ois.readObject();
            System.out.println("Pacientes leidos: " + pacientes.size());
            
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
        
        for (Paciente paciente : pacientes) {
            crearCitaParaPaciente(paciente);
        }
        
    }
    
    private static void crearCitaParaPaciente(Paciente paciente) {
        try {
            int dia = 10;
            int mes = 12;               
            int año = 2025;
            int horas = 9;
            int minutos = 0;
            double precio = 500.0;
            
            Fechamex fecha = new Fechamex(dia, mes, año);
            LocalTime hora = LocalTime.of(horas, minutos);
            
            Cita nuevaCita = new Cita(paciente.getNombre(), fecha, hora, precio, paciente.getId());
            
            paciente.agregarCitaPaciente(nuevaCita);
            
            
        } catch (Exception e) {
            System.out.println("Error creando cita ");
        }
    }
    
}