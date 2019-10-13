/*
Indica que líneas se mostrarán por consola, si se produce una excepción al intentar conectar con el fichero "datos.txt"
Seleccione una o más de una:
a. Nada
b. Mensaje 1 Correcta
c. Mensaje 2
*/
import java.io.*;
import java.util.*;
public class Ejercicio07 {
   public static void main(String[] args) throws FileNotFoundException {
      System.out.println("Mensaje 1");
      Scanner leerFichero = new Scanner(new File("datos.txt"));
      System.out.println("Mensaje 2");
   }
}
