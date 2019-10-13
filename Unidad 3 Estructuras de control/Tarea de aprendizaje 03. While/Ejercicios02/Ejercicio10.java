/*
Crea el método digitoMayor() al que se le pasa un número y devuelve cuál es el dígito mayor. El método también funcionará con números negativos.
Recuerda que para obtener el último dígito de un número solo tienes que calcular el resto de la división por 10:

Por ejemplo:

System.out.println(digitoMayor(423));
4
System.out.println(digitoMayor(672));
7
*/
public class Ejercicio10 {
   public static void main(String[] args) {
      System.out.println(digitoMayor(423));
      System.out.println(digitoMayor(672));
   }
   public static int digitoMayor(int num) {
      int mayor = num % 10;
      num = num / 10;
      while (num > 0) {
         mayor = Math.max(mayor, num % 10);
         num = num / 10;
      }
      return mayor;
   }   }