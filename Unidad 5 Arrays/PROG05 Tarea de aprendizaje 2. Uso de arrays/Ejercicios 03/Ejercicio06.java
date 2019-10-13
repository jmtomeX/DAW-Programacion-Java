import java.util.*;
import java.io.*;
public class Ejercicio06 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leer = new Scanner(new File("datos.txt"));
      int[] contador = new int[15];
        
      while (leer.hasNext()) {
         String palabra = leer.next();
         contador[palabra.length()]++;
      }
   
      System.out.println(Arrays.toString(contador));
      leer.close();
   
   }
}