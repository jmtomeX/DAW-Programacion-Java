/*
Corrige el método getCoche de la clase Concesionario para que el resultado que se muestre por consola sea:

Ford Focus (2012)
Hyundai IONIQ (2017)
*/

public class ConcesionarioMain {
   public static void main(String[] args)  {
      Concesionario tuConcesionario = new Concesionario("Tu concesionario");
      tuConcesionario.addCoche(new Coche("Hyundai", "IONIQ", 2017));
      Coche tuCoche = tuConcesionario.getCoche(0);
      tuConcesionario.setCoche(0, "Ford", "Focus", 2012);
      System.out.println(tuConcesionario.getCoche(0));
      System.out.println(tuCoche);
    
   }

}