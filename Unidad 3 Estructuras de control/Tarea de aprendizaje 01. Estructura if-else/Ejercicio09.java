/*
Escribe un programa que pida un número y que únicamente lo lea si es un número entero. En caso contrario, dará el mensaje "No cumple las condiciones".

Ejemplo:

Introduce un numero: 4.5
No cumple las condiciones

Introduce un numero: abc
No cumple las condiciones

Introduce un numero: 14
El numero introducido es 14
*/

import java.util.*;
public class Ejercicio09 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.print("Introduce un dato: ");
      if (teclado.hasNextInt()) {
         int num = teclado.nextInt();
         System.out.println("  El numero introducido es " + num);
      } else  {
         System.out.println("No cumple las condiciones");
      } 
   }
       
}