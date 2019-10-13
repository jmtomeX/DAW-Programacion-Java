  

public class Ejercicio05 {
   public static void main(String[] args) {
   
      ifElse(8, 3);
      ifElse(4, 8);
      ifElse(4, 3); 	
      ifElse(8, 8); 	
      ifElse(4, 4);
   
   }
   public static void ifElse(int a, int b) {
      int c = 5;
      if (a > b) {
         b = a - 1;
      } else {
         a = c + 1;
      }
      if (c > a) {
         c++;
      }
      System.out.println("a: " + a + " b: " + b + " c: " + c);
   }
   
   
}