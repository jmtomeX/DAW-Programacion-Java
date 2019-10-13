//Completa el siguiente programa para que cuente el número de palabras que tiene el fichero de texto datos.dat.

import java.util.*;
import java.io.*;
public class Ejeercicio12 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("edades.txt"));
      int contPalabras = 0;
      while(leerFichero.hasNext()) {
         String linea =leerFichero.next();
         contPalabras++;
      }
      System.out.println("Número de palabras: " + contPalabras);
      leerFichero.close();
   }
}