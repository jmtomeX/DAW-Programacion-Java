
public class ClienteTest {
   public static void main(String[] args) {
   
      Cliente alicia1 = new Cliente("11111111A", "Alicia");
      Cliente peio1 = new Cliente("22222222B", "Peio");
      Cliente peio2 = new Cliente(peio1);
      System.out.println(alicia1);
      System.out.println(peio2);
      System.out.println(alicia1.getDni());
      Cliente alicia2 = new Cliente("11111111A", "Alicia");
      if (alicia1.equals(alicia2)) {
         System.out.println("Son iguales");
      }
      if (!alicia1.equals(peio2)) {
         System.out.println("Son diferentes");
      }
   }
}