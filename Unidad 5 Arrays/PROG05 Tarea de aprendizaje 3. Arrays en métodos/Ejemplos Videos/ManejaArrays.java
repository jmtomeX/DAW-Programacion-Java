/* 
   Programa que demuestra la diferencia entre pasar como parámetro a un método
   un dato de alguno de los tipos primitivos y un array
*/
  
import java.util.*;

public class ManejaArrays {
   public static void main(String[] args) {
      
      /*Intercambia el valor entre 2 variables
      int a = 5;
      int b = 7;
      System.out.println(a + " " + b);
      intercambiar(a, b);
      System.out.println(a + " " + b);*/
      
      // Crea un array y lo muestra antes y despúes de pasarlo a un método
      // Los cambios que se realizan en el método tienen efecto. Paso por referencia
      int[] nums = {1, 2, 3, 4, 5};
      /*System.out.println(Arrays.toString(nums));
      cambiar(nums);
      System.out.println(Arrays.toString(nums));
      
      // Crea un array y lo muestra antes y despúes de pasarlo a un método
      // Los valores mayores que 10 los deja en 10 y los menores de 0 en 0
      System.out.println("Crea un array y lo muestra antes y despúes de pasarlo a un método");
      double[] vals = {-10.2, 3.5, 9.7, 12.5, 1.3, -0.4, 11.1, 10.0};
      System.out.println(Arrays.toString(vals));
      limitar(vals, 0, 10);
      System.out.println(Arrays.toString(vals));*/
      
      // Da la vuelta al array creando uno nuevo
      System.out.println("Da la vuelta al array creando uno nuevo");
      System.out.println(Arrays.toString(nums));
      int[] nums2 = darVuelta1(nums);
      System.out.println(Arrays.toString(nums));
      System.out.println(Arrays.toString(nums2));
      
      // Da la vuelta al array sin crear uno nuevo
      System.out.println(" Da la vuelta al array sin crear uno nuevo");
      System.out.println(Arrays.toString(nums));
      darVuelta2(nums);
      System.out.println(Arrays.toString(nums));
    
   }
   
   /* Este método intercambia el valor entre 2 variables utilizando una variable intermedia
   // Solo se cambia dentro del método
   // No tiene efecto fuera porque está trabajando con copias de las variables originales. Paso por valor
   System.out.println("");
   public static void intercambiar(int x, int y) {
      int temp = x;
      x = y;
      y = temp;
   }

   // Si pasamos un array, los cambios que se realizan se reflejan
   // fuera del método. Se dice que los arrays se pasan por referencia
   public static void cambiar(int[] lista) {
   System.out.println("Si pasamos un array, los cambios que se realizan se reflejan");
      lista[0] = -924;
      lista[1] = -42;
   }*/
   
   // Método que recorre un array
   // Todos los valores mayores que max se sustituyen por max
   // Todos los valores menores que min se sustituyen por min
   public static void limitar(double[] nums, double min, double max) {
      System.out.println("Método que recorre un array\nTodos los valores mayores que max se sustituyen por max\nTodos los valores menores que min se sustituyen por min");
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] > max) {
            nums[i] = max;    // limitar a 10. También se podría hacer con Math.min(max, nums[i])
         }
         nums[i] = Math.max(min, nums[i]);   // Limitar a 0
      }
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
   

   // Da la vuelta al array. El primer elemento será el ultimo, el último el primero...
   // Sin crear un nuevo array
   public static void darVuelta2(int[] lista) {
   
      // Solo hay que cambiar de posición la mitad del array
      for (int i = 0; i < lista.length / 2; i++) {
         // Calcula el índice del elemento con el que se debe cambiar
         int ultimo = lista.length - 1;
         int j = ultimo - i;
         // Intercambia los dos valores
         int temp = lista[i];
         lista[i] = lista[j];
         lista[j] = temp;
      }
   }
}