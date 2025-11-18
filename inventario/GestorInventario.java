package inventario;

import java.io.*;

public class GestorInventario {

    private static String archivoBinario = "inventario.dat";
    private static Inventario inventario;

    public static void cargarDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoBinario))) {
            
            inventario = (Inventario) ois.readObject();
            System.out.println("Inventario cargado desde " + archivoBinario);

        } catch (FileNotFoundException e) {
            System.err.println("Archivo de inventario no encontrado, se va a crear otro ");
            inventario = new Inventario();
            inventario.poblarInventario(); 
            guardarEnArchivo(); 
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar el inventario ");
        
            inventario = new Inventario();
        }
    }

    public static void guardarEnArchivo() {
        if (inventario == null) {
            System.err.println("No hay instancia de inventario para guardar");
            return;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoBinario))) {
            
            oos.writeObject(inventario);
            System.out.println("Inventario guardado en " + archivoBinario);
            
        } catch (IOException e) {
            System.err.println("Error al guardar el inventario: " + e.getMessage());
        }
    }


    public static Inventario getInventario() {
        if (inventario == null) {
            System.out.println("Inicializando y cargando inventario...");
            cargarDesdeArchivo();
        }
        return inventario;
    }
}