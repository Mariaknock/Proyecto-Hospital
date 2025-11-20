package menus;

import java.util.Scanner;
import java.util.ArrayList;
import paciente.Paciente;
import cita.*;

public class MenuGestionCitas {
    private Agenda agenda;
    private ArrayList<Paciente> pacientes;
    private Scanner scanner;
    
    public MenuGestionCitas(ArrayList<Paciente> pacientes) {
        this.agenda = new Agenda(pacientes);
        this.pacientes = pacientes;
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarMenuPrincipal() {
        int opcion;
        
        do {
            System.out.println("\n=== SISTEMA DE GESTION DE CITAS ===");
            System.out.println("1. Crear nueva cita");
            System.out.println("2. Ver todas las citas");
            System.out.println("3. Actualizar cita");
            System.out.println("4. Eliminar cita");
            System.out.println("5. Buscar cita por nombre");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opcion: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        crearCita();
                        break;
                    case 2:
                        verCitas();
                        break;
                    case 3:
                        actualizarCita();
                        break;
                    case 4:
                        eliminarCita();
                        break;
                    case 5:
                        buscarCitaPorNombre();
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion no valida. Por favor selecciona 1-6.");
                }
                
            } catch (Exception e) {
                System.out.println("Error: Debes ingresar un numero valido.");
                scanner.nextLine();
                opcion = 0;
            }
            
        } while (opcion != 6);
    }
    
    private void crearCita() {
        System.out.println("\n--- CREAR NUEVA CITA ---");
        
        if (pacientes == null || pacientes.isEmpty()) {
            System.out.println("Error: No hay pacientes registrados en el sistema.");
            System.out.println("Por favor, registre pacientes primero.");
            return;
        }
        
        agenda.crearCita(pacientes);
    }
    
    private void verCitas() {
        System.out.println("\n--- LISTA DE TODAS LAS CITAS ---");
        agenda.verCitas();
    }
    
    private void actualizarCita() {
        System.out.println("\n--- ACTUALIZAR CITA EXISTENTE ---");
        
        if (pacientes == null || pacientes.isEmpty()) {
            System.out.println("Error: No hay pacientes registrados en el sistema.");
            return;
        }
        
        agenda.actualizarCita(pacientes);
    }
    
    private void eliminarCita() {
        System.out.println("\n--- ELIMINAR CITA ---");
        
        if (pacientes == null || pacientes.isEmpty()) {
            System.out.println("Error: No hay pacientes registrados en el sistema.");
            return;
        }
        
        agenda.eliminarCita(pacientes);
    }
    
    private void buscarCitaPorNombre() {
        System.out.println("\n--- BUSCAR CITA POR NOMBRE ---");
        
        if (pacientes == null || pacientes.isEmpty()) {
            System.out.println("Error: No hay pacientes registrados en el sistema.");
            return;
        }
        
        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();
        
        if (nombrePaciente == null || nombrePaciente.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }
        
        Cita citaEncontrada = agenda.buscarCitaPorNombre(nombrePaciente);
        
        if (citaEncontrada != null) {
            System.out.println("Cita encontrada exitosamente:");
            System.out.println(citaEncontrada);
        
        }
        
    }
    
}
