package cita;
import paciente.Paciente;
import java.util.ArrayList;
import menus.*;
public class pruebas
{
    public static void main(String[] args)
    {
      
      Paciente paciente1=new Paciente(1, "manu", 1.64, 100, 20);
      Paciente paciente2=new Paciente(2, "mariano", 1.80, 100, 22);
      Paciente paciente3=new Paciente(3, "gabo", 1.80, 100, 22);
      Paciente paciente4=new Paciente(4, "manchego", 1.80, 100, 22);
      Paciente paciente5=new Paciente(5, "victor", 1.80, 100, 22);

      ArrayList<Paciente> pacientes=new ArrayList<>();
      pacientes.add(paciente1);
      pacientes.add(paciente2);
      pacientes.add(paciente3);
      pacientes.add(paciente4);
      pacientes.add(paciente5);

      MenuGestionCitas menuGestionCitas=new MenuGestionCitas(pacientes);
      menuGestionCitas.mostrarMenuPrincipal();


    }
}