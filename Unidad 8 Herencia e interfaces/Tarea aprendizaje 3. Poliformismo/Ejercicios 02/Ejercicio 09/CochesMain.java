import java.util.*;

public class CochesMain {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      ArrayList<Coche> listaCoches = new ArrayList<Coche>();
      listaCoches.add(new Coche("Opel", "Meriva"));
      listaCoches.add(new Coche("Renault", "19"));
      listaCoches.add(new CocheElectrico("Renault", "ZOE", 300));
      listaCoches.add(new CocheGasolina("Fiat", "Punto", 15000));
      listaCoches.add(new Coche("Ford", "Fiest"));
      listaCoches.add(new CocheElectrico("Hyundai", "Ioniq", 200));
      listaCoches.add(new CocheGasolina("Renault", "Clio", 1500));   
         
      System.out.println(listaCoches);
      System.out.println();
      
      // Mejora el siguiente programa para que pida una marca por teclado 
      // y muestre todos los coches de esa marca.
         // Si el ArrayList tiene los siguientes elementos y se introduce "Renault":  
      System.out.print("Introduce marca: ");
      String marca = teclado.next();
   
      for(Coche unCoche: listaCoches) {
         if(unCoche instanceof CocheElectrico) {
            CocheElectrico electrico = (CocheElectrico) unCoche;
            devuelveMarca(marca, electrico);        
         } else if(unCoche instanceof CocheGasolina){
            CocheGasolina gasolina = (CocheGasolina) unCoche;
            devuelveMarca(marca, gasolina);  
         } else {
            Coche normal = (Coche) unCoche;
            devuelveMarca(marca, normal);  
         }
         
      }
   
   }
   public static void devuelveMarca(String marca, Coche unCoche) {
      if(marca.equals(unCoche.marca))
         System.out.println(unCoche.getClass().getName()  + " " + unCoche.marca + " " + unCoche.modelo);
   }
}

/*
  Respuesta dada por la plataforma
      Scanner leer = new Scanner(System.in);
      System.out.print("Introduce marca: ");
      String marca = leer.next();
      for (Coche unCoche : listaCoches) {
         String laMarca = unCoche.getMarca();
         if (laMarca.equals(marca)) {
            System.out.println(unCoche);
         }
      } 

*/

/*
El resultado será:
     CocheElectrico Renault ZOE
        CocheGasolina Renault Clio

*/
