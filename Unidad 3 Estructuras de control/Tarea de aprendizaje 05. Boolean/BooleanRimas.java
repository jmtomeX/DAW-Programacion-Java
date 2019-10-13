// Programa que utiliza booleanos como return de un método

import java.util.*;

public class BooleanRimas {
   public static void main(String[] args) {
      if(riman("Hola", "Caracola")) {
         System.out.println("Buena rima");
      } else {
         System.out.println("Tienes que mejorar tu rima.");
      }
   }
   
   // Comprueba si 2 palabras riman, si acaban con las mismas 2 letras.
   //
   // String palabra1 - primera palabra de la rima
   // String palabra2 - segunda palabra de la rima
   // return true si las palabras riman false en caso contrario
   public static boolean riman(String palabra1, String palabra2) {
      String letrasFin = "";
      // Comprueba que la primera palabra tiene más de 2 letras
      // para poder seleccionarlas
      if(palabra1.length() > 2) {
         letrasFin = palabra1.substring(palabra1.length() - 2);
      } else {
         return false;
      }
      
      return palabra2.endsWith(letrasFin);
   }
}