
import java.util.*;
import java.io.*;
public class Ejercicio01 {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner sarrera = new Scanner(new File("lineas.txt"));
      while (sarrera.hasNextLine()) {
         System.out.println("Linea: " + sarrera.nextLine());
      }
   }
}