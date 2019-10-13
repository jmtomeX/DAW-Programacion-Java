public class Ejercicio01{
   public static void main(String[] args){
      ifElse(8, 3);
      ifElse(4, 8); 	
      ifElse(4, 3); 	
      ifElse(8, 8); 	
      ifElse(1, 4);
   }
 
 
   public static void ifElse(int a, int b) {
      if (a > b / 2) {
         b++;
      } else if (a <= b) {
         a = b * 2;
      }
      if (b > a) {
         b--;
      } else {
         a = 7;
      }
      System.out.println(a + " " + b);
   }
   
}