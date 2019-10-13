/*
Tenemos un programa en el que queremos añadir un método para que pida el nombre y los coches de un concesionario y recorra y
devuelva un objeto de la clase Concesionario. El funcionamiento sería el siguiente pidiendo coches hasta que se pulse "N":

Nombre del concesionario: House of Cars
Introducir un coche (S/N)? S
Marca: Opel
Modelo: Corsa
Year: 2010
Introducir un coche (S/N)? S
Marca: Ford
Modelo: Fiesta
Year: 2012
Introducir un coche (S/N)? N

Si la clase Concesionario tiene los siguientes métodos:

public class Concesionario {
   private String nombre;
   private ArrayList<Coche> lista;
   
   public Concesionario(String concesionario) 
   public void addCoche(String marca, String modelo, int year)
   public String toString()
}
*/
import java.util.*;
import java.io.*;

public class Concesionario {
   // Atributos
   private String nombre;
   private ArrayList<Coche> lista;
   
   // Constructor
   public Concesionario(String concesionario) {
      nombre = concesionario;
      lista = new ArrayList<Coche>();
   }
   
   public void setCoche(int indice, String marca, String modelo, int year) {
      lista.get(indice).setMarca(marca);
      lista.get(indice).setModelo(modelo);
      lista.get(indice).setYear(year);
   }
   
   public Coche getCoche(int indice) {
      Coche copiaCoche = new Coche(lista.get(indice).getMarca(), lista.get(indice).getModelo(), lista.get(indice).getYear());
      return copiaCoche;
   }
      
   // Metodos
   public String toString() {
      String formato = nombre.toUpperCase() + "\n";
      int i = 1;
      for (Coche unCoche : lista) {      
         formato += i + ": " + unCoche + "\n";
         i++;             
      }
      return formato;
   }
   public void addCoche(Coche unCoche) {
      Coche otroCoche = new Coche(unCoche.getMarca(), unCoche.getModelo(), unCoche.getYear());
      lista.add(otroCoche);
   }
   //
   public Concesionario cochesYear(int year) {
      Concesionario mismoYear = new Concesionario("Coches del " + year);
      for(Coche esteCoche: lista){
         int esteYear = esteCoche.getYear();
         if(esteYear == year) {
            Coche copia = new Coche(esteCoche);
            mismoYear.addCoche(copia);
         }
      }
      return mismoYear;
   }
   
}