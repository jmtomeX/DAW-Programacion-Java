// Programa que  genera 100 números al azar entre 0 y 9
// y cuenta las veces que se repite cada uno de ellos
//
// Se utiliza un array para llevar la cuenta

import java.util.*;  // Librería para utilizar Random y Arrays

public class CuentaNumeros {
   public static void main(String[] args) {
   
      // Crear los contadores
      int[] contadores = new int[10];
      
      // Genera 100 números aleatorio del 0 al 9
      // Utiliza un array para contar cuantas veces se repite cad número
      Random aleatorio = new Random();
      
      for (int i = 0; i < 100; i++) {
         int numero = aleatorio.nextInt(10);
         System.out.println(numero);
         
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