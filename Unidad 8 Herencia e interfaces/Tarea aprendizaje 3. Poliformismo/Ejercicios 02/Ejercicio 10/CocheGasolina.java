public class CocheGasolina extends Coche {

   private int kilometros;
   
   public CocheGasolina(String marca, String modelo, int kilometros) {
      super(marca, modelo);
      this.kilometros = kilometros;
   }
   
   public int getKilometros() {
      return kilometros;
   }
   
   public boolean tocaRevision() {
      if (kilometros > 10000) {
         return true;
      }
      return false;
   }
}