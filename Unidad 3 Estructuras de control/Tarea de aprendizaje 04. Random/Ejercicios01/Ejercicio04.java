/*
Ordena el programa para que genere 4 números aleatorios entre 0 y 100, ambos incluidos.
Por ejemplo:
Numero 1: 11
Numero 2: 91
Numero 3: 34
Numero 4: 70
*/
import java.util.*;
public class Ejercicio04 {
   public static void main(String[] args) {
      Random r = new Random();
      for(int i = 1; i <= 4; i++){
         System.out.println("Número " + i + ": " + r.nextInt(101));
      }
   }
}
