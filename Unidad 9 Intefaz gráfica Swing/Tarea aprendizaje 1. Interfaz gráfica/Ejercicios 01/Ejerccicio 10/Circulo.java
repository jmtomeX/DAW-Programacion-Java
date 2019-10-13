public class Circulo {
   private double radio;
   private String color;
   
   public Circulo() {
      this(0.0, "");
   }

   public Circulo(double radio, String color) {
      this.radio = radio;
      this.color = color;
   }
   
   public Circulo(Circulo otro) {
      this(otro.radio, otro.color);
   }

   public void setRadio(double radio) {
      this.radio = radio;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public double getRadio() {
      return radio;
   }

   public String getColor() {
      return color;
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