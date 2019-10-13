// Programa que cuenta las veces que se repite cada vocal
// en un String
// Se utiliza un array para llevar la cuenta
import java.util.*;

public class CuentaVocales3 {
   public static void main(String[] args) {
      // Crea el array para contar cuántas veces se repite cada vocal
      // contadores[0] contará las a-s, contadores[1] contará las e-s...
      int[] contadores = new int[5];
      
      
      // Crea un variable para controlar las letras que hay que buscar, las vocales
      String letras = "aeiou";
      
      // Lee una cadena de caracteres
      Scanner teclado = new Scanner(System.in);
      System.out.print("Introduce un texto: ");
      String texto = teclado.nextLine();
      
      // Utiliza un array para contar cuantas veces se repite cada vocal
      for (int i = 0; i < texto.length(); i++) {
         // Coge una letra del array
         char letra = texto.charAt(i);
         
         // Busca la letra en el String de letras y la cuenta
         // Si no está devolverá -1
         int indice = letras.indexOf(letra);        
         if (indice > -1) {
            contadores[indice]++;
         }
      }
      
      // Muestra el contenido del array mediante el método toString
      System.out.println("Contadores de vocales: " + Arrays.toString(contadores));
      
      // Muestra el contenido del array mediante un for
      for (int i = 0; i < contadores.length; i++) {
         System.out.println("La letra " + letras.charAt(i) + " ha salido " + contadores[i] + " veces");
      }
   }
}