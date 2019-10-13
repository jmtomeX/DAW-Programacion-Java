/*
Ordena el código del método para que recorra un ArrayList y devuelva la 
palabra más larga que encuentre:
*/
import java.util.*;

public class Ejercicio08 {
   public static void main(String[] args) {
      ArrayList<String> lista = new ArrayList<String>(Arrays.asList("RO", "BLANCO", "AZUL", "NEGRO", "AMARILLO"));
      System.out.print(metodo(lista));
   
   }
   public static String metodo(ArrayList<String> palabras) {
      String palabraMax = palabras.get(0);
      int max = palabraMax.length();
      for(int i = 1; i < palabras.size(); i++) {
         String palabra = palabras.get(i);
         int largo = palabra.length();
      
         if (largo > max) {
            max = largo;
            palabraMax = palabra;
         }
      }
      return palabraMax; 
   
   
   }
}