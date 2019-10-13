/*
Escribe el método escribirOcultos que acepte como parámetro un Scanner para leer un fichero de texto.

En algunos puntos de ese fichero aparecera la palabra OCULTAR seguida de un número. Por ejemplo:

en un OCULTAR 3 lugar de la Mancha de OCULTAR 1 cuyo
nombre no OCULTAR 2 quiero acordarme no ha mucho tiempo

El método escribirá cada una de las palabras leídas en una línea diferente. Cuando encuentre la palabra OCULTAR,
ocultará tantas palabras como el número que viene a continuación. En vez de esas palabras se escribirá *OCULTO*.

Con el fichero anterior el resultado sería:
en
un
*OCULTO*
*OCULTO*
*OCULTO*
Mancha
de
*OCULTO*
nombre
no
*OCULTO*
*OCULTO*
no
ha
mucho
tiempo

*/
import java.util.*;
import java.io.*;

public class Ejercicio05 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("texto.txt"));
      
      escribirOcultos(leerFichero);
   }
   public static void escribirOcultos(Scanner leerFichero){
      while(leerFichero.hasNextLine()){
         int cont = 0;
         String linea = leerFichero.nextLine();
         Scanner leerLinea = new Scanner(linea);
         int num = 0;
         while(leerLinea.hasNext()){ 
            String palabra = leerLinea.next();
            if(palabra.equals("OCULTAR")){
               palabra = null;
               cont = leerLinea.nextInt();
               leerLinea.next();
            }   
            if(cont != 0){
               palabra = null;
               palabra =  "*OCULTO*";//lugar de la
               cont--;
            }
            System.out.println(palabra);
         }
      }
   }
}