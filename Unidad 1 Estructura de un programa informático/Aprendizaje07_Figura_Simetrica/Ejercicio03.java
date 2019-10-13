/*
Corrige el programa para que muestre por consola lo siguiente:

1 3 5 7 9 11 13 15 17 19 21
AGUR
*/


public class Ejercicio03 {
   public static final int MAX_ODD = 21;

   public static void mostrarImpar() {
      for (int cont = 1; cont <= MAX_ODD  ; cont++) {
         System.out.print(cont + " ");
         cont = cont + 1;
         
      }
      System.out.println();
   }
   public static void main(String[] args) {
      mostrarImpar();
      System.out.print("AGUR");
   }
}