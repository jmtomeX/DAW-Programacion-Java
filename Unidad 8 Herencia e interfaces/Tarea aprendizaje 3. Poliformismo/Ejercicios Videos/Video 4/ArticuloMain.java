// Muestra como funciona el método equals
// Se hereda de la clase object y comprueba si el objeto pasado es el mismo objeto
// Hay que reescribirlo para que compruebe si tienen los mismos valores
// Se utiliza en métodos como contains, indexOf o remove

import java.util.*;

public class ArticuloMain {
   public static void main(String[] args) {
      ArrayList<String> palabras = new ArrayList<String>();
      palabras.add("Rojo");
      palabras.add("Azul");
      palabras.add("Blanco");

      System.out.println(palabras);
      if (palabras.contains("Azul")) {
         System.out.println(palabras.indexOf("Azul"));
      }
      palabras.remove("Rojo");
      System.out.println(palabras);

      // Creamos un array de Articulos
      ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
      listaArticulos.add(new Articulo("Naranjas", 5));
      Articulo unArticulo = new Articulo("Chocolate", 2);
      listaArticulos.add(unArticulo);
      listaArticulos.add(new Articulo("Galletas", 1));
      
      System.out.println(listaArticulos);
      Articulo otroArticulo = new Articulo("Naranjas", 5);
      if (listaArticulos.contains(otroArticulo)) {
         System.out.println(listaArticulos.indexOf(otroArticulo));
      }
      listaArticulos.remove(otroArticulo);
      System.out.println(listaArticulos);
   }
}