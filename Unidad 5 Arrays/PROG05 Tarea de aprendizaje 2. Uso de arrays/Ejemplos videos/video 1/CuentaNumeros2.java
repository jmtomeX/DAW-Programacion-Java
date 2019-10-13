// Programa que  genera 100 números al azar entre 0 y 9
// y cuenta las veces que se repite cada uno de ellos
//
// Se utiliza un array para llevar la cuenta
import java.util.*;
import java.io.*;

public class CuentaNumeros2 {
   public static void main(String[] args) throws FileNotFoundException {
   
      // Crea el array para contar cuántas veces se repite cada dígito
      int[] contadores = new int[10];
      
      // Lee 100 números del 0 al 9 del fichero numeros.txt
      // Utiliza un array para contar cuantas veces se repite cada número
      Scanner leerFich = new Scanner(new File("numeros.txt"));
      
      for (int i = 0; i < 100; i++) {
         int numero = leerFich.nextInt();
         contadores[numero]++;
      }
      
      // Muestra el contenido del array mediante el método toString
      System.out.println("Contadores de dígitos: " + Arrays.toString(contadores));
      
      // Muestra el contenido del array mediante un for
      for (int i = 0; i < contadores.length; i++) {
         System.out.println("El número " + i + " ha salido " + contadores[i] + " veces");
      }
   }
}