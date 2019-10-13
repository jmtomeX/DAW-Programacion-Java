//Tarea Aprendizaje 07. Figura simétrica

/*
Completa el programa escribiendo el código indicado para que muestre lo siguiente por consola:

!******  1  ******!
!*****   2   *****!
!****    3    ****!
!***     4     ***!
!**      5      **!

!******  1  ******!
!*****   2   *****!
!****    3    ****!
!***     4     ***!
!**      5      **!

!******  1  ******!
!*****   2   *****!
!****    3    ****!
!***     4     ***!
!**      5      **!
*/

public class Aprendizaje07For {
   public static void main(String[] args) {
      for(int i = 0; i < 3; i++) {
         bloque();
         System.out.println();
      }
   }
    ///Método
   public static void bloque() {
      for(int linea = 1; linea <= 5 ; linea++){
         System.out.print("¡");
      //Estrellas
         for(int i = 0; i < - linea + 7; i++) {
            System.out.print("*");  
         }
         
      //Espacios blanco
         for(int i = 0; i <  linea + 1; i++) {
            System.out.print(" ");  
         }
      //Números
         System.out.print(linea);
      //Espacios blanco
         for(int i = 0; i <  linea + 1; i++) {
            System.out.print(" ");  
         }
      //Estrellas
         for(int i = 0; i < - linea + 7; i++) {
            System.out.print("*");  
         }
      
      
         System.out.print("¡");
      
         System.out.println();
      }
   }
   
}