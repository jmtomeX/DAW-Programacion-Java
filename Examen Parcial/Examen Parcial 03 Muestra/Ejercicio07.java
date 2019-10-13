/*
Crea el método combinarArrays que recibe 2 arrays de enteros como parámetros y devuelve un nuevo array
con la mitad de los elementos del primer array, seguidos del segundo array más la otra mitad del primer array.

Por ejemplo, si los arrays son:

int[] a = {2, 4, 6, 8, 10};
int[] b = {1, 1, 1};

Devolverá:

{2, 4, 1, 1, 1, 6, 8, 10}

Ten en cuenta que si el número de elementos del primer array es impar, la mitad más corta va delante.

En el método solo puedes crear el array que se va a devolver y no se pueden modificar los array originales.
*/
import java.util.*;

public class Ejercicio07 {
   public static void main(String[] args){
      int[] a = {2, 4, 6, 8, 10};
      int[] b = {1, 1, 1};
      int[] combinados = combinarArrays(a, b);
      System.out.println(Arrays.toString(combinados));
   }
   public static int[] combinarArrays(int[] ar1, int[] ar2){
      int[] arrayCombo = new int[ar1.length + ar2.length];
      int medio1 = ar1.length / 2;
      for(int i = 0; i < medio1; i++){
         arrayCombo[i] = ar1[i];
      }
      for(int i = 0; i < ar2.length; i++){
         arrayCombo[medio1 + i] = ar2[i];
      }
      for(int i = medio1; i < ar1.length; i++){
         arrayCombo[i + ar2.length] = ar1[i];
      }
      return arrayCombo;
   }
}