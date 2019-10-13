import java.io.*;
import java.util.*;
public class Ejercicio08 {
   public static void main(String[] args) throws FileNotFoundException {
   
      Scanner leer = new Scanner(new File("datos.txt"));
      
      while (leer.hasNextLine()) {
         String linea = leer.nextLine();
         while (linea.length() > 50) {
            System.out.println(linea.substring(0, 50));
            linea = linea.substring(50);
         }
         System.out.println(linea);
      }
      leer.close();
   }
}