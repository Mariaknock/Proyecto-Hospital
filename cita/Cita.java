package cita;
import java.time.LocalTime;
public class Cita
{
    private String nombrePaciente;
    private Fechamex fecha;
    private LocalTime hora;
    private double precio;
    
    Cita(String nombrePaciente,Fechamex fecha,LocalTime hora, double precio)
    {
        this.nombrePaciente=nombrePaciente;
        this.fecha=fecha;
        this.hora=hora;
        this.precio=precio;
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

    @Override
    public String toString()
    {
        return "----Datos de la cita---\n"
        +"Nombre del paciente: " + getNombrePaciente()+"\n"
        +"Fecha: " +getFecha()+"\n"
        +"Hora: "+ getHora() + "\n"
        +"Precio: "+getPrecio()+" pesos mexicanos" + "\n";
    }

}

