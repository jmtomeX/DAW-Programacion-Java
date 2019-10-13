import java.util.*;
public class Ejercicio03 {
   public static void main(String[] args) {     
      int[] a = {1, 2, 3, 4, 5};
      int[] b = {5, 0, 10, 15, 30, 25};
      int[] c = {1};
      
      metodo(a);
      System.out.println(Arrays.toString(a));
      metodo(b);
      System.out.println(Arrays.toString(b));
      metodo(c);
      System.out.println(Arrays.toString(c));
   }
   
   public static void metodo(int[] nums) {
      for (int i = 0; i < nums.length - 1; i++) {
         if (nums[i] > nums[i + 1]) {
            nums[i + 1]++;
         }
      }
   }
}