import java.util.*;

public class DarVueltaArray {
   public static void main(String[] args) {
   
     // Da la vuelta al array creando uno nuevo
      int[] nums = {1, 2, 3, 4, 5};
      System.out.println(Arrays.toString(nums));
      int[] nums2 = darVuelta1(nums);
      System.out.println(Arrays.toString(nums));
      System.out.println(Arrays.toString(nums2));  
   }
   // Da la vuelta al array. El primer elemento será el ultimo, el último el primero...
   // Crea un nuevo array
   public static int[] darVuelta1(int[] lista) {
      // Crea un array con la misma cantidad de elementos que el original
      int longi = lista.length;
      int[] nuevoArray = new int[longi];
      
      // Recorremos el array original y guardamos cada elemento en la posición inversa
      // El primero en la última posición, el segundo en la penúltima...
      // Índice del último elemento
      int ultimo = longi - 1;
      for (int i = 0; i < longi; i++) {
         // Posición en el núevo array
         // Guarda el valor en el nuevo array
         int j = ultimo - i;
         nuevoArray[j] = lista[i];
      }
      return nuevoArray;
   }  
}