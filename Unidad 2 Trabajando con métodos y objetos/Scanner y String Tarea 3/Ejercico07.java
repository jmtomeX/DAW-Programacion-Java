/*
Corrige el programa para que pida un nombre y escriba un saludo como se muestra a continuación:

Introduce tu nombre: Idoia
Egun on Idoia. Que tengas buen dia.

*/

import java.util.*;
public class Ejercico07 {
   public static void main(String[] args) {
      Scanner consola = new Scanner(System.in);
      System.out.print("Introduce tu nombre: ");
      String nombre = consola.next();
      System.out.println(formatear(nombre));
    
   }

   public static String formatear(String nombre) {
      return "Egun on " + nombre + ". Que tengas buen dia.";
   }
}