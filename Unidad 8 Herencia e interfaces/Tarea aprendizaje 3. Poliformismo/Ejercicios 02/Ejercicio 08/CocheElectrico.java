public class CocheElectrico extends Coche {
   private int autonomiaKm;
   public CocheElectrico(String marca, String modelo, int autonomiaKm) {
      super(marca, modelo);
      this.autonomiaKm = autonomiaKm;
   }

   public int getAutonomia() {
      return autonomiaKm;
   }

   public int viajar(int km) {
      autonomiaKm -= km;
      return autonomiaKm;
   }
   
   public void repostar(int autonomiaKm) {
      this.autonomiaKm = autonomiaKm;
   }
   
   
}