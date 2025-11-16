package paciente;
import java.util.ArrayList;

import cita.Cita;

public class Paciente {
    private String id;
    private String nombre;
    private double altura;
    private double peso;
    private int edad;
    private ArrayList<Cita> citasPaciente;
    private ExpedienteClinico expedienteMedico;

    public Paciente(String id, String nombre, double altura, double peso, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.expedienteMedico = new ExpedienteClinico();
        this.citasPaciente = new ArrayList<>();
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ExpedienteClinico getExpedienteMedico() {
        return expedienteMedico;
    }
    public void setExpedienteMedico(ExpedienteClinico expedienteMedico) {
        this.expedienteMedico = expedienteMedico;
    }
    public ArrayList<Cita> getCitasPaciente() {
        return citasPaciente;
    }
    public void setCitasPaciente(ArrayList<Cita> citasPaciente) {
        this.citasPaciente = citasPaciente;
    }


    // Método para calcular IMC
    public double calcularIMC() {
        return peso / (altura * altura);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", edad=" + edad +
                ", IMC=" + String.format("%.2f", calcularIMC()) +
                '}';
    }
}