package cita;
import java.util.ArrayList;
import paciente.Paciente;
import menus.*;

public class Pruebas {
    public static void main(String[] args) {
        
        ArrayList<Paciente> pacientes = GestorArchivosCitas.leerPacientes("pacientes.dat");
        
        GestorArchivosCitas.crearCitasAutomaticas(pacientes);
    
        MenuGestionCitas menuGestionCitas= new MenuGestionCitas(pacientes);
        menuGestionCitas.mostrarMenuPrincipal();

    }
}