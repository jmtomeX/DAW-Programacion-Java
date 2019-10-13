/*Tenemos el siguiente código:
[2, 5, 1, 8] 	==>  [2, 8, 2, 5, 1, 8, 5] 

[15, 10, 5, 30] 	==>   [30, 10, 30, 15, 10, 5, 30]

[-3, 13, 5, 7, 13] 	==>   [-3, 13, 5, 7, 13, 13, 7, 5, 13]

[12, 0, 2, 12, -2]  ==>   [2, 12, 2, -2, 12, 0, 2, 12, -2] 

*/
import java.util.*;
public class Ejercicios03 {
   public static void main(String[] args) {
      ArrayList<Integer> listaNumeros = new ArrayList<Integer>(Arrays.asList(12, 0, 2, 12, -2));
      metodo(listaNumeros);
   }
   public static void metodo(ArrayList<Integer> numeros) {
      for (int i = numeros.size() - 1; i > 0; i--) {
         int numero = numeros.get(i);
         if (numero % 2 == 1) {
            numeros.add(numero);
         } else {
            numeros.add(0, numero);
         }
      }
   }
}