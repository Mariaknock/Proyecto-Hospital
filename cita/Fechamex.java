package cita;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fechamex implements Serializable {
    private LocalDate fecha;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yy");

    public Fechamex(int dia, int mes, int año) {
        this.fecha = LocalDate.of(año, mes, dia);
    }

    @Override
    public String toString() {
        return fecha.format(FORMATO);
    }
}