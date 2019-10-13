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

public class Coche {
//Atributos
   private String marca;
   private String modelo;
   private int year;

//Constructores
   public Coche(String marca, String modelo,  int year){
      setMarca(marca);
      setModelo(modelo);
      setYear(year);
   }
   public Coche(){
      this("", "", 0);
   }
   public Coche(Coche otroCoche){
      this(otroCoche.getMarca(), otroCoche.getModelo(), otroCoche.getYear());
   }
//get&set
   public void setMarca(String marca){
      this.marca = marca;
   }
   public void setModelo(String modelo){
      this.modelo = modelo;
   }
   public void setYear(int year){
      this.year = year;
   }
   public String getMarca(){
      return marca;
   }
   public String getModelo(){
      return modelo;
   }
   public int getYear(){
      return year;
   }
   public String toString(){
      return marca + " " + modelo +  " (" + year +")";
   }
}