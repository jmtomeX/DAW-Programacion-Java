/*
Completa el siguiente programa para que lea el fichero "datos.txt" y muestre las palabras que empiezan por 'c' mayúscula o minúscula:

Por ejemplo si el fichero es:

rojo amarillo azul

56 78,45 901 33
-Cuantos elementos hay?
Todo se cuenta como si fueran palabras.

El resultado sera:

CUENTA
COMO
*/


import java.util.*;
import java.io.*;

public class Ejercicio15 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("datos.txt"));
        
      palabrasEmpiezanC(leerFichero);
        
      leerFichero.close();
   }
   public static void palabrasEmpiezanC(Scanner fichero){
    
      while(fichero.hasNextLine()){
         if(fichero.hasNextDouble()){
            fichero.nextDouble();
         }else if(fichero.hasNextInt()){
            fichero.nextInt();
         }else{
            String palabra = fichero.next();
            palabra.toLowerCase();
            if(palabra.startsWith("c")){
               System.out.println(palabra.toUpperCase());
            }
         }
      }
   }
}