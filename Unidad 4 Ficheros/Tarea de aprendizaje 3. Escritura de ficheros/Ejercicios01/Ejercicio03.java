/*
Completa el siguiente código para que lea el fichero entrada.txt 
y escriba su contenido en salida.txt.
*/
import java.io.*;
import java.util.*;
public class Ejercicio03 {
   public static void main(String[] args) throws FileNotFoundException {
   
      File fichEntrada = new File("entrada.txt");
      Scanner entrada = new Scanner (fichEntrada);
   
      File fichSalida = new File("salida.txt");
      PrintStream salida = new PrintStream("fichSalida");
      while(entrada.hasNextLine()) {
         String linea = entrada.nextLine();
         salida.println(linea);
      }
      entrada.close();
      salida.close();
   }
}