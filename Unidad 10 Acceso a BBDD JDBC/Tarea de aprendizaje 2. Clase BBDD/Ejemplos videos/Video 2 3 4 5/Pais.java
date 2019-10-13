public class Pais {

   String idPais ;
   String nombrePais;
   int idRegion;

   public Pais(String idPais, String nombrePais, int idRegion) {
      this.idPais = idPais ;
      this.nombrePais = nombrePais;
      this.idRegion = idRegion;   
   }
   
   public String toString() {
      return nombrePais + " (" + idPais + "): región " + idRegion;
   }
}