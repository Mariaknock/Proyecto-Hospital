package inventario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventario {

    private List<Medicamento> catalogoDeMedicamentos;
    private HashMap<String, Integer> stock; 

    public Inventario() {
        this.catalogoDeMedicamentos = new ArrayList<>();
        Stock.crearMedicamentos();
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

    public int verificarStock(String nombre) {
        return verificarStock(nombre); 
    }

    public void despacharMedicamento(String nombre, int cantidadADespachar) {
        Stock.disminuirStock(nombre, cantidadADespachar);
    }

    
}