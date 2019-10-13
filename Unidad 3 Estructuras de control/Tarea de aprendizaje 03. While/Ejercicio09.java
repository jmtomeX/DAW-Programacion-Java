/*
Modifica el programa para que no realice la suma hasta que el usuario haya introducido un número entero.
El programa comprobará si el número introducido es de tipo int y si no lo es descartará el dato y pedirá otro hasta que lo sea.
Por ejemplo:
Introduce un numero:
5.8
Introduce un numero:
tyu
Introduce un numero:
25tt
Introduce un numero:
6
6 + 2 = 8
*/
import java.util.*;
public class Ejercicio09 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      int num = 0;
      System.out.println("Introduce un numero:");  
      while(!teclado.hasNextInt()){
         teclado.next();
         System.out.println("Introduce un numero:");     
      }
      num = teclado.nextInt();
      
      
      System.out.println(num + " + 2 = " + (num + 2));         
   }
}
