import java.util.*;

public class CambiarNumerosArray {
   public static void main(String[] args) {
   // Crea un array y lo muestra antes y despúes de pasarlo a un método
      // Los cambios que se realizan en el método tienen efecto. Paso por referencia
      int[] nums = {1, 2, 3, 4, 5};
      System.out.println(Arrays.toString(nums));
      cambiar(nums);
      System.out.println(Arrays.toString(nums));
   }
   // Si pasamos un array, los cambios que se realizan se reflejan
   // fuera del método. Se dice que los arrays se pasan por referencia
   public static void cambiar(int[] lista) {
      lista[0] = -924;
      lista[1] = -42;
   }
}