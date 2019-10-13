/*Escribe el código para el método porcentajeImpares. Recibirá como parámetro un array y devolverá el porcentaje
 de números impares que tiene el array. Si el array está vacío o no tiene impares devolverá un 0.0:

int[] nums = {12, 4, 7, 25};
double resultado = porcentajeImpares(nums);
System.out.printf("Resultado: %.2f%%", resultado);

Resultado: 50.00%
*/

import java.util.*;

public class Ejercicio10 {
   public static void main(String[] args){
      int[] nums = {};
      double resultado = porcentajeImpares(nums);
      System.out.printf("Resultado: %.2f%%", resultado);
   } 
   public static double porcentajeImpares(int[] numeros){
      int cont = 0;
      double result;
      if(numeros == null || numeros.length == 0){
         result = 0.0;
      }else{
         for(int i = 0; i < numeros.length; i++){
            if(numeros[i] % 2 == 1){
               cont++;
            }
         }
         result = (cont*100)/numeros.length;
      }
      return result;
   }
}