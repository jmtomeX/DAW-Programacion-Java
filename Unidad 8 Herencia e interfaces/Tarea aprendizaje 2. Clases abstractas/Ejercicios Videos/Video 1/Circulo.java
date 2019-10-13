// Clase Circulo.

public class Circulo implements FormaCalculable  {

   // Atributos
   private double radio;
   
   // Constructor
   public Circulo(double radio) {
      this.radio = radio;
   }
   
   // Devuelve el área de un círculo
   public double calcularArea() {
      return FormaCalculable.PI * radio * radio;
   }
   
   // Devuelve el perímetro de un círculo
   public double calcularPerimetro() {
      return 2.0 * FormaCalculable.PI * radio;
   }
}