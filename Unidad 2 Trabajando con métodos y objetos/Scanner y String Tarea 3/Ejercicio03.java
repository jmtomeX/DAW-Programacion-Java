
public class Ejercicio03 {
   public static void main(String[] args) {           
      mostrar("Kaixo");
   }

   public static void mostrar(String texto) {
      for (int i = 1; i <= texto.length(); i++) {
         System.out.println((6 - i) + ". " + texto.substring(0, i).toLowerCase());
      }
   }
}