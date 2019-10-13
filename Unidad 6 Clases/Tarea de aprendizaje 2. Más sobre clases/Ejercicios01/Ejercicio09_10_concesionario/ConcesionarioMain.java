import java.util.*;
public class ConcesionarioMain {
   public static void main(String[] args) {
      Concesionario concesionario1 = new Concesionario( "La Subida Coches", "",  5);
      concesionario1.setCoche(0,"Opel", "Astra", 2005);
      concesionario1.setCoche(1,"Hyundai", "Ioniq", 2018);
      concesionario1.setCoche(2,"Renault", "Megane", 2014);
      concesionario1.setCoche(3,"Volkswagen", "Golf", 2019);
      concesionario1.setCoche(4,"Ford", "Focus", 2016);
      //Coche miCoche = new Coche("Opel", "Astra", 2015);
      System.out.println(concesionario1.toString());
      boolean[] resultado = concesionario1.cochesMasRecientes(2015);
      System.out.println(Arrays.toString(resultado));
      System.out.println("El coche más viejo es el " +  concesionario1.buscarViejo());
   
   }
}