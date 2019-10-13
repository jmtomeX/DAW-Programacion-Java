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
}
*/

public class ConcesionarioMain {
   public static void main(String[] args)  {
      Concesionario miConcesionario = new Concesionario("Mi concesionario");
      Coche miCoche = new Coche("Opel", "Corsa", 2015);
      miConcesionario.addCoche(miCoche);
      miConcesionario.setCoche(0, "Seat", "Ibiza", 2010);
      System.out.println(miCoche);
      Coche miCoche1 = new Coche("Hyundai", "Ioniq", 2018);
      Coche miCoche2 = new Coche("Opel ", "Meriva", 2015);
      Coche miCoche3 = new Coche("Renault", " Megane", 2015);
      Coche miCoche4 = new Coche("Renault ", "MAgaszine", 2015);
      Coche miCoche5 = new Coche("Opel", " Vectra", 2017);
      Coche miCoche6 = new Coche("Volkswagen", "Golf", 2013);
      miConcesionario.addCoche(miCoche1);
      miConcesionario.addCoche(miCoche2);
      miConcesionario.addCoche(miCoche3);
      miConcesionario.addCoche(miCoche4);
      miConcesionario.addCoche(miCoche5);
      miConcesionario.addCoche(miCoche6);
    
   
      System.out.println(miConcesionario.getCoche(0));
      System.out.println(miConcesionario.cochesYear(2015));
    
   }

}