/*
Corrige el siguiente programa para que lea el fichero "datos.txt" y diga cuántos números enteros contiene:
Por ejemplo si el fichero es:
rojo amarillo azul
56 78,45 901 33
¿Cuántos elementos hay?
Todo se cuenta como si fueran palabras.

El resultado sera:
Tiene 3 números enteros
*/

import java.util.*;
import java.io.*;
public class Ejeercicio13 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("datos.txt"));   
      int cont = 0;
      while (leerFichero.hasNext()) {
         if (leerFichero.hasNextInt()) {
            int num = leerFichero.nextInt();
            cont++;
         } else {
            String linea = leerFichero.next();
         }
      }
      System.out.println("Tiene " + cont + " numeros enteros");
      leerFichero.close();
   }
}