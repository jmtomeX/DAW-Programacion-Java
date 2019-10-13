import java.util.*;

public class ArticuloMain {
   public static void main(String[] args) {
      // Creamos un array de Articulos
      ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
      listaArticulos.add(new Articulo("Naranja", 5));
      listaArticulos.add(new Articulo("Chocolate", 2));
      listaArticulos.add(new Articulo("Galletas", 1));
      
      System.out.println(listaArticulos);
      Collections.sort(listaArticulos, new ComparadorCantidadArticulos());
      System.out.println(listaArticulos);
      Collections.sort(listaArticulos, new ComparadorDescripcionArticulos());
      System.out.println(listaArticulos);
   }
}
/*TAmbién se puede poner las clases en el main, evitando tener que crear 2 archivos más.
   class ComparadorArticulosCantidad implements Comparator<Articulo> {   
 
     Por convenio, compare recibirá siempre 2 objetos de la clase indicada y devolverá:
        - un valor negativo para indicar que el objeto es menor que el pasado como parámetro y debe ir delante
        - 0 cuando sean iguales
        - un valor mayor que 0 para indicar que es mayor y debe ir detrás


   @Override
   public int compare(Articulo unArticulo, Articulo otroArticulo) {
      
      // Permite ordenar por cantidad de mayor a menor
      return unArticulo.cantidad - otroArticulo.cantidad;
   }

}

   class ComparadorArticulosDescripcion implements Comparator<Articulo> {   

     Por convenio, compare recibirá siempre 2 objetos de la clase indicada y devolverá:
        - un valor negativo para indicar que el objeto es menor que el pasado como parámetro y debe ir delante
        - 0 cuando sean iguales
        - un valor mayor que 0 para indicar que es mayor y debe ir detrás


   @Override
   public int compare(Articulo unArticulo, Articulo otroArticulo) {
      // Permite ordenar en orden alfabético de la A a la Z
      return unArticulo.descripcion.compareTo(otroArticulo.descripcion);
   
   }

}

*/