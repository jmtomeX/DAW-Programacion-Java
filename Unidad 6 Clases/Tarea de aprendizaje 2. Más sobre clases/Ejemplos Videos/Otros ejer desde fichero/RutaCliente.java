/*
   Programa cliente que utiliza la clase Punto y la clase Ruta
   Tanto la entrada como la salida de datos se hará desde el main
   Las clases recibirán los datos después de ser leídos y formatearán la salida
   Serán independientes de las fuentes de entrada y salida de datos
*/

import java.util.*;
import java.io.*;

public class RutaCliente {
   public static void main(String[] args) throws FileNotFoundException {
        
      Scanner leerFichero = new Scanner(new File("ruta.txt"));

      // Crear una ruta de puntos
      Ruta miRuta = crearRuta(leerFichero);
      
      // Modificar los valores de los puntos del array
      modificarDatos(leerFichero, miRuta);
      
      // Mostrar ruta
      System.out.println(miRuta.toString());
      
      // Calcular la longitud de la ruta
      double longitud = miRuta.calcularDistancia();
      System.out.printf("Longitud total de la ruta: %.2f", longitud);
   }
   
   // Método para crear la ruta
   // Lee el nombre y el número de puntos de un fichero y crea la ruta
   // Todos los puntos se incializarán a (0, 0)
   public static Ruta crearRuta(Scanner leerDatos) {
      String nombre = leerDatos.next();
      int num = leerDatos.nextInt();
      
      return new Ruta(nombre, num);  
   }
   
   // Método para modificar los valores de los puntos de la ruta
   // desde un fichero
   public static void modificarDatos(Scanner leerDatos, Ruta miRuta) {
      int longi = miRuta.getLongitud();
      for (int i = 0; i < longi; i++) {

          // Leer el nombre para el punto
         String etiqueta = leerDatos.next();
         
         // Leer coordenadas
         int x = leerDatos.nextInt();
         int y = leerDatos.nextInt();
                  
         // Modificar los valores de x e y del elemento i del array
         miRuta.setPunto(i, etiqueta, x, y);
      }
   }
}