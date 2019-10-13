import java.util.*;
import java.io.*;

public class Ejercicio07 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFich = new Scanner(new File("lineas.txt"));
     
      String linea = "";
      while (leerFich.hasNextLine()) {
         linea = leerFich.nextLine();
         System.out.println(contarPalabras(linea));
      
      }
      leerFich.close();
   }
   public static int contarPalabras(String texto){
      Scanner leer = new Scanner(texto);
      int cont = 0;
      int suma = 0;
      while(leer.hasNext()){
         String palabra = leer.next();
         cont++;
      }
      return cont;
   }
}