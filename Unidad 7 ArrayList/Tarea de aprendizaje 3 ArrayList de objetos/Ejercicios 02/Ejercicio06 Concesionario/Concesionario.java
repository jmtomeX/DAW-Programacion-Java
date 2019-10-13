/*
Tenemos el siguiente código:

Concesionario miConcesionario = new Concesionario("Mi concesionario");
Coche miCoche = new Coche("Opel", "Corsa", 2015);
miConcesionario.addCoche(miCoche);
miConcesionario.setCoche(0, "Seat", "Ibiza", 2010);
System.out.println(miCoche);
System.out.println(miConcesionario.getCoche(0));

Corrige el método addCoche de la clase Concesionario para que el resultado que se muestre por consola sea:

Opel Corsa (2015)
Seat Ibiza (2010)

Ten en cuenta que la clase Coche tiene los siguientes métodos:

public class Coche {
    private String marca;
    private String modelo;
    private int year;
    
    public Coche(String marca, String modelo, int year) 
    public void setMarca(String marca)
    public void setModelo(String modelo) 
    public void setYear(int year) 
    public String getMarca()
    public String getModelo()
    public int getYear()
    public String toString()
    
    // Programa para demostrar el manejo básico de los ArrayLists
//
// Operaciones con arrays:
//    String[] arr         ==> ArrayList<String> lista
//    new String[n]        ==> new ArrayList<String>()   
//    String s = arr[i];   ==> String s = lista.get(i);
//    arr[i] = s;          ==> lista.set(i, s);
//    arr.length           ==> lista.size()
//
// Nuevas operaciones con ArrayLists:
//    lista.add(s)         ==> añade un nuevo elemento al final de la lista
//    lista.add(i, s)      ==> añade un nuevo elemento en la posición indicada por el índice i,
//                             mueve los elementos siguientes hacia la derecha
//    lista.remove(i)      ==> borra el elemento en la posición indicada por el índice i,
//                             mueve los elementos siguientes hacia la izquierda
//    lista.clear()        ==> removes all elements of the list
//    lista.indexOf(s)     ==> devuelve el índice del elemento indicado. -1 si no lo encuentra
    
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