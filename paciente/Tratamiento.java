package paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import inventario.Medicamento;

public class Tratamiento implements Serializable{
    private String diagnostico;
    private LocalDate fechaDeInicio;
    private LocalDate fechaDeFin;
    private List<Medicamento> medicamentosPrescritos;
    private String estado; 

    
    public Tratamiento(String diagnostico, LocalDate fechaDeInicio) {
        this.diagnostico = diagnostico;
        this.fechaDeInicio = fechaDeInicio;
        this.medicamentosPrescritos = new ArrayList<>();
        this.estado = "Tratamiento activo";
    }

    public void agregarMedicamento(Medicamento medicamento) {
        this.medicamentosPrescritos.add(medicamento);
        System.out.println("Medicamento agregado");
    }

    public void quitarMedicamento(Medicamento medicamento) {
        this.medicamentosPrescritos.remove(medicamento);
        System.out.println("Medicamento quitado");
    }

    public void marcarComoCompletado() {
        this.estado = "Completado";
        System.out.println("Tratamiento completado");
    }

    public void actualizarFechaDeFin(LocalDate fecha) {
        this.fechaDeFin = fecha;
        System.out.println("Fecha de fin actualizada");
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(LocalDate fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public LocalDate getFechaDeFin() {
        return fechaDeFin;
    }

    public void setFechaDeFin(LocalDate fechaDeFin) {
        this.fechaDeFin = fechaDeFin;
    }

    public List<Medicamento> getMedicamentosPrescritos() {
        return medicamentosPrescritos;
    }

    public void setMedicamentosPrescritos(List<Medicamento> medicamentosPrescritos) {
        this.medicamentosPrescritos = medicamentosPrescritos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Tratamiento - ").append(diagnostico).append("\n");
        sb.append("  Periodo: ").append(fechaDeInicio);
        sb.append(" Hasta ").append(fechaDeFin).append("\n");
        sb.append("  Estado: ").append(estado).append("\n");
        sb.append("  Medicamentos: ").append(medicamentosPrescritos.size()).append(" prescritos\n");
        
        for (Medicamento medicamento : medicamentosPrescritos) {
            if (medicamento != null) {
                sb.append("").append(medicamento.toString()).append("\n");
            }
        }
        
        return sb.toString();
    }
    

   
}