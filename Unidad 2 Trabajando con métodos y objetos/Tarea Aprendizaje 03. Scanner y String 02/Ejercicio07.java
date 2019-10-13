import java.util.*;

public class Ejercicio07 {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      System.out.println("Introduce una palabra: ");
      String texto = leerTeclado.next();
      System.out.println(palabra(texto));
   }
   
   public static String palabra(String cadena) {
      String resultado = "";
      for(int i = cadena.length() - 1; i >= 0; i--) {
         resultado += cadena.toLowerCase().charAt(i);
      }
      return resultado;
   }
}