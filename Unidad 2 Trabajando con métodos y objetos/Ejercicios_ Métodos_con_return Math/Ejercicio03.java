/*
Crea el método formatear(). Se le pasará el nombre de un producto y la cantidad comprada 
y devolverá un texto indicando lo que se ha comprado del producto.
Por ejemplo:

System.out.println(formatear("manzanas", 4));
Has comprado 4 kilos de manzanas
*/
public class Ejercicio03{
   public static void main(String[] args){
   
      System.out.print(formatear("peras", 4));
   }
   
   public static String formatear(String tipo, int peso) {
      return "Has comprado " + peso + " kilos de " + tipo;
   }
}