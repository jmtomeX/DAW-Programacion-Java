/*
Tenemos la siguiente clase:

public class Piso {
    public String id;
    public int superficie;
    public double precioMetro;
}

Completa el programa para que muestre lo siguiente:

A25C(15 euros/m^2): 55.5 metros cuadrados
Es muy caro
*/

public class PisoMain {
   public static void main(String[] args) {
      Piso piso1 = new Piso();
      String id = "A25C";
      double superficie = 55;
      double precioMetro = 15.0;
      System.out.println(id + "(" + precioMetro + " euros/m^2): " + superficie + " metros cuadrados" );
      double precioTotal = superficie * precioMetro;
      if (precioTotal > 600) {
         System.out.println("Es muy caro");
      }
   }
}