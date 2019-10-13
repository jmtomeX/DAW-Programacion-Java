/*
   Programa que analiza las consecuencias de pasar los objetos por referencia
   Se está pasando el objeto y no una copia
   Si luego modificamos ese objeto, cambia también el original
*/

import java.util.*;
import java.io.*;

public class RutaCliente {
   public static void main(String[] args) throws FileNotFoundException {
        
      // Crea una ruta con título
      Ruta miRuta = new Ruta("Mi excursión");
      
      // Creo un punto y lo añado a la ruta
      Punto unPunto = new Punto(0, 0, "Inicio");
      miRuta.addPunto(unPunto);
      
      // Mostrar ruta
      System.out.println(miRuta);
      
            
      // Modificamos el punto unPunto y afecta a la ruta
      // No debería pasar
      unPunto.setEtiqueta("Fin");
      System.out.println(miRuta);
      
      // Obtenemos un punto y lo modificamos
      // La ruta también cambia y no debería pasar
      Punto otroPunto = miRuta.getPunto(0);
      otroPunto.setCoordenadas(10, 10);
      System.out.println(miRuta);
   }
}