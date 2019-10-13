// Clase Triangulo

public class Triangulo implements FormaCalculable {

   // Atributos
   private double lado1;
   private double lado2;
   private double lado3;
   
   // Constructor
   public Triangulo(double lado1, double lado2, double lado3) {
      this.lado1 = lado1;
      this.lado2 = lado2;
      this.lado3 = lado3;
   }
   
   // Devuelve el área de un triángulo usando la fórmula de Heron
   @Override
   public double calcularArea() {
      double s = (lado1 + lado2 + lado3) / 2.0;
      return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
   }
   
   // Devuelve el perímetro de un triángulo
   @Override
   public double calcularPerimetro() {
      return lado1 + lado2 + lado3;
   }
}