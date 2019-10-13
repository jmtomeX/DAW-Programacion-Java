/*
Crea el método combinarArrays que recibe 2 arrays de enteros ordenados como parámetros y devuelve un nuevo array también 
ordenado de la unión de esos 2 arrays.

Por ejemplo, si los arrays son:

int[] a = {2, 4, 6, 8, 10};
int[] b = {1, 5, 11};

Devolverá:

{1, 2, 4, 5, 6, 8, 10, 11}

En el método solo puedes crear el array que se va a devolver y no se pueden modificar los array originales. Además,
no se podrá usar Arrays.sort para ordenar el array final. Los diferentes números se deberán introducir en el nuevo
array en orden.
*/
import java.io.*;
import java.util.*;
public class Ejercicio08 {

   public static void main(String[] args) throws FileNotFoundException {
      int[] a = {2, 4, 6, 8, 10};
      int[] b = {1, 5 , 11};
      System.out.println(Arrays.toString(combinarArrays(a, b)));
   }
     
   public static int[] combinarArrays(int[] array1, int[] array2) {
   
      int[] nuevo = new int[array1.length + array2.length];
      int indice1 = 0;
      int indice2 = 0;
      int size = array2.length;
      for(int i = 0; i < nuevo.length; i++) {
         if(array1[indice1] <= array2[indice2]) {
            nuevo[i] = array1[indice1];
            indice1++;
         }else {
            nuevo[i] = array2[indice2];
            indice2++;
         }
         
         if(indice1 == array1.length) {
            for(int j = indice2; j < array2.length; j++) {
               i++;
               nuevo[i] = array2[j];
            }
         } else if(indice2 == array2.length) {
            for(int j = indice1; j < array1.length; j++) {
               i++;
               nuevo[i] = array1[j];
            }
         }
         
      }
     
      return nuevo;
   }
}