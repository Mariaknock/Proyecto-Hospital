package paciente;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorPaciente {
    private static String archivoBinario = "pacientes.dat";
    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    

    public static ArrayList<Paciente> getPacientes(){
        return pacientes;
    }

    public static ArrayList<Paciente> generarPacientes(){
        String[] nombres = {
            "Mariano Millán Luna", "Jose Manuel Meneses Zempoaltecatl", "Gabriel Salais Serrano",
            "Ana Martínez Pérez", "Carlos López Ramírez", "Guadalupe García Sánchez",
            "Miguel Pérez González", "Sofía Díaz Cruz", "Francisco Morales Reyes",
            "Isabel Vargas Mendoza", "Antonio Silva Ortega", "Carmen Ruiz Flores",
            "Jesús Castro Romero", "Patricia Herrera Medina", "Manuel Torres Ríos", 
            "Laura Mendoza Vargas", "Roberto Ortega Jiménez", "Elena Navarro Solís",
            "Fernando Delgado Campos", "Adriana Vega Guerrero"
        };

        String[] vacunas = {
            "Hepatitis B", "BCG", "Pentavalente acelular",
            "Rotavirus", "Neumococo conjugada", "Influenza estacional",
            "SRP", "DTP", "VPH", "Fiebre amarilla"
        };

        String[] enfermedadesPrevias = {
            "Hipertensión arterial", "Diabetes mellitus tipo 2", "Asma bronquial",
            "Artritis reumatoide", "Epilepsia controlada", "Anemia ferropénica",
            "Gastritis crónica", "Hipotiroidismo", "Migraña crónica", "Colecistitis aguda"
        };

        String[] enfermedadesHeredables = {
            "Diabetes mellitus tipo 2", "Hipertensión arterial esencial", "Cáncer de mama",
            "Enfermedad cardiovascular", "Alzheimer de inicio tardío", "Glaucoma primario",
            "Osteoporosis", "Esquizofrenia", "Depresión mayor", "Artritis reumatoide"
        };

        String[] alergias = {
            "Penicilina", "Aspirina", "Sulfas", "Mariscos",
            "Maní", "Látex", "Polen de ambrosía", "Ácaros del polvo",
            "Huevo", "Picadura de abeja"
        };

        String[] medicamentosPrescritos = {
            "Metformina 850 mg", "Losartán 50 mg", "Atorvastatina 20 mg",
            "Omeprazol 20 mg", "Levotiroxina 50 mcg", "Salbutamol inhalador",
            "Paracetamol 500 mg", "Ibuprofeno 400 mg", "Clonazepam 0.5 mg",
            "Insulina glargina"
        };

        for (int i = 0; i < nombres.length; i++){
            Paciente paciente = new PacienteBuilder(i + 1, nombres[i])
                .edad(12 + (int)(Math.random() * 93))  
                .altura(1.0 + Math.random())
                .peso(50 + (Math.random() * 50))
                .build();
            
            pacientes.add(paciente);
        }

        rellenarExpediente(pacientes, vacunas, enfermedadesPrevias, medicamentosPrescritos, enfermedadesHeredables, alergias);
        
        return pacientes;
    }

    public static void rellenarExpediente(ArrayList<Paciente> pacientes, String[] vacunas, String[] previas, String[] medicamentos, String[] heredables, String[] alergias){
        for(Paciente paciente : pacientes){
            int contador = (int)(Math.random()*10);
            for(int i= 0; i< contador; i++){
                double probabilidad = Math.random();
                if (probabilidad >= 0.3){
                    paciente.getExpedienteMedico().agregarVacuna(vacunas[i]);
                }
                if (probabilidad >= 0.6){
                    paciente.getExpedienteMedico().agregarEnfermedad(previas[i]);
                    paciente.getExpedienteMedico().agregarMedicamento(medicamentos[i]);
                }
                if (probabilidad >= 0.7){
                    paciente.getExpedienteMedico().agregarAntecedente(heredables[i]);
                }
                if (probabilidad >= 0.8){
                    paciente.getExpedienteMedico().agregarAlergia(alergias[i]);
                }
            }
        }
    }

    public static void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(archivoBinario))) {
            
            oos.writeObject(pacientes);
            System.out.println(pacientes.size() + " pacientes guardados ");
            
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Paciente> cargarDesdeArchivo() {
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(archivoBinario))) {
            
            pacientes = (ArrayList<Paciente>) ois.readObject();
            System.out.println(pacientes.size() + " pacientes cargados");
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar: " + e.getMessage());
            pacientes = new ArrayList<>();
            generarPacientes();
            guardarEnArchivo();
        }
        
        return pacientes;
    }

    /* 
    public static void main(String[] args) {
        System.out.println("=== GENERANDO Y GUARDANDO PACIENTES ===");
        pacientes = cargarDesdeArchivo();
        for(Paciente paciente : pacientes){
            System.out.println(paciente);
            System.out.println(paciente.getExpedienteMedico());
            System.out.println();

        }
    }
    */
    

    public static void registrarPaciente(Scanner scanner){

      try {

        System.out.println("Ingresa el nombre del paciente: ");
        String nombre=scanner.nextLine();
        scanner.nextLine();
        System.out.println("Ingresa la edad: ");
        int edad=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingresa la altura (en metros): ");
        double altura=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese el peso (en kg): ");
        double peso=scanner.nextDouble(); 
        scanner.nextLine();

        int nuevoid;
        int maxId=0;
        if(!pacientes.isEmpty()){
            for (Paciente p: pacientes){
                if(p.getId()> maxId){
                    maxId=p.getId();
                }
            }
        }
        nuevoid=maxId+1;
        
        Paciente nuevoPaciente = new PacienteBuilder(nuevoid, nombre).edad(edad).altura(altura).peso(peso).build();
        pacientes.add(nuevoPaciente);
        guardarEnArchivo();
        System.out.println("Paciente registrado");
        System.out.println(nuevoPaciente.toString());
        System.out.println("Total de pacientes: " + pacientes.size());

      }catch(InputMismatchException e){
        System.out.println("Ingresa un numero que sea valido");
        scanner.nextLine();
      }catch (IllegalArgumentException e){
        System.out.println("Error en los datos, hazlo de nuevo");
      }
    }

    public static Paciente getPacienteEspecifico(int id){
        if (id <= 0) {
            System.out.println("El id no es válido");
            return null;
        } else {
            return pacientes.get(id-1);
        }
    }

    public static void eliminarPaciente(int id)
    {
        Paciente pacienteEliminar=pacientes.get(id-1);
        System.out.println("Paciente "+ pacienteEliminar.getNombre()+" eliminado");
        pacientes.remove(pacienteEliminar);
        guardarEnArchivo();

    }
}

