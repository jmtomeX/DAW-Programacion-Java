/*
Crea el método girarRuleta que recibe un objeto Random y un número entero como parámetros y simulará
giros de una ruleta hasta que el 20 salga tantas veces seguidas como el número indicado como parámetro.
Además, devuelverá cuántas tiradas se han necesitado.

La ruleta tendrá los siguientes números: 20, 30, 40, 50 y 60. Se tendrán que generar de manera aleatoria.

El método mostrará 2 líneas por cada llamada. Por ejemplo:

Random numAzar = new Random();
girarRuleta(numAzar, 2);

Tiradas: 20, 40, 50, 50, 50, 20, 40, 40, 50, 40, 50, 20, 30, 20, 20

Devolverá: 15 (15 tiradas hasta que han salido 2 20s seguidos)

Random numAzar = new Random();
girarRuleta(numAzar, 3);

Tiradas: 50, 50, 50, 20, 40, 20, 40, 20, 20, 20

Devolverá: 10 (10 tiradas hasta que han salido 3 20s seguidos)
*/
import java.util.*;

public class Ejercicio08 {
   public static void main(String[] args) {
      Random numAzar = new Random(10);
      int total = girarRuleta(numAzar, 2);
      System.out.println("Tiradas totales: " + total);
   }
   public static int girarRuleta(Random numeroAzar, int numero){
      int numAzar = 0;
      int cont = 0;
      int numeroSalida = 0;
      int[] ruleta = {20, 30, 40, 50, 60};
      System.out.print("Tiradas: ");
      do{
         do{
            numAzar = numeroAzar.nextInt(5);
            System.out.print(ruleta[numAzar] + ", ");
            cont++;
         }while(ruleta[numAzar] != 20);
         numeroSalida++;
      }while(numero != numeroSalida);
      System.out.println();
      
      return cont;
   }
}