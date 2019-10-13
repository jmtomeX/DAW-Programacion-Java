import java.util.*;

public class CochesMain {
   public static void main(String[] args) {
      ArrayList<Coche> listaCoches = new ArrayList<Coche>();
      listaCoches.add(new Coche("Opel", "Meriva"));
      listaCoches.add(new CocheElectrico("Renault", "ZOE", 300));
      listaCoches.add(new CocheGasolina("Fiat", "Punto", 15000));
      listaCoches.add(new Coche("Ford", "Fiest"));
      listaCoches.add(new CocheElectrico("Hyundai", "Ioniq", 200));
      listaCoches.add(new CocheGasolina("Renault", "Clio", 1500));   
         
      System.out.println(listaCoches);
      System.out.println();
      
      // Mejora el siguiente programa para que muestre la autonomía de todos los coches eléctricos.
      int cont = 0;
      for(Coche unCoche: listaCoches) {
         if(unCoche instanceof CocheElectrico) {
            cont++;
            CocheElectrico electrico = (CocheElectrico) unCoche;
            System.out.println(cont + ". " + electrico + " " + electrico.getAutonomia());
         }
      }
   }
}

/*
El resultado será:
      1. CocheElectrico Renault ZOE 300
      2. CocheElectrico Hyundai Ioniq 200

*/