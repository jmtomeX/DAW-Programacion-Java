public class Circulo {
   private double radio;
   private String color;

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
   public String toString(){
      return radio  + " " + color;
   }
   public double calculaArea(){
      return Math.PI * Math.pow(radio,2);
   }
   public boolean esIgual(Circulo otro){
      if(otro.getColor.equals(this.color) && otro.getRadio == this.radio){
         return true;
      }
      return false;
   }


}