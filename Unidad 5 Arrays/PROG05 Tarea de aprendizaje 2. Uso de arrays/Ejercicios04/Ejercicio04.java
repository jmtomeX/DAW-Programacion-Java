import java.util.*;
public class Ejercicio04 {
   public static void main(String[] args) {
      int[] nums1 = {1, 2, 3, 4, 5};
      int[] nums2 = {1, 5, 10, 15, 25};
       
      for (int i = 0; i < nums1.length; i++) {
         nums1[i] += nums2[nums2.length - 1 - i];
      } 
      System.out.println(Arrays.toString(nums1));
   }
}