package crud;
import java.util.ArrayList;

public interface CRUD<T> {
    public void crearInstancia(ArrayList<T> elementos);
    public void verElementos();
    public void actualizarInstancia();
    public void eliminarInstancia();
}