// Programa que muestra el uso del objeto de la clase PrintStream
// para escribir texto en un fichero
import java.io.*;

public class EscribirFichero {
   public static void main(String[] args) throws FileNotFoundException {
      // Conectaremos con el fichero
      File fichero = new File("salida.txt");
      PrintStream escribirFichero = new PrintStream(fichero);
      //PrintStream escribirFichero = System.out;
      
      // Escribiremos   
      escribir(escribirFichero);//Lo escribe en el fichero que crea nuevo.   
      escribir(System.out);//Lo muestra por pantalla.
      
      escribir(System.out);
      // Cerraremos la conexión
      escribirFichero.close();
   }
   
   public static void escribir(PrintStream escribirFichero ) {
      escribirFichero.println("En este programa vamos a escribir texto en un fichero.");
      escribirFichero.println("Lo vamos a hacer utilizando un objeto de la clase PrintStream.");
      escribirFichero.println("System.out también es un objeto de la clase PrintStream.");
      escribirFichero.println("Todo lo que hemos hecho con System.out funcionará con ficheros");
      escribirFichero.println("Esto es así");
   }
}