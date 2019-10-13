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
      
      // Mejora el siguiente programa para que muestre los kilometros de todos los coches de gasolina.
      int cont = 0; 
      for(Coche unCoche: listaCoches) {
         if(unCoche instanceof CocheGasolina) {
            cont++;
            CocheGasolina gasolina = (CocheGasolina) unCoche;
            System.out.println(cont + ". " + gasolina.getClass().getName() + " " + unCoche.marca + " " + unCoche.modelo + " " + gasolina.getKilometros());
         }
      }
   }
}

/*
El resultado será:
      
      1. CocheGasolina Fiat Punto 15000
      2. CocheGasolina Renault Clio 1500

*/