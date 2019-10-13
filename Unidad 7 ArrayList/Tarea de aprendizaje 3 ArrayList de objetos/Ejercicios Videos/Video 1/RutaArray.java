/*
   Definición de la clase Ruta
   Utiliza un array para guardar los puntos de la ruta
*/
public class RutaArray { 

   // Atributos
   private String titulo;
   private Punto[] ruta;
   
   // Constructor
   // Recibe  nombre de la ruta y su número de elementos e inicializa el array con puntos (0, 0)
   public Ruta(String titulo, int num) {
      this.titulo = titulo;
      ruta = new Punto[num];
      
      for (int i = 0; i < ruta.length; i++) {
      
         // Crear un punto
         Punto nuevoPunto = new Punto();
         
         // Asigna el punto a un elemento del array
         // El elemento del array referenciará o apuntará al nuevo punto
         ruta[i] = nuevoPunto;
      }
   }
   
   // Métodos get
   // Obtiene la longitud de la ruta
   public int getLongitud() {
      return ruta.length;
   }
   
   // Obtiene el título de la ruta
   public String getTitulo() {
      return titulo;
   }
   
   // Métodos set
   // Modifica el nombre y las coordenadas del punto con el indice indicado
   public void setPunto(int indice, String etiqueta, int x, int y) {
      ruta[indice].setCoordenadas(x, y);
      ruta[indice].setEtiqueta(etiqueta);
   }
   
   // Modifica el título de la ruta
   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   // Método toString: Mostrar el nombre y los puntos de la ruta
   public String toString() {
      String formato = "";
      formato = formato + "RUTA " + titulo.toUpperCase() + "\n";
      formato += "1. " + ruta[0].toString();
      for (int i = 1; i < ruta.length; i++) {      
         formato += " --> " + (i + 1) + ". " + ruta[i].toString();                  
      }
      formato += "\n";
      return formato;
   }
   
   // Método para calcular la longitud de la ruta
   public double calcularDistancia() {
      double longitud = 0;
      for (int i = 0; i < ruta.length - 1; i++) {
      
         // Calcular distancia entre 2 puntos consecutivos y sumarla
         Punto p1 = ruta[i];
         Punto p2 = ruta[i + 1];
         longitud += p1.distanciaPuntos(p2);
      }
      return longitud;
   }
}