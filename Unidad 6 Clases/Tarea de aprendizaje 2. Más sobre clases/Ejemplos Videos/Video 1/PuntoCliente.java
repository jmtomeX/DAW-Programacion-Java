/*
   Programa cliente que utiliza la clase Punto
   Crea una ruta, un array de puntos
*/
import java.util.*;

public class PuntoCliente {
   public static void main(String[] args) {
      
      // Pide el número de puntos de la ruta
      Scanner leerTeclado = new Scanner(System.in);
      System.out.print("Número de puntos en la ruta: ");
      int num = leerTeclado.nextInt();
      
      // Crea una ruta del número de puntos indicado
      Punto[] ruta;
      ruta = new Punto[num];
      
      inicializaRuta(ruta);
      modificaRuta(ruta, leerTeclado);
      muestraRuta(ruta);
      System.out.printf("Longitud total de la ruta: %.2f\n", longitudRuta(ruta));

      // Crear otra ruta, ésta de 4 puntos
      Punto[] otraRuta = creaRuta(leerTeclado); 
      muestraRuta(otraRuta);
      System.out.printf("Longitud total de la ruta: %.2f\n", longitudRuta(otraRuta));  
   }
      
   /*
      Inicializa el array de punto
      Rellena el array con puntos (0, 0, "")
   */
   public static void inicializaRuta(Punto[] ruta) {
      for (int i = 0; i < ruta.length; i++) {
      
         // Crear un punto
         Punto nuevoPunto = new Punto();
         
         // Asigna el punto a un elemento del array
         // El elemento del array referenciará o apuntará al nuevo punto
         ruta[i] = nuevoPunto;
      }
   }
   
   /*
      Modifica los valores de los puntos del array
   */
   public static void modificaRuta(Punto[] ruta, Scanner leerDatos) {
      for (int i = 0; i < ruta.length; i++) {
      
         // Pedir coordenadas
         System.out.print("Introduce coordenadas: ");
         int x = leerDatos.nextInt();
         int y = leerDatos.nextInt();

          // Pedir un nombre para el punto
         System.out.print("Introduce etiqueta: ");
         String etiqueta = leerDatos.next();

         // Modificar los atributo del elemento i del array
         ruta[i].setCoordenadas(x, y);
         ruta[i].setEtiqueta(etiqueta);
      }
   }
   
   /*
      Mostrar los puntos de la ruta
   */
   public static void muestraRuta(Punto[] ruta) {
      System.out.print("RUTA: ");
      System.out.print(1 + ". " + ruta[0].toString());
      for (int i = 1; i < ruta.length; i++) {      
         System.out.print(" --> " + (i + 1) + ". " + ruta[i].toString());                  
      }
      System.out.println();
   }
  
   /*
      Calcular la longitud de la ruta
   */
   public static double longitudRuta(Punto[] ruta) {
      double longitud = 0;
      for (int i = 0; i < ruta.length - 1; i++) {
      
         // Calcular distancia entre 2 puntos consecutivos y sumarla
         Punto p1 = ruta[i];
         Punto p2 = ruta[i + 1];
         longitud += p1.distanciaPuntos(p2);
      }
      return longitud;
   }

   /*
      Crea los puntos del array con valores introducidos por teclado
   */
   public static Punto[] creaRuta(Scanner leerDatos) {
      Punto[] ruta = new Punto[4];
      for (int i = 0; i < ruta.length; i++) {
      
         // Pedir coordenadas
         System.out.print("Introduce coordenadas: ");
         int x = leerDatos.nextInt();
         int y = leerDatos.nextInt();
 
          // Pedir un nombre para el punto
         System.out.print("Introduce etiqueta: ");
         String etiqueta = leerDatos.next();
                 
         // Crear el punto
         Punto nuevoPunto = new Punto(x, y, etiqueta);
         
         // Asignárselos a un elemento del array
         // El elemento del array referenciará o apuntará al nuevo punto
         ruta[i] = nuevoPunto;
      }
      return ruta;
   }
}