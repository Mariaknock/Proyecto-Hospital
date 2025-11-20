package inventario;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario implements Serializable{

    private List<Medicamento> catalogoDeMedicamentos;
    private HashMap<String, Integer> stock; 

    public Inventario() {
        Stock.crearMedicamentos();
        this.catalogoDeMedicamentos = Stock.getMedicamentos();
        Stock.crearStock();
        this.stock = Stock.getStock();
    }


    public List<Medicamento> getCatalogoDeMedicamentos() {
        return catalogoDeMedicamentos;
    }

    public void setCatalogoDeMedicamentos(List<Medicamento> catalogoDeMedicamentos) {
        this.catalogoDeMedicamentos = catalogoDeMedicamentos;
    }

    public HashMap<String, Integer> getStock() {
        return stock;
    }

    public void setStock(HashMap<String, Integer> stock) {
        this.stock = stock;
    }

    public void agregarMedicamentoAlCatalogo(Medicamento medicamento) {
        this.catalogoDeMedicamentos.add(medicamento);
        System.out.println(" Medicamento agregado al catalogo");
    }

    
    public void agregarStock(String nombre, int cantidad) {
        stock.put(nombre, cantidad);
        System.out.println(nombre + " agregado al stock");
    }

    public void incrementarStock(String nombre, int cantidad){
        Stock.incrementarStock(nombre, cantidad);
    }

    public void verificarStock(String nombre) {
        Stock.verificarStock(nombre); 
    }

    public void despacharMedicamento(String nombre, int cantidadADespachar) {
        Stock.disminuirStock(nombre, cantidadADespachar);
    }

    public void verInventario() {
        for (Map.Entry<String, Integer> entrada : stock.entrySet()) {
            String medicamento = entrada.getKey();
            Integer cantidad = entrada.getValue();
            System.out.println("Medicamento: " + medicamento + ", Stock: " + cantidad);
        }
    }
}