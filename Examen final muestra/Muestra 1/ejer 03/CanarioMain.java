public class CanarioMain {
   public static void main(String[] args) {
   
      Canario unCanario = new Canario('M', 5, 23.0);
   
      System.out.println("CANARIO");
      System.out.println(unCanario);
      System.out.println(unCanario.trinar());
      System.out.println("Tipo: " + unCanario.tipoCanario());
   }
}