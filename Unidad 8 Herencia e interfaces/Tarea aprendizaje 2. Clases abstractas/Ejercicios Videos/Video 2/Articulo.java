// Muestra como funciona el interfaz comparable
// Tiene un único método que se debe sobre escribir para definir el orden
// El método compareTo se pude usar directamente o a través de otros métodos como sort

import java.util.*;

class Articulo implements Comparable<Articulo> {
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
     Por convenio, compareTo recibirá siempre un objeto de la clase indicada y devolverá:
        - un valor negativo para indicar que el objeto es menor que el pasado como parámetro y debe ir delante
        - 0 cuando sean iguales
        - un valor mayor que 0 para indicar que es mayor y debe ir detrás
   */
   @Override
   public int compareTo(Articulo unArticulo) {
        // Permite ordenar en orden alfabético de la A a la Z
        // return descripcion.compareTo(unArticulo.descripcion);
        
        /* Permite ordenar por cantidad de mayor a menor
        if (cantidad < unArticulo.cantidad) {
            return -1;
        }
        if (cantidad > unArticulo.cantidad) {
            return 1;
        }
        return 0;    */  
              
      return cantidad - unArticulo.cantidad;
   }
}