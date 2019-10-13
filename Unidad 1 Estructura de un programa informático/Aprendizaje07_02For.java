/*
Pregunta 3
Completa el programa escribiendo el código indicado para que muestre lo siguiente por consola:

+========+
|        |
|        |
|        |
|        |
+========+
|        |
|        |
|        |
|        |
+========+

*/


public class Aprendizaje07_02For {
   public static final int ANCHO = 8;
   public static final int ALTO = 4;
   
   public static void main(String[] args) {
      linea();
      bloque();
      linea();
      bloque();
      linea();
   }
   
   public static void linea() {
      //*Dibujamos el +
      System.out.print("+");
      //Dibujamos el =
      for(int i = 1; i <= ANCHO; i++){
         System.out.print("=");
      }
      //Dibujamos el +
      System.out.print("+");
      System.out.println();
   }
   
   public static void bloque() {
      //dibujamos la pipeta
      
      //Dibujamos el =
      for(int i = 1; i <= ALTO; i++){
         System.out.print("|");
         for(int j = 1; j <= ANCHO; j++){
            System.out.print(" ");
            
         }
      //Dibujamos la pipeta
         System.out.print("|");
         System.out.println(); 
      }
     
     
    
   }
}