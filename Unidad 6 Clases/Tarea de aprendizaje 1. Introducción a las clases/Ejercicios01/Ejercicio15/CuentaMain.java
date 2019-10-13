/*
Corrige el siguiente programa para que muestre lo siguiente:
Para que de lo siguiente
(0): 0.0 euros
1234 Pedro Arana 1000.67
Ana Albizu(22): 500.5 euros
Ingresa: 1000.5 Saldo: 1000.5
Retira: true Saldo: 500.5
Retira: false Saldo: 500.5
Ana Albizu(22): 500.5 euros
*/
public class CuentaMain {
   public static void main(String[] args) {
      //int numero;
      //double saldo;
      //String titular;
      // Crea una cuenta vacia y la muestra
      Cuenta miCuenta = new Cuenta();
      System.out.println(miCuenta.enmarcar());
      System.out.println(miCuenta.toString());
      
      // Modifica los valores de miCuenta
      miCuenta.setTitular("Pedro Arana");
      miCuenta.setSaldo(1000.67);
      miCuenta.setNumero(1234);
      
      // Muestra los valores de miCuenta
      System.out.println(miCuenta.getNumero() + " " + miCuenta.getTitular()  + " " + miCuenta.getSaldo());
      
      // Crea y muestra otra cuenta con los siguientes valores 22, 500.5, "Ana Albizu"
      Cuenta otraCuenta = new Cuenta(22, 500.5, "Ana Albizu");
      System.out.println(otraCuenta);
      
      // Ingresa 500 euros en otraCuenta
      System.out.println("Ingresa: " + otraCuenta.ingresar(500) + " Saldo: " + otraCuenta.getSaldo());
      
      // Retira 500 euros de otraCuenta
      System.out.println("Retira: " + otraCuenta.retirar(500) + " Saldo: " + otraCuenta.getSaldo());
      
      // Retira 2000 euros otraCuenta
      System.out.println("Retira: " + otraCuenta.retirar(2000) + " Saldo: " + otraCuenta.getSaldo());
      
      // Muestra otraCuenta
      System.out.println(otraCuenta.toString());
      System.out.println(miCuenta.enmarcar());
   }
}