public class FiguraConConstante {
   public static final int SIZE = 6; //Valor constante para todo el programa
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
      for(int i = 0; i < (SIZE * 4 - 2); i++){
         System.out.print("-");
      }
      System.out.println("+");
   }
   
   
   public static void dibujarParteSuperior(){
   //Dibujar parte superior de la figura
   
      for(int linea = 1; linea <= SIZE; linea++){
         System.out.print("|");
      //Espacios en blanco
         for(int i = 1; i<= linea + (SIZE - 3); i++){
            System.out.print(" ");
         }
         System.out.print("\\\\");
      
      //Puntos
         for(int i = 1; i<=  -2 * linea  + (SIZE * 2); i++){
            System.out.print(".");
         }
         System.out.print("//");
      
      //Espacios en blanco
         for(int i = 1; i<= linea + (SIZE - 3); i++){
            System.out.print(" ");
         }
         System.out.println("|");
      }
   }
   
   
   public static void dibujarParteInferior(){
    //Dibujar parte inferior de la figura
   
      for(int linea = 1; linea <= SIZE; linea++){
         System.out.print("|");
      //Espacios en blanco
         for(int i = 1; i<= -linea + (SIZE * 2 - 2); i++){
            System.out.print(" ");
         }
         System.out.print("//");
      
      //Puntos
         for(int i = 1; i<=  2 * linea - 2; i++){
            System.out.print(".");
         }
         System.out.print("\\\\");
      
      //Espacios en blanco
         for(int i = 1; i<= -linea + (SIZE  * 2 - 2);i++){
            System.out.print(" ");
         }
         System.out.println("|");
      }
   
   }
   

   
}