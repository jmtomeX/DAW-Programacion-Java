
import java.util.*;
public class Ejercicio01 {
   public static void main(String[] args) { 
      String[] a = {"hola", "kaixo", "Agur", "ADIOS"};
      System.out.println(a[0].toUpperCase() );	
      System.out.println(a[3].startsWith("a") );	
      System.out.println(!a[1].equals(a[2]) );	
      System.out.println(a[3].toLowerCase().substring(2));
   }
   
}