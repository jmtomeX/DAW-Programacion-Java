public class Coche {
   private String marca;
   private String modelo;
   private int year;
   
   Coche(String marca, String modelo, int year) {
      this.marca = marca;
      this.modelo = modelo;
      this.year = year;
   }

   public String toString() {
      return marca + " " + modelo + " (" + year + ")";
   }
}