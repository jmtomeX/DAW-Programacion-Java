import java.util.*;
public class Ejercicio05 {
   public static void main(String[] args) {
      int[] opciones = {0, 1, 2, 2, 1, 0, 0, 1, 0, 2, 0, 1, 1, 2};
      int[] contarOpciones = new int[3];
   
        
      for(int i = 0; i < opciones.length; i++) {
         int opcion = opciones[i];
         contarOpciones[opcion]++;
      }
      System.out.println(Arrays.toString(contarOpciones));
   }
}
