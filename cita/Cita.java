package cita;
public class Cita
{
    private String nombrePaciente;
    private Fechamex fecha;
    private String hora;
    private double precio;
    
    Cita(String nombrePaciente,Fechamex fecha,String hora, double precio)
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

    public String getHora()
    {
        return hora;
    }

    public void setHora(String hora)
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

