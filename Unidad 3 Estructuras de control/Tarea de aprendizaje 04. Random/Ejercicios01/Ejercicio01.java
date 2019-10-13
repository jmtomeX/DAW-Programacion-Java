import java.util.*;
public class Ejercicio01 {
   public static void main(String[] args) {
   
      Random rand = new Random();
      int a = rand.nextInt(6) * 2;
      int b = rand.nextInt(8) - 3;
      int c = rand.nextInt(2 * 5);
      int d = 0;
      int  menor = 0;
      int  mayor = 0;
      int cont = 0;
      while(cont != 100){
         d = rand.nextInt(3) * 4 + 5;
         menor = Math.min(menor, d);
         mayor = Math.max(mayor,d );
         cont++;
         System.out.println(cont + " - El número mayor es " + mayor + " y el menor es " + menor);
      }   
      System.out.println("El número mayor es " + mayor + " y el menor es " + menor);
      System.out.println("a -> " + a);
      System.out.println("b -> " + b);
      System.out.println("c -> " + c);
      System.out.println("d -> " + d);
         
   }
}