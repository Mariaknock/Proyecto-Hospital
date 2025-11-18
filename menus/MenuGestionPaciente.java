package menus;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import inventario.GestorInventario;
import inventario.Inventario;
import inventario.Medicamento;
import paciente.GestorPaciente;
import paciente.Paciente;
import paciente.Tratamiento;


public class MenuGestionPaciente {

    Scanner scanner= new Scanner(System.in); 

    public void mostrarSubMenu(Paciente paciente) {
        int opcion = 0;
        do {
            System.out.println("Estas viendo al paciente  " + paciente.getNombre() + " con ID: " + paciente.getId() );
            System.out.println("1) Ver expediente");
            System.out.println("2) Añadir alergia");
            System.out.println("3) Ver tratamientos");
            System.out.println("4. Iniciar tratamiento");
            System.out.println("5. Volver al menu principal ");
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

    private void verTratamientos(Paciente paciente) {

        if (paciente.getTratamientos().isEmpty()) {
            System.out.println("El paciente no tiene tratamientos registrados");
            return;
        }
        for (Tratamiento t : paciente.getTratamientos()) {

            System.out.println("Diagnostico: " + t.getDiagnostico());
            System.out.println("Fecha de inicio: " + t.getFechaDeInicio());
            System.out.println("Estado: " + t.getEstado());
            System.out.println("Medicamentos recetados:");
            if (t.getMedicamentosPrescritos().isEmpty()) {
                System.out.println(" No hay medicamentos recetados");
            } else {
                for (Medicamento m : t.getMedicamentosPrescritos()) {
                    System.out.println(m.getNombre());
                }
            }
        }
    }


    private void iniciarTratamiento(Paciente paciente) {

        System.out.print("Ingrese el diagnostico: ");
        String diagnostico = scanner.nextLine();

        Tratamiento nuevoTratamiento = new Tratamiento(diagnostico, LocalDate.now());
        paciente.agregarTratamiento(nuevoTratamiento);
        System.out.println("Tratamiento iniciado");

        System.out.print("¿Desea prescribir medicamentos ahora? ");
        System.out.print("Teclea 1 para si y 2 para no");

        int resp = scanner.nextInt();
        if (resp==1) {
            gestionarMedicamentos(nuevoTratamiento); 
        }
        
        GestorPaciente.guardarEnArchivo(); 
        System.out.println("Tratamiento guardado en el expediente");
    }

    private void gestionarMedicamentos(Tratamiento tratamiento) {
        String nombreMed;
        Inventario inventario = GestorInventario.getInventario();

        do {
            verInventario(); 
            System.out.print("Escriba el nombre exacto del medicamento: ");
            nombreMed = scanner.nextLine();

            Medicamento medEncontrado = null;
            for (Medicamento m : inventario.getCatalogoDeMedicamentos()) {
                if (m.getNombre().equals(nombreMed)) {
                    medEncontrado = m;
                    break;
                }
            }

            if (medEncontrado != null) {
                if (inventario.verificarStock(medEncontrado) > 0) {
                    tratamiento.agregarMedicamento(medEncontrado);
                    inventario.despacharMedicamento(medEncontrado, 1);
                    GestorInventario.guardarEnArchivo();
                    System.out.println(medEncontrado.getNombre() + " agregado al tratamiento");
                } else {
                    System.out.println("No hay stock de " + medEncontrado.getNombre());
                }
            } else {
                System.out.println("Medicamento no encontrado en el inventario");
                break;
            }
        } while (true);
        
    }


    private void verInventario() {
        Inventario inventario = GestorInventario.getInventario();

        if (inventario.getCatalogoDeMedicamentos().isEmpty()) {
            System.out.println("El inventario esta vacio");
            return;
        }

        for (Medicamento m : inventario.getCatalogoDeMedicamentos()) {
            int cantidad = inventario.verificarStock(m);
            System.out.println(m.getNombre() + " Stock de: " + cantidad);
        }
    }
}