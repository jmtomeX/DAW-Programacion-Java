// Este programa lee las notas de diferentes alumnos y alumnas de un fichero de texto
// y calcula y muestra la nota media de cada uno
// Gestiona las excepciones
import java.io.*;
import java.util.*;

public class ComprobarFicheroExiste {
   public static void main(String[] args) throws FileNotFoundException {
   
      // Leemos el nombre del fichero y creamos un objeto de la clase File
      Scanner leerTeclado = new Scanner(System.in);
      System.out.print("Nombre del fichero: ");
      String nombreFichero = leerTeclado.nextLine();
      File fichero = new File(nombreFichero);
      
      // Comprobamos si el fichero introducido se puede leer mediante el método canRead
      // mientras no se pueda leer seguimos pidiendo un nombre de fichero válido
      while (!fichero.canRead()) {
         System.out.println("No se puede leer este fichero. Inténtalo otra vez.");
         System.out.print("Nombre del fichero: ");
         nombreFichero = leerTeclado.nextLine();
         fichero = new File(nombreFichero);
      }
      
      // Conectamos con el fichero para leerlo
      System.out.println("El fichero " + nombreFichero + " se puede leer");
      Scanner leerFichero = new Scanner(fichero);
   }
}