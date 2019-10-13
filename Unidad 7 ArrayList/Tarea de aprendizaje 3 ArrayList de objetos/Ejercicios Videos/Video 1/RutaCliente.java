/*
   Programa principal: crea una ruta a partir de un fichero
   La muestra por pantalla y calcula su distancia
   No sabemos si la clase Ruta usa Arrays o ArrayLists
   Se abstrae de cómo está construída la clase Ruta
   La clase Ruta encapsula los detalles de cómo está construída al exterior
   Solo importa los métodos definidos para utilizar la clase Ruta
*/

import java.util.*;
import java.io.*;

public class RutaCliente {
   public static void main(String[] args) throws FileNotFoundException {
        
      // Crear una ruta de puntos a partir de un fichero
      Ruta miRuta = crearRuta();
      
      // Mostrar ruta
      System.out.println(miRuta);
      
      // Calcular la longitud de la ruta
      double longitud = miRuta.calcularDistancia();
      System.out.printf("Longitud total de la ruta: %.2f", longitud);
   }
   
   // Método para crear una ruta, leer sus puntos de un fichero y guardarlos
   public static Ruta crearRuta() throws FileNotFoundException {
      Scanner leerDatos = new Scanner(new File("ruta.txt"));
      String titulo = leerDatos.nextLine();
      int num = leerDatos.nextInt();

      // Crear una ruta de puntos
      Ruta miRuta = new Ruta(titulo, num);
      
      for(int i = 0; i < num; i++) {
               
         // Leer coordenadas
         String etiqueta = leerDatos.next();
         int x = leerDatos.nextInt();
         int y = leerDatos.nextInt();
                  
         // Modificar los valores de x e y del elemento i del array
         miRuta.setPunto(i, etiqueta, x, y);
      }
      return miRuta;
   }
}