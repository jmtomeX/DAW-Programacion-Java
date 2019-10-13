/*
Indica el valor de las siguientes expresiones en los diferentes puntos del programa.
Habrá condiciones que según los valores que tomen las variables, se podrán cumplir siempre, nunca o algunas veces:
*/
import java.util.*;
public class Ejercicio08 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.println(metodo(teclado, 34));
   }
   public static int metodo(Scanner teclado, int a) {
      int b = teclado.nextInt();
      int cont = 0;
   
   // Punto A
      while (b < a) {
      // Punto B
         if (b == 0) {
            cont++;
         // Point C
         }
         b = teclado.nextInt();
      // Point D
      }
   // Point E
      return cont;
   }
}