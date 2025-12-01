package empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GestorEmpleado {
    
    private static String archivoBinario = "empleados.dat";
    private static ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    private static String[] nombres = {"Juan", "Maria", "Pedro", "Lucia", "Carlos", "Ana", "Luis", "Sofia"};
    private static String[] apellidos = {"Perez", "Gomez", "Rodriguez", "Lopez", "Diaz", "Martinez", "Hernandez"};
    private static String[] especialidades = {"Cardiologia", "Pediatria", "General", "Neurologia", "Dermatologia"};
    private static String[] turnos = {"Matutino", "Vespertino", "Nocturno"};

    public static ArrayList<Empleado> getListaEmpleados(){
        return listaEmpleados;
    }

    public static ArrayList<Empleado> generarEmpleados() {
        Random random = new Random();

        for (int i = 100; i <= 104; i++) {

            String nombre = nombres[random.nextInt(nombres.length)];
            String apellido = apellidos[random.nextInt(apellidos.length)];
            String turno = turnos[random.nextInt(turnos.length)];
            String area = "medico";

            String cedula = "MED" + (10000 + random.nextInt(90000));
            String especialidad = especialidades[random.nextInt(especialidades.length)];
            int consultorio = random.nextInt(20) + 1;

            Medico m = new Medico(i, nombre, apellido, area, turno);
            m.setCedula(cedula);
            m.setEspecialidad(especialidad);
            m.setConsultorio(consultorio);
            
            listaEmpleados.add(m);
        }

        for (int i = 300; i <= 302; i++) {
            String nombre = nombres[random.nextInt(nombres.length)];
            String apellido = apellidos[random.nextInt(apellidos.length)];
            String turno = turnos[random.nextInt(turnos.length)];
            String area = "recepcionista";
            Recepcionista r = new Recepcionista(i, nombre, apellido, area, turno);
            listaEmpleados.add(r);
        }

        return listaEmpleados;
    }

    public static void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(archivoBinario))) {
            
            oos.writeObject(listaEmpleados);
            System.out.println(listaEmpleados.size() + " empleados guardados");
            
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Empleado> cargarDesdeArchivo() {
        ArrayList<Empleado> empleados = null;
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(archivoBinario))) {
            
            empleados = (ArrayList<Empleado>) ois.readObject();
            listaEmpleados = empleados;
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No se pudo cargar el archivo: " + e.getMessage());
            empleados = new ArrayList<>();
        }
        
        return empleados;
    }

    public static void verEmpleados(){
        
        for (Empleado empleado : listaEmpleados) {
            empleado.mostrarInformacion();
        }
    }
    /*public static void main(String[] args) {
        System.out.println("=== GENERANDO EMPLEADOS ===");
        generarEmpleados();
        guardarEnArchivo();
    } */
}