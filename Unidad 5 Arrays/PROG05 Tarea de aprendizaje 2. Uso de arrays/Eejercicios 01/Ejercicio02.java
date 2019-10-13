/*
Si el fichero contiene estos datos:
Pedro 1
Susana 2
Aritz 1
Miren 2
Guillermo 1
*/

import java.io.*;
import java.util.*;
public class Ejercicio02 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leer = new Scanner(new File("nombres.txt"));
      int[] contarOpciones = new int[2];
      
      while (leer.hasNext()) {
         String nombre = leer.next();
         int opcion = leer.nextInt();
         contarOpciones[opcion - 1]++;
      }
      System.out.println(Arrays.toString(contarOpciones));
      leer.close();
   }
}