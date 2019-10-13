/*
Crea el método esMenorResta() al que se le pasan 3 números en cualquier orden y devuelve true si uno de ellos
es menor que la resta de los otros 2 y false en caso contrario. Recuerda que puedes obtener el valor absoluto de un número con la clase Math:
Por ejemplo:
System.out.println(esMenorResta(4, 18, 6));
true
System.out.println(esMenorResta(6, 7, 2));
false
*/
public class Ejercicio09 {
   public static void main(String[] args) {
      System.out.println(esMenorResta(6, 7, 2));
      System.out.println(esMenorResta(4, 18, 6));
   }
   public static boolean esMenorResta(int num1, int num2, int num3){
      int num = Math.abs(num1-num2);
      if(num > num3) {
         return true;
      }
      return false;
   }
}