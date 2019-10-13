/*
Crea el método cambiarMasViejo que recibira un objeto de la clase Concesionario y
un Scanner para leer por teclado, buscará el coche más viejo del concesionario y lo mostrará.
A continuación, preguntará si se quiere cambiar y en caso afirmativo, pedirá los nuevos
valores y lo modificará.
Por ejemplo:
Tu coche mas viejo es: Volkswagen Golf (2013)
Quieres cambiarlo (S/N)? S
Marca: Seat
Modelo: Ibiza
Fecha: 2017
*/
import java.util.*;

public class ConcesionarioMain {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      
      // Crear concesionario de ejemplo
      Concesionario tuConcesionario = crearConcesionario();
      System.out.println(tuConcesionario);
      
      // Buscar el coche mas viejo y cambia sus datos
      cambiarMasViejo(tuConcesionario, leerTeclado);
      System.out.println(tuConcesionario);
   }

   /*
      Crea un concesionario de ejemplo
   */
   public static Concesionario crearConcesionario() {
      
      // Crea el concesionario  
      Concesionario unConcesionario = new Concesionario("House of Cars", "", 5);
      
      // Modifica las caracteristicas de los 5 coches con unos valores de prueba
      unConcesionario.setCoche(0, "Opel", "Astra", 2015);
      unConcesionario.setCoche(1, "Hyundai", "Ioniq", 2018);
      unConcesionario.setCoche(2, "Renault", "Megane", 2014);
      unConcesionario.setCoche(3, "Volkswagen", "Golf", 2013);
      unConcesionario.setCoche(4, "Ford", "Focus", 2016);
      
      return unConcesionario;
   }
   
    // CREAR METODO
   public static void cambiarMasViejo(Concesionario concesionario, Scanner teclado){
      String respuesta = "";
      int masViejo = concesionario.buscarViejo();
      System.out.println("Tu coche mas viejo es: " + concesionario.mostrarCoche(masViejo));
      System.out.println("Quieres cambiarlo (S/N)? ");
      respuesta = teclado.next();
      if(respuesta.equalsIgnoreCase("s")){
         System.out.print("Marca: ");
         String marca = teclado.next();
         System.out.print("Modelo: ");
         String modelo = teclado.next();
         System.out.print("Año: ");
         int year = teclado.nextInt();
         concesionario.setCoche( masViejo, marca, modelo, year);
      }
   }
}