/*
Completa el programa con el método buscarEdad() al que se le pasarán un objeto de tipo Scanner conectado a un fichero y un nombre.
 Leerá el fichero y devolverá la edad de esa persona. Si el nombre no está en el fichero devolverá -1.

El fichero sigue el siguiente formato:
Marta 25 Nerea 30 Miren 27 Aitor 41 Javier 36

El resultado de las siguientes llamadas debería ser:
resultado = buscarEdad(leerFich, "marta");
devolverá 25
resultado = buscarEdad(leerFich, "Ramon");
devolverá -1
*/
import java.io.*;
import java.util.*;
public class Ejercicio09 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFich = new Scanner(new File("edades.txt"));
      Scanner leerTeclado = new Scanner(System.in);
      
      System.out.print("Nombre: ");
      String buscar = leerTeclado.next();
      
      int edad = buscarEdad(leerFich, buscar);
      
      if (edad == -1) {
         System.out.println("Ese nombre no esta en la lista");
      } else {
         System.out.println("La edad de " + buscar + " es " + edad);
      }
      
      leerFich.close();
   
   }
   public static int buscarEdad(Scanner leerFichero, String buscarPersona) {
      int edad = 0;
      while(leerFichero.hasNextLine()){
         String nombre = leerFichero.next();
         if(nombre.equalsIgnoreCase(buscarPersona)){
            edad = leerFichero.nextInt();
            break;
         }else{
            edad = -1;
         }
      }
      return edad;
   }
}