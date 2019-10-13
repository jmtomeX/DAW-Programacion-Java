// Utilizamos las clases que hemos creado.

public class FormasTest {

   public static void main(String[] args) {  

      Rectangulo unRectangulo = new Rectangulo(10, 10);
      Triangulo unTriangulo = new Triangulo(10, 10, 10);
      Circulo unCirculo = new Circulo(10);
      System.out.printf("RECTANGULO: Area = %.2f, Perímetro = %.2f\n", unRectangulo.calcularArea(), unRectangulo.calcularPerimetro());  
      System.out.printf("TRIANGULO: Area = %.2f, Perímetro = %.2f\n", unTriangulo.calcularArea(), unTriangulo.calcularPerimetro());  
      System.out.printf("CIRCULO: Area = %.2f, Perímetro = %.2f\n", unCirculo.calcularArea(), unCirculo.calcularPerimetro());  
   }
}