/*
Corrige el método esPrimo() al que se le pasa un número y devuelve true si es un número primo y false en caso contrario.
 Recuerda que un número primo solo es divisible por 1 y por él mismo:
Por ejemplo:
System.out.println(esPrimo(3));
true
System.out.println(esPrimo(6));
false
*/
public class Ejercicio06 {
   public static void main(String[] args) {
      System.out.println(esPrimo(3));
      System.out.println(esPrimo(6));
      System.out.println(esPrimo(7));
      System.out.println(esPrimo(189));
      System.out.println(esPrimo(83));
   }
   public static boolean esPrimo(int num) {
      boolean primo = true; 
      for(int i = 2; i < num; i++) {
         if (num % i == 0) {
            primo = false;
         }
      }
      return primo;
   }
}