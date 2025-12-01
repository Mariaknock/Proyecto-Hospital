package inventario;

import java.io.*;
import paciente.Tratamiento;

public class GestorInventario {

    private static String archivoBinario = "inventario.dat";
    private static Inventario inventario;

    public static void cargarDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoBinario))) {
            
            inventario = (Inventario) ois.readObject();

            Stock.sincronizarDesdeInventario(inventario);

        } catch (FileNotFoundException e) {
            System.err.println("Archivo de inventario no encontrado, se va a crear otro ");
            inventario = new Inventario();
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


    public static void verInventario() {
        getInventario().verInventario();
    }


   public static void prescribirMedicamento(String nombreMed, Tratamiento tratamiento) {
        Inventario inv = getInventario();
        
        Medicamento medEncontrado = null;
        for (Medicamento m : inv.getCatalogoDeMedicamentos()) {
            if (m.getNombre().equalsIgnoreCase(nombreMed)) {
                medEncontrado = m;
                break;
            }
        }

        if (medEncontrado != null) {
            if (Stock.verificarStock(medEncontrado.getNombre()) > 0) {
                
                tratamiento.agregarMedicamento(medEncontrado);
                inv.despacharMedicamento(medEncontrado.getNombre(), 1);
                guardarEnArchivo(); 
                
            
                System.out.println(medEncontrado.getNombre() + " agregado al tratamiento.");
                
            } else {
                System.out.println("No hay stock de " + medEncontrado.getNombre());
            }
        } else {
            System.out.println(" Medicamento no encontrado");
        }
    }
    
    /*public static void main(String[] args) {
        inventario = new Inventario();
        guardarEnArchivo();
        cargarDesdeArchivo();
        verInventario();
    }*/


}