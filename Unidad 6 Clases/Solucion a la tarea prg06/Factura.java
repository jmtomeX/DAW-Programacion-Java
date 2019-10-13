/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2018
  Modulo:   Programación.
  UD:       UD6 Clases.
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa:   Definición de la clase Factura
                              Trabaja con los datos de un cliente y su lista de productos comprados.
                              La lista tendrá un tamaño máximo de NUM productos pero el cliente podrá comprar menos.
                                
*******************************************************************************************************************/

import java.util.*;
import java.io.*;

public class Factura {

   // Atributos
   private Cliente comprador;
   private CompraProducto[] listaCompra;
   private int numProductos;
   private final int NUM = 10; 

   /*
      Constructor: crea la factura a partir de los datos del comprador.
      La lista de productos será una lista vacía de NUM productos
      Parámetros:
         unCliente: objeto de la clase Cliente
   */
   public Factura(Cliente unCliente) {
      
      // Inicializa los atributos para tener una lista vacía 
      listaCompra = new CompraProducto[NUM];
      comprador = new Cliente(unCliente);
      numProductos = 0;
      
      // Obtiene el fichero de compras y lo lee si existe 
      // Mejor canRead que exists
      File fichero = obtenerFichero();
      if (fichero.canRead()) {
         leerCompras(fichero);
      }
   }

   // Método privado (solo se usa dentro de la clase) que obtiene el fichero del cliente
   private File obtenerFichero() {  
      String nombreFichero = comprador.getNombre();
      nombreFichero = nombreFichero.toLowerCase();
      nombreFichero = nombreFichero.replace(" ", "");
      nombreFichero = nombreFichero + ".txt";
      return new File(nombreFichero);
   }
   
   // Método privado (solo se usa dentro de la clase) que lee el fichero y
   // guarda los productos en la lista
   private void leerCompras(File fichero) {
      Scanner leerFichero = null;
      try {            
         leerFichero = new Scanner(fichero);
         leerFichero.useLocale(Locale.US);
         
         while (leerFichero.hasNext() && numProductos < NUM) {
            String nombre = leerFichero.next();
            double precio = leerFichero.nextDouble();
            int cantidad = leerFichero.nextInt();
            addCompra(nombre, precio, cantidad);
         }
      } catch (Exception e) {
         System.out.println("Se ha producido la excepción: " + e);
      }
      if (leerFichero != null) {
         leerFichero.close();
      }
   }
  
   /*
      Método que añade la compra de un producto a la factura.
      Parámetros:
         unProducto el producto que el cliente a comprado
         cantidad la cantidad de producto que ha comprado
   */
   public void addCompra(String nombre, double precio, int cantidad) {
      if (numProductos < NUM) {
         CompraProducto unacompra = new CompraProducto(nombre, precio, cantidad);
         listaCompra[numProductos] = unacompra;
         numProductos++;
      } else {
         System.out.println("Tu lista de la compra está completa");
      }
   }

   /*
      Método que formatea la factura para mostrarla por consola o guardarla en un fichero.
      Utiliza el método format de la clase String. Funciona de manera análoga a printf.
      Devuelve la cadena formateada de la factura
   */
   public String toString() {
      
      // Título de la factura
      String factura =  String.format("%30s\n\n", "F A C T U R A");
      
      // Datos del comprador
      factura += comprador.toString();
      
      // Cabecera de los productos
      factura += String.format("\n\n%-30s%8s%8s%8s\n", "Descripcion", "Precio", "Cant.", "Total");
      
      // Lista de productos
      for(int i = 0; i < numProductos; i++) {  
         factura += listaCompra[i] + "\n";
      }
      
      // Total de la factura
      factura = factura + String.format("\nTOTAL: %8.2f Euros", getTotalFactura());

      return factura;
   }

   /*
      Método que calcula el total de la factura.
      Devuelve el total calculado
   */
   private double getTotalFactura() {
      double total = 0;
      for(int i = 0; i < numProductos; i++) {
         total = total + listaCompra[i].getPrecioTotal();
      }
      return total;
   }
   
   /*
      Método que busca un producto en la lista.
      Parámetros:
         nombre: nombre del producto buscado
      Devuelve el índice del producto en el array, -1 si no está.
   */
   public int buscaProducto(String nombre) {
      for(int i = 0; i < numProductos; i++) {
         if (nombre.equals(listaCompra[i].getNombre())) {
            return i;   // Acabamos en cuanto encontramos el producto
         }
      }
      return -1;
   }
   
   // Modifica la cantidad del producto con el índice indicado
   // Si la cantidad final es menor o igual que 0 hay que eliminar el producto de la lista
   public void modificarCompra(int indice, int cantidad) {
      int cantidadActual = listaCompra[indice].getCantidad();
      cantidadActual += cantidad;
      
      if (cantidadActual <= 0) {
         // Fin del bucle debe ser numProductos - 1 para no salirnos del array
         for (int i = indice; i < numProductos - 1; i++) {
            listaCompra[i] = listaCompra[i + 1];
         }
         numProductos--;
      } else {
         listaCompra[indice].setCantidad(cantidadActual);
      }
   }
   
   /*
      Este método no se pedía pero algunos lo habéis añadido
      Método que guarda la lista de productos en el fichero nombreapellido.txt.
      Parámetros:
         nombre: nombre del producto buscado
      Devuelve el índice del producto en el array, -1 si no está.
   */
   public void guardarCompras() {
      File fichero = obtenerFichero();
      PrintStream escribirFichero = null;
      try {
         escribirFichero = new PrintStream(fichero);
         for(int i = 0; i < numProductos; i++) {
            escribirFichero.print(listaCompra[i].getNombre() + " ");
            escribirFichero.print(listaCompra[i].getPrecio() + " ");
            escribirFichero.println(listaCompra[i].getCantidad());
         }
      } catch (Exception e) {
         System.out.println("Se ha producido la excepción: " + e);
      }
      if (escribirFichero != null) {
         escribirFichero.close();
      }
   }
}