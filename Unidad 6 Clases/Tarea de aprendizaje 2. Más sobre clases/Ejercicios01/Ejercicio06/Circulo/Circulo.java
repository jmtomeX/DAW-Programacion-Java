public class Circulo{
// Atributos   
   private double radio;
   private String color;

// Constructores   
   public Circulo(){
      this(0.0, "");
   }
   public Circulo(double radio, String color){
      setRadio(radio);
      setColor(color);
   }
   public Circulo(Circulo otro){
      this(otro.getRadio(), otro.getColor());
   }
// Otros métodos
   public void setRadio(double radio){
      this.radio = radio;
   }
   public void setColor(String color){
      this.color = color;
   }
   public double getRadio(){
      return radio;
   }
   public String getColor(){
      return color;
   }
// Formatea el objeto de la siguiente manera: Circulo color de radio radio
   public String toString(){
      return "Circulo " + color + " de radio " + radio;
   }     
   public double calculaArea(){
      return Math.PI * Math.pow(radio,2);
   }

}