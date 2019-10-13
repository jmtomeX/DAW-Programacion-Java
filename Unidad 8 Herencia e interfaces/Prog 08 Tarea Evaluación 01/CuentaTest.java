
public class CuentaTest {
   public static void main(String[] args) {
      
      Cliente peio = new Cliente("22222222B", "Peio");
      Cuenta unaCuenta = new Cuenta(peio, 1000);
      System.out.println(unaCuenta);
      
      if (unaCuenta.mismoDni("22222222B")) {
         System.out.println("Los DNIs son iguales");
      }
      if (!unaCuenta.mismoDni("11111111A")) {
         System.out.println("Son diferentes");
      }
      
      // Cambiar los valores del DNI y del saldo para probar distintas posibilidades
      Cliente alicia = new Cliente("11111111A", "Alicia");
      Cuenta otraCuenta = new Cuenta(alicia, 1000);
      
      if (unaCuenta.compareTo(otraCuenta) > 0) {
         System.out.println("Va detrás");
      }
      if (otraCuenta.compareTo(unaCuenta) < 0) {
         System.out.println("Va delante");
      }
   }
}