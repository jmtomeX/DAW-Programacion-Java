// Programa que cuenta las veces que se repite cada vocal
// en un String
// Se utiliza un array para llevar la cuenta

import java.util.*;     // Librería para usar la clase Arrays

public class CuentaVocales {
   public static void main(String[] args) {
   
      // Crea el array para contar cuántas veces se repite cada vocal
      // contadores[0] contará las a-s, contadores[1] contará las e-s...
      int[] contadores = new int[5];
      
      // Creo un array con los valores de las letras que quiero contar
      char[] letras = {'a', 'e', 'i', 'o', 'u'};
      
      // Lee una cadena de caracteres
      Scanner teclado = new Scanner(System.in);
      System.out.print("Introduce un texto: ");
      String texto = teclado.nextLine();
      texto = texto.toLowerCase();
      
      // Recorre la cadena de caracteres que se ha introducido y
      // utiliza un array para contar cuantas veces se repite cada vocal
      for (int i = 0; i < texto.length(); i++) {
      
         // Coge una letra del array
         char letra = texto.charAt(i);
         
         // Recorrer el array letras y si la letra está contarla
         for (int indice = 0; indice < letras.length; indice++) {
            if (letra == letras[indice]) {
               contadores[indice]++;
            }
         }
      }
      
      // Muestra el contenido del array mediante el método toString
      System.out.println("Contadores de vocales: " + Arrays.toString(contadores));
      
      // Muestra el contenido del array mediante un for
      for (int i = 0; i < contadores.length; i++) {
         System.out.println("La vocal " + letras[i] + " ha salido " + contadores[i] + " veces");
      }
   }
}