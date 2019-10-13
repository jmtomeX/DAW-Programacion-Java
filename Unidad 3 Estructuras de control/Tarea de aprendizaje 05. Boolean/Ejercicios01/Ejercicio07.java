/*Indica el valor de las siguientes expresiones en los diferentes puntos del programa. 
Habrá condiciones que según los valores que tomen las variables, se podrán cumplir siempre, nunca o algunas veces:
*/
import java.util.Random;
public class Ejercicio07 {
   public static void main(String[] args) {
      System.out.println(metodo(8));
   }
   public static int metodo(int num) {
      Random r = new Random();
      int x = r.nextInt(3) + 1;
      int y = 2;
   // Punto A
      while (num > y) {
      // Punto B
         y = y + x;
         if (x > 1) {
            num--;
         // Punto C
            x = r.nextInt(y) + 1;
         } else {
            x = y + 1;
         // Punto D
         }
      }
   // Punto E
      return num;
   }
}