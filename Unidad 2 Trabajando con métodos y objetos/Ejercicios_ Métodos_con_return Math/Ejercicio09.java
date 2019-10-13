public class Ejercicio09 {
   public static void main(String[] args) {
      int x = 0, y = 5, z = 10;
      
      z = mostrar(x, z, y);
      System.out.println("z " + z);
      System.out.println(x + " " + y + " " + z);
      System.out.println("///////////////////");
      
      x = mostrar(z, z, x);
      System.out.println("x " + x);
      System.out.println(x + " " + y + " " + z);
      System.out.println("///////////////////");
     
      y = mostrar(y, y, z);
      System.out.println("y " + y);
      System.out.println(x + " " + y + " " + z);
     
   }

   public static int mostrar(int z, int x, int y) {
      z -= 2;
      x = z / 2 + y;
      y = x + 4;
      System.out.println("y = " + y + " " + "z = " + z);
      return x;
   }
}