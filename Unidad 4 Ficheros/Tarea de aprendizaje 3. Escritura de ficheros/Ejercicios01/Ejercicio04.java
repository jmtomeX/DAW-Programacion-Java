/*
¿Qué veremos en el fichero escribir.txt después de ejecutar el siguiente código?

PrintStream escribirFichero = new PrintStream(new File("escribir.txt"));
escribir(escribirFichero );
*/
import java.io.*;
import java.util.*;
public class Ejercicio04 {
   public static void main(String[] args) throws FileNotFoundException {
      PrintStream escribirFichero = new PrintStream(new File("escribir.txt"));
      escribir(escribirFichero );
   }
   public static void escribir(PrintStream escribirTexto) {
      escribirTexto.print("Empezamos");
      escribirTexto.println("a trabajar");
      escribirTexto.printf("Entero: %6d", 2345);
      escribirTexto.println();
      escribirTexto.printf("Decimal: %6.1f\n", 15.67823);
   }
}