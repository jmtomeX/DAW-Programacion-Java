public class Ejercicio10 {
   public static void main(String[] args) { 
      problema();
   }
   
   public static void problema() {
      for (int i = 1; i <= 3; i++) {
         for (int j = 1; j <= 4; j++) {
            System.out.print((i * j) + " ");
         }
         System.out.println();
      }
   }
      
}