// Programa que lee números de un fichero y los muestra por consola
//
// Considera que el fichero numeros.txt existe y tiene números, no se sabe cuántos
// Lee hasta encontrar un valor que no sea númerico

import java.util.*;     // Clase Scanner
import java.io.*;       // Clase File

public class LeerFicheroTexto2 {
   public static void main(String[] args) throws FileNotFoundException {
      // Conecta con el fichero
      File fichero = new File("numeros3.txt");
      Scanner leerFichero = new Scanner(fichero);
      leerFichero.useLocale(Locale.US);      // Notación americana, números con punto decimal
      
      // Lee números double del fichero y los muestra por consola
      // Mientras el elemento siguiente sea un número leerlo
      while (leerFichero.hasNextDouble()) {
         double num = leerFichero.nextDouble();
         System.out.println(num);
      }

      // Cierra la conexión
      leerFichero.close();
   }
}