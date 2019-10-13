import java.util.*;

public class Ejercicio09 {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      int inicio = leerTeclado.nextInt();
      int fin = leerTeclado.nextInt();
      mostrar(inicio, fin);
   }
   
   public static void mostrar(int hasi, int bukatu) {
      System.out.println("INICIO");
      for(int i = hasi; i <= bukatu; i++) {
         System.out.println("<" + i + ">");
      }
      System.out.println("FIN");
   }
}
