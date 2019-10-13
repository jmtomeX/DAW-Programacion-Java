import java.util.*;
import java.io.*;

public class PruebaJava {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFich = new Scanner(new File("PruebaJava.java"));
      while(leerFich.hasNextLine()){
         String linea = leerFich.nextLine();
         System.out.println(linea);
      }
      leerFich.close();
   }
}