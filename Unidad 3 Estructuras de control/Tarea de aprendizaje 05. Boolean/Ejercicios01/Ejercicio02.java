 //Tenemos el siguiente método.
 
public class Ejercicio02 {
   public static void main(String[] args) {
      System.out.println(metodo (5, 5));
      System.out.println(metodo (5, 8));
      System.out.println(metodo (12, 4));
      System.out.println(metodo (21, 35));
   }
   public static int metodo(int a, int b) {
      while (a != 0 && b != 0) {
         if (a < b) {
            b -= a;
         } else {
            a -= b;
         }
      }
      return a + b;
   }
}