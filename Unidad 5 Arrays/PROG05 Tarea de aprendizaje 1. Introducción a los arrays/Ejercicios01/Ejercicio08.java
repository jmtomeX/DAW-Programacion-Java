import java.util.*;
public class Ejercicio08 {
   public static void main(String[] args) {
      int[] numeros =  new int[5];
      int[] numeros2 =  {43,543,4345,876,6574,65};
      imprimir(numeros);
      imprimir(numeros2);
   }
   public static void imprimir(int[] nums) {
      for (int i = nums.length - 1; i >= 0; i--) {
         System.out.println("Elemento [" + i + "]: " + nums[i]);
      }
      System.out.println();
   }
}
