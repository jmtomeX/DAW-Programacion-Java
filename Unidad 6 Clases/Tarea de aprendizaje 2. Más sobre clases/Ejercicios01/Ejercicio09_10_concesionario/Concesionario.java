public class Concesionario {
   // Atributos
   private String nombre;
   private Coche[] lista;
   
   // Constructor
   public Concesionario(String concesionario, String marca, int num) {
      nombre = concesionario;
      lista = new Coche[num];
      for (int i = 0; i < lista.length; i++) {
         lista[i] = new Coche(marca, "", 0);
      }
   }
   
   // Metodos
   public void setCoche(int indice, String marca, String modelo, int year) {
      lista[indice].setMarca(marca);
      lista[indice].setModelo(modelo);
      lista[indice].setYear(year);   
   }
   
   public int getNumCoches() {
      return lista.length;
   }
   
   public String toString() {
      String formato = nombre.toUpperCase() + "\n";
      for (int i = 0; i < lista.length; i++) {      
         formato += (i + 1) + ": " + lista[i] + "\n";                  
      }
      return formato;
   }
   
   public String mostrarCoche(int indice) {
      return lista[indice].toString();
   }

   /*
      Busca los coches mas reciente al anio indicado
      Devolvera un array de booleanos que contendra true si el coche en esa posicion es mas reciente
      false en caso contrario
   */     
   public boolean[] cochesMasRecientes(int year) {
      boolean[] masRecientes = new boolean[lista.length];
      for (int i = 0; i < lista.length; i++) {
         if (lista[i].getYear() > year) {
            masRecientes[i] = true;
         }
      }
      return masRecientes;
   }
   /*
   Tenemos la clase Concesionario y queremos añadir el método buscarViejo que buscará el coche mas viejo 
   del concesionario y devolvera su indice en el array de objetos de la clase Coche.
   */
   public int buscarViejo(){
      int masAntiguo = lista[0].getYear();
      int indice = 0;
      for(int i = 1 ; i < lista.length; i++){
         masAntiguo = Math.min(masAntiguo, lista[i].getYear());
         if(lista[i].getYear() == masAntiguo){
            indice = i;
         }
      }
      return indice;
   }
}