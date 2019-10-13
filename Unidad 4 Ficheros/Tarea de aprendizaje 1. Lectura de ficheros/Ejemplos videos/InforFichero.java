// Programa de uso de la clase File

import java.io.*;
//import java.util.*;//.Scanner , .Locale

public class InforFichero {
   public static void main(String[] args) {
      File fichero = new File("numeros.txt");
      
      System.out.println("el método exists() devuelve " + fichero.exists());
      System.out.println("el método canRead() devuelve " + fichero.canRead());
      System.out.println("el método length() devuelve " + fichero.length());
      System.out.println("el método getAbsolutePath() devuelve " + fichero.getAbsolutePath());
      
      //Scanner leerFichero = new Scanner(fichero);
      //leerFichero.UseLocale(Locale.US);//Se le indica la configuración de teclado dependiendo del país
   }
}