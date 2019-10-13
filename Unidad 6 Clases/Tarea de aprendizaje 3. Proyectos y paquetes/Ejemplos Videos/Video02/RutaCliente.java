/*
   Programa cliente que utiliza la clase Punto y la clase Ruta
   Tanto la entrada como la salida de datos se hará desde el main
   Las clases recibirán los datos después de ser leídos y formatearán la salida
   Serán independientes de las fuentes de entrada y salida de datos
*/
import ud6.geolocalizacion.*;
import java.util.*;
public class RutaCliente {
   public static void main(String[] args) {
      
      // Crear una ruta de puntos
      Scanner leerTeclado = new Scanner(System.in);
      Ruta miRuta = crearRuta(leerTeclado);
           
      // Modificar los valores de los puntos de la ruta
      modificarDatos(leerTeclado, miRuta);
      
      // Mostrar ruta
      System.out.println(miRuta.toString());
      
      // Calcular la longitud de la ruta
      double longitud = miRuta.calcularDistancia();
      System.out.printf("Longitud total de la ruta: %.2f", longitud);
   }

   // Método para crear la ruta
   // Lee el nombre y el número de puntos por teclado y crea la ruta
   // Todos los puntos se incializarán a (0, 0)
   public static Ruta crearRuta(Scanner leerDatos) {
      System.out.print("Nombre de la ruta: ");
      String nombre = leerDatos.next();
      System.out.print("Número de puntos en la ruta: ");
      int num = leerDatos.nextInt();
      
      return new Ruta(nombre, num);  
   }
   
   // Método para modificar los valores de los puntos de la ruta
   public static void modificarDatos(Scanner leerDatos, Ruta miRuta) {
      int longi = miRuta.getLongitud();
      for (int i = 0; i < longi; i++) {
      
         // Pedir coordenadas
         System.out.print("Introduce coordenadas: ");
         int x = leerDatos.nextInt();
         int y = leerDatos.nextInt();
      
          // Pedir un nombre para el punto
         System.out.print("Introduce etiqueta: ");
         String etiqueta = leerDatos.next();
                  
         // Modificar los valores de x e y del elemento i del array
         miRuta.setPunto(i, etiqueta, x, y);
      }
   }
}