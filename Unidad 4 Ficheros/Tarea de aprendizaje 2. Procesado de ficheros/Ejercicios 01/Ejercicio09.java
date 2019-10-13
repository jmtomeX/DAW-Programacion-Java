/*Escribe un programa que lea el fichero parrafos.txt y muestre las líneas que tiene cada párrafo. 
Los párrafos están divididos mediante la etiqueta <p>, tanto en mayúsuclas como en minúsculas.
Con el siguiente fichero:
Vamos a contar
cuantas lineas tiene
cada parrafo
<P>
los parrafos estan
separados por una etiqueta
<p>
<P>
Puede haber parrafos vacios
<p>

El resultado del programa debería ser:

Parrafo con 3 lineas
Parrafo con 2 lineas
Parrafo con 0 lineas
Parrafo con 1 lineas
*/
import java.util.*;
import java.io.*;

public class Ejercicio09 {
   public static void main(String[] args) throws FileNotFoundException {     
      Scanner leerFich = new Scanner(new File("parrafos.txt"));   
      int cont = 0;
      while (leerFich.hasNextLine()) {
         String linea = leerFich.nextLine();
         if(!linea.equalsIgnoreCase("<p>")) {
            cont++;
         } else {
            System.out.println("Parrafo con " + cont + " lineas");
            cont = 0;
         }
      }       
      leerFich.close();
   }
   public static void encriptar(Scanner leer, char letra) {
      String nombre = leer.next();
      String apellido = leer.next();
      for (int i = 0; i < nombre.length(); i++) {
         System.out.print(letra);
      }  
      System.out.println(" " + apellido.toLowerCase());
   }
}
