/*
Crea el método repetir(). Se le pasará:
    una palabra
    un número

Devolverá la palabra repetida el número de veces indicado:

System.out.println(repetir("casa", 3));

casacasacasa
*/

public class Ejercicio00001{
   public static void main(String[] args){
      repetir("casa", 3);
   }
   public static void repetir(String palabra, int numrept){
      for(int i = 1; i <= numrept; i++){
         System.out.print(palabra);
      }
     
   }
}