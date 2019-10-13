public class Mesa extends Mueble {

   public void metodo2() {
      System.out.println("mesa 2");
      super.metodo1();
   }
   
   public String toString() {
      return "mesa";
   }
}