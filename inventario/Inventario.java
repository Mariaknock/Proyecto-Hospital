package inventario;
import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Medicamento> catalogoDeMedicamentos;
    private List<Stock> stock; 

    public Inventario() {
        this.catalogoDeMedicamentos = new ArrayList<>();
        this.stock = new ArrayList<>();
    }


    public List<Medicamento> getCatalogoDeMedicamentos() {
        return catalogoDeMedicamentos;
    }

    public void setCatalogoDeMedicamentos(List<Medicamento> catalogoDeMedicamentos) {
        this.catalogoDeMedicamentos = catalogoDeMedicamentos;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    public void agregarMedicamentoAlCatalogo(Medicamento medicamento) {
        this.catalogoDeMedicamentos.add(medicamento);
        System.out.println(" Medicamento agregado al catalogo");
    }

    
    public void agregarStock(Medicamento medicamento, int cantidad) {

        for (Stock item : stock) {
            if (item.getMedicamento().getNombre().equals(medicamento.getNombre())) {
                item.setCantidad(item.getCantidad() + cantidad);
                System.out.println("Stock actualizado");
                return; 
            }
        }
        
        Stock nuevoItem = new Stock(medicamento, cantidad);
        this.stock.add(nuevoItem);
        System.out.println(medicamento.getNombre() + " agregado al stock");
    }

    public int verificarStock(Medicamento medicamento) {
    
        for (Stock item : stock) {

            if (item.getMedicamento().getNombre().equals(medicamento.getNombre())) {
                return item.getCantidad(); 
            }
        }
        return 0; 
    }

    public void despacharMedicamento(Medicamento medicamento, int cantidadADespachar) {
    
        for (Stock item : stock) {
            if (item.getMedicamento().getNombre().equals(medicamento.getNombre())) {
                
    
                if (item.getCantidad() >= cantidadADespachar) {
                    item.setCantidad(item.getCantidad() - cantidadADespachar);
                    System.out.println("Se despacharon " + cantidadADespachar + " de " + medicamento.getNombre());
                } else {
                    System.out.println("No hay suficiente cantidad");
                }
                return; 
            }
        }
        System.out.println("El medicamento no existe en el stock");
    }
    
}