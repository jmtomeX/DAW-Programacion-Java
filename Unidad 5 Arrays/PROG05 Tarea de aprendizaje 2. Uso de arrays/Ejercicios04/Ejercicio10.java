/*Escribe el código para el método capicua. Recibirá como parámetro un array de números y devolverá true si el array es capicúa y false en caso contrario.:

int[] nums1 = {12, 4, 7, 25};
boolean resultado = capicua(nums);
System.out.println("Resultado: " + resultado);

Resultado: false

int[] nums1 = {2, 4, 7, 4, 2};
boolean resultado = capicua(nums);
System.out.println("Resultado: " + resultado);

Resultado: true
*/
import java.util.*;

public class Ejercicio10 {
   public static void main(String[] args) {
      int[] nums =  {12, 4, 7, 25};
      boolean resultado = capicua(nums);
      System.out.println("Resultado: " + resultado);
   }
   public static boolean capicua(int[] numeros){
     
      for(int i = 0; i < numeros.length/2; i++){
         System.out.println(numeros[i] + " " +  numeros[numeros.length - 1 -i]);
         if(numeros[i] != numeros[numeros.length - 1 -i]){
            return false;
         }
      }
      return true;
   }
}