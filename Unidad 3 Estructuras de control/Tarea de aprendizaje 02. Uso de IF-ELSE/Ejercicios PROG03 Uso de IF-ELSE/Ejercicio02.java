/*
Corrige el método multiplicarNumeros() para que multiplique todos los números impares entre 2 dados.
Por ejemplo, si se le pasa los números 3 y 6, devolverá 15, es decir 3 * 5.
*/
public class Ejercicio02{
   public static void main(String [] args){
      System.out.println(multiplicarNumeros(4,9));
   }
   public static int multiplicarNumeros(int inicio, int fin) {
      int producto = 1;
      for ( int i = inicio  ; i <= fin; i++) {
         if(i % 2 != 0){
            producto *= i;
         }
      }
      return producto;
   }
}