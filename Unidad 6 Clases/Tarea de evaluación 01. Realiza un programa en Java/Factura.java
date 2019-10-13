import java.util.*;
import java.io.*;
// Clase Factura
public class Factura {
// Atributos
   private Cliente comprador;
   private CompraProducto[] listaCompra;
   private int numProductos;
   private final int NUM = 10; 
   Scanner teclado = new Scanner(System.in);
  //Constructor
   public Factura(Cliente unCliente) throws FileNotFoundException {
      // Constructor: crea la factura a partir de los datos del comprador o de la compradora
      comprador = new Cliente(unCliente.getNombre(),unCliente.getCalle(), unCliente.getCiudad(), unCliente.getProvincia(), unCliente.getcodigoPostal());
    // La lista de productos sería una lista vacía de NUM productos
      //inicialalizamos el array al número máximo de valores  
      listaCompra = new CompraProducto[NUM];
      for (int i = 0; i < listaCompra.length; i++) {
         // Crear un punto
         CompraProducto anhadirProducto = new CompraProducto();
         // Asigna el producto a un elemento del array
         // El elemento del array referenciará o apuntará al producto
         listaCompra[i] = anhadirProducto;
      }
      //Cogemos el nombre del comprador para buscar el archivo
      String nombrecomprador = comprador.getNombre().replace(" ","").toLowerCase();   
      boolean ficheroLeido = false;
      Scanner leerFichero = null;
      //Conectamos con el fichero
      File archivo = new File(nombrecomprador + ".txt");
       
        // Utilizará la sentencia try-catch para gestionar las excepciones
      //Comprobamos si existe el fichero
      try{
         // Si existe un fichero TXT para el comprador o la compradora
         // leerá los productos y los guardará en el array hasta llenarlo
         if (archivo.exists()) {
            //si existe lo leeremos
            leerFichero = new Scanner(archivo); 
            leerFichero.useLocale(Locale.US);// Notación americana, números con punto decimal
            String nombre = "";
            double precio = 0.0;
            int cantidad = 0;
           //mientras que tenga líneas para leer las leerá
            while(leerFichero.hasNextLine()) {
              //Leemos los datos del fichero
               nombre = leerFichero.next();
               precio = leerFichero.nextDouble();
               cantidad = leerFichero.nextInt();
               //Añadimos los datos del fichero a una compra
               CompraProducto nuevaCompra = new CompraProducto(nombre, precio, cantidad);
               //Añadimos el producto a la listaCopra
               listaCompra[numProductos] = nuevaCompra;
               //numProductos llevará la cuenta de productos 
               numProductos++;
            }
         }
         ficheroLeido = true;
      } catch (FileNotFoundException excepcion) { 
         System.out.println("Error al abrir el fichero");
         
      }finally {
         if(leerFichero != null) {
            leerFichero.close();
         }
      }
   }
  
   //Get & Set
   
   public int getNumProductos() {
      return numProductos;
   }
   
   public CompraProducto[] getListaCompra() {
      return listaCompra;
   }
      
   public void setNumProductos(int numProductos) {
      this.numProductos = numProductos;
   }
   
   
//Otrod métodos

    //Método para añadir una línea de compra, recibe 3 parámetros (String nombre, double precio, int cantidad) 
   public void addCompra(String nombre, double precio, int cantidad) {
      // Si todavía hay sitio en el array añadirá la compra de un producto a la factura.
      if(numProductos <= 10){
         numProductos++;//aumenta la compra en número productos
         for(int i = numProductos; i <= numProductos; i++) {
            listaCompra[i - 1].setNombre(nombre);
            listaCompra[i - 1].setPrecio(precio);
            listaCompra[i - 1].setCantidad(cantidad);
         }
      }
   }


/* Formatea la factura de la siguiente manera:
                F A C T U R A      // Hueco de 30 caracteres, texto alineado a la derecha

Pedro Olabe
Catillo 15
Vitoria, Araba 01194

Descripcion                     Precio   Cant.   Total      // Formateo igual que los productos
Queso                             5,50       1    5,50
Mermelada                         3,20       2    6,40
Patatas                           0,99      10    9,90
Manzanas                          1,29       4    5,16

TOTAL:    26,96 Euros      // TOTAL: (hueco de 8 caracteres, texto alineado a la derecha, 2 decimales) Euros
      
Puede ser útil usar el método format de la clase String.*/
//Devuelve un String con el texto.
   public String toString() {
      String salidaDatos = "\n";
      salidaDatos += "                         FACTURA                       \n";
      salidaDatos += comprador.toString() + "\n";
      salidaDatos +="Descripcion                      Precio    Cant.    Total \n";
      for(int i = 0; i < numProductos; i++) { 
         salidaDatos += listaCompra[i] + "\n";
      }
      //salidaDatos = String.format("%-30s %8.2f %8d %8.2f", nombre, precio, cantidad ,getPrecioTotal(precio, cantidad));
      salidaDatos += String.format("\nTOTAL: %.2f", getTotalFactura());
      return salidaDatos;
   }

// Calcula y devuelve el total de la factura. Devuelve un double
   public double getTotalFactura() {
      double totalFactura = 0.0;
      double precio = 0.0;
      int cantidad = 0;
      for (int i = 0; i < numProductos ; i++) {
         totalFactura += listaCompra[i].getPrecioTotal(listaCompra[i].getPrecio(), listaCompra[i].getCantidad());
      }
      return totalFactura;
   }
      
// Busca un producto en la lista a partir de su nombre
// Devuelve el ìndice del producto en el array, -1 si no está.Recibe como parametro (String nombre) y devuelve un int.
   public int buscaProducto(String nombre) {
      int indice = 0;
      int cont = 0;
      for(int i = 0; i < numProductos; i++) {
         if(listaCompra[i].getNombre().equalsIgnoreCase(nombre)) {
            indice = i;
            cont++;//Si encuentra un producto ya no devuelve -1, si no sí.
         } else if(!listaCompra[i].getNombre().equalsIgnoreCase(nombre) && cont == 0) {
            indice = -1;
         }
      }
      return indice;
   }
   
// Modifica la cantidad del producto con el índice indicado
//Recibe  3 variables (int indice, int cantidad, boolean eliminaAnnade) 
//eliminaAnnade se ha creado para decir si es compra o devolución.
   public void modificarCompra(int indice, int cantidad, boolean eliminaAnnade) {
      int nuevaCantidad = 0;
      if(eliminaAnnade == true) {
         nuevaCantidad = listaCompra[indice].getCantidad() + cantidad;
         listaCompra[indice].setCantidad(nuevaCantidad);
      } else {
         nuevaCantidad = listaCompra[indice].getCantidad() - cantidad;            
      }
   
   // Si la cantidad final es menor o igual que 0 el producto se elimina de la lista   
      if(nuevaCantidad <= 0) {
         eliminarProducto(indice,listaCompra);
      }  
   }
   
  //Método que eliminar un producto, recibe como parámetros (int indice, CompraProducto[] listaCompra)
   public  void eliminarProducto(int indice, CompraProducto[] listaCompra) {
   // buscamos el producto a eliminar
      for (int i = 0; i < numProductos ; i++) {
         if (listaCompra[i].equals(indice)) {
            indice = i;
            i = numProductos; //Terminamos el bucle
         }
      }
      if ( (indice != -1) ) { //Si el producto existe
         listaCompra[indice] = null; // Lo borramos
         for (int j = indice ; j < numProductos; j++) // Movemos los que estén despues
            listaCompra[j] = listaCompra[j + 1] ;
         numProductos--; //Reducimos el numero de productos  
      }
   }  
}


                
