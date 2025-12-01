package habitacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestorHabitacion {
    
    private static String archivoBinario = "habitaciones.dat";
    private static ArrayList<Habitacion> habitaciones = new ArrayList<>();

    public static ArrayList<Habitacion> getHabitaciones(){
        return habitaciones;
    }

    public static ArrayList<Habitacion> generarHabitaciones() {
        Random random = new Random();
        
        for (int i = 101; i <= 115; i++) {
            int aforo = random.nextInt(2); 
            habitaciones.add(new Habitacion(i, 1, aforo));
        }
        
        for (int i = 201; i <= 220; i++) {
            int aforo = random.nextInt(3);
            habitaciones.add(new Habitacion(i, 2, aforo));
        }
        
        for (int i = 301; i <= 315; i++) {
            int aforo = random.nextInt(4);
            habitaciones.add(new Habitacion(i, 3, aforo));
        }
        
        return habitaciones;
    }
    
    public static void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(archivoBinario))) {
            
            oos.writeObject(habitaciones);
            System.out.println(habitaciones.size() + " habitaciones guardadas ");
            
            
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static ArrayList<Habitacion> cargarDesdeArchivo() {        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(archivoBinario))) {
            
            habitaciones = (ArrayList<Habitacion>) ois.readObject();
            System.out.println(habitaciones.size() + " habitaciones cargadas");
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar: " + e.getMessage());
            habitaciones = new ArrayList<>();
        }
        
        return habitaciones;
    }
    /* public static void main(String[] args) {
        System.out.println("=== GENERANDO Y GUARDANDO HABITACIONES ===");
        habitaciones = generarHabitaciones();
        guardarEnArchivo();
        cargarDesdeArchivo();
        mostrarEstadisticas();
        for(Habitacion habitacion : habitaciones){
            System.out.println(habitacion);
        }
    }*/
    
    
    public static void mostrarEstadisticas() {
        int totalCamas = 0;
        int totalOcupadas = 0;
        int habitacionesLibres = 0;
        int habitacionesOcupadas = 0;
        int habitacionesCompletas = 0;
        
        List<Habitacion> habitacionesConEspacio = new ArrayList<>();
        
        for (Habitacion h : habitaciones) {
            totalCamas += h.getCantidadCamas();
            totalOcupadas += h.getAforoActual();
            
            if (h.getAforoActual() == 0) {
                habitacionesLibres++;
            } else if (h.getAforoActual() == h.getCantidadCamas()) {
                habitacionesCompletas++;
            } else {
                habitacionesOcupadas++;
                habitacionesConEspacio.add(h);
            }
        }
        
        double tasaOcupacion = (totalOcupadas * 100.0 / totalCamas);
        
        System.out.println("\n ESTADÍSTICAS DE DISPONIBILIDAD");
        System.out.println("═".repeat(40));
        
        System.out.println(" HABITACIONES CON ESPACIO DISPONIBLE:");
        if (habitacionesConEspacio.isEmpty()) {
            System.out.println("   No hay habitaciones con espacio disponible");
        } else {
            for (Habitacion h : habitacionesConEspacio) {
                int espacios = h.getCantidadCamas() - h.getAforoActual();
                System.out.printf("   • Habitación %d: %d espacio(s) libre(s) (%d/%d camas)\n",
                                h.getNumeroHabitacion(), espacios, 
                                h.getAforoActual(), h.getCantidadCamas());
            }
        }
        
        System.out.println("─".repeat(40));
        
        // Resumen rápido
        System.out.printf("RESUMEN:\n");
        System.out.printf("   • Habitaciones con espacio: %d\n", habitacionesOcupadas);
        System.out.printf("   • Habitaciones libres: %d\n", habitacionesLibres);
        System.out.printf("   • Habitaciones completas: %d\n", habitacionesCompletas);
        System.out.printf("   • Ocupación total: %.1f%%\n", tasaOcupacion);
        System.out.println("═".repeat(40));
    }
}