/*
Escribe el método problema() para que muestre lo siguiente por consola:

1    *    1
2   /*\   2
3  //*\\  3
4 ///*\\\ 4
*/

public class Ejercicio02 {
   public static void main(String[] args) {
      problema();
   }
   
   public static void problema(){
      for(int linea = 1; linea <= 4; linea++){
         System.out.print(linea);
         for(int i = 1; i <= -linea + 5;i++){
            System.out.print(" ");
         }
         for(int j = 1; j < linea ;j++){
            System.out.print("/");
         }
         System.out.print("*");  
         for(int j = 1; j < linea ;j++){
            System.out.print("\\");
         }
         for(int i = 1; i <= -linea + 5;i++){
            System.out.print(" ");
         }
         System.out.println(linea);
      }
   }  
}
