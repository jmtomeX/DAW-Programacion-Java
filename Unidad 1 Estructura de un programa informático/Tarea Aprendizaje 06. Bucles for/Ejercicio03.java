/*
Corrige este programa para que visualice por consola lo siguiente:

0 al cubo = 0
1 al cubo = 1
2 al cubo = 8
3 al cubo = 27
4 al cubo = 64
Ultimo cubo = 64
*/

public class Ejercicio03 {
   public static void main(String[] args) {
      int cubo =0;
      for (int i = 0; i < 5; i++) {
         cubo = i * i * i;
         System.out.println(i + " al cubo = " + cubo);
        
      }
      System.out.println("Ultimo cubo = " + cubo);
   }
}