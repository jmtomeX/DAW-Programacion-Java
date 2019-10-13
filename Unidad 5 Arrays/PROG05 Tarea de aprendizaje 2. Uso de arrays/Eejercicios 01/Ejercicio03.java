import java.util.*;
public class Ejercicio03 {
   public static void main(String[] args) {
      int[] nums = {5, 15, 25, 35, 45, 55, 65, 75, 85, 95};
        
      int num = nums[0];
      for (int i = 0; i < nums.length - 1; i++) {
         nums[i] = nums[i + 1];
      }
      nums[nums.length - 1] = num;
   
      System.out.println(Arrays.toString(nums));
   }
}