public class Concesionario{
   // Atributos
   private String nombre;
   private Coche[] lista;
   // Constructor
   public Concesionario(String nombreConcesionario, String marca, int numCoches){
      nombre = nombreConcesionario;
      lista = new Coche[numCoches];
      for(int i = 0;i < lista.length;i++){
         lista[i] = new Coche(marca, "", 0);
      }
   }

   // Modifica los datos del coche con el indice indicado en el concesionario.
   // Los indices empezarán en 0.
   public void setCoche(int indice, String marca, String modelo, int year){
      lista[indice].setMarca(marca);
      lista[indice].setModelo(modelo);
      lista[indice].setYear(year);
   }

   
   // Devuelve el número de coches en el concesionario
   public int getNumCoches(){
      return lista.length;
   }


   // Formatea los datos del concesionario de la siguiente manera:
   // NOMBRE DEL CONCESIONARIO
   // 1: Marca Modelo (año)
   // 2: Marca Modelo (año)
   public String toString(){
      String formato = nombre.toUpperCase() + "\n";
      for(int i = 0; i < getNumCoches(); i++){
         formato += (i + 1) + ": " + lista[i] + "\n";
      }
      return formato;
   }


   // Muestra los datos del coche en el concesionario con el indice indicado 
   public String mostrarCoche(int indice){
      return lista[indice].toString();
   }


   // Busca el primer coche que del modelo indicado. Devolvera su indice (empieza en 0) o
   // -1 si no lo encuentra
  //public int indexOf(String str)
   public int BuscarModelo(String modelo){
      int index = -1;
      for(int i = 0; i < getNumCoches(); i++){
         index = lista[i].getModelo().indexOf(modelo);
      }
      return index;
   }


   // Busca el coche mas viejo del concesionario. Devolvera su indice (empieza en 0)
   // en el concesionario
   public int buscarViejo() {
      int masAntiguo = lista[0].getYear();
      int indice = 0;
      for(int i = 0; i < getNumCoches(); i++){
         masAntiguo = Math.min(masAntiguo, lista[i].getYear());
         if(lista[i].getYear() == masAntiguo){
            indice = i;
         }
      }
      return indice;
   }

   
}