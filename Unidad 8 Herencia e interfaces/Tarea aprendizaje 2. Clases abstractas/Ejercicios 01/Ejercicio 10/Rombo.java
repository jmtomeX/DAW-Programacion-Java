// Clase Rombo

public class Rombo implements FormaCalculable {

   // Atributos
   private double diagonal1;
   private double diagonal2;
   
   // Constructor
   public Rombo(double diagonal1, double diagonal2) {
      this.diagonal1 = diagonal1;
      this.diagonal2 = diagonal2;
   }
   
   // Devuelve el area de un rombo usando la formula de Heron
   @Override
   public double calcularArea() {
      return diagonal1 * diagonal2 / 2;
   }
   
   // Devuelve el perimetro de un rombo
   @Override
   public double calcularPerimetro() {
      double lado = Math.sqrt(Math.pow(diagonal1, 2) + Math.pow(diagonal2, 2));
      return 2 * lado;
   }
}