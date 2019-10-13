/*Corrige el método contarDigitos() para que a partir de un número, devuelva el número de dígitos que tiene. 
Recuerda que cada vez que divides un número por 10 desaparece un dígito.
Por ejemplo:
System.out.println(contarDigitos(4567));
4
System.out.println(contarDigitos(10924));
5
*/

public class Ejercicio07 {
   public static void main(String[] args) {
      System.out.println(contarDigitos(4567));
      System.out.println(contarDigitos(10924)); 
      System.out.println(contarDigitos(0));
   }
   public static int contarDigitos(int num) {
      int cont = 0;
      do {
         cont++;
         num = num / 10;
      } while (num > 0  );
      return cont;
   }
   
  
}