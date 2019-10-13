//Completa el siguiente código para que pida el nombre de un fichero hasta que éste exista
// y se pueda leer:
import java.io.*;
import java.util.*;

public class Ejercicio02 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner teclado = new Scanner(System.in);
      System.out.print("Nombre del fichero: ");
      String nombre  = teclado.nextLine();
      File fichero = new File(nombre);
      while(!fichero.canRead()){
         System.out.println("No se puede leer este fichero.Inténtalo otra vez.");
         System.out.print("Nombre del fichero: ");
         nombre = teclado.nextLine();
         fichero = new File(nombre);
      }
      Scanner leerFichero =  new Scanner(fichero);
      leerFichero.close();
   }
   
}