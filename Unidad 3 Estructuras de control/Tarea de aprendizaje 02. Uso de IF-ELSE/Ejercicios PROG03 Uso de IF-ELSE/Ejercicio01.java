/*
Corrige el método contarNegativos() para que diga cuantos números negativos hay entre 3 dados.
Por ejemplo, si se le pasan los números -3, -7 y 6, devolverá 2 porque dos números son negativos.
*/

public class Ejercicio01{   
   public static void main(String[] args){
      System.out.println(contarNegativos(-32,-3,-34));
   }
   public static int contarNegativos(int num1, int num2, int num3) {
      int contador = 0;
      if (num1 < 0) {
         contador++;
      }  
      if (num2 < 0) {
         contador++;
      }  
      if (num3 < 0) {
         contador++;
      }
      return contador;
   }
}