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

public class Ejercicio08_Bien {
   public static void main(String[] args) {
      Random numAzar = new Random(10);
      int total = girarRuleta(numAzar, 2);
      System.out.println("Tiradas totales: " + total);
   }
   public static int girarRuleta (Random ruleta, int fin) {
      int cont = 0;
      int num = (ruleta.nextInt(5) + 2) * 10;
      System.out.print("Tiradas: " + num);
      if (num == 20) {
         cont++;
      }
      int tiradas = 1; 
      while (cont < fin) {
         num = (ruleta.nextInt(5) + 2) * 10;
         System.out.print(", " + num);
         tiradas++;
         if (num == 20) {
            cont++;
         } else {
            cont = 0;
         }
      }
      System.out.println();
        
      return tiradas;
   }
}