/*Ordena el código del método para que recorra un ArrayList y devuelva el número de letras 
de la palabra más corta que encuentre utilizando el bucle for-each:*/
import java.util.*;

public class Ejercicio07 {
   public static void main(String[] args) {
      ArrayList<String> lista = new ArrayList<String>(Arrays.asList("RO", "BLANCO", "AZUL", "NEGRO", "AMARILLO"));
      System.out.print(metodo(lista));
   }
   public static int metodo(ArrayList<String> palabras) {
      String primera = palabras.get(0);
      int min = primera.length();
      int largo = 0;
      for(String palabra : palabras) {
         largo = palabra.length();
         min = Math.min(largo, min);
      }
      return min;
   }
}