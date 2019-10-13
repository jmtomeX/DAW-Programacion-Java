

/*Tenemos el siguiente fichero, lineas.txt:

Kaixo        34 45,78    zer

moduz zaude gaur?
100  90  ...  0

BUKAERA :)

¿Cuántos valores leería el siguiente código?
b. Ninguno, mostraría el error de ejecución "InputMismatchException" 
*/
import java.util.*;
import java.io.*;
public class Ejercicio03 {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner sarrera = new Scanner(new File("lineas.txt"));
      while (sarrera.hasNext()) {
         System.out.println("Leido: " + sarrera.next());
      }
   
   }
}