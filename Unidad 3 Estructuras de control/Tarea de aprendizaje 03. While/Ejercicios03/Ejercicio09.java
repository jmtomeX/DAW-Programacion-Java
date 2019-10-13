/*
Corrige el programa para que pida introducir un dato hasta que este sea correcto. 
Es decir, hasta que se haya introducido un número entero y mayor que 0. El programa comprobará si 
el número introducido es de tipo int y si no lo es descartará el dato y pedirá otro. Finalmente sumará el número más 2 y mostrará el resultado.
Por ejemplo:
Introduce un numero:
5.8
Introduce un numero:
tyu
Introduce un numero:
-5
Introduce un numero:
6
6 + 2 = 8
*/
import java.util.*;
public class Ejercicio09 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.println("Introduce un numero:");
      int num = leerEntero(teclado);
      while(num < 0) {
         System.out.println("Introduce un numero:");
         num = leerEntero(teclado);  
      }
      System.out.println(num + " + 2 = " + (num + 2)); 
      
      
   }
   
   public static int leerEntero(Scanner leer) {
      while(!leer.hasNextInt()) {
         leer.next();
         System.out.println("Introduce un numero:");   
      }
      int numero = leer.nextInt();
      return numero;
   }
}