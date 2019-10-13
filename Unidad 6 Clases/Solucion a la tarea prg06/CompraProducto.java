/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2018
  Modulo:   Programación.
  UD:       UD6 Clases.
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa:   Definición de la clase CompraProducto.
                              Necesita la descripción del producto, su precio y la cantidad comprada
                                
*******************************************************************************************************************/

public class CompraProducto {

   // Atributos
   private String nombre;
   private double precio;
   private int cantidad;

   /*
      Constructor: crea una compra a partir de la descripción y el precio del producto y la cantidad comprada.
      Parámetros:
         nombre: descripción del producto comprado
         precio: precio del producto comprado
         cantidad: la cantidad comprada del producto
   */
   public CompraProducto(String nombre, double precio, int cantidad) {
      this.nombre = nombre;
      this.precio = precio;
      this.cantidad = cantidad;
   }
    
   /*
      Método que calcula el precio total de la compra.
      Devuelve el precio total
   */
   public double getPrecioTotal() {
      return precio * cantidad;
   }
   
   /*
      Método que devuelve el nombre del producto
   */
   public String getNombre() {
      return nombre;
   }
   
   /*
      Método que devuelve la cantidad del producto
   */
   public int getCantidad() {
      return cantidad;
   }
   
   /*
      Método que devuelve la cantidad del producto
   */
   public double getPrecio() {
      return precio;
   }
   
   /*
      Método que devuelve la cantidad del producto
   */
   public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
   }
   
   /*
      Método que formatea la compra para mostrarla por consola o guardarla en un fichero.
      Utiliza el método format de la clase String. Funciona de manera análoga a printf.
      devuelve la cadena formateada de la compra
      Al indicar el número de huecos que vamos a usar, mejor evitar espacios en blanco
   */
   public String toString() {
      return String.format("%-30s%8.2f%8d%8.2f", nombre, precio, cantidad, getPrecioTotal());
   }
}