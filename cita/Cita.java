package cita;
import java.time.LocalTime;
public class Cita
{
    private String nombrePaciente;
    private Fechamex fecha;
    private LocalTime hora;
    private double precio;
    private int idPaciente;
    
    Cita(String nombrePaciente,Fechamex fecha,LocalTime hora, double precio, int idPaciente)
    {
        this.nombrePaciente=nombrePaciente;
        this.fecha=fecha;
        this.hora=hora;
        this.precio=precio;
        this.idPaciente=idPaciente;
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

    @Override
    public String toString()
    {
        return "----Datos de la cita---\n"
        +"Nombre del paciente: " + getNombrePaciente()+"\n"
        +"Fecha: " +getFecha()+"\n"
        +"Hora: "+ getHora() + "\n"
        +"Precio: "+getPrecio()+" pesos mexicanos" + "\n"
        +"ID del paciente: "+ getIdPaciente()+"\n";
    }

}

