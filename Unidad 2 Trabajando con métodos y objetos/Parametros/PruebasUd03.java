public class PruebasUd03{
   public static void main(String[] args){
    
      System.out.println(calcularPrecio(3,25.3));
   }

   public static double calcularPrecio(int cantidad, double precio) {
      double total = cantidad * precio;
      return total;
   }
}