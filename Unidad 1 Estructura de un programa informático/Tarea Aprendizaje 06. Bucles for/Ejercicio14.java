/*
Completa el programa escribiendo el código del metodo1 para que muestre lo siguiente por consola:

2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
*/

public class Ejercicio14 {
   public static void main(String[] args) {
      problema();
   }
   public static void problema() {
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < i; j++) {
            System.out.print(" ");
         }
         for (int j = 0; j < 2 *(5 - i) - 1; j++) {
            System.out.print(".");
         }
         System.out.println();
      }
   }
}