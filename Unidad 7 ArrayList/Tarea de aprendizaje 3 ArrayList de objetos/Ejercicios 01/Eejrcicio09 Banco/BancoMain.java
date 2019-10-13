/*
Tenemos el siguiente código:

Banco unBanco = new Banco("banco");
unBanco.addCuenta(1234, 1000.55, "Pedro");
unBanco.addCuenta(4321, 222.22, "Miren");
unBanco.addCuenta(2222, 4444.44, "Ana");
System.out.print(unBanco);
System.out.println("La cuenta con el saldo menor es: " + unBanco.saldoMenor());

Crea el método saldoMenor de la clase Banco para que devuelva un String con la información de la cuenta con menor saldo. Recuerda que para formatear un objeto tenemos el método toString().

El resultado del código será:

BANCO
Pedro(1234): 1000.55 euros
Miren(4321): 222.22 euros
Ana(2222): 4444.44 euros
La cuenta con el saldo menor es: Miren(4321): 222.22 euros
*/
public class BancoMain {
   public static void main(String[] args) {
      Banco unBanco = new Banco("banco");
      unBanco.addCuenta(1234, 1000.55, "Pedro");
      unBanco.addCuenta(4321, 222.22, "Miren");
      unBanco.addCuenta(2222, 4444.44, "Ana");
      System.out.print(unBanco);
      System.out.println("La cuenta con el saldo menor es: " + unBanco.saldoMenor());
   
   }
}