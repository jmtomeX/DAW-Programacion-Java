// Clase Circulo.
public class Circulo implements FormaCalculable {
   private double radio;
   
   // Constructor
   public Circulo(double radio) {
      this.radio = radio;
   }
   
   public String toString() {
      return "Círculo de radio " + radio;
   }
   
   public double getRadio() {
      return radio;
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