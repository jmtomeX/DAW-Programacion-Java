// Programa que lee números de un fichero y los muestra por consola
//
// Considera que el fichero numeros.txt existe y tiene números, no se sabe cuántos
// Lee todos los números y se salta los que no son

import java.util.*;     // Clase Scanner
import java.io.*;       // Clase File

public class LeerFicheroTexto3 {
   public static void main(String[] args) throws FileNotFoundException {
      // Conecta con el fichero
      File fichero = new File("numeros3.txt");
      Scanner leerFichero = new Scanner(fichero);
      leerFichero.useLocale(Locale.US);      // Notación americana, números con punto decimal
      
      // Lee números double del fichero y los muestra por consola
      // Mientras haya otro elemento para leer sigue leyendo
      while (leerFichero.hasNext()) {
         // Si el elemento es un número lo lee y lo muestra
         if (leerFichero.hasNextDouble()) {
            double num = leerFichero.nextDouble();
            System.out.println(num);
         } else {    // Si no es un número lo lee como texto para saltarlo y continuar
                     //Se ha añadido para que lo imprima por pantalla, si es un String
            String otros = leerFichero.next();
            System.out.println("Saltamos --> " + otros);
         }
      }
   
      // Cierra la conexión
      leerFichero.close();
   }
}