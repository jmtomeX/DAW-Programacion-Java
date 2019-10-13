public class Coche {
   protected String marca;
   protected String modelo;
   
   public Coche(String marca, String modelo) {
      this.marca = marca;
      this.modelo = modelo;
   }

   public String toString() {
      return this.getClass().getName() + " " + marca + " " + modelo;
   }
   
}