package cita;
import java.time.LocalTime;
public class pruebas
{
    public static void main(String[] args)
    {
        Fechamex fecha=new Fechamex(15,11,2025,16,45);
        LocalTime hora = LocalTime.of(9, 0, 0);
        Cita cita= new Cita("Jose Manuel",fecha,hora,500 );
        System.out.println(cita);

    }
}