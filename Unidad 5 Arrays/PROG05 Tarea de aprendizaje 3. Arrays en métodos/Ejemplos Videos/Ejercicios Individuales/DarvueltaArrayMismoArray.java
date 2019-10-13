import java.util.*;

public class DarvueltaArrayMismoArray {
   public static void main(String[] args) { 
      int[] nums = {1, 2, 3, 4, 5};
    // Da la vuelta al array sin crear uno nuevo
      System.out.println("");
      System.out.println(Arrays.toString(nums));
      darVuelta2(nums);
      System.out.println(Arrays.toString(nums));
      
   }
        // Da la vuelta al array. El primer elemento será el ultimo, el último el primero...
   // Sin crear un nuevo array
   public static void darVuelta2(int[] lista) {
   
      // Solo hay que cambiar de posición la mitad del array
      for (int i = 0; i < lista.length / 2; i++) {
         // Calcula el índice del elemento con el que se debe cambiar
         int j = lista.length - 1 - i;
         // Intercambia los dos valores
         int temp = lista[i];
         lista[i] = lista[j];
         lista[j] = temp;
      }
   }
}