/*
Corrige el siguiente programa para que pida una edad, lea el fichero edades.dat y diga las personas menores que esa edad.

Si no hay ninguna menor se mostrará "Todos son mayores"

El fichero sigue el siguiente formato:

Marta 25 Nerea 30 Miren 27 Aitor 41 Javier 36

El resultado debería ser:

Edad: 30
Marta es menor: 25
Miren es menor: 27

Edad: 20
Todos son mayores
*/
import java.io.*;
import java.util.*;
public class Ejercicio11 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFich = new Scanner(new File("edades.txt"));
      Scanner leerTeclado = new Scanner(System.in);
      
      System.out.print("Edad: ");
      int buscar = leerTeclado.nextInt();
      
      boolean encontrado = true;
      while (leerFich.hasNext()) {
         String nombre = leerFich.next();
         int edad = leerFich.nextInt();
         if (edad < buscar) {
            System.out.println(nombre + " es menor: " + edad);
            encontrado = false;
         }
      }
      
      if (encontrado) {
         System.out.println("Todos son mayores");
      }
      
      leerFich.close();
   }
}


