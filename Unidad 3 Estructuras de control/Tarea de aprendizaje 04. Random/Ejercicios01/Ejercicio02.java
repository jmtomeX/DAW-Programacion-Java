//Ordena el método siguiente para que genere 10 número aleatorios pares entre 0 y 200,
//los muestre por consola y los sume.
import java.util.*;
public class Ejercicio02 {
   public static void main(String[] args) {
      Random r = new Random();
      numeros(r);
   }
   public static void numeros(Random r) {
      int suma = 0;
      for(int i = 0; i < 10; i++){
         int num = r.nextInt(101) * 2;
         System.out.println(num);
         suma += num;
      }
      System.out.println("Suma: " + suma);
   }
}