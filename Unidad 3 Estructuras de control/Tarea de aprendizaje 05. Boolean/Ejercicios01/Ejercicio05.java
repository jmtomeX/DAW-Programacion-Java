/*
Indica el valor de las siguientes expresiones en los diferentes puntos del programa. Habrá condiciones que
según los valores que tomen las variables, se podrán cumplir siempre, nunca o algunas veces:
Punto     	b == 0         a == 0         0b == a
*/
import java.util.*;
public class Ejercicio05 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.println(mystery(teclado));
   }
   public static int mystery(Scanner teclado) {
      int a = 0;
      int cont = 0;
      int b = teclado.nextInt();
   // Point A
      while (b != 0) {
      // Point B
         if (b == a) {
         // Point C
            cont++;
         }
         a = b;
         b = teclado.nextInt();
      // Point D
      }
   // Point E
      return cont;
   }
}