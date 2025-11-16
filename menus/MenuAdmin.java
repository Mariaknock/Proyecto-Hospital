package menus;

import java.util.Scanner;

public class MenuAdmin {
    Scanner scanner= new Scanner(System.in);
    int opcion;


    public void mostrarMenu(){
        System.out.println("Viendo ahora: Menu de administrador ");
        System.out.println("¡Bienvenido! ¿Que opcion deseas realizar hoy?");
       
        do{
            System.out.println("1) Registrar nuevo empleado");
            System.out.println("2) Eliminar empleados");
            System.out.println("3) Ver reportes existentes");
            System.out.println("4) Cerrar Sesion");

            try {
                opcion = scanner.nextInt();
                switch(opcion){

                    case 1:
                        //registrarempleados();
                        break;
                    case 2:
                        //eliminarempleado();
                        break;
                    case 3:
                        //verreportes();
                        break;
                    case 4:
                        System.out.println("Cerrando la sesion de administrador");
                        break;
                    default:
                        System.out.println("Opcion no valida, otra vez");
                }
                
                
            } catch (NumberFormatException e) {
                System.out.println("No ingresaste un numero, intenta de nuevo");
            }


        }while(opcion!=4);
    }
    
}
