package empleado;
public class Recepcionista extends Empleado {

    public Recepcionista (int idEmpleado,String nombre,String apellido,String area,String turno,int contraseña){
        super(idEmpleado,nombre,apellido,area,turno,contraseña);
    }

    public void agendarCita(){
        System.out.println(getNombre() + "del turno " + getTurno() + "esta agendando una cita");


    }
    
    @Override
    public void mostrarInformacion(){
        System.err.println("Cargo -> Recepcionista");
        super.mostrarInformacion();
    }

}
