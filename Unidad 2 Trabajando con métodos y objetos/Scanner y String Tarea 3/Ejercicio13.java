/*
Escribe un programa que pida 2 palabras por consola al usuario y muestre por pantalla
el número de letras de la palabra más larga. Acuerdate de los métodos de las clases Math y String.
Por ejemplo:

Primera palabra: casa
Segunda palabra: etxea
La palabra mas larga tiene 5 letras.
*/

import java.util.*;
public class Ejercicio13 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
        
      System.out.println("Introduce la primera palabra");
      String palabra1 = teclado.next();   
      System.out.println("Introduce la segunda palabra");  
      String palabra2 = teclado.next();
      System.out.println("Primera palabra "  + palabra1); 
      System.out.println("Segunda palabra "  + palabra2); 
      int palabraLarga = Math.max(palabra1.length(),palabra2.length());
      System.out.println("La palabra mas larga tiene  " + palabraLarga + " letras."  ); 
   }
}