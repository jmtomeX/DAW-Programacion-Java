//Estudia el siguiente programa y elige las opciones correctas:

import java.util.*;

public class Ejercicio06 {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      String respuesta;
      do {
         System.out.println("Esto es un bucle do-while");
         System.out.print("Lo repito: ");
         respuesta = leerTeclado.next();
      } while (respuesta.toUpperCase().equals("SI"));
      System.out.println("Agur");
   }
}