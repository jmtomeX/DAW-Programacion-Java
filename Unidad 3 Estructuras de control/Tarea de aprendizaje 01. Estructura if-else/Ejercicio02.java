/*Corrige el siguiente programa para que muestre lo siguiente por consola:

x es menor
*/



public class Ejercicio02 {
   public static void main(String[] args) {
      int x = 23, y = 45;
      int menor = esMenor(x, y);
      if(menor == x) {
         System.out.println("x es menor");
      }else{
         System.out.println("y es menor");
      }int a = 67;
      if(a >= (x+y)){
         System.out.println("A es mayor");
      }
   }
   
   public static int esMenor(int a, int b) {
      int menor = 0;
      if (a < b) {
         menor = a;
      } else if (a >= b) {
         menor = b;
      }
      return   menor;
   }
}