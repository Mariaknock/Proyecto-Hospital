package habitacion;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GestorHabitacion {
    
    private String archivoBinario = "habitaciones.dat";
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();


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
                new FileOutputStream(nombreArchivo))) {
            
            oos.writeObject(habitaciones);
            System.out.println(habitaciones.size() + " habitaciones guardadas ");
            
            
        } catch (IOException e) {
            System.err.println("✗ Error al guardar: " + e.getMessage());
        }
    }
    
    public static ArrayList<Habitacion> cargarDesdeArchivo() {
        ArrayList<Habitacion> habitaciones = null;
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(nombreArchivo))) {
            
            habitaciones = (ArrayList<Habitacion>) ois.readObject();
            System.out.println(habitaciones.size() + " habitaciones cargadas desde: " + nombreArchivo);
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("✗ Error al cargar: " + e.getMessage());
            habitaciones = new ArrayList<>();
        }
        
        return habitaciones;
    }
    
    public static void main(String[] args) {
        
        System.out.println("=== GENERANDO Y GUARDANDO HABITACIONES ===");
        ArrayList<Habitacion> habitaciones = generarHabitaciones();
        guardarEnBinario(habitaciones, archivoBinario);
        
      
    }
    
    public static void mostrarEstadisticas(ArrayList<Habitacion> habitaciones) {
        int totalCamas = 0;
        int totalOcupadas = 0;
        int habitacionesLibres = 0;
        int habitacionesCompletas = 0;
        
        for (Habitacion h : habitaciones) {
            totalCamas += h.getCantidadCamas();
            totalOcupadas += h.getAforoActual();
            
            if (h.getAforoActual() == 0) {
                habitacionesLibres++;
            } else if (h.getAforoActual() == h.getCantidadCamas()) {
                habitacionesCompletas++;
            }
        }
        
        System.out.println("Total de habitaciones: " + habitaciones.size());
        System.out.println("Total de camas: " + totalCamas);
        System.out.println("Camas ocupadas: " + totalOcupadas);
        System.out.println("Habitaciones libres: " + habitacionesLibres);
        System.out.println("Habitaciones completas: " + habitacionesCompletas);
        System.out.printf("Tasa de ocupación: %.2f%%\n", 
                         (totalOcupadas * 100.0 / totalCamas));
    }
}