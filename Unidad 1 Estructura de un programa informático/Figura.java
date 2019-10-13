public class Figura {
   public static void main(String[] args) {
      dibujaLinea();
      dibujarParteSuperior();
      dibujarParteInferior();
      dibujaLinea();
   
   }
   
/////////////////////////////// Métodos ///////////////////////////////////////////
  
  //Dibujar la línea que aparece en la parte superior e inferior
  // de la figura
   public static void dibujaLinea(){
      System.out.print("+");
      //Dibujar simbolo - 14 veces
      for(int i = 0; i < 14; i++){
         System.out.print("-");
      }
      System.out.println("+");
   }
   
   
   public static void dibujarParteSuperior(){
   //Dibujar parte superior de la figura
   
      for(int linea = 1; linea <= 4; linea++){
         System.out.print("|");
      //Espacios en blanco
         for(int i = 1; i<= linea + 1; i++){
            System.out.print(" ");
         }
         System.out.print("\\\\");
      
      //Puntos
         for(int i = 1; i<=  -2 * linea  + 8; i++){
            System.out.print(".");
         }
         System.out.print("//");
      
      //Espacios en blanco
         for(int i = 1; i<= linea + 1; i++){
            System.out.print(" ");
         }
         System.out.println("|");
      }
   }
   
   
   public static void dibujarParteInferior(){
    //Dibujar parte inferior de la figura
   
      for(int linea = 1; linea <= 4; linea++){
         System.out.print("|");
      //Espacios en blanco
         for(int i = 1; i<= -linea + 6; i++){
            System.out.print(" ");
         }
         System.out.print("//");
      
      //Puntos
         for(int i = 1; i<=  2 * linea  - 2; i++){
            System.out.print(".");
         }
         System.out.print("\\\\");
      
      //Espacios en blanco
         for(int i = 1; i<= -linea + 6;i++){
            System.out.print(" ");
         }
         System.out.println("|");
      }
   
   }
   

   
}