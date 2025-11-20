package empleado;

import java.util.ArrayList;
import java.util.Scanner;

import menus.MenuMedico;

public class Login {
    
    private static ArrayList<Empleado> empleados;

    public static Empleado iniciarSesion(String nombre, int contrasena) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombre) && 
                empleado.getContrasena().equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso");
                System.out.println("Bienvenido, " + empleado.getArea() + " " + empleado.getNombre() );
                return empleado;
            }
        }
        
        System.out.println("Nombre o contraseña incorrectos");
        return null;
    }

    public static void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduce tu contraseña: ");
        String contrasenia = scanner.nextLine();
        
        
        Empleado empleado = iniciarSesion(nombre, contrasenia);

        switch (empleado.getArea()) {
            case "medico":
                MenuMedico medmen = new MenuMedico();
                medmen.mostrarMenu();
                break;
            case "recepcionista":
                
                break;
            case "admin":
            default:
                break;
        }
    } 
}
