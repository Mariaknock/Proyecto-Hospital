import java.util.ArrayList;

public class Medico extends Empleado {
    private String cedula;
    private String especialidad;
    private int consultorio;
    private ArrayList<Paciente> pacientesAtendidos;

    public Medico(String nombre, String apellido, int idPaciente, String area){
        super(nombre, apellido, idPaciente, area);
        this.pacientesAtendidos = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public int getConsultorio() {
        return consultorio;
    }
    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public ArrayList<Paciente> getPacientesAtendidos() {
        return pacientesAtendidos;
    }
    public void agregarPacientesAtendidos(Paciente paciente){
        this.pacientesAtendidos.add(paciente);
    }

}
