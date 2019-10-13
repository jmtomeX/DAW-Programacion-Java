/*
Completa el programa escribiendo el código indicado para que muestre lo siguiente por consola:

!!!!!!!!
\\!!!!!!
\\\\!!!!
\\\\\\!!
*/


public class Ejercicio01 {
   public static void main(String[] args) {
      for (int linea = 1; linea <= 4; linea++) {
         for(int j = 0; j < (2 * linea) -2; j++) {
            System.out.print("\\");
         }
         for(int i = 0; i < (-2 * linea) + 10; i++) {
         
            System.out.print("¡");
         }
         System.out.println();
      }
   }
}