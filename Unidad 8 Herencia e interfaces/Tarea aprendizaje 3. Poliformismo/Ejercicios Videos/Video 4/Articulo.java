// Muestra como funciona el método equals
// Se hereda de la clase object y comprueba si el objeto pasado es el mismo objeto
// Hay que reescribirlo para que compruebe si tienen los mismos valores
// Se utiliza en métodos como contains, indexOf o remove

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
   
    /*
      El método equals se hereda de la clase Object
      Siempre recibe un objeto de la clase Object y devuelve un boolean:
         - true si el objeto pasado es un Articulo y su valores son iguales al objeto actual
         - false en caso contrario
    */
   @Override
   public boolean equals(Object obj) {
      if (obj instanceof Articulo) {
         Articulo unArticulo = (Articulo) obj;
         if (descripcion.equals(unArticulo.descripcion) && cantidad == unArticulo.cantidad) {
            return true;
         }
      }
      return false;
   }

}