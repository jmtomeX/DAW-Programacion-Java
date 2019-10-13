/*Corrige el siguiente programa para que dependiendo del tipo de valor introducido por teclado, nos de un mensaje diferente:

Introduce un dato: 5
5 es un int

Introduce un dato: 5,55
5.55 es un double

Introduce un dato: hola
hola es un String
*/

import java.util.*;
public class Ejercicio07 {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      System.out.print("Introduce un dato: ");
      if (leerTeclado.hasNextInt()) {
         int num = leerTeclado.nextInt();
         System.out.println(num + " es un int");
      } else if (leerTeclado.hasNextDouble()) {
         double num = leerTeclado.nextDouble();
         System.out.println(num + " es un double");
      } else {
         String palabra = leerTeclado.next();
         System.out.println(palabra + " es un String");
      } 
   }
}