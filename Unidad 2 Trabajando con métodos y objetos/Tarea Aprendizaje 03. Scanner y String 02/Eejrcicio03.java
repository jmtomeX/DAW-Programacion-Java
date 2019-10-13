public class Eejrcicio03 {
   public static void main(String[] args) {           
      mostrar("Kaixo");
   }

   public static void mostrar(String texto) {
      for (int i = 0; i < texto.length(); i++) {
         System.out.println(i + ". " + texto.toUpperCase().charAt(i));
      }
   }
}