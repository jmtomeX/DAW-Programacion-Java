// Clase CompraProducto.
public class CompraProducto {
// Atributos
   private String nombre;
   private double precio;
   private int cantidad;

// Constructor
   public CompraProducto(String nombre, double precio, int cantidad) {
      setNombre(nombre);
      setPrecio(precio);
      setCantidad(cantidad);
   }
   public CompraProducto() {
      this("", 0.0, 0);
   }
     
// Métodos  
   
   public String getNombre() {
      return nombre;
   }
   
   public double getPrecio() {
      return precio;
   }
      
   public int getCantidad() {
      return cantidad;
   }
   
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
     
   public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
   }
   
   public void setPrecio(double precio) {
      this.precio = precio;
   }
   // Calcula y devuelve el precio total de la compra, recibe 2 parámetros y devuelve un String 
   public double getPrecioTotal(double precio, int cantidad) {
      double totalCompra = 0.0;
      totalCompra = precio * cantidad;
      return totalCompra;
   }  
    // Formatea la compra de un producto de la siguiente manera
                        // Nombre: hueco de 30 caractéres, alineado a la izquierda
                        // Precio: hueco de 8 caracteres, precio alineado a la derecha, 2 decimales
                        // Cantidad: hueco de 8 caracteres, alineado a la derecha
                        // Precio total: hueco de 8 caracteres, precio alineado a la derecha, 2 decimales
                        // Naranjas                          1,40       5    7,00
                        // Te puede ayudar usar el método format de la clase String      
   public String toString() {
      String salidaDatos = "";
      salidaDatos = String.format("%-30s %8.2f %8d %8.2f", nombre, precio, cantidad ,getPrecioTotal(precio, cantidad));
      return salidaDatos;
   }
}