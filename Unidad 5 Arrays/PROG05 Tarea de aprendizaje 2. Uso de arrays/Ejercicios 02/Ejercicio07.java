/*
Corrige el siguiente método para que diga si en un array hay tres números consecutivos como se muestra a continuación.

int[] nums = {1, 3, 5, 7, 9};
boolean result = metodo(nums);
System.out.println("Resultado: " + result);

Resultado: false

int[] nums = {1, 3, 4, 5, 9};
boolean result = metodo(nums);
System.out.println("Resultado: " + result);

Resultado: true
*/
public class Ejercicio07 {
   public static void main(String[] args) {  
      int[] nums = {1, 3, 4, 5, 9};
      boolean result = metodo(nums);
      System.out.println("Resultado: " + result);
   }
   public static boolean metodo(int[] nums) {
      for (int i = 0; i < nums.length - 1 ; i++) {
         if (nums[i + 1] == nums[i] + 1 && nums[i + 2] == nums[i] + 2) {
            return true;
         }
      }
      return false;
   }
}