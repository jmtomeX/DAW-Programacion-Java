/*Tenemos la clase Concesionario y queremos añadir un constructor que reciba el nombre del concesionario y el nombre de un fichero,
 lea los datos de diferentes coches y los almacene el el ArrayList de la clase. El formato del fichero será el siguiente:

Opel Astra 2015
Hyundai Ioniq 2018
Renault Megane 2014
Volkswagen Golf 2013
Ford Focus 2016

Si ejecutamos las siguientes líneas:

Concesionario unConcesionario = new Concesionario("Mas Motor", "concesionario.txt");
System.out.println(unConcesionario);

Por consola se verá:

MAS MOTOR
1: Opel Astra (2015)
2: Hyundai Ioniq (2018)
3: Renault Megane (2014)
4: Volkswagen Golf (2013)
5: Ford Focus (2016)
*/
import java.util.*;
import java.io.*;

public class Concesionario {
   // Atributos
   private String nombre;
   private ArrayList<Coche> lista;
   
   // Constructor
   public Concesionario(String concesionario) {
      nombre = concesionario;
      lista = new ArrayList<Coche>();
   }
   
   // METODO QUE HAY QUE CORREGIR
   public Concesionario(String nombre, String fichero) throws FileNotFoundException {
      this.nombre = nombre;
      lista = new ArrayList<Coche>();
      Scanner leerFichero = new Scanner(new File(fichero));
      while (leerFichero.hasNext()) {
         String marca = leerFichero.next();
         String modelo = leerFichero.next();
         int year = leerFichero.nextInt();
         Coche unCoche = new Coche(marca, modelo, year);
         lista.add(unCoche);
      }
   }
   
   // Metodos
   public String toString() {
      String formato = nombre.toUpperCase() + "\n";
      int i = 1;
      for (Coche unCoche : lista) {      
         formato += i + ": " + unCoche + "\n";
         i++;             
      }
      return formato;
   }
}