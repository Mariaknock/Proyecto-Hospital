package empleado;

import java.util.ArrayList;
import java.util.Scanner;
import menus.MenuAdmin;

import menus.MenuMedico;
import menus.MenuRecepcionista;

public class Login {
    
    private static ArrayList<Empleado> empleados;

    public static Empleado iniciarSesion(String nombre, String contrasena) {

        
        for (Empleado empleado : empleados) {
            if (empleado.getContrasena().equals(contrasena)) {
                System.out.println("Inicio de sesion aprobado");
                System.out.println("Bienvenido  " + empleado.getArea() + " " + empleado.getNombre() );
                return empleado;
            }
        }
        
        System.out.println("Contraseña incorrecta");
        return null;
    }

    public static void login(){

        GestorEmpleado.verEmpleados();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduce tu contraseña: ");
        String contrasenia = scanner.nextLine();
        
        
        Empleado empleado = iniciarSesion(nombre, contrasenia);

        if(empleado!=null){
            switch (contrasenia) {
                case "M1E2D3":
                    MenuMedico medmen = new MenuMedico();
                    medmen.mostrarMenu();
                    break;
                case "R4E5C6":
                    MenuRecepcionista recmen= new MenuRecepcionista();
                    recmen.mostrarMenu();
                    break;
                case "A7D8M9":
                    MenuAdmin menuadm= new MenuAdmin();
                    menuadm.mostrarMenu();
                default:
                    System.out.println("Ocurrio un error, hazlo de nuevo");
                    break;
            }
        }
    }
}
