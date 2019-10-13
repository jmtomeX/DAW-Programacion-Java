import java.util.*;
public class Ejercicio04 {
   public static void main(String[] args) {
      //int[] a = {1, 2, 7, 6, 3};
      int[] a = {-2, 5, 4, 6, -5};
      metodo(a);
    
      System.out.println(Arrays.toString(a));
      //System.out.println(metodo());
      //System.out.println(metodo());
   }
  
   public static void metodo(int[] a) { 
      System.out.println(a.length -1); 
      for (int i = 1; i < a.length - 1; i++) { 
         a[i] = (a[i - 1] + a[i + 1]) / 2; 
      } 
   }
}