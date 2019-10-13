// Este programa calcula la temperatura media de una serie de días
// y además indica cuántos días superan la temperatura media
//
// Se utiliza un array aunque no sabemos cuantas temperaturas 
// vamos a almacenar antes de empezar el programa
// Sin arrays no podríamos haber realizado este programa
// Podríamos haber calculado la media pero no podríamos saber
// cuántos días superan la temperatura media

import java.util.*;

public class Temperaturas1 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      
      // Pedimos el número de días cuyas temperaturas vamos a introducir
      System.out.print("Numero de días a analizar: ");
      int numDias = teclado.nextInt();
   
      // Creamos el array para ese número de días
      double[] temperaturas = new double[numDias];
      
      // Recorremos el array, lo llenamos con las temperaturas introducidas
      // y calculamos la media. Utilizamos el algoritmo acumulador
      double total = 0;
      for (int i = 0; i < temperaturas.length; i++) {
         System.out.print("Temperatura del día " + (i + 1) + ": ");
         temperaturas[i] = teclado.nextDouble();
         
         total += temperaturas[i];
      }
      
      // Calculamos la media
      double media = total / temperaturas.length;
      
      // Volvemos a recorrer el array para contar cuantos días superan la temperatura media
      int superanMedia = 0;
      for(int i = 0; i < temperaturas.length; i++){
         if(temperaturas[i] > media){
            superanMedia++;
         }
      }
      
      System.out.println("Temperatura media: " + media);
      System.out.println("Durante " + superanMedia + " días se ha superado la media.");
   }
}