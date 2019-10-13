// Muestra como funciona el interfaz Comparator
// Tenemos que usar una clase que no implementa el interfaz Comparable
// No tenemos acceso al código fuente y no podemos modificarla

import java.util.*;

class Articulo {
   public String descripcion; // Descripción del artículo.
   public int cantidad;       // Cantidad a proveer del artículo.
    
    // Constructor
   public Articulo (String descripcion, int cantidad) {
      this.descripcion = descripcion;
      this.cantidad = cantidad;
   }
    
    // toString
   @Override
    public String toString() {
      return descripcion + "(" + cantidad + ")";
   }
}
