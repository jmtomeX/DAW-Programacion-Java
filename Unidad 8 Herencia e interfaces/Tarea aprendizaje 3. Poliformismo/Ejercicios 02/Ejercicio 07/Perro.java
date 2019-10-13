public class Perro extends Mamifero {

   public void metodo1() {
      System.out.println("perro 2");
      super.metodo1();
   }

   public String toString() {
      return "PERRO" + super.toString();
   }
}