package empleado;
public class Recepcionista extends Empleado {

    private static String contraRec= "R4E5C6";

    public Recepcionista (int idEmpleado,String nombre,String apellido,String area,String turno){
        super(idEmpleado,nombre,apellido,area,turno);
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
