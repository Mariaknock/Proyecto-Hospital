package menus;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import cita.GestorArchivosCitas;
import paciente.GestorPaciente;
import habitacion.GestorHabitacion; 
import paciente.Paciente;


public class MenuRecepcionista {

    Scanner scanner= new Scanner(System.in);
    int opcion;

    public void mostrarMenu(){

        GestorPaciente.cargarDesdeArchivo();
        GestorHabitacion.cargarDesdeArchivo();

        System.out.println("\n Viendo ahora: Menu de Recepcionista ");
        System.out.println("¡Bienvenido! ¿Que opcion deseas realizar hoy?");
       
        do{
            System.out.println("1) Registrar paciente");
            System.out.println("2) Gestionar citas");
            System.out.println("3) Cerrar Sesion");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch(opcion){

                    case 1:
                        GestorPaciente.registrarPaciente(scanner);
                        break;
                    case 2:
                        ArrayList<Paciente> pacientes = GestorArchivosCitas.leerPacientes("pacientes.dat");
                        GestorArchivosCitas.crearCitasAutomaticas(pacientes);
                        MenuGestionCitas menuGestionCitas= new MenuGestionCitas(pacientes);
                        menuGestionCitas.mostrarMenuPrincipal();
                        break;
                    case 3:
                        System.out.println("Cerrando la sesion de Recepcionista");
                        break;
                    default:
                        System.out.println("Opcion no valida, otra vez");
                }
                
                
            } catch (InputMismatchException e) {
                System.out.println("No ingresaste un numero, intenta de nuevo");
                scanner.nextLine();
                opcion=0;
            }


        }while(opcion!=3);

        System.out.println("Adios :D");
        scanner.close();
    }
    
    
    
}
