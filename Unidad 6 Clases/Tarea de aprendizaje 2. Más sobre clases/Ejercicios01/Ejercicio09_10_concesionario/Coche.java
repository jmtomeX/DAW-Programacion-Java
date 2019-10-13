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
      return marca + " " + modelo +  " " + year;
   }
}