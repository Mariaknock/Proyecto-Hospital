package cita;
import paciente.Paciente;
import java.util.ArrayList;
public class pruebas
{
    public static void main(String[] args)
    {
      
      Agenda agenda =new Agenda();
      Paciente paciente1=new Paciente(1, "manu", 1.64, 100, 20);
      Paciente paciente2=new Paciente(2, "mariano", 1.80, 100, 22);
      ArrayList<Paciente> pacientes=new ArrayList<>();
      pacientes.add(paciente1);
      pacientes.add(paciente2);
      agenda.crearCita(pacientes);
      agenda.crearCita(pacientes);
      agenda.crearCita(pacientes);

      agenda.actualizarCita(pacientes);
      agenda.actualizarCita(pacientes);


      //agenda.verCitas();

    }
}