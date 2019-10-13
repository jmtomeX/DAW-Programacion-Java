import java.util.*;

public class LimitarNumero {
   public static void main(String[] args) {
   //Crea un array y lo muestra antes y despúes de pasarlo a un método
      //Los valores mayores que 10 los deja en 10 y los menores de 0 en 0
   
      double[] vals = {-10.2, 3.5, 9.7, 12.5, 1.3, -0.4, 11.1, 10.0};
      double[] vals2 = {-10.2, 3.5, 9.7, 12.5, 1.3, -0.4, 11.1, 10.0};
      System.out.println(Arrays.toString(vals));
      limitar(vals, 0, 10);
      System.out.println(Arrays.toString(vals));
      limitarCorto(vals2, 1,11);
      System.out.println(Arrays.toString(vals2));
   }
    // Método que recorre un array
   // Todos los valores mayores que max se sustituyen por max
   // Todos los valores menores que min se sustituyen por min
   public static void limitar(double[] nums, double min, double max) {
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] > max) {
            nums[i] = max;    // limitar a 10. 
         }
         nums[i] = Math.max(min, nums[i]);   // Limitar a 0
      }
   }
   //También se podría hacer con Math.min(max, nums[i])
   public static void limitarCorto(double[] nums, double min, double max){
      for (int i = 0; i < nums.length; i++) {
         if(nums[i] > max) {
            nums[i] = Math.min(max, nums[i]);//Limitar a 10.
         }
         nums[i] = Math.max(min, nums[i]);// Limitar a 0 
      
      }
   }
}