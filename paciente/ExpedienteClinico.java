package paciente;
import java.util.ArrayList;
import java.util.List;

public class ExpedienteClinico {
    private List<String> historialVacunas;
    private List<String> antecedentesFamiliares;
    private List<String> enfermedadesPrevias;
    private List<String> alergias;
    private List<String> medicamentosPrescritos;
    private List<String> citasPrevias;

    public ExpedienteClinico() {
        this.historialVacunas = new ArrayList<>();
        this.antecedentesFamiliares = new ArrayList<>();
        this.enfermedadesPrevias = new ArrayList<>();
        this.alergias = new ArrayList<>();
        this.medicamentosPrescritos = new ArrayList<>();
        this.citasPrevias = new ArrayList<>();
    }
    // Getters y Setters
    public List<String> getHistorialVacunas() {
        return historialVacunas;
    }

    public void setHistorialVacunas(List<String> historialVacunas) {
        this.historialVacunas = historialVacunas;
    }

    public List<String> getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public void setAntecedentesFamiliares(List<String> antecedentesFamiliares) {
        this.antecedentesFamiliares = antecedentesFamiliares;
    }

    public List<String> getEnfermedadesPrevias() {
        return enfermedadesPrevias;
    }

    public void setEnfermedadesPrevias(List<String> enfermedadesPrevias) {
        this.enfermedadesPrevias = enfermedadesPrevias;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public List<String> getMedicamentosPrescritos() {
        return medicamentosPrescritos;
    }

    public void setMedicamentosPrescritos(List<String> medicamentosPrescritos) {
        this.medicamentosPrescritos = medicamentosPrescritos;
    }

    public List<String> getCitasPrevias() {
        return citasPrevias;
    }

    public void setCitasPrevias(List<String> citasPrevias) {
        this.citasPrevias = citasPrevias;
    }
    
    // Métodos para agregar elementos
    public void agregarVacuna(String vacuna) {
        this.historialVacunas.add(vacuna);
        System.out.println("Vacuna '" + vacuna + "' agregada al historial");
    }

    public void agregarAntecedente(String antecedente) {
        this.antecedentesFamiliares.add(antecedente);
        System.out.println("Antecedente familiar '" + antecedente + "' agregado");
    }

    public void agregarEnfermedad(String enfermedad) {
        this.enfermedadesPrevias.add(enfermedad);
        System.out.println("Enfermedad previa '" + enfermedad + "' agregada");
    }

    public void agregarAlergia(String alergia) {
        this.alergias.add(alergia);
        System.out.println("Alergia '" + alergia + "' agregada");
    }

    public void agregarMedicamento(String medicamento) {
        this.medicamentosPrescritos.add(medicamento);
        System.out.println("Medicamento '" + medicamento + "' agregado");
    }

    public void agregarCitaPrevia(String cita) {
        this.citasPrevias.add(cita);
        System.out.println("Cita previa '" + cita + "' agregada");
    }

    

    public String toString() {
        return "ExpedienteClinico{" +
                "historialVacunas=" + historialVacunas +
                ", antecedentesFamiliares=" + antecedentesFamiliares +
                ", enfermedadesPrevias=" + enfermedadesPrevias +
                ", alergias=" + alergias +
                ", medicamentosPrescritos=" + medicamentosPrescritos +
                ", citasPrevias=" + citasPrevias +
                '}';
    }
}