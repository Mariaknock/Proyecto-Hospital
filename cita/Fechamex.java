package cita;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Fechamex
{
    private LocalDateTime fecha;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yy");

    public Fechamex(int dia, int mes, int año, int horas, int minutos)
    {
        this.fecha=LocalDateTime.of(año,mes,dia,horas,minutos);
    }

    @Override
    public String toString(){
        return fecha.format(FORMATO);
    }

}