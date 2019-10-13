/*Escribe el código para el método porcentajeImpares. Recibirá como parámetro un array 
y devolverá el porcentaje de números impares que tiene el array. Si el array está vacío o no tiene impares devolverá un 0.0:
Resultado: 50.00%
Se supone que el array siempre tendrá al menos un elemento
*/
public class Ejercicio10{
   public static void main(String[] args){
      int[] nums = {12, 4, 7, 25};
      //int[] nums = {};
      double resultado = porcentajeImpares(nums);
      System.out.printf("Resultado: %.2f%%", resultado);
   
   }
   public static double porcentajeImpares(int[] numeros){
      double porcentaje = 0.0;
      int cont = 0;
      if(numeros == null || numeros.length == 0){
         return  0.0;
      }else{
      
         for(int i = 0; i <= numeros.length - 1; i++){
            if(numeros[i] % 2 == 1){
               cont++;
            }    
         }
         porcentaje = (100 * cont) / numeros.length;
      }
      return porcentaje;
   }
}


