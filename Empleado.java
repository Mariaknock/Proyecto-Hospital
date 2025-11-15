public class Empleado {
    private String nombre;
    private String apellido;
    private int idEmpleado;
    private String area;
    
    public Empleado(int idEmpleado, String nombre, String apellido, String area){
        this.idEmpleado=idEmpleado;
        this.nombre= nombre;
        this.apellido= apellido;
        this.area= area;

    }


    public void mostrarInformacion(){
        System.out.println("ID: " + idEmpleado);
        System.out.println("Nombre " + nombre + " " + apellido);
        System.out.println("Area: "+ area);

    }

    public String getNombre(){
        return nombre;
    }

    public int getidEmpleado(){
        return idEmpleado;
    }

    public String getApellido(){
        return apellido;
    }

    public String getArea(){
        return area;
    }




}
