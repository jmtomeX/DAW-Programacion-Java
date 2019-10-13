  /***********************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  15/02/2019.
 Módulo:  Programación.
 Tarea:   PROG06 Tarea de evaluación 01. Realiza un programa en Java
 
 Descripción del programa: En concreto, el programa leerá por teclado los datos de un cliente, 
 obtendrá de un fichero los productos que ha comprado y mostrará la factura total de la compra.
 Además, proporcionará un menú que permitirá modificar la lista de la compra. Cuando se elija
 imprimir factura, el programa mostrará la factura definitiva y acabará.
    
 El fichero si existe, tendrá el nombre del cliente en minúsculas, sin espacios en blanco y
 con extensión txt. Por ejemplo, si el nombre de la clienta es Marta Alda, el nombre de su
 fichero será martaalda.txt.

 En el fichero habrá tantas líneas como productos se han comprado y en cada una de ellas siempre
 se indicará primero el nombre del producto con una sola palabra, luego el precio y
 finalmente la cantidad comprada. 
 
RECOMENDACIONES ==>  	FUNCIONALIDAD (70%): 8,5
En la clase Cliente puedes acceder directamente a los atributos de un objeto de esta clase. No harían falta los métodos get.
Cuando gestionas las excepciones con try-catch no necesitas throws.
El for del método addCompra solo se ejecuta un vez, lo puedes eliminar.
El método getPrecioTotal no necesita parámetros, accede directamente a los atributos de la clase.
En el método buscaProducto es mejor inicializar a -1. Si encuentra el producto cambia el valor y si no al final devolverá -1.
En el método eliminarProducto no hace falta buscar el producto. Sabemos que existe y solo lo tenemos que eliminar.
En el menú el código que está en todas las opciones es mejor sacarlo fuera y escribirlo una sola vez.
En el método modificarCompra no necesitas el parámetro boolean. Puedes sumar siempre: valores positivos en las compras y negativos en las devoluciones.
En este caso no cambia el número de productos.
COMENTARIOS (15%): 8
Recuerda comentar también los ficheros de las clases.
LEGIBILIDAD (15%): 10
NOTA PROFE: 8,65 (Buen trabajo)
AUTOEVALUACION: 9,25
A los métodos de la clase no hay que pasarles como parámetro los atributos. Son directamente accesibles.
Los métodos que creas en una clase y solo se usan dentro de ella se pueden declarar como private.  
 
 
 
     
*************************************************************************************************/ 
import java.util.*;
import java.io.*;

public class FacturaMain {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner teclado = new Scanner(System.in);
      intro();
      //Pedir un cliente
      Cliente PedirCliente = new Cliente(PedirCliente(teclado));    
   
      Factura nuevaFactura = new Factura(PedirCliente);
      System.out.println(nuevaFactura.toString());
   
      int opcion = 0;
      System.out.println();
      do{
         System.out.println("******* MENU *******\n1. Imprimir factura\n2. Comprar un producto\n3. Devolver un producto");
         System.out.print("Elige tu opción: ");
         while(!teclado.hasNextInt()){
            teclado.next();
            System.out.println("Opción incorrecta\n");
            System.out.println("******* MENU *******\n1. Imprimir factura\n2. Comprar un producto\n3. Devolver un producto");
            System.out.print("Elige tu opción: ");
         }
         opcion = teclado.nextInt();
         switch (opcion) {
            case 1:System.out.println(nuevaFactura.toString() + "\n");//Mostrará la factura
               break;
            case 2: ComprarProducto(teclado, nuevaFactura);
               System.out.println(nuevaFactura.toString() + "\n");//Mostrará la factura
               break;
            case 3:  devolverProducto(teclado, nuevaFactura);
               System.out.println(nuevaFactura.toString() + "\n");//Mostrará la factura
               break;
            default: System.out.println("Opción incorrecta\n");
               System.out.println(nuevaFactura.toString() + "\n");//Mostrará la factura
               break;
         }
         System.out.println();
      } while(opcion != 1);//Hasta que no se inserte un 1 no saldra el programa.
   }
   
   //Métodos del main
   //Mostrará la introducción del programa
   public static void intro() {
      System.out.println("Este programa muestra la factura de la compra realizada\npor un cliente o una clienta");
      System.out.println("Lee la lista de la compra inicial de un fichero, si es que existe\nMediante un menú permite comprar más productos o devolverlos");
      System.out.println("Cuando se elige finalizar, muestra la factura definitiva\n");
   }
   //Método para pedir un cliente recibe un objeto de la clase Scanner y devuelve otro objeto de la clase Cliente
   //Recibe un parámetro de tipo Scanner y devuelve un objeto de tipo Cliente
   public static Cliente PedirCliente(Scanner leerTeclado) {
      System.out.print("Nombre del cliente o de la clienta: ");
      String nombre = leerTeclado.nextLine();
      System.out.print("Calle: ");
      String calle = leerTeclado.nextLine();
      System.out.print("Ciudad: ");
      String ciudad = leerTeclado.nextLine();
      System.out.print("Provincia: ");
      String provincia = leerTeclado.next();
      System.out.print("Código Postal: "); 
      String codigoPostal = leerTeclado.next();
      System.out.println();
    
      return new Cliente(nombre, calle, ciudad, provincia, codigoPostal);
   }
   
 /*
   Cuando se elija "Comprar un producto", pedirá el nombre y la cantidad. Si el producto no está en la lista 
   también pedirá el precio y lo añadirá a la factura. En caso contrario, solamente actualizará la cantidad comprada.
   Obtendrá la cantidad actual y le añadirá la nueva.
   Recibe dos parámetros (Scanner teclado, Factura factura)
   */
   public static void ComprarProducto(Scanner teclado, Factura factura) {
      System.out.print("\nNombre del producto: ");
      String nombre = teclado.next();
      System.out.print("Cantidad: ");
      int cantidad = teclado.nextInt();
    //Muestra el indice del producto si está
      int indice = factura.buscaProducto(nombre);
      boolean comprar = true; //true le damos el valor de compra, false sería devolución
   //Si el indice es mayor a -1 el producto se modifica ya que existe
      if(indice >= 0) {
         factura.modificarCompra(indice, cantidad, comprar);
         factura.setNumProductos(factura.getNumProductos());
      } else {
      //Si no se crea una linea de compra nueva
         System.out.print("Precio: ");
         double precio = teclado.nextDouble();
         factura.addCompra(nombre, precio, cantidad);
      
      }
   }  
   /*Cuando se elija "Devolver un producto", pedirá el nombre producto Si el producto no está en la lista,
    informará de ello. En caso contrario, pedirá la cantidad a devolver y actualizará la cantidad comprada. 
    Si la cantidad final del producto es menor o igual a 0 se eliminará de la factura.*/
   public static void devolverProducto(Scanner teclado, Factura factura) {
      boolean eliminar = false;//false le damos el valor de devolución, true sería compra
      System.out.print("Nombre del producto:");
      String nombreProd = teclado.next();
      int indice = factura.buscaProducto(nombreProd);
      if(indice == -1) { 
         System.out.println("Ese producto no está en la lista de la compra");
      } else {
         System.out.print("Cantidad: ");
         int cantidad = teclado.nextInt();
         factura.modificarCompra(factura.buscaProducto(nombreProd), cantidad, eliminar);
      }
   } 
}