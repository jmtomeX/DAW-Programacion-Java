//Tenemos el siguiente código:
import java.util.*;
public class Ejercicio07 {
   public static void main(String[] args) {
      int[] numeros = new int[5];
      numeros[0] = 3;
      numeros[2] = 9;
      numeros[4] = numeros[2] + 1;
   
      int x = numeros[2] / 3;
      numeros[x] = numeros[4] - numeros[0];
      numeros[numeros[0]] = 2 * numeros[0];
   
      System.out.println(Arrays.toString(numeros));
   }
}