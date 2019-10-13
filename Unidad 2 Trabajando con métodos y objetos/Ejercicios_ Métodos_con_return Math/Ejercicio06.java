/*
Corrige el método multiplicarNumeros() para que multiplique todos los números entre 2 dados.
Por ejemplo, si se le pasa los números 3 y 6, devolverá 360, es decir 3 * 4 * 5 * 6.
*/

public class Ejercicio06{
   public static void main(String[] args){
      System.out.println(multiplicarNumeros(3,6));
   }
   /*public static int multiplicarNumeros(int num1, int num2){
      int resultado = 1;
      for(int i = num1; i <= num2; i++ ){
         resultado   *= i;
      }
      return resultado;
   }*/
   public static int multiplicarNumeros(int inicio, int fin) {
      int producto = 1;
      for (int i = inicio; i <= fin; i++) {
         producto *= i;
      }
      return producto;
   }
   
}