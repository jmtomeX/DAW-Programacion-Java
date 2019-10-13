/*
Corrige el siguiente programa para que lea el fichero "datos.txt" y diga  cuántos números contiene:
Por ejemplo si el fichero es:

rojo amarillo azul

56 78,45 901 33
¿Cuántos elementos hay?
Todo se cuenta como si fueran palabras.

El resultado sera:

Tiene 4 números
*/
import java.util.*;
import java.io.*;
public class Ejercicio13 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("datos.txt"));
      int cont = 0;
      String linea = "";
      while (leerFichero.hasNextLine()) {
         if (leerFichero.hasNextInt()) {
            int num = leerFichero.nextInt();
            cont++;
         }
         else if(leerFichero.hasNextDouble()){
            double doble = leerFichero.nextDouble();
            cont++;
         } else {
            linea = leerFichero.next();
         }
      }
      System.out.println("Tiene " + cont + " numeros" );
      leerFichero.close();
   }
}