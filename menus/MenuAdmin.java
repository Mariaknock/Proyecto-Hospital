package menus;

import java.util.ArrayList;
import java.util.Scanner;

import empleado.Empleado;
import empleado.GestorEmpleado;
import empleado.Medico;
import empleado.Recepcionista;
import habitacion.GestorHabitacion;

public class MenuAdmin {
    private ArrayList<Empleado> listaEmpleados;
    Scanner scanner= new Scanner(System.in);
    int opcion;


    public void mostrarMenu(){
        GestorEmpleado.cargarDesdeArchivo();

        listaEmpleados = GestorEmpleado.getListaEmpleados();
        System.out.println("Viendo ahora: Menu de administrador ");
        System.out.println("¡Bienvenido! ¿Que opcion deseas realizar hoy?");
       
        do{
            System.out.println("1) Registrar nuevo empleado");
            System.out.println("2) Listar empleados");
            System.out.println("3) Ver estaditicas de habitaciones");
            System.out.println("4) Cerrar Sesion");

            try {
                opcion = scanner.nextInt();
                switch(opcion){

                    case 1:
                        registrarEmpleado();
                        break;
                    case 2:
                        listarEmpleados();
                        break;
                    case 3:
                        GestorHabitacion.cargarDesdeArchivo();
                        GestorHabitacion.mostrarEstadisticas();
                        break;
                    case 4:
                        System.out.println("Cerrando la sesion de administrador");
                        break;
                    default:
                        System.out.println("Opcion no valida, otra vez");
                        break;
                }
                
                
            } catch (NumberFormatException e) {
                System.out.println("No ingresaste un numero, intenta otra vez");
            }


        }while(opcion!=4);
    }

    private void registrarEmpleado() {
        System.out.println("Ingresa los datos que se solicitan");
        try {
            System.out.println("ID: ");
            int id = scanner.nextInt();
            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.println("Area: ");
            String area = scanner.nextLine();
            System.out.println("Turno: ");
            String turno = scanner.nextLine(); 

            System.out.println("Selecciona Cargo:");
            System.out.println("1) Medico");
            System.out.println("2) Recepcionista");
            int tipo = scanner.nextInt();

            Empleado nuevo;

            switch (tipo) {
                case 1: 
                    Medico m = new Medico(id, nombre, apellido, area, turno);
                    System.out.print("Cedula: "); 
                    String cedula= scanner.nextLine();
                    m.setCedula(cedula);
                    System.out.print("Especialidad: ");
                    String especialidad=scanner.nextLine();
                    m.setEspecialidad(especialidad);
                    System.out.print("Consultorio: "); 
                    int consultorio=scanner.nextInt();
                    m.setConsultorio(consultorio);
                    nuevo = m;
                    break;
                case 2:
                    nuevo = new Recepcionista(id, nombre, apellido, area, turno);
                    break;
                default:
                    System.out.println("Cargo inexistente");
                    return;
            }

            if (nuevo != null) {
                listaEmpleados.add(nuevo);
                System.out.println("Empleado registrado");
            }

        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar un numero");
        }
    }



    private void listarEmpleados() {

        if (listaEmpleados.isEmpty()) {
            System.out.println("Sin registro de empleados");
        }

        for (Empleado empleado : listaEmpleados) {
            empleado.mostrarInformacion();
        }
    }



    
}
