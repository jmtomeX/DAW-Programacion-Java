/*
   Programa cliente que utiliza la clase Punto
   Crea una ruta, un array de puntos
*/
import java.util.*;

public class RutaCliente {
   public static void main(String[] args) {
      
      // Pide el número de puntos de la ruta
      Scanner leerTeclado = new Scanner(System.in);
      System.out.print("Nombre de la ruta: ");
      String titulo = leerTeclado.next();
      System.out.print("Número de puntos en la ruta: ");
      int num = leerTeclado.nextInt();
      
      // Crea una ruta del número de puntos indicado
      Ruta ruta = new Ruta(titulo, num);
      
      modificaRuta(ruta, leerTeclado);
      muestraRuta(ruta);
      System.out.printf("Longitud total de la ruta: %.2f\n", ruta.calcularDistancia());

      // Crear otra ruta, ésta de 4 puntos
      Ruta otraRuta = new Ruta("Ascension", 4);      
      modificaRuta(otraRuta, leerTeclado); 
      muestraRuta(otraRuta);
      System.out.printf("Longitud total de la ruta: %.2f\n", otraRuta.calcularDistancia());  
   }
   
   /*
      Modifica los valores de los puntos del array
   */
   public static void modificaRuta(Ruta ruta, Scanner leerDatos) {
      for (int i = 0; i < ruta.getLongitud(); i++) {
      
         // Pedir coordenadas
         System.out.print("Introduce coordenadas: ");
         int x = leerDatos.nextInt();
         int y = leerDatos.nextInt();

          // Pedir un nombre para el punto
         System.out.print("Introduce etiqueta: ");
         String etiqueta = leerDatos.next();

         // Modificar los atributo del elemento i del array
         ruta.setPunto(i, etiqueta, x, y);
      }
   }
   
   /*
      Mostrar los puntos de la ruta
   */
   public static void muestraRuta(Ruta ruta) {
      System.out.print(ruta);
   }
}