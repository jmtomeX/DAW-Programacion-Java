import java.util.*;
import java.io.*;

public class Ejercicio01 {
   public static void main(String[] args) throws FileNotFoundException {
          // Conecta con el fichero palabras.txt
      Scanner leerFichero = new Scanner(new File("palabras.txt"));
      
      // Mientras haya otra línea más por leer, la lee y la procesa
   
      collapseSpaces(leerFichero);
   
   }

   public static void collapseSpaces(Scanner leerFich) {
      while (leerFich.hasNextLine()) {
         String linea = leerFich.nextLine();
         Scanner leerLinea = new Scanner(linea);
         while (leerLinea.hasNext()) {
            String token = leerLinea.next();
            System.out.print(token + " ");           
         }
         System.out.println();           
      }
   }
}