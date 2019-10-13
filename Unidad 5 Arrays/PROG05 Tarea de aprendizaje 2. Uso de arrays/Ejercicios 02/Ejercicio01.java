import java.util.*;
import java.io.*;
public class Ejercicio01 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leer = new Scanner(new File("valores.txt"));
      leer.useLocale(Locale.ENGLISH);
      int[] contarValores = new int[4];
        
      while (leer.hasNextDouble()) {
         double valor = leer.nextDouble();
         if (valor >= 9) {
            contarValores[0]++;
         } else if (valor >= 6.5) {
            contarValores[1]++;
         } else if (valor >= 5) {
            contarValores[2]++;
         } else {
            contarValores[3]++;
         }             
      }
      System.out.println(Arrays.toString(contarValores));
      leer.close();
   }
}