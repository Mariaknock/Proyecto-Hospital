package empleado;

import java.util.InputMismatchException;
import java.util.Scanner;
import menus.MenuAdmin;
import menus.MenuMedico;
import menus.MenuRecepcionista;
public class Login{

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        int opcionMenu = 0; 

        do {
            System.out.println("\n=====================================");
            System.out.println("  SISTEMA DE GESTIÓN HOSPITALARIA");
            System.out.println("=====================================");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Salir del Sistema");
            System.out.print("Seleccione una opción: ");
            try{
                opcionMenu = scanner.nextInt();
                scanner.nextLine();
            } catch(InputMismatchException exe)
            {
                System.out.println("Opción no válida. Por favor, ingrese 1 o 2.");
            }
            switch (opcionMenu) {
                case 1:
                    System.out.println("\n--- INICIO DE SESIÓN ---");
                    System.out.print("Introduce tu contraseña (Admin:A7D8M9 / Medico:M1E2D3 / Recep:R4E5C6): ");
                    System.out.println("(contraseñas visibles para el profe)");
                    String contrasenia = scanner.nextLine();

                    switch (contrasenia) {
                        case "A7D8M9":
                            System.out.println("\nAcceso concedido. Bienvenido Administrador.\n");
                            MenuAdmin menuadm = new MenuAdmin();
                            menuadm.mostrarMenu();
                            break;

                        case "M1E2D3":
                            System.out.println("\nAcceso concedido. Bienvenido Medico.\n");
                            MenuMedico medmen = new MenuMedico();
                            medmen.mostrarMenu();
                            break;

                        case "R4E5C6":
                            System.out.println("\nAcceso concedido. Bienvenido Recepcionista.\n");
                            MenuRecepcionista recmen = new MenuRecepcionista();
                            recmen.mostrarMenu();
                            break;

                        default:
                            System.out.println("\nContraseña incorrecta. Intente de nuevo.");
                            break;
                    }
                    break; 

                case 2:
                    System.out.println("\nGracias por usar el Sistema de Gestion Hospitalaria.Hasta pronto");
                    break;

                default:
                    System.out.println("\nOpción no válida. Por favor, ingrese 1 o 2.");
                    break;
            }

        } while (opcionMenu != 2);
        
        scanner.close();
    }
}