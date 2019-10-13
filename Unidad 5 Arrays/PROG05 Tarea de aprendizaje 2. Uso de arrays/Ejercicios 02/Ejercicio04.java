import java.util.*;
public class Ejercicio04 {
   public static void main(String[] args) {
      //int[] nums = {5}; 	
      //int[] nums = {15, 5}; 	
      //int[] nums = {15, 8, 9, 5, 5}; 	
      int[] nums = {5, 1, 3, 2, 0, 5};
      for (int i = 0; i < nums.length - 1; i++) {
         if (nums[i] > nums[i + 1]) {
            nums[i + 1]++;
         }
      }
   
      System.out.println(Arrays.toString(nums));
   }
}