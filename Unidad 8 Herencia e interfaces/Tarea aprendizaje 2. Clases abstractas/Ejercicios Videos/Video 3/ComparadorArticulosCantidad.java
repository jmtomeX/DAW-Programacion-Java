// Muestra como funciona el interfaz comparable
// Tiene un único método que se debe sobre escribir para definir el orden
// El método compareTo se pude usar directamente o a través de otros métodos como sort

import java.util.*;

class ComparadorArticulosCantidad implements Comparator<Articulo> {   
   /*
     Por convenio, compare recibirá siempre 2 objetos de la clase indicada y devolverá:
        - un valor negativo para indicar que el objeto es menor que el pasado como parámetro y debe ir delante
        - 0 cuando sean iguales
        - un valor mayor que 0 para indicar que es mayor y debe ir detrás

   */
   @Override
   public int compare(Articulo unArticulo, Articulo otroArticulo) {
      
      // Permite ordenar por cantidad de mayor a menor
      return unArticulo.cantidad - otroArticulo.cantidad;
   }

}