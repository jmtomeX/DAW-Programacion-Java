/*
Completa el siguiente programa para que lea el fichero "datos.txt" y diga cuantas palabras acaban por 'o' mayúscula o minúscula:
Por ejemplo si el fichero es:

rojo amarillo azul

56 78,45 901 33
-Cuantos elementos hay?
Todo se cuenta como si fueran palabras.

El resultado sera:
4 palabras acaban por 'o'
*/
import java.util.*;
import java.io.*;
//Ejercicio 15
public class Programa {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("datos15.txt"));
        
      int total = palabrasAcabanO(leerFichero);
      System.out.println(total + " palabras acaban por 'o' ");
        
      leerFichero.close();
   }
   public static int palabrasAcabanO(Scanner leerFichero){
      int totalOs = 0;
      while(leerFichero.hasNext()){
         String palabra = leerFichero.next().toLowerCase();
         if(palabra.endsWith("o")){
            totalOs++;
         }
        
      }
      return totalOs;
   }
}