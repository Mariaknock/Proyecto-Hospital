package habitacion;

public class Habitacion {
    private int numeroHabitacion;
    private int cantidadCamas;
    private int aforoActual;

    public Habitacion(int numeroHabitacion, int cantidadCamas, int aforoActual){
        this.numeroHabitacion = numeroHabitacion;
        this.cantidadCamas = cantidadCamas;
        this.aforoActual = aforoActual;
    }

    public int getAforoActual() {
        return aforoActual;
    }
    public void setAforoActual(int aforoActual) {
        this.aforoActual = aforoActual;
    }
    public int getCantidadCamas() {
        return cantidadCamas;
    }
    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }
    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

}
