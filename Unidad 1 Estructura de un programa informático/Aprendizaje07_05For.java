/*
Escribe el método problema() para que muestre lo siguiente por consola:

////////////
//////////\\
////////\\\\
//////\\\\\\
////\\\\\\\\
//\\\\\\\\\\
\\\\\\\\\\\\
*/

public class Aprendizaje07_05For {
   public static  int lineas = 0; 
   public static void main(String[] args) {
      for(lineas = 1; lineas <=7;  lineas++){
         bloque();
      }
   }
   public static void bloque(){
   //dibujamos las barras
      for(int i = 1; i<=  -2 * lineas  + 14; i++){
         System.out.print("/");
      }
   //dibujamos las contrabarras
      for(int i = 1; i <= 2 * lineas - 2;i++){
         System.out.print("\\");
      }
   //for
      System.out.println();
   }
}

