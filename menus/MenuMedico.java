package menus;

import java.util.InputMismatchException;
import java.util.Scanner;
import inventario.GestorInventario; 
import paciente.GestorPaciente; 
import paciente.Paciente;


public class MenuMedico {

    Scanner scanner= new Scanner(System.in);
    int opcion;
    private MenuGestionPaciente submenu = new MenuGestionPaciente();



    public void mostrarMenu(){
        GestorPaciente.cargarDesdeArchivo();
        GestorInventario.cargarDesdeArchivo();


        System.out.println("Viendo ahora: Menu de Medico ");
        System.out.println("¡Bienvenido! ¿Que opcion deseas realizar hoy?");
       
        do{
            System.out.println("1) Atender al paciente (Expediente y Tratamientos)");
            System.out.println("2) Ver lista de pacientes");
            System.out.println("3) Consultar medicamentos");
            System.out.println("4) Cerrar Sesion");

            try {
                opcion = scanner.nextInt();

                switch(opcion){

                    case 1:
                        GestorPaciente.consultarExpediente(scanner);
                        break;
                    case 2:
                        verListaPacientes();
                        break;
                    case 3:
                        GestorInventario.verInventario();
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
    
    
    private void verListaPacientes() {

        if (GestorPaciente.getPacientes().isEmpty()) {
            System.out.println("No hay pacientes");
        } else {
            for (Paciente p : GestorPaciente.getPacientes()) {
    
                System.out.println("ID: " + p.getId() + " Nombre: " + p.getNombre());
            }
        }
    }
    

    private void seleccionarYAtenderPaciente() {
        
        Paciente pacienteEncontrado=null;
        System.out.print("Ingrese el ID del paciente: ");
        try {
            int id = scanner.nextInt();
            for (Paciente p : GestorPaciente.getPacientes()) {
                if (p.getId() == id) {
                    pacienteEncontrado = p;
                    break;
                }
            }
            if (pacienteEncontrado != null) {
                System.out.println("Paciente encontrado: " + pacienteEncontrado.getNombre());
                submenu.mostrarSubMenu(pacienteEncontrado);
                
            } else {
                System.out.println("No hay ningun paciente con el ID utilizado");
            }

        } catch (InputMismatchException e) {
            System.out.println("El ID es un numero");
        }
    }
    
    
}
