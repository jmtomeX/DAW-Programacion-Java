/*
Ordena el programa para que pida palabras por teclado hasta pulsar "Q" y nos dirá cuántas palabras acaban por "o".
 Distinguirá entre mayúsculas y minúsculas.

Por ejemplo:

Introduce una palabra: Hola
Introduce una palabra: kaixo
Introduce una palabra: mesa
Introduce una palabra: PERRO
Introduce una palabra: q
Introduce una palabra: Q
Palabras que acaban en o: 1
*/
import java.util.*;
public class Ejercicio08{
   public static void main(String[] args){
      Scanner teclado = new Scanner(System.in);
      int contador = 0;
      String palabra ;
      do{
         System.out.print("Introduce una palabra: ");
         palabra = teclado.next();
         if(palabra.endsWith("o")){
            contador++;
         }
      }while(!palabra.equals("Q"));
   }
}