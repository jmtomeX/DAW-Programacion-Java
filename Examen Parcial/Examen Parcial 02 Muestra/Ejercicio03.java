public class Ejercicio03 {
   public static void main(String[] args) {
      System.out.println(metodo(4, 1));
      System.out.println(metodo(1, 4));
      System.out.println(metodo(2, 5));
   }

   public static int metodo(int x, int y) {      
      y = y * 2; 
      
      while (y > x) { 
         if (x % 2 == 1) { 
            x++;
            y--; 
         } else if (y % 2 == 0) { 
            y /= 2; 
         } else { 
            x++; 
            y = y - 2; 
         }
      }
      
      return x; 
   }
}