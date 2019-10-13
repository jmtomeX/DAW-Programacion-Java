
public class CuentasTest {
   public static void main(String[] args) {
      
      Cliente alicia = new Cliente("11111111A", "Alicia");
      Cliente peio = new Cliente("22222222B", "Peio");
      
      // Cambiar las cantidades para comprobar que el constructor funciona
      CuentaAhorro cuenta1 = new CuentaAhorro(alicia, 3000.00);
      CuentaCorriente cuenta2 = new CuentaCorriente(peio, 500.00);
      System.out.println(cuenta1);
      System.out.println(cuenta2);
      
      // Cuenta ahorro. Cambiar las cantidades para comprobar que funciona
      cuenta1.ingreso(100); 
      cuenta1.retirada(100);
      cuenta1.addInteres(1);
      System.out.println(cuenta1);
       
      // Cuenta corriente. Cambiar las cantidades para comprobar que funciona
      cuenta2.ingreso(100); 
      System.out.println(cuenta2);
      for (int i = 0; i < 3; i++) {
         cuenta2.retirada(50);
         System.out.println(cuenta2);
      }
      cuenta2.retirada(50);
      System.out.println(cuenta2);
      
      cuenta2.reseteaNumeroRetiradas();
      cuenta2.retirada(50);   
      System.out.println(cuenta2);
   }
}