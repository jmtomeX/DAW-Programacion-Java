/*
Escribe el método crearAcronimos que acepte como parámetro un Scanner para leer un ficheros de texto,
muestre el acrónimo del texto de cada línea y devuelva el número de letras del acrónimo más largo.

Por ejemplo, si tenemos el siguiente fichero:

objeto volador no identificado
alta velocidad española
light emitting diode
united nations international children emergency fund

El método mostraría:

OVNI
AVE
LED
UNICEF 
*/


import java.util.*;
import java.io.*;

public class Ejercicio06 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("acronimos.txt"));
        
      int total = crearAcronimos(leerFichero);
      System.out.println("El acronimo mas largo tiene " + total + " letras");
   }
   public static int crearAcronimos(Scanner leerFich){
      int masLargo = 0;
      int cont = 0;
      
      while(leerFich.hasNextLine()){
         String linea  = leerFich.nextLine();
         Scanner leerLinea = new Scanner(linea);
         while(leerLinea.hasNext()){
            String palabra = leerLinea.next();
            palabra = palabra.substring(0,1).toUpperCase();
            System.out.print(palabra);
            cont++;
         }
         masLargo = Math.max(masLargo,cont);
         cont = 0;
         System.out.println();
      
      }
     
      return masLargo;
   }
}