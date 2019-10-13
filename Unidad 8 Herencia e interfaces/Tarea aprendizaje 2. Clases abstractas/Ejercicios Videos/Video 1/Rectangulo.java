// Clase Rectangulo

public class Rectangulo implements FormaCalculable {

   // Atributos
   private double ancho;
   private double alto;
   
   // Constructor
   public Rectangulo(double ancho, double alto) {
      this.ancho = ancho;
      this.alto = alto;
   }
   
   // Devuelve el área de un rectángulo
   public double calcularArea() {
      return ancho * alto;
   }
   
   // Devuelve el perímetro de un rectángulo
   public double calcularPerimetro() {
      return 2.0 * (ancho + alto);
   }
}