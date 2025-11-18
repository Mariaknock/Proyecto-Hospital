package menus;

import java.util.InputMismatchException;
import java.util.Scanner;
import cita.Agenda;
import paciente.GestorPaciente;
import habitacion.GestorHabitacion;


public class MenuRecepcionista {

    Scanner scanner= new Scanner(System.in);
    int opcion;
    private Agenda agenda=new Agenda();

    public void mostrarMenu(){

        System.out.println("Viendo ahora: Menu de Recepcionista ");
        System.out.println("¡Bienvenido! ¿Que opcion deseas realizar hoy?");
       
        do{
            System.out.println("1) Registrar paciente");
            System.out.println("2) Agendar cita");
            System.out.println("3) Ver citas existentes");
            System.out.println("4) Administrar ocupacion de habitaciones");
            System.out.println("5) Cerrar Sesion");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch(opcion){

                    case 1:
                        GestorPaciente.registrarPaciente(scanner);
                        break;
                    case 2:
                        agenda.crearInstancia(GestorPaciente.getPacientes());
                        break;
                    case 3:
                        agenda.verElementos();
                        break;
                    case 4:
                        GestorHabitacion.mostrarEstadisticas();
                        break;
                    case 5:
                        System.out.println("Cerrando la sesion de Recepcionista");
                        break;
                    default:
                        System.out.println("Opcion no valida, otra vez");
                }
                
                
            } catch (NumberFormatException e) {
                System.out.println("No ingresaste un numero, intenta de nuevo");
                scanner.nextLine();
                opcion=0;
            }


        }while(opcion!=5);

        System.out.println("Adios :D");
        scanner.close();
    }
    
    
    
}
