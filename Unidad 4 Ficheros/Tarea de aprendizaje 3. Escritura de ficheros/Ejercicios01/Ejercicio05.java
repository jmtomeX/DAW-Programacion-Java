/*
¿Qué mostrará por consola si hacemos la siguiente llamada?
escribir(System.out);
*/
import java.io.*;
import java.util.*;
public class Ejercicio05 {
   public static void main(String[] args) throws FileNotFoundException {
      escribir(System.out);
   }
   public static void escribir(PrintStream escribirTexto) {
      escribirTexto.println("Linea 1");
      escribirTexto.print("Kaixo");
      escribirTexto.printf("Numero: %5d", 45);
      escribirTexto.println();
      escribirTexto.printf("Numero: %8.2f\n", 145.67823);
   }
}