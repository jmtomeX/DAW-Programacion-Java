public class Coche {
   private String marca;
   private String modelo;
   private int year;
   
   public Coche(String marca, String modelo, int year) {
      this.marca = marca;
      this.modelo = modelo;
      this.year = year;
   }

   public String toString() {
      return marca + " " + modelo + " (" + year + ")";
   }
   
   public boolean equals(Coche unCoche) {
      if (marca.equals(unCoche.marca) && modelo.equals(unCoche.modelo)) {
         return true;
      }
      return false;
   }
}