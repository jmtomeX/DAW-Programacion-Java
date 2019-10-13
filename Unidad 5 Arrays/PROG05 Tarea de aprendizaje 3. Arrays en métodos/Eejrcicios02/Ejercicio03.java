import java.util.*;
public class Ejercicio03 {
   public static void main(String[] args) {     
      //int[] a = {1, 2, 3, 4, 5};
      //int[] a = {0, 5, 10, 15, 20, 25}; 	
      int[] a = {1}; 	
     //int[] a = {1, 3, 5};
      metodo(a);
      System.out.println(Arrays.toString(a));
   }
   
   public static void metodo(int[] lista) {
      for (int i = lista.length - 1; i > 0; i = i - 2) {
         int aux = lista[i];
         lista[i] = lista[i - 1];
         lista[i - 1] = aux;
      }
   }
}