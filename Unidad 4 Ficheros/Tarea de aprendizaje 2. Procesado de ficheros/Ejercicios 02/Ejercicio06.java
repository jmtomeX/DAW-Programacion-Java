/*
Tenemos el siguiente fichero, clientes.txt:

125-1 Sur 105.70 225.00 157.00 147.00
147-1 Avelinos 224.00 157.00 224.00 38.50
189-1 Doimar 178.00 201.00 265.00 265.00
145-1 Lazaro 56 285.30 104.00 98.50 125.00
121-1 Domino 87.90 56.00 105.00 74.00
138-1 Marimar 360.00 448.60 226.00 307.00

Escribe lo que mostraría en consola el siguiente programa:
*/
import java.util.*;
import java.io.*;

public class Ejercicio06 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFich = new Scanner(new File("..\\Ejercicios 01\\clientes.txt"));
      System.out.println("Ventas totales:");
      while (leerFich.hasNextLine()) {
         String linea = leerFich.nextLine();
         Scanner leerLinea = new Scanner(linea);
         leerLinea.useLocale(Locale.US);
         String id = leerLinea.next();
         String cliente = leerLinea.next();
         
         double total = 0;;
         while (leerLinea.hasNextDouble()) {
            double ventas = leerLinea.nextDouble();
            total = total + ventas;
         }
         System.out.println(cliente + " (" + id + "): " + total);    
      }
      leerFich.close();
   }
}