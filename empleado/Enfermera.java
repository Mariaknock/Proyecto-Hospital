package empleado;
import paciente.Paciente;

public class Enfermera extends Empleado {

    public Enfermera(int idEmpleado,String nombre,String apellido,String area,String turno,int contraseña){
        super(idEmpleado,nombre,apellido,area,turno,contraseña);
    }

    public void asistirPaciente(Paciente pacientePrueba){
        System.out.println("El enfermera " + getNombre() + "esta asistiendo al paciente " + pacientePrueba.getNombre());

    }

    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
    }


    
}
