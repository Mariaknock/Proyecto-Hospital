public class Enfermera extends Empleado {

    public Enfermera(int idEmpleado,String nombre,String apellido,String area){
        super(idEmpleado,nombre,apellido,area);
    }

    public void asistirPaciente(Paciente pacientePrueba){
        System.out.println("El enfermera " + getNombre() + "esta asistiendo al paciente " + pacientePrueba.getNombre());

    }

    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
    }


    
}
