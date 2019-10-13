/*
Crea el método repetir(). Se le pasará:
    una palabra
    un número

Devolverá la palabra repetida el número de veces indicado:

System.out.println(repetir("casa", 3));

casacasacasa
*/

public class Ejercicio01{
   public static void main(String[] args){
      System.out.println(repetir("casa", 3));
   }
   public static String repetir(String palabra, int numrept){
      String pso ="";
      for(int i = 1; i <= numrept; i++){
         pso += palabra;
      }
      return pso;
   }
}