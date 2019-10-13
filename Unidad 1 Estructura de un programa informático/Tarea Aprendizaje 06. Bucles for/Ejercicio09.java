/*
Escribe el método problema() para que muestre por pantalla el siguiente resultado:

         |         |         |         |         |         |
123456789012345678901234567890123456789012345678901234567890
*/
public class Ejercicio09 {
   public static void main(String[] args) {
   
      for( int i = 1; i <= 6; i++ ){
         for(int j = 1; j <= 9; j++){
            System.out.print(" ");   
         }
         System.out.print("|");
      }
      System.out.println();
      
      for( int i = 1; i <= 6; i++ ){
         for(int j = 1; j <= 9; j++){
            System.out.print(j);   
         }
         System.out.print("0");
      
      }
   }
}
