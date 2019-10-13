public class Circulo {
   private double radio;
   private String color;
   
   public Circulo(double radio, String color) {
      this.radio = radio;
      this.color = color;
   }
   
   public String getColor() {
      return color;
   }
   
   public double getRadio() {
      return radio;
   }

   public String toString() {
      return "Circulo " + color + " de radio " + radio;
   }

   public double calculaArea() {
      return Math.PI * radio * radio;
   }

   public boolean esIgual(Circulo otro) {
       return radio == otro.radio && color.equals(otro.color);
   }
}