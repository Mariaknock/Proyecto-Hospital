package cita;
import java.io.Serializable;
import java.time.LocalTime;
public class Cita implements Serializable
{
    private String nombrePaciente;
    private Fechamex fecha;
    private LocalTime hora;
    private double precio;
    private int idPaciente;
    private static int contador=1;
    private int idCita;
    
    Cita(String nombrePaciente,Fechamex fecha,LocalTime hora, double precio, int idPaciente)
    {
        this.nombrePaciente=nombrePaciente;
        this.fecha=fecha;
        this.hora=hora;
        this.precio=precio;
        this.idPaciente=idPaciente;
        this.idCita=contador++;
    }


    public String getNombrePaciente()
    {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente)
    {
        this.nombrePaciente=nombrePaciente;
    }

    public Fechamex getFecha()
    {
        return fecha;
    }

    public void setFecha(Fechamex fecha)
    {
        this.fecha=fecha;
    }

    public LocalTime getHora()
    {
        return hora;
    }

    public void setHora(LocalTime hora)
    {
        this.hora=hora;
    }

    public double getPrecio()
    {
        return precio;
    }
    
    public void setPrecio(double precio)
    {
        this.precio=precio;
    }

    public int getIdPaciente()
    {
        return idPaciente;
    }

    //no se puede modificar el ID del paciente

    public int getIdCita()
    {
        return idCita;
    }

    public static void setContador(int nuevoValor) {
        contador = nuevoValor;
    }

    public static int getContador() {
        return contador;
    }

    @Override
    public String toString()
    {
        return "----Datos de la cita---\n"
        +"Nombre del paciente: " + getNombrePaciente()+"\n"
        +"Fecha: " +getFecha()+"\n"
        +"Hora: "+ getHora() + "\n"
        + "Precio: " + String.format("%.2f", getPrecio()) + " pesos mexicanos" + "\n"
        +"ID del paciente: "+ getIdPaciente()+"\n"
        +"ID de la cita: "+ getIdCita()+"\n";

    }

}

