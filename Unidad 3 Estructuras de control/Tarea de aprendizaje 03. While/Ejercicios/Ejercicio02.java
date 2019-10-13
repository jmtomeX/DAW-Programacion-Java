//Indica cuántas veces se repite el siguiente bucle while:
//Se repite 3 veces

public class Ejercicio02 {
   public static void main(String[] args) {
      int x = 55;
      do {
         System.out.println(x);
         x = x / 2;
      } while (x % 2 != 0);
   }
}