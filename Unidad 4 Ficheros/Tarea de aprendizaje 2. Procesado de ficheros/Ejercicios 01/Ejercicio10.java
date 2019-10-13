/*
Escribe un programa que leera el fichero clientes.txt y mostrara los clientes con ventas superiores a 800 euros.
El fichero sigue el siguiente formato. Cada linea guardara los datos de un cliente: id, nombre y ventas de los ultimos cuatro años:

125-1 Sur 105.70 225.00 157.00 147.00
147-1 Avelinos 224.00 157.00 224.00 38.50
189-1 Doimar 178.00 201.00 265.00 265.00
145-1 Lazaro 56 285.30 104.00 98.50 125.00
121-1 Domino 87.90 56.00 105.00 74.00
138-1 Marimar 360.00 448.60 226.00 307.00

El resultado de programa deberia ser:

Las ventas de Doimar son: 909.0
Las ventas de Marimar son: 1341.6
*/
import java.util.*;
import java.io.*;

public class Ejercicio10 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFich = new Scanner(new File("clientes.txt"));
      
      while(leerFich.hasNextLine()){
         String linea = leerFich.nextLine();
         Scanner leerLinea= new Scanner(linea);
         String id = leerLinea.next();
         String nombre = leerLinea.next();
         leerLinea.useLocale(Locale.US);
         double suma = 0.0;
         
         
         while(leerLinea.hasNextDouble()){
            double venta = leerLinea.nextDouble();
            suma += venta;
         }
         if(suma > 800){
            System.out.println("Las ventas de " + nombre + " son " + suma);
         }
        
      }
      leerFich.close();
   }
    
}
