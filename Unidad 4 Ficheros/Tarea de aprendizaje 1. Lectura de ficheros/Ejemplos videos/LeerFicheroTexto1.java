// Programa que lee números de un fichero y los muestra por consola
//
// Considera que el fichero numeros.txt existe y tiene al menos 5 números
// Lanzará una excepción si encuentra un valor no númerico o hay menos de 5 números

import java.util.*;     // Clase Scanner
import java.io.*;       // Clase File

public class LeerFicheroTexto1 {
   public static void main(String[] args) throws FileNotFoundException {
      // Conecta con el fichero
      File fichero = new File("numeros3.txt");
      Scanner leerFichero = new Scanner(fichero);
      leerFichero.useLocale(Locale.US);
      
           // Lee 5 números double del fichero y los muestra por consola
      for(int i = 0; i < 5; i++){
         double num = leerFichero.nextDouble();
         System.out.println(num);
      }
      // Cierra la conexión
      leerFichero.close();
   }
}