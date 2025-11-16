import java.util.ArrayList;
public class Agenda
{
    private ArrayList<Cita> agenda;

    Agenda()
    {
        this.agenda=new ArrayList<Cita>();
    }

    public ArrayList<Cita> getAgenda()
    {
        return agenda;
    }



    

    public void agregarCita(Cita cita)
    {
        agenda.add(cita);
        System.out.println("Cita agregada exitosamente");
    }

    public void eliminarCita(Cita cita)
    {
        agenda.remove(cita);
        System.out.println("Cita eliminada exitosamente");

    }

   public Cita buscarCitaPorNombre(String nombrePaciente) {
        if (agenda.isEmpty()) {
            System.out.println("Agenda vacía");
            return null;
        } else {
            for (Cita cita : agenda) {
                if (cita.getNombrePaciente().equals(nombrePaciente)) {
                    System.out.println("Cita de " + cita.getNombrePaciente() + " encontrada exitosamente");
                    return cita;
                }
            }
            System.out.println("Cita no encontrada");
            return null;
        }
    }


    

    /*
    Idea en desarrollo
    public void verCitasDesdeCalendario()
    {

    }

    */
}