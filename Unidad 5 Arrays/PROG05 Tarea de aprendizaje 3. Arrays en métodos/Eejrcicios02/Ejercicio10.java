/*
Escribe el código para el método series. Recibirá como parámetro un número y devolverá un array de series de la siguiente manera:

Por ejemplo:

int[] a = series(3);
System.out.println(Arrays.toString(a));

[1, 1, 2, 1, 2, 3] (3 series de 1, 2 y 3 números seguidos empezando por 1)

int[] a = series(4);
System.out.println(Arrays.toString(a));

[1, 1, 2, 1, 2, 3, 1, 2, 3, 4] (4 series de 1, 2, 3 y 4 números)

int[] a = series(2);
System.out.println(Arrays.toString(a));

[1, 1, 2] (2 series de 1 y 2 números)

 Para saber cuantos elementos tendrá el nuevo array puedes usar un for que lo calcule.
*/
import java.util.*;
public class Ejercicio10 {
   public static void main(String[] args) { 
      
      int[] a = series(10);
      System.out.println(Arrays.toString(a));
   }
   public static int[] series(int num) {
      int total = 0;
      for (int i = 1; i <= num; i++) {
         total += i;
      }
      int[] nums = new int[total];
    
      int indice = 0;
      for (int i = 1; i <= num; i++) {
         for (int serie = 1; serie <= i; serie++) {
            nums[indice] = serie;
            indice++;
         }
      }
   
      return nums;
   }
}