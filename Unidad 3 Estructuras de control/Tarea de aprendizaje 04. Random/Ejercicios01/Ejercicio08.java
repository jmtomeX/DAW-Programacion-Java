//Estudia el siguiente método y elige las opciones correctas:
import java.util.*;
public class Ejercicio08 {
   public static void main(String[] args) {
      Random r = new Random();
      System.out.println("El número total de veces es " + producto(2, r));
   }
   public static int producto(int num, Random r) {
      int cont = 0;
      int num1, num2;
      do {
         num1 = r.nextInt(10) + 1;
         num2 = r.nextInt(10) + 1;
         System.out.println(num1 + " x " + num2 + " = " + num1 * num2);
         cont++;
      } while(num1 * num2 != num);
      return cont;
   }
}