/*
Tenemos el siguiente código:

Banco unBanco = new Banco("banco");
unBanco.addCuenta(4320, 555.55, "Miren");
unBanco.addCuenta(1234, 1000.55, "Pedro");
unBanco.addCuenta(4321, 222.22, "Miren");
unBanco.addCuenta(2222, 4444.44, "Ana");
unBanco.addCuenta(4322, 1111.11, "Miren");
Banco cuentasTitular = unBanco.cuentasTitular("Miren");
System.out.println(cuentasTitular);

Crea el método cuentasTitular de la clase Banco para que devuelva un objeto también de la clase Banco con la información de las cuentas es el titular indicado como parámetro.

El resultado del código será:

CUENTAS DEL TITULAR: MIREN
Miren(4320): 555.55 euros
Miren(4321): 222.22 euros
Miren(4322): 1111.11 euros   */
public class BancoMain {
   public static void main(String[] args) {
      Banco unBanco = new Banco("banco");
      unBanco.addCuenta(4320, 555.55, "Miren");
      unBanco.addCuenta(1234, 1000.55, "Pedro");
      unBanco.addCuenta(4321, 222.22, "Miren");
      unBanco.addCuenta(2222, 4444.44, "Ana");
      unBanco.addCuenta(4322, 1111.11, "Miren");
      Banco cuentaTitular = unBanco.cuentasTitular("Miren");
      System.out.println(cuentaTitular);      }
}