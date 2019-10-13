/*
Corrige el siguiente programa para que pida un nombre, lea el fichero edades.dat y diga la edad de esa persona. Si el nombre no está en el fichero lo indicará.
El fichero sigue el siguiente formato:

Marta 25 Nerea 30 Miren 27 Aitor 41 Javier 36

El resultado debería ser:
Nombre: marta
La edad de Marta es 25
Nombre: Raul
Ese nombre no esta en la lista
*/

import java.util.*;
import java.io.*;

public class Ejeercicio11 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFich = new Scanner(new File("edades.txt"));
      Scanner leerTeclado = new Scanner(System.in);
      
      System.out.print("Nombre: ");
      String buscar = leerTeclado.next();
      boolean encontrado = false;
      
      while (encontrado == false && leerFich.hasNext()) {
         String nombre = leerFich.next();
         int edad = leerFich.nextInt();
         if (nombre.equalsIgnoreCase(buscar)) {
            System.out.println("La edad de " + nombre + " es " + edad);
            encontrado = true;
         }
      }
      if (!encontrado) {
         System.out.println("Ese nombre no esta en la lista");
      }
      leerFich.close();
   }
}