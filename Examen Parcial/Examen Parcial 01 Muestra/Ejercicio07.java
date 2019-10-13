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
   public static void main(String[] args) throws FileNotFoundException {
      int[] a = {2, 4, 6, 8, 10};
      int[] b = {1, 1, 1};
      int[] combinados = combinarArrays(a, b);
      System.out.println(Arrays.toString(combinados));
   }
   public static int[] combinarArrays(int[] array1, int[] array2){
      int[] nuevoCombinado = new int[array1.length + array2.length];
      for(int i = 0; i < nuevoCombinado.length; i++){
         if(i < array1.length / 2){
            nuevoCombinado[i] = array1[i];
         }else if(i >= array1.length / 2 && i < (array1.length / 2) + (array2.length)){
            for(int j = 0; j < array2.length; j++){
               nuevoCombinado[i] = array2[j];
               i++;
            }
            i--;
         }else{
            nuevoCombinado[i] = array1[(i) - array2.length];
         }
        
      }
      return nuevoCombinado;
   }
}