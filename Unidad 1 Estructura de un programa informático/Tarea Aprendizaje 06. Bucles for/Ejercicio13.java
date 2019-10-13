/*
Escribe el programa Problema para que muestre por pantalla el siguiente resultado:

000111222333444555666777888999
000111222333444555666777888999
000111222333444555666777888999
*/

public class Ejercicio13 {
   public static void main(String[] args) { 
      for(int j = 1; j <=3; j++){
         for(int i = 0; i <=9; i++){
            for(int k = 1; k <= 3; k++){
               System.out.print(i);
            } 
         } 
         System.out.println();
      }  
   }
}