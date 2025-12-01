package menus;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import inventario.GestorInventario;
import paciente.GestorPaciente;
import paciente.Paciente;
import paciente.Tratamiento;


public class MenuGestionPaciente {

    Scanner scanner= new Scanner(System.in); 

    public void mostrarSubMenu(Paciente pacienteRecibido) {
        Paciente paciente=pacienteRecibido;

        int opcion = 0;
        do {
            System.out.println("\nEstas viendo al paciente  " + paciente.getNombre() + " con ID: " + paciente.getId() );
            System.out.println("1) Ver expediente");
            System.out.println("2) Añadir alergia");
            System.out.println("3) Ver tratamientos");
            System.out.println("4) Iniciar tratamiento");
            System.out.println("5) Volver al menu principal ");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println(paciente.getExpedienteMedico().toString());
                        break;
                    case 2:
                        System.out.print("Escriba la alergia a registrar: ");
                        String alergia = scanner.nextLine();
                        paciente.getExpedienteMedico().agregarAlergia(alergia);
                        GestorPaciente.guardarEnArchivo(); 
                        System.out.println("Hecho :D");
                        break;
                    case 3:
                        verTratamientos(paciente);
                        break;
                    case 4:
                        iniciarTratamiento(paciente);
                        break;
                    case 5:
                        System.out.println("Volviendooo");
                        break;
                    default:
                        System.out.println("Opcion no valida, escoge otra");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error, no es un numero ");
                scanner.nextLine();
            }
        } while (opcion != 5);
    }

    private void iniciarTratamiento(Paciente paciente) {

        System.out.print("\nIngrese el diagnostico: ");
        String diagnostico = scanner.nextLine();

        Tratamiento nuevoTratamiento = new Tratamiento(diagnostico, LocalDate.now());
        paciente.agregarTratamiento(nuevoTratamiento);
        System.out.println("Tratamiento iniciado");

        System.out.print("¿Desea prescribir medicamentos ahora? ");
        System.out.print("Teclea 1 para si y 2 para no");

        int resp = scanner.nextInt();
        scanner.nextLine();
        if (resp==1) {
            System.out.println("¿Que medicamento desea recetar?");
            GestorInventario.verInventario();
            String medPreescrito=scanner.nextLine();
            GestorInventario.prescribirMedicamento(medPreescrito, nuevoTratamiento); 
        }
        
        GestorPaciente.guardarEnArchivo(); 
        System.out.println("Tratamiento guardado en el expediente");
    }
    
    private void verTratamientos(Paciente paciente){

        for(Tratamiento tratamiento : paciente.getTratamientos()){
            System.out.println(tratamiento);
        }
    }
}