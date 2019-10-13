/*
Escribe el código para los métodos palabraBuscada y mostrarResultados.

palabraBuscada recibirá como parámetro una palabra y devolverá el índice de esa palabra en el array PALABRAS.
Si la palabra no está en el array devolverá -1.
mostrarResultados recibirá como parámetro una array de enteros y mostrará lo siguiente:

public static final String[] PALABRAS = {"de", "y", "el", "la"};

int[] contador = {4, 2, 1, 3};
mostrarResultados(contador);

Palabra de: 4
Palabra y: 2
Palabra el: 1
Palabra la: 3
*/
import java.io.*;
import java.util.*;

public class Ejercicio09 {
   public static final String[] PALABRAS = {"de", "y", "el", "la"};
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leer = new Scanner(new File("datos.txt"));
      int[] contador = new int[PALABRAS.length];
      while(leer.hasNext()) {
         String palabra = leer.next();
         int indice = palabraBuscada(palabra);
         if(indice != -1){
            contador[indice]++;
         }
      }
      mostrarResultados(contador);
   } 
   public static void mostrarResultados(int[] contador){
      for(int i = 0; i < PALABRAS.length; i++){
         System.out.println("Palabra" +  PALABRAS[i] + ": " + contador[i] );
      }
   }
   public static int palabraBuscada(String palabra){
      int result = -1;
      for(int i = 0; i < PALABRAS.length; i++){
         if(PALABRAS[i].equals(palabra)){
            return i;
         }
      }
      return result;
   }
}