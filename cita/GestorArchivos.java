package cita;

import java.io.*;
import java.util.ArrayList;
import paciente.Paciente;

public class GestorArchivos {
    public static void main(String[] args) {
        try {
            // Sube un nivel desde cita para llegar a la raíz del proyecto
            FileInputStream archivo = new FileInputStream("pacientes.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            
            ArrayList<Paciente> pacientes = (ArrayList<Paciente>) lector.readObject();
            
            lector.close();
            archivo.close();
            
            System.out.println("=== PACIENTES CARGADOS ===");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo 'pacientes.dat' no existe en la raíz del proyecto");
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Clase no encontrada - " + e.getMessage());
        }
    }
}