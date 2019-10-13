import java.util.*;

public class Ejercicio02 {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      int numero = leerTeclado.nextInt();
      int veces = leerTeclado.nextInt();
      int suma = 0;
      for(int i = 0; i < veces; i++) {
         suma += numero;
      }
      System.out.println(numero + " sumado " + veces + " veces es igual a " + suma);
   }
}