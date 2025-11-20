package empleado;

import java.util.Scanner;
import menus.MenuAdmin;
import menus.MenuMedico;
import menus.MenuRecepcionista;

public class Login {

    public static void login() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu contraseña: ");
        String contrasenia = scanner.nextLine();

        switch (contrasenia) {
            case "A7D8M9":
                System.out.println("Bienvenido Administrador");
                MenuAdmin menuadm = new MenuAdmin();
                menuadm.mostrarMenu();
                break;

            case "M1E2D3":
                System.out.println("Bienvenido Medico");
                MenuMedico medmen = new MenuMedico();
                medmen.mostrarMenu();
                break;

            case "R4E5C6":
                System.out.println("Bienvenido Recepcionista");
                MenuRecepcionista recmen = new MenuRecepcionista();
                recmen.mostrarMenu();
                break;

            default:
                System.out.println("Contraseña incorrecta");
                break;
        }
        scanner.close();
    }
}