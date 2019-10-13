/*
Crea el método conectarFichero que recibirá como parámetro un objeto de la clase Scanner para leer por teclado 
y devolverá otro objeto de la clase Scanner conectado al fichero introducido por el usuario. El método pedirá 
el nombre del fichero por teclado hasta que el usuario o la usuaria introduzca uno válido, que pueda ser leído.
A continuación, conectará con ese fichero y devolverá el Scanner conectado.

Cuando se llame al método mostrará algo parecido a:
Nombre del fichero:
nombres.dat
Ese fichero no se puede leer. Nombre:
entrada.txt
Fichero valido.

Devuelve el Scanner conectado a ese fichero
*/
import java.io.*;
import java.util.*;

public class Ejercicio10 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner teclado = new Scanner(System.in);
      Scanner fichero = conectarFichero(teclado);
      while (fichero.hasNextLine()) {
         System.out.println(fichero.nextLine());
      }
      fichero.close();
   }
   public static Scanner conectarFichero(Scanner teclado) throws FileNotFoundException{
      System.out.println("Nombre del fichero: ");
      String nombreFich = teclado.nextLine();
      File fichero = new File(nombreFich);
      while (!fichero.canRead()){
         System.out.println("Ese fichero no se puede leer. Nombre: ");
         nombreFich = teclado.nextLine();
         fichero = new File(nombreFich);
      }
      System.out.println("Fichero valido.");
      return  new Scanner(new File(nombreFich));
   }
    
}