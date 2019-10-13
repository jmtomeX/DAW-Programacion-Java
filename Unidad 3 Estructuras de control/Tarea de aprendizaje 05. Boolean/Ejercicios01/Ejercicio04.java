/*
Corrige el método tieneDigito3() al que se le pasa un número y devuelve true si al menos uno de sus digitos es 3 y false en caso contrario.
 Recuerda que para obtener el último dígito de un número solo tienes que calcular el resto de la división por 10:
Por ejemplo:
System.out.println(tieneDigito3(423));
true
System.out.println(tieneDigito3(672));
System.out.println(tieneDigito3(672));
false
*/

public class Ejercicio04 {
   public static void main(String[] args) {
      System.out.println(tieneDigito3(423));
      System.out.println(tieneDigito3(672));
   }
   public static boolean tieneDigito3(int num) {
      while (num > 0) {
         int digito = num % 10;
         if (digito == 3) {
            return true;
         }
         num = num /10;
      } 
      return false;  
   }
}