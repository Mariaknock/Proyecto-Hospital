package cita;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import paciente.Paciente;

public class Agenda

{
    private Scanner scanner;
    private ArrayList<Cita> agenda;
    private ArrayList<Paciente> pacientes; 




    public Agenda(ArrayList<Paciente> pacientes) {
        this.scanner = new Scanner(System.in);
        this.agenda = new ArrayList<Cita>();
        this.pacientes = pacientes; 
        inicializarContadorCitas(pacientes);
        cargarCitasDesdePacientes(pacientes);
    }

    public ArrayList<Cita> getCitas()
    {
        return agenda;
    }

    public void guardarCambios() {
    try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(
            new java.io.FileOutputStream("pacientes.dat"))) {
        
        oos.writeObject(pacientes);
        System.out.println("Cambios guardados automáticamente");
        
    } catch (java.io.IOException e) {
        System.err.println("Error al guardar: " + e.getMessage());
    }
    }

    public void cargarCitasDesdePacientes(ArrayList<Paciente> pacientes) {
        System.out.println("=== CARGANDO CITAS EN AGENDA ===");
    
        for (Paciente paciente : pacientes) {
            for (Cita cita : paciente.getCitasPaciente()) {
                agenda.add(cita);
            }
        }
        
        System.out.println("Citas cargadas en agenda: " + agenda.size());
    }

    public void crearCita(ArrayList<Paciente> pacientes){
        int dia;
        int mes;
        int año;
        int horas;
        int minutos;
        double precio;
        int idPaciente;

        try{

            System.out.println("Ingrese el ID del paciente");
            idPaciente=scanner.nextInt();
            scanner.nextLine();

            if(idPaciente<0)
            {
                throw new ConfiguracionInvalida("El ID del paciente no puede ser un numero negativo");
            }

            Paciente pacienteEncontrado = buscarPacientePorID(idPaciente, pacientes);

            if (pacienteEncontrado == null) {
                throw new ConfiguracionInvalida("No se encontro un paciente con ID: " + idPaciente);
            }

            System.out.println("El paciente es " +pacienteEncontrado.getNombre());
            System.out.println("Favor de llenar los campos de la nueva cita");

            System.out.println("---FECHA DE LA CITA---");
            System.out.print("Dia (1-31): ");
            dia = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Mes (1-12): ");
            mes = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Año (ej: 2025): ");
            año = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Hora (0-23): ");
            horas = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Minutos (0-59): ");
            minutos = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Ingresa el precio de la cita:");
            precio = scanner.nextDouble();
            scanner.nextLine();

            if (dia<1 || dia>31){
                throw new ConfiguracionInvalida("Favor de ingresar dias entre 1-31");
            }

            if (mes<1 || mes>12 )
            {
                throw new ConfiguracionInvalida("Favor de ingresar meses entre 1-12");

            }
            
            if (año<2025|| año>2100)
            {
                throw new ConfiguracionInvalida("Favor de ingresar años entre 2025-2100");
            }

            if(horas<0 || horas>23 )
            {
                throw new ConfiguracionInvalida("Favor de ingresar horas entre 0-23");
            }

            if(minutos<0 || minutos>59)
            {
                throw new ConfiguracionInvalida("Favor de ingresar minutos entre 0-59");
            }

            if (precio<0)
            {
                throw new ConfiguracionInvalida("Los precios no pueden ser negativos");

            }

            Fechamex fecha = new Fechamex(dia, mes, año);
            LocalTime hora= LocalTime.of(horas, minutos);
            Cita nuevaCita= new Cita(pacienteEncontrado.getNombre(), fecha, hora, precio,idPaciente);

            //agregar a la agenda
            agenda.add(nuevaCita);
            //agregar al paciente
            pacienteEncontrado.agregarCitaPaciente(nuevaCita);
            System.out.println("Cita de "+ pacienteEncontrado.getNombre() + " Agregada exitosamente");
            guardarCambios();


        }catch(ConfiguracionInvalida e)
        {
            System.out.println("Error de configuracion."+ e.getMessage());
            System.out.println("No se pudo crear la cita");
        }catch(InputMismatchException e2)
        {
            System.out.println("Error de usuario, no se permiten agregar letras en los campos numericos");
            scanner.nextLine();
        }
    
    }


    public void verCitas(){
        System.out.println("\n===CITAS===");
        for (Cita cita : agenda) {
            System.out.println(cita);
        }
    }

    public void actualizarCita(ArrayList<Paciente> pacientes){
            String nombrePaciente;
            int dia;
            int mes;
            int año;
            int horas;
            int minutos;
            double precio;
            int idPaciente;
        try{

            System.out.println("Ingrese el ID del paciente para actualizar su cita");
            idPaciente=scanner.nextInt();
            scanner.nextLine();

            if(idPaciente<0)
            {
                throw new ConfiguracionInvalida("El ID del paciente no puede ser un numero negativo");
            }

            Paciente pacienteEncontrado = buscarPacientePorID(idPaciente, pacientes);

            if (pacienteEncontrado == null) {
                throw new ConfiguracionInvalida("No se encontro un paciente con ID: " + idPaciente);
            }

            //Si no tienes citas por actualizar
            if (pacienteEncontrado.getCitasPaciente().isEmpty())
            {
                throw new ConfiguracionInvalida("El paciente aun no tiene citas");
            }

            //mostrar citas actuales
            mostrarCitasDePaciente(pacienteEncontrado);

            int idCita;
            System.out.println("Ingrese el ID de la cita a modificar");
            idCita=scanner.nextInt();
            scanner.nextLine();

            Cita modificacionCita = buscarCitadePacientePorID(idCita, pacienteEncontrado);
    
            if (modificacionCita == null) {
                throw new ConfiguracionInvalida("No se encontro cita con ID: " + idCita);
            }
             

            System.out.println("\n¿Qué campo deseas modificar?");
            System.out.println("1. Nombre del paciente");
            System.out.println("2. Fecha de la cita");
            System.out.println("3. Hora de la cita");
            System.out.println("4. Precio de la cita");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo nombre del paciente: ");
                    nombrePaciente = scanner.nextLine().trim();
                    if (nombrePaciente.isEmpty()) {
                        throw new ConfiguracionInvalida("El nombre no puede estar vacío");
                    }
                    modificacionCita.setNombrePaciente(nombrePaciente);
                    System.out.println("Nombre actualizado correctamente");
                    guardarCambios();
                    break;
                    
                case 2:
                    System.out.println("--- NUEVA FECHA DE LA CITA ---");
                    System.out.print("Día (1-31): ");
                    dia = scanner.nextInt();
                    System.out.print("Mes (1-12): ");
                    mes = scanner.nextInt();
                    System.out.print("Año (ej: 2024): ");
                    año = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (dia < 1 || dia > 31) {
                        throw new ConfiguracionInvalida("Día debe estar entre 1-31");
                    }
                    if (mes < 1 || mes > 12) {
                        throw new ConfiguracionInvalida("Mes debe estar entre 1-12");
                    }
                    if (año < 2024 || año > 2100) {
                        throw new ConfiguracionInvalida("Año debe estar entre 2024-2100");
                    }

                    Fechamex nuevaFecha= new Fechamex(dia, mes, año);
                    modificacionCita.setFecha(nuevaFecha);
                    System.out.println("Fecha actualizada correctamente");
                    guardarCambios();
                    break;
                    
                case 3:
                    System.out.println("--- NUEVA HORA DE LA CITA ---");
                    System.out.print("Hora (0-23): ");
                    horas = scanner.nextInt();
                    System.out.print("Minutos (0-59): ");
                    minutos = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (horas < 0 || horas > 23) {
                        throw new ConfiguracionInvalida("Hora debe estar entre 0-23");
                    }
                    if (minutos < 0 || minutos > 59) {
                        throw new ConfiguracionInvalida("Minutos deben estar entre 0-59");
                    }
                    LocalTime nuevaHora=LocalTime.of(horas, minutos);
                    modificacionCita.setHora(nuevaHora);
                    System.out.println("Hora actualizada correctamente");
                    guardarCambios(); 
                    break;
                    
                case 4:
                    System.out.print("Nuevo precio de la cita: ");
                    precio = scanner.nextDouble();
                    scanner.nextLine();
                    
                    if (precio < 0) {
                        throw new ConfiguracionInvalida("El precio no puede ser negativo");
                    }
                    modificacionCita.setPrecio(precio);
                    System.out.println("Precio actualizado correctamente");
                    guardarCambios();
                    break;
                    
                default:
                    throw new ConfiguracionInvalida("Opción no válida. Selecciona 1-4");
            }
        }catch(ConfiguracionInvalida e)
        {
            System.out.println("Error de configuracion."+ e.getMessage());
            System.out.println("No se pudo actualizar la cita");
        }catch(InputMismatchException e2)
        {
            System.out.println("Error de usuario, no se permiten agregar letras en los campos numericos");
            scanner.nextLine();
        }
    }

    public void eliminarCita(ArrayList<Paciente> pacientes){
        try{

            int idPaciente;
            System.out.println("Ingrese el ID del paciente para eliminar su cita");
            idPaciente=scanner.nextInt();
            scanner.nextLine();

            if(idPaciente<0)
            {
                throw new ConfiguracionInvalida("El ID del paciente no puede ser un numero negativo");
            }

            Paciente pacienteEncontrado = buscarPacientePorID(idPaciente, pacientes);

            if (pacienteEncontrado == null) {
                throw new ConfiguracionInvalida("No se encontró un paciente con ID: " + idPaciente);
            }

            //Si no tienes citas por eliminar
            if (pacienteEncontrado.getCitasPaciente().isEmpty())
            {
                throw new ConfiguracionInvalida("El paciente aun no tiene citas");
            }

            //mostrar citas actuales
            mostrarCitasDePaciente(pacienteEncontrado);

            int idCita;
            System.out.println("Ingrese el ID de la cita a eliminar");
            idCita=scanner.nextInt();
            scanner.nextLine();

            Cita citaEliminada = buscarCitadePacientePorID(idCita, pacienteEncontrado);

            if (citaEliminada == null) {
                throw new ConfiguracionInvalida("No se encontro cita con ID: " + idCita);
            }

           pacienteEncontrado.eliminarCitaPaciente(citaEliminada);
           boolean eliminadaDeAgenda = agenda.remove(citaEliminada);
        
            if (eliminadaDeAgenda) {
                System.out.println("Cita eliminada exitosamente de la agenda");
            } else {
                System.out.println("Cita eliminada del paciente pero no encontrada en agenda");
            }

            guardarCambios();

        }catch(ConfiguracionInvalida e)
        {
            System.out.println("Error de configuracion."+ e.getMessage());
            System.out.println("No se pudo eliminar la cita");
        }catch(InputMismatchException e2)
        {
            System.out.println("Error de usuario, no se permiten agregar letras en los campos numericos");
            scanner.nextLine();
        }

    }


    public Cita buscarCitaPorNombre(String nombrePaciente) {
        if (agenda.isEmpty()) {
            System.out.println("Agenda vacía");
            return null;
        } else {
            for (Cita cita : agenda) {
                if (cita.getNombrePaciente().equals(nombrePaciente)) {
                    System.out.println("Cita de " + cita.getNombrePaciente() + " encontrada exitosamente");
                    return cita;
                }
            }
            System.out.println("Cita no encontrada");
            return null;
        }
    }

    public Paciente buscarPacientePorID(int idPaciente, ArrayList<Paciente> pacientes)
    {
            for (Paciente paciente : pacientes) {
                if (paciente.getId() ==idPaciente) {
                    return paciente;
                }
            }

            return null;
        
    }

    public void mostrarCitasDePaciente(Paciente paciente)
    {
        for (Cita cita : paciente.getCitasPaciente()) {
            System.out.println(cita);
        }
    }

    public Cita buscarCitadePacientePorID(int idCita,Paciente paciente)
    {
        for (Cita cita : paciente.getCitasPaciente()) {
                if (cita.getIdCita() ==idCita) {
                    return cita;
                }
            }
        return null;
    }

    public void inicializarContadorCitas(ArrayList<Paciente> pacientes) {
        int maxId = 0;        
        for (Paciente paciente : pacientes) {
            for (Cita cita : paciente.getCitasPaciente()) {
                if (cita.getIdCita() > maxId) {
                    maxId = cita.getIdCita();
                }
            }
        }
        if (maxId > 0) {
            Cita.setContador(maxId + 1);
        } else {
            System.out.println("No hay citas existentes, contador en: " + Cita.getContador());
        }
    }
    
    
}






       