/*
   Este programa testea la clase cliente
*/
public class FacturaTest {
 
   // Método principal
   public static void main(String[] args) {
      
   // Prueba la clase Cliente
      // Prueba constructor 1   
      Cliente unCliente = new Cliente("Aitor Aguirre", "Florida 72", "Vitoria", "Alava", "01005");
      
      // Prueba toString
      System.out.println(unCliente);
      System.out.println();
      
      // Prueba constructor 2
      Cliente copiaCliente = new Cliente(unCliente);
      System.out.println(copiaCliente);
      System.out.println();
      
      // Prueba getNombre
      System.out.println(copiaCliente.getNombre());
      
   // Prueba la clase CompraProducto
      // Prueba constructor 1   
      CompraProducto unCompraProducto = new CompraProducto("Arroz", 1.5, 2);
      
      // Prueba toString
      System.out.println(unCompraProducto);
      
   // Prueba la clase Factura
      // Constructor si fichero
      Factura unaFactura = new Factura(unCliente);
      System.out.println(unaFactura);
      
      // Constructor con fichero
      Cliente otroCliente = new Cliente("Marta Alda", "Florida 72", "Vitoria", "Alava", "01005");
      Factura otraFactura = new Factura(otroCliente);
      System.out.println(otraFactura);
   }
}