// Este program lee las notas de diferentes alumnos y alumnas de un fichero de texto
// y calcula y muestra la nota media de cada uno

import java.io.*;
import java.util.*;

public class MediaAlumna {
  
   // Conecta con el fichero introducido por el usuario para leer mediante el método obtenerConexionFichero
   // Conecta con el fichero output.txt para escribir
   // Lee línea a línea el fichero y llama al método procesarLinea por cada una de ellas
   public static void main(String[] args) throws FileNotFoundException {
      
      // Conecta con las diferentes entradas y salidas
      Scanner teclado = new Scanner(System.in);
      Scanner leerFichero = obtenerConexionFichero(teclado);
      PrintStream escribirFichero = new PrintStream(new File("output.txt"));
      
      // Mientras haya otra línea más por leer, la lee y la procesa
      while (leerFichero.hasNextLine()) {
         String linea = leerFichero.nextLine();
         procesarLinea(linea, escribirFichero);
      }
      
      // Cierra la conexión
      leerFichero.close();
   }
   
   // Pide el nombre de un fichero hasta que éste se pueda leer
   // Crea la conexión y la devuelve
   // Scanner leerTeclado: fuente de la que se leerá el nombre del fichero
   // return Scanner: objeto para leer del fichero introducido
   public static Scanner obtenerConexionFichero(Scanner leerTeclado) throws FileNotFoundException {
      System.out.print("Nombre del fichero: ");
      File fichero = new File(leerTeclado.next());
      while (!fichero.canRead()) {
         System.out.println("No se puede leer este fichero. Inténtalo otra vez.");
         System.out.print("Nombre del fichero: ");
         fichero = new File(leerTeclado.next());
      }
      return new Scanner(fichero);
   }

   // Procesa la cadena proporcionada (ID, name, and hours worked)
   // Lee los datos de una alumno o alumna, calcula la media
   // La escribe en el objeto de la clase PrintStream pasado como parámetro
   // String texto: línea de texto que hay que procesar
   // PrintStream escribir: destino donde se escribirá el resultado
   public static void procesarLinea(String texto, PrintStream escribir) {
   
      // Crea un objeto de tipo Scanner a partir de una cadena de texto
      Scanner linea = new Scanner(texto);
      
      // Lee el id del alumno o alumna
      int id = linea.nextInt();
      
      // Lee el nombre del alumno o alumna
      String nombre = linea.next();
      
      // Lee las calificaciones, las cuenta y las suma
      int cont = 0;
      double suma = 0;
      while (linea.hasNextDouble()) {
         double num = linea.nextDouble();
         suma = suma + num;
         cont++;
      }
      
      // Visualiza los datos del alumno o alumna y su nota media
      escribir.println("Nota media de " + nombre + " (id#" + id + ") = " + suma / cont);
   
   }
}