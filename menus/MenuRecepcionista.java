package menus;

import java.util.Scanner;

public class MenuRecepcionista {

    Scanner scanner= new Scanner(System.in);
    int opcion;

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
                switch(opcion){

                    case 1:
                        //consultarexpediente();
                        break;
                    case 2:
                        //asignartratamiento();
                        break;
                    case 3:
                        //pedirmedicamentos();
                        break;
                    case 4:
                        //ocupacionhabitaciones();
                        break;
                    case 5:
                        System.out.println("Cerrando la sesion de Recepcionista");
                        break;
                    default:
                        System.out.println("Opcion no valida, otra vez");
                }
                
                
            } catch (NumberFormatException e) {
                System.out.println("No ingresaste un numero, intenta de nuevo");
            }


        }while(opcion!=5);
    }
    
    
    
}
