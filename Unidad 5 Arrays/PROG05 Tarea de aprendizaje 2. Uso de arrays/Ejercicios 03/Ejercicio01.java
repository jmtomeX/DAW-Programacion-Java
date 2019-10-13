/*
Si el fichero contiene estos datos:
   6.1 7.4 7.3 5.8 4.9 5.4 8.6 9.0 7.7 9.6 10.0 3.8 6.2 5.9
*/
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
