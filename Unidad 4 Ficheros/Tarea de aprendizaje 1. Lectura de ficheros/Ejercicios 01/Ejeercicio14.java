/*
Crea el siguiente programa para que lea el fichero "datos.txt" y muestre cada uno de los elementos que contiene
y diga si es un entero, un double o una cadena de caracteres:
Por ejemplo si el fichero es:
rojo 56 

78.45 901 amarillo
34.33

El resultado sera:
rojo: palabra
56: entero
78.45: double
901: entero
amarillo: palabra
34.33: double
*/

import java.util.*;
import java.io.*;
public class Ejeercicio14 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("datos14.txt"));
      leerFichero.useLocale(Locale.US); 
      while(leerFichero.hasNext()){
         if(leerFichero.hasNextInt()) {
            int entero = leerFichero.nextInt();
            System.out.println(entero + ": entero");
         }
         else if(leerFichero.hasNextDouble()) {
            double decimal = leerFichero.nextDouble();
            System.out.println(decimal + ": double");
         }
         else {
            String cadena = leerFichero.next();
            System.out.println(cadena + ": palabra");
         }
      }
      leerFichero.close();
   }
}