/*
Tenemos un programa en el que queremos añadir un método para que pida el nombre y los coches de un concesionario y recorra y
devuelva un objeto de la clase Concesionario. El funcionamiento sería el siguiente pidiendo coches hasta que se pulse "N":

Nombre del concesionario: House of Cars
Introducir un coche (S/N)? S
Marca: Opel
Modelo: Corsa
Year: 2010
Introducir un coche (S/N)? S
Marca: Ford
Modelo: Fiesta
Year: 2012
Introducir un coche (S/N)? N

Si la clase Concesionario tiene los siguientes métodos:

public class Concesionario {
   private String nombre;
   private ArrayList<Coche> lista;
   
   public Concesionario(String concesionario) 
   public void addCoche(String marca, String modelo, int year)
   public String toString()
}
*/

import java.util.*;
import java.io.*;

public class ConcesionarioMain {
   public static void main(String[] args) throws FileNotFoundException  {
      Scanner leerTeclado = new Scanner(System.in);
      Concesionario otroConcesionario =  crearConcesionario(leerTeclado);
      System.out.println(otroConcesionario);
      
      File fichero = new File("concesionario08.txt");
      System.out.println(crearConcesionarioFichero(fichero));
      System.out.println(otroConcesionario.cochesYear(2015));
   }
   
   // METODO A CORREGIR
   public static Concesionario crearConcesionario(Scanner leerDatos) {
      System.out.print("Nombre del concesionario: ");
      String nombre = leerDatos.nextLine();       
      Concesionario unConcesionario = new Concesionario(nombre);
      
      System.out.print("Introducir un coche (S/N)? ");
      String respuesta = leerDatos.next();
      while(respuesta.equalsIgnoreCase("S")){
         System.out.print("Marca: ");
         String marca = leerDatos.next();
         System.out.print("Modelo: ");
         String modelo = leerDatos.next();
         System.out.print("Year: ");
         int year = leerDatos.nextInt();
         unConcesionario.addCoche(new Coche(marca, modelo, year));
         System.out.print("Introducir un coche (S/N)? ");
         respuesta = leerDatos.next();
      };
      
      return unConcesionario;
   }
   //Método que crea un concesionario a partir de un fichero
   
   public static Concesionario crearConcesionarioFichero(File fichEntrada) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(fichEntrada);
      String nombre = leerFichero.nextLine();
      Concesionario unConcesionario = new Concesionario(nombre);
      while(leerFichero.hasNext()) {
         String marca = leerFichero.next();
         String modelo = leerFichero.next();
         int year = leerFichero.nextInt();
         unConcesionario.addCoche(new Coche(marca, modelo, year));
      }
            
      return unConcesionario;
   
   }
}

