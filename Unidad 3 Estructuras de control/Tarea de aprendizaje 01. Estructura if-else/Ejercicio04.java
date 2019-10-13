/*
Si tenemos el siguiente código:

Scanner teclado = new Scanner(System.in)
System.out.print("Introduce un dato: ");

E introducimos los siguientes 2 datos por teclado:

23,7 abc
*/
import java.util.*;
public class Ejercicio04 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.print("Introduce un dato: ");
      System.out.println( teclado.hasNextInt()); 	
      System.out.println( teclado.hasNextDouble());	
      System.out.println( teclado.hasNext()); 	 
      System.out.println( teclado.hasNextDouble()); 	
      System.out.println( teclado.hasNextInt()); 	
      System.out.println( teclado.hasNext()); 	
      
   }
}