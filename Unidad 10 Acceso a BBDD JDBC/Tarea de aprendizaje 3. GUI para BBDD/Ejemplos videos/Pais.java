public class Pais {

   // ATRIBUTOS
   String idPais;
   String nombrePais;
   int idRegion;
   
   public Pais(String idPais, String nombrePais, int idRegion) {
      this.idPais = idPais;
      this.nombrePais = nombrePais;
      this.idRegion = idRegion;
   }
   
   public String getId() {
      return idPais;
   }
   
   public String getNombre() {
      return nombrePais;
   }

   public int getRegion() {
      return idRegion;
   }

   public String toString() {
      return nombrePais + " (" + idPais + "): región " + idRegion;
   }
}