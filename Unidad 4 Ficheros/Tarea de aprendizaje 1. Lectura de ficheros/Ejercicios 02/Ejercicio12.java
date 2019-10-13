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
public class Ejercicio12 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner("datos.txt");
      int cont = 0;
      while (leerFichero.hasNextLine()) {
         int num = leerFichero.nextInt();
         if (leerFichero.hasNextInt()) {
           
            cont++;
         } else {
            String linea = leerFichero.next();
         }
      }
      System.out.println("Tiene " + cont + " numeros");
      leerFichero.close();
   }
}