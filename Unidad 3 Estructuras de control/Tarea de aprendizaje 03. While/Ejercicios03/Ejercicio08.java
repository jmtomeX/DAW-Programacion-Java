/*
Corrige el programa para que pida palabras por teclado y cuente cuántas empiezan por "a" o por "A".
Cuando el usuario escriba "fin", independientemente de las mayúsculas o las minúsculas, dejará de pedir palabras.
Por ejemplo:
Introduce una palabra: Ave
Introduce una palabra: abierto
Introduce una palabra: cerrado
Introduce una palabra: fIn
2
*/
import java.util.*;
public class Ejercicio08 {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      System.out.println(contarPalabras(leerTeclado));
   }
   public static int contarPalabras(Scanner teclado) {
      String palabra = "";
      int contador = 0;
      do {
         System.out.print("Introduce una palabra: ");
         palabra = teclado.next();
         palabra = palabra.toUpperCase();
         if(palabra.startsWith("A"))  {
            contador++;  
         }
      } while (!palabra.equals("FIN"));
      return contador;
   }    
}