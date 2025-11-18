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


    public void poblarInventario(){
    //prubeas
    Medicamento m1 = new Medicamento("Paracetamol 500 mg", "Paracetamol", "Tabletas", "500 mg", "Analgésico");
    Medicamento m2 = new Medicamento("Losartán 50 mg", "Losartán", "Tabletas", "50 mg", "Antihipertensivo");
    Medicamento m3 = new Medicamento("Amoxicilina 250 mg", "Amoxicilina", "Suspensión", "250 mg/5ml", "Antibiótico");
    
    agregarMedicamentoAlCatalogo(m1);
    agregarMedicamentoAlCatalogo(m2);
    agregarMedicamentoAlCatalogo(m3);
    agregarStock(m1, 100);
    agregarStock(m2, 50);
    agregarStock(m3, 30);
    
    }

    public void verInventario() {

        if (getCatalogoDeMedicamentos().isEmpty()) {
            System.out.println("El inventario esta vacio");
            return;
        }

        for (Medicamento m : getCatalogoDeMedicamentos()) {
            int cantidad = verificarStock(m);
            System.out.println(m.getNombre() + " Stock de: " + cantidad);
        }
    }
    
}