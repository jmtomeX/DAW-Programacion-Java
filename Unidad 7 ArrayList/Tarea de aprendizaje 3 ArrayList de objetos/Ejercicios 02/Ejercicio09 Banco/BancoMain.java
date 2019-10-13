/*
Banco unBanco = new Banco("banco");
System.out.println(unBanco);

Crea el constructor de la clase Banco para que a partir del nombre que recibe como parámetro inicialice los atributos de la clase Banco (el nombre y la lista de cuentas). Además, si el fichero nombre.txt se puede leer, añadirá los datos de todas las cuentas que tiene al array.

Para el fichero "banco.txt":

1234 1000.55 Pedro
4321 222.22  Miren
1111 999.99  Asier
2222 4444.44 Ana

El resultado del código será:

BANCO
Pedro(1234): 1000.55 euros
Miren(4321): 222.22 euros
Asier(1111): 999.99 euros
Ana(2222): 4444.44 euros
*/
import java.io.*;
public class BancoMain {
   public static void main(String[] args) throws FileNotFoundException {
      try{
         Banco unBanco = new Banco("banco");
         System.out.println(unBanco);
      } catch (FileNotFoundException e) {
         System.out.println("Error");
      }
   
   }
}