import java.io.*;
import java.util.*;

public class Ejercicio07 {
   public static final String[] MESES = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
   public static void main(String[] args){
      Scanner leer = new Scanner(System.in);
      System.out.println("Introduce la fecha de nacimiento (dd/mm/aaaa): ");
      String fecha = leer.next();
      Scanner separar = new Scanner(fecha);
      separar.useDelimiter("/"); 
      int dia = separar.nextInt();
      int mes = separar.nextInt();
      int anio = separar.nextInt();
      System.out.println(dia + " de " + MESES[mes - 1 ] + " de " + anio);
   }
}