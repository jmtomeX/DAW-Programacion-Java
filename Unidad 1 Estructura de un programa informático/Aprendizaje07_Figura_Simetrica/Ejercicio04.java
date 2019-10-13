/*Completa el programa escribiendo el código indicado para que muestre lo siguiente por consola:
!!!!!!!!!!!!!!!!!!!!!!
\\!!!!!!!!!!!!!!!!!!//
\\\\!!!!!!!!!!!!!!////
\\\\\\!!!!!!!!!!//////
\\\\\\\\!!!!!!////////
\\\\\\\\\\!!//////////
*/

public class Ejercicio04 {
   public static void main(String[] args) {
      for (int linea = 1; linea <= 6; linea++) {
         for(int i = 0; i < (2 * linea) - 2; i++) {
            System.out.print("\\");
         }
         for(int j = 0; j < (-2 * linea) + 13; j++) {
            System.out.print("!");
            
         }
         for(int k = 0; k < (-2 * linea) + 13; k++) {
            System.out.print("!");
            
         }
         for(int l = 0; l <(2 * linea) - 2 ; l++) {
            System.out.print("/");
         }
         System.out.println();
      }  
   }
}