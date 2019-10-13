import java.util.*;
public class Ejercicio04 {
   public static void main(String[] args) {   
   //int[] a = {5, 15}; 	
      //int[] a = {5, 4, 12, 10}; 	
      //int[] a = {1}; 	
      int[] a = {8, 2, 10, 4, 10, 9};
      System.out.println(metodo(a));
   }
   public static int metodo(int[] lista) {
      int x = 0;
      for (int i = 1; i < lista.length; i++) {
         int y = lista[i] - lista[0];
         if (y > x) {
            x = y;
         }
      }
      return x;
   }
}