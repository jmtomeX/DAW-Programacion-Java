/*
Completa el programa con el método abrirFichero al que se le pasará un objeto de tipo Scanner para leer datos por teclado.
Pedirá el nombre del fichero que se quiere abrir, creará un objeto de tipo Scanner para leerlo y lo devolverá.
Se considerá que el nombre del fichero que se introduce siempre es válido.
*/
import java.util.*;
import java.io.*;

public class Ejercicio10 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner teclado = new Scanner(System.in);
      Scanner leer =  abrirFichero(teclado);
      while (leer.hasNextLine()) {
         System.out.println(leer.nextLine());              
      }  
   }
   public static Scanner abrirFichero(Scanner leerTeclado) throws FileNotFoundException {
      System.out.print("Nombre del fichero: ");
      String nombreFich = leerTeclado.next();
      return new Scanner(new File(nombreFich));       
   }
}