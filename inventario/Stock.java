package inventario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Stock {
    
    private static HashMap<String, Integer> stock = new HashMap<>();
    private static ArrayList<Medicamento> medicamentos = new ArrayList<>();

    public static void crearStock(){
        for(Medicamento medicamento : medicamentos){
            Random rdm = new Random();
            stock.put(medicamento.getNombre(), rdm.nextInt(21));
        }
    }

    public static void crearMedicamentos(){
        
        String[] nombres = {
            "Paracetamol", "Ibuprofeno",  "Amoxicilina",
            "Omeprazol", "Loratadina", "Metformina",
            "Atorvastatina", "Salbutamol"
        };

        String[] principiosActivos = {
            "Paracetamol", "Ibuprofeno",
            "Amoxicilina Trihidratada", "Omeprazol Magnésico",
            "Loratadina", "Metformina Clorhidrato", 
            "Atorvastatina Cálcica", "Salbutamol Sulfato"
        };

        String[] presentaciones = {
            "Tabletas 500mg", "Cápsulas 400mg",
            "Suspensión oral 250mg/5ml",
            "Cápsulas gastrorresistentes 20mg",
            "Tabletas 10mg", "Tabletas 850mg",
            "Tabletas 20mg", "Inhalador 100mcg"
        };

        String[] dosis = {
            "1 tableta cada 8 horas",
            "1 cápsula cada 6-8 horas",
            "5ml cada 12 horas",
            "1 cápsula al día antes del desayuno",
            "1 tableta al día",
            "1 tableta con las comidas",
            "1 tableta al día por la noche", 
            "1-2 inhalaciones cada 4-6 horas"
        };

        for(int i=0; i<nombres.length; i++){
            Medicamento medicamento = new Medicamento(nombres[i], principiosActivos[i], presentaciones[i], dosis[i]);
            medicamentos.add(medicamento);
        }
    }

    public static HashMap<String, Integer> getStock() {
        return stock;
    }

    public static ArrayList<Medicamento> getMedicamentos(){
        return medicamentos;
    }

    public static void incrementarStock(String nombre, int cantidad){
        if(stock.get(nombre)!= null){
            int cantidadActual = stock.get(nombre);
            stock.replace(nombre, cantidadActual + cantidad);
        } else {
            System.out.println("El medicamento no se encuentra en el stock");
        }
        
    }

    public static void disminuirStock(String nombre, int cantidad){
        if(stock.get(nombre) != null){
            int cantidadActual = stock.get(nombre);
            if(cantidad > cantidadActual){
                System.out.println("No se puede quitar más de la cantidad en stock");
            } else {
                stock.replace(nombre, cantidadActual - cantidad);
                System.out.println("Medicamento despachado ");
            }
        } else {
            System.out.println("El medicamento no se encuentra en el stock");
        }
    }
    public static int verificarStock(String nombre){
        return stock.get(nombre);
    }
}
