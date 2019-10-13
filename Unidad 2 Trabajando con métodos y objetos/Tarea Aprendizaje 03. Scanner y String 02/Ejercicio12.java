/*
Crea el método palabraVertical().

Se le pasará una palabra y escribirá por consola la misma palabra en mayúsculas y en vertical. Es decir, una letra por línea.

palabraVertical("hola");

H
O
L
A
*/
public class Ejercicio12 {
   public static void main(String[] args) {
      palabraVertical("hola");
   }
   public static void palabraVertical(String palabra){
      for(int i = 0; i < palabra.length(); i++){
         System.out.println(palabra.toUpperCase().charAt(i));
      }
   }
}
