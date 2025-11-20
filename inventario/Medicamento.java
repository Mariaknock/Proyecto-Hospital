package inventario;

import java.io.Serializable;

public class Medicamento implements Serializable {
    private String nombre;
    private String principioActivo;
    private String presentacion; 
    private String dosis;
    private String descripcion;


    public Medicamento(String nombre, String principioActivo, String presentacion, String dosis) {
        this.nombre = nombre;
        this.principioActivo = principioActivo;
        this.presentacion = presentacion;
        this.dosis = dosis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void mostrarInformacion(){
        System.out.println("Nombre " + nombre );
        System.out.println("Principio activo " + principioActivo );
        System.out.println("Presemtacion : "+ presentacion);
        System.err.println("Dosis " + dosis);

    }


}