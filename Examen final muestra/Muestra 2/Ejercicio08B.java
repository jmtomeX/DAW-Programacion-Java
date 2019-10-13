
import java.io.*;
import java.util.*;
public class Ejercicio08B {

   public static void main(String[] args) throws FileNotFoundException {
      int[] a = {2, 4, 6, 8, 10};
      int[] b = {1, 5 , 11};
      System.out.println(Arrays.toString(combinarArrays(a, b)));
   }

   public static int[] combinarArrays(int[] uno, int[] dos) {
      int cont = 0;
      int[] tres = new int[uno.length + dos.length];
      for(int i = 0; i < uno.length; i++) {
         tres[i] = uno[i];
      }
      for(int i = uno.length; i < tres.length; i++) {
         tres[i] = dos[cont];
         cont++;
      }
      Arrays.sort(tres);
 
      return tres;
   }
}