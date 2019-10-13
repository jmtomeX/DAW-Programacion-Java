/*
Corrige el siguiente programa para que lea el fichero "datos.txt" y diga el número de palabras que contiene:
Por ejemplo si el fichero es:

rojo amarillo azul

56 78,45 901 33
¿Cuántos elementos hay?
Todo se cuenta como si fueran palabras.

El resultado sera:

Tiene 17 palabras
*/
import java.util.*;
import java.io.*;

public class Ejercicio13B {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("datos.txt"));
      int cont = 0;
      while (leerFichero.hasNextLine()) {
         if(leerFichero.hasNext()){
            String linea = leerFichero.next();
            cont++;
         }
      }
      System.out.println("Tiene " + cont + " palabras");
      leerFichero.close();
   }
}