//Tenemos el siguiente método.
class Ejercicio04 {
   public static void main(String[] args) {  
      bucleWhile(5); 	
      bucleWhile(2);  	
      bucleWhile(0); 	
      bucleWhile(-2);
   }
   public static void bucleWhile(int x) {
      int y = 2;
      int z = -2;
      while (x + 3 > y) {
         y = y + 2;
         z++;
         System.out.println("------------" + x + " " + y + " " + z);
      }
      System.out.println(x + " " + y + " " + z);
   }
}