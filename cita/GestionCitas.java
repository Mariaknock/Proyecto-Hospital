package cita;

import java.time.LocalTime;
import java.util.Scanner;
import crud.CRUD;

public class GestionCitas implements CRUD
{
    private Scanner scanner;
    private Agenda agenda;

    public GestionCitas()
    {
        this.scanner=new Scanner(System.in);
        this.agenda=new Agenda();
    }


    @Override
    public void crearInstancia(){
        String nombrePaciente;
        int dia;
        int mes;
        int año;
        int horas;
        int minutos;
        double precio;

        System.out.println("\n=== CREAR NUEVA CITA ===");
        System.out.print("Ingrese el nombre del paciente: ");
        nombrePaciente = scanner.nextLine();
        System.out.println("---FECHA DE LA CITA---");
        System.out.print("Día (1-31): ");
        dia = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Mes (1-12): ");
        mes = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Año (ej: 2024): ");
        año = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Hora (0-23): ");
        horas = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Minutos (0-59): ");
        minutos = scanner.nextInt();
        scanner.nextLine(); 
        
        Fechamex fecha = new Fechamex(dia, mes, año, 0, 0);
        LocalTime hora= LocalTime.of(horas, minutos);
    
        System.out.print("Ingresa el precio de la cita:");
        precio = scanner.nextDouble();
        scanner.nextLine(); 

        Cita nuevaCita= new Cita(nombrePaciente, fecha, hora, precio);
        agenda.agregarCita(nuevaCita);
    }


    @Override
    public void verElementos(){
        System.out.println("\n===CITAS===");
        for (Cita cita : agenda.getAgenda()) {
            System.out.println(cita);
        }
    }

    @Override
    public void modificarInstancia(){}
    @Override
    public void eliminarInstancia(){}
}