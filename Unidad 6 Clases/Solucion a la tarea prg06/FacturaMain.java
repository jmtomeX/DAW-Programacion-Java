/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2018
  Modulo:   Programación.
  UD:       UD6 Clases.
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa:   Este programa crea la factura y la imprime por consola
                              Para ello, pide los datos del cliente y crea una factura 
                              A continuación, muestra un menú de opciones hasta que se elija finalizar.
  
  Enlace autoevaluación: 
                                
*******************************************************************************************************************/

import java.util.*;     // Para utilizar el objeto Scanner
import java.io.*;       // Para utilizar los ficheros

public class FacturaMain {

   // Constantes
   public static final int FIN = 1;
   public static final int COMPRAR = 2;
   public static final int DEVOLVER = 3;
   
   // Método principal
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerTeclado = new Scanner(System.in);
   
      presentacion();
        
      Cliente datosCliente = pideDatosCliente(leerTeclado);
      Factura facturaCliente = new Factura(datosCliente);
      
      System.out.println(facturaCliente);
      int opcion = elegirOpcion(leerTeclado);
      while (opcion != FIN) {
         switch (opcion) {
            case COMPRAR:
               comprar(leerTeclado, facturaCliente);
               break;
            case DEVOLVER:
               devolver(leerTeclado, facturaCliente);
               break;
            default:
               System.out.println("Opción incorrecta");
               break;
         }
         System.out.println(facturaCliente);
         opcion = elegirOpcion(leerTeclado);
      }
   
      facturaCliente.guardarCompras();
      System.out.println(facturaCliente);
      guardarFactura(facturaCliente);
   }
   
   /*
      Presentación
   */
   public static void presentacion() {
      System.out.println("Este programa muestra la factura de la compra realizada");
      System.out.println("por un cliente o una clienta");
      System.out.println("Lee la lista de la compra inicial de un fichero, si es que existe");
      System.out.println("Mediante un menú permite comprar más productos o devolverlos");
      System.out.println("Cuando se elige finalizar, muestra la factura definitiva");
      System.out.println();
   }
   
   /*
      Método que pide los datos del cliente
      Parámetros:
         consola: el Scanner para leer datos por teclado
         decuelve un objeto de la clase Cliente con los datos leídos
   */
   public static Cliente pideDatosCliente(Scanner consola) {     
      System.out.print("Nombre del cliente o la clienta: ");
      String nombre = consola.nextLine();
      System.out.print("Calle: ");
      String calle = consola.nextLine();
      System.out.print("Ciudad: ");
      String ciudad = consola.nextLine();
      System.out.print("Provincia: ");
      String provincia = consola.nextLine();
      System.out.print("Código postal: ");
      String codigoPostal = consola.nextLine();
      
      return new Cliente(nombre, calle, ciudad, provincia, codigoPostal);
   }

   /*
      Elegir opcion:  muestra el menú, lee la opción elegida y la devuelve
      Parámetros: 
         Scanner consola para leer datos por teclado
      return: un char con la opción elegida
   */
   public static int elegirOpcion(Scanner consola) {
      System.out.print("\n******* MENU *******\n1. Imprimir factura\n2. Comprar un producto\n3. Devolver un producto\n");
      System.out.print("Elige tu opción: ");
      int opcion = consola.nextInt();
      return opcion;
   }

   /*
      Pide los datos del producto. Si existe modifica la cantidad, si no lo añade a la lista.
      Parámetros: 
         Scanner consola: para leer datos por teclado
         Factura unaFactura: para añadir o modificar los productos de la factura
      No devuelve nada
   */   
   public static void comprar(Scanner consola, Factura unaFactura) {
      System.out.print("Nombre del producto: ");
      String nombre = consola.next();
      System.out.print("Cantidad: ");
      int cantidad = consola.nextInt();
      int indice = unaFactura.buscaProducto(nombre);
      if (indice == -1) {
         System.out.print("Precio: ");
         double precio = consola.nextDouble();
         unaFactura.addCompra(nombre, precio, cantidad);
      } else {
         unaFactura.modificarCompra(indice, cantidad);
      }
      
   }
   
   /*
      Pide los datos del producto. Si existe modifica la cantidad, si no avisa que el producto no está en la lista.
      Parámetros: 
         Scanner consola: para leer datos por teclado
         Factura unaFactura: para modificar los productos de la factura
      No devuelve nada
   */ 
   public static void devolver(Scanner consola, Factura unaFactura) {
      System.out.print("Nombre del producto: ");
      String nombre = consola.next();
      int indice = unaFactura.buscaProducto(nombre);
      if (indice != -1) {
         System.out.print("Cantidad: ");
         int cantidad = consola.nextInt();
         unaFactura.modificarCompra(indice, -cantidad);
      } else {
         System.out.println("Ese producto no está en la lista de la compra");
      }
   }
   
   /*
      Este método no era obligatorio pero algunos lo habéis incluido
      Método que guarda la factura en el fichero factura.txt.
      Parámetros:
         Factura unaFactura: para poderla guardar
      No devuelve nada.
   */
   public static void guardarFactura(Factura unaFactura) {
      PrintStream escribirFichero = null;
      try {
         escribirFichero = new PrintStream(new File("factura.txt"));
         escribirFichero.print(unaFactura);
      } catch (Exception e) {
         System.out.println("Se ha producido la excepción: " + e);
      }
      if (escribirFichero != null) {
         escribirFichero.close();
      }
   }

}