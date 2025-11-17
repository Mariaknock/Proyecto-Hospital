package paciente;

import java.util.ArrayList;
import cita.Cita;

public class PacienteBuilder {
    private int id;
    private String nombre;
    private double altura;
    private double peso;
    private int edad;
    private ArrayList<Cita> citasPaciente;

    public PacienteBuilder(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.altura = 0.0;
        this.peso = 0.0;
        this.edad = 0;
        this.citasPaciente = new ArrayList<>();
    }

    public PacienteBuilder altura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor a 0");
        }
        this.altura = altura;
        return this;
    }

    public PacienteBuilder peso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a 0");
        }
        this.peso = peso;
        return this;
    }

    public PacienteBuilder edad(int edad) {
        if (edad < 0 || edad > 105) {
            throw new IllegalArgumentException("Edad inválida: " + edad);
        }
        this.edad = edad;
        return this;
    }

    public PacienteBuilder citasPaciente(ArrayList<Cita> citas) {
        this.citasPaciente = citas != null ? new ArrayList<>(citas) : new ArrayList<>();
        return this;
    }

    public PacienteBuilder agregarCita(Cita cita) {
        if (cita != null) {
            this.citasPaciente.add(cita);
        }
        return this;
    }

    public Paciente build() {
        validarDatos();
        Paciente paciente = new Paciente(id, nombre, altura, peso, edad);
        
        if (!citasPaciente.isEmpty()) {
            paciente.setCitasPaciente(new ArrayList<>(citasPaciente));
        }
        
        return paciente;
    }

    private void validarDatos() {
        if (nombre == null) {
            throw new IllegalStateException("El nombre no puede estar vacío");
        }
    }
}
