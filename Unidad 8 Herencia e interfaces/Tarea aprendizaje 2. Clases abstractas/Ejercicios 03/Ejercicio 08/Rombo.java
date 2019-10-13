/*
Modifica la clase Rombo para que implemente correctamente la interfaz FormaCalculable:
área = diagonal1 * diagonal2 / 2
perímetro = 2 * raizCuadrada(diagonal1 "alcuadrado" + diagonal2 "alcuadrado")
*/
// Clase Rombo

public class Rombo implements FormaCalculable{

   // Atributos
   private double diagonal1;
   private double diagonal2;
   
   // Constructor
   public Rombo(double diagonal1, double diagonal2) {
      this.diagonal1 = diagonal1;
      this.diagonal2 = diagonal2;
   }
   
     //área = diagonal1 * diagonal2 / 2
   @Override
     public double calcularArea() {
      return (diagonal1 * diagonal2) / 2;
   }
     
    //perímetro = 2 * raizCuadrada(diagonal1 "alcuadrado" + diagonal2 "alcuadrado")
   @Override
   public double calcularPerimetro() {
      double lado = Math.sqrt(Math.pow(diagonal1, 2) + Math.pow(diagonal2, 2));
      return 2 * lado;
   }
}