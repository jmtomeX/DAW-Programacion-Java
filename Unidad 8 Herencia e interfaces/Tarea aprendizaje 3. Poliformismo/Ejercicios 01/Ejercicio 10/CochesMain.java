import java.util.*;

public class CochesMain {
   public static void main(String[] args) {
      Coche[] arrayCoches = {new Coche("Opel", "Meriva"), new CocheElectrico("Renault", "ZOE", 300), 
         new CocheGasolina("Fiat", "Punto", 15000), new Coche("Ford", "Fiesta"),
         new CocheElectrico("Hyundai", "Ioniq", 200), new CocheGasolina("Renault", "Clio", 1500)};
   
      System.out.println(Arrays.toString(arrayCoches));
      System.out.println();
      
      // Detectamos el coche electrico con mayor autonomia
      CocheElectrico mayorAutonomia = null;
      for (Coche unCoche : arrayCoches) {
         if (unCoche instanceof CocheElectrico) {
            CocheElectrico electrico = (CocheElectrico) unCoche;
            if (mayorAutonomia == null || (electrico.getAutonomia() > mayorAutonomia.getAutonomia())) {
               mayorAutonomia = electrico;
            }
         }
      }      
      System.out.println(mayorAutonomia + " " + mayorAutonomia.getAutonomia());      }
}