/*
Corrige el siguiente método para que devuelva la suma de todos los 
números hasta el número que se le pasa como parámetro:

System.out.println(suma(5));
15
System.out.println(suma(7));
28
*/
public class Ejercicio09{
   public static void main(String[] args){
      System.out.println(suma(5));
      System.out.println(suma(7));
   }
   public static int suma(int n) {
      int sum = 0;
      for (int i = 1; i <= n; i++) {
         sum += i;
      }
      return sum;
   }
}
