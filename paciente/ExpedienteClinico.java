package paciente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExpedienteClinico implements Serializable{    
    private List<String> historialVacunas;
    private List<String> antecedentesFamiliares;
    private List<String> enfermedadesPrevias;
    private List<String> alergias;
    private List<String> medicamentosPrescritos;

    public ExpedienteClinico() {
        this.historialVacunas = new ArrayList<>();
        this.antecedentesFamiliares = new ArrayList<>();
        this.enfermedadesPrevias = new ArrayList<>();
        this.alergias = new ArrayList<>();
        this.medicamentosPrescritos = new ArrayList<>();
    }
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
    
    public void agregarVacuna(String vacuna) {
        this.historialVacunas.add(vacuna);
    }

    public void agregarAntecedente(String antecedente) {
        this.antecedentesFamiliares.add(antecedente);
    }

    public void agregarEnfermedad(String enfermedad) {
        this.enfermedadesPrevias.add(enfermedad);
    }

    public void agregarAlergia(String alergia) {
        this.alergias.add(alergia);
    }

    public void agregarMedicamento(String medicamento) {
        this.medicamentosPrescritos.add(medicamento);
    }



    public String toString() {
        return "ExpedienteClinico{" +
                "\nhistorialVacunas=" + historialVacunas +
                ", \nantecedentesFamiliares=" + antecedentesFamiliares +
                ", \nenfermedadesPrevias=" + enfermedadesPrevias +
                ", \nalergias=" + alergias +
                ", \nmedicamentosPrescritos=" + medicamentosPrescritos +
                '}';
    }
}