// Este programa es un ejemplo de uso de la sentencia try-catch-finally
// para gestionar excepciones
//
// hasNextInt, hasNextDouble: InputMismatchException
// hasNext, hasNextLine: NoSuchElementException
// canRead: FileNotFoundException

import java.io.*;
import java.util.*;

public class TryCatch {
   public static void main(String[] args) throws FileNotFoundException {
      File fichero = new File("alumnosID.txt");
      Scanner leerFichero = null;
      try {
         leerFichero = new Scanner(fichero);
         procesar(leerFichero);
      } catch (FileNotFoundException excepcion) {
         System.out.println("Excepción");
      } catch (Exception excepcion) {
         System.out.println("Otras excepción");
         System.out.println(excepcion.getMessage());
      } finally {
         System.out.println("Se ejecuta siempre");
      }
      
      if (leerFichero != null) {
         leerFichero.close();
      }
      System.out.println("Final del programa");
   }
 
   public static void procesar(Scanner entrada) {
      for (int i = 0; i < 5; i++) {
         String linea = entrada.nextLine();
         System.out.println(linea);
      }
   }
}