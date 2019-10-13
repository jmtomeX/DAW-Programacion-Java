/*
   Define la clase Ruta
   Utiliza un ArrayList para guardar los puntos de la ruta
   Mantiene los mismos métodos que la versión con arrays
*/

import java.util.*;

public class Ruta {

   // Atributos
   private String titulo; 
   private ArrayList<Punto> ruta;
   
   // Constructor
   // Recibe  nombre de la ruta y su número de elementos e inicializa el array con puntos (0, 0)
   public Ruta(String titulo, int num) {
      this.titulo = titulo;
      ruta = new ArrayList<Punto>();
      for (int i = 0; i < num; i++ ) {
         Punto nuevo = new Punto();
         ruta.add(i, nuevo);
      }
   }
   
   // Métodos get
   // Obtiene la longitud del ArrayList
   public int getLongitud() {
      return ruta.size();
   }
   
   // Obtiene el título de la ruta
   public String getTitulo() {
      return titulo;
   }
   
   // Métodos set
   // Modifica el nombre y las coordenadas del punto con el indice indicado
   public void setPunto(int indice, String etiqueta, int x, int y) {
      Punto unPunto = ruta.get(indice);
      unPunto.setCoordenadas(x, y);
      unPunto.setEtiqueta(etiqueta);
   }
   
   // Modifica el título de la ruta
   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   // Método toString: Mostrar el nombre y los puntos de la ruta
   public String toString() {
      String mostrar = "RUTA " + titulo.toUpperCase() + "\n";
      mostrar += "1. " + ruta.get(0);
      for (int i = 1; i < ruta.size(); i++) {      
         mostrar += " --> " + (i + 1) + ". " + ruta.get(i);                  
      }
      mostrar += "\n";
      return mostrar;
   }
   
   // Método para calcular la longitud de la ruta
   public double calcularDistancia() {
      double longitud = 0;
      for (int i = 0; i < ruta.size() - 1; i++) {
      
         // Calcular distancia entre 2 puntos consecutivos y sumarla
         Punto p1 = ruta.get(i);
         Punto p2 = ruta.get(i + 1);
         longitud += p1.distanciaPuntos(p2);
      }
      return longitud;
   }
}