package menus;

import java.util.InputMismatchException;
import java.util.Scanner;
import inventario.GestorInventario; 
import inventario.Inventario;
import inventario.Medicamento;
import paciente.GestorPaciente; 
import paciente.Paciente;


public class MenuMedico {

    Scanner scanner= new Scanner(System.in);
    int opcion;



    public void mostrarMenu(){
        GestorPaciente.cargarDesdeArchivo();
        GestorInventario.cargarDesdeArchivo();


        System.out.println("Viendo ahora: Menu de Medico ");
        System.out.println("¡Bienvenido! ¿Que opcion deseas realizar hoy?");
       
        do{
            System.out.println("1) Consultar expediente de los pacientes");
            System.out.println("2) Pedir medicamentos");
            System.out.println("3) Cerrar Sesion");

            try {
                opcion = scanner.nextInt();
                switch(opcion){

                    case 1:
                        GestorPaciente.consultarExpediente(scanner);
                        break;
                    case 2:
                        //pedirmedicamentos();
                        break;
                    case 3:
                        System.out.println("Cerrando la sesion de Medico");
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
