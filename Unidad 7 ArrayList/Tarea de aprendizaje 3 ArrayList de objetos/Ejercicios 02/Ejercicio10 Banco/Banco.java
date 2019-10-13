/*
Tenemos un programa en el que queremos añadir el método nuevaCuenta para que a partir de un Scanner y un objeto de la Clase Banco,
 pregunte el número de la cuenta que se quiere crear, compruebe que no exista, pida el resto de datos y la cree.

   El funcionamiento sería:
   
   // Si en el Banco existe esa cuenta, nos pedirá otro número hasta introducir uno libre: 
   Introduce el numero de la cuenta: 1111
   Introduce el numero de la cuenta: 11
   Introduce el saldo de la cuenta: 1111.11
   Introduce el titular de la cuenta: Marta
*/

import java.util.*;
import java.io.*;

public class Banco {
   // Atributos
   private String nombre;
   private ArrayList<Cuenta> lista;

   // Constructor
   /* public Banco(String nombre) {
      this.nombre = nombre;
      lista = new ArrayList<Cuenta>();
   } */
   
   public Banco(String nombre) throws FileNotFoundException {
      this.nombre = nombre;
      lista = new ArrayList<Cuenta>();
      File fichero = new File(nombre + ".txt");
      if (fichero.canRead()) {
         Scanner leerFichero = new Scanner(fichero);
         leerFichero.useLocale(Locale.ENGLISH);
         while (leerFichero.hasNext()) {
            int numero = leerFichero.nextInt();
            double saldo = leerFichero.nextDouble();
            String titular = leerFichero.next();
            Cuenta unaCuenta = new Cuenta(numero, saldo, titular);
            lista.add(unaCuenta);
         }
      }
   }
   
   public void addCuenta(int numero, double saldo, String titular) {
      Cuenta unaCuenta = new Cuenta(numero, saldo, titular);
      lista.add(unaCuenta);
   }
   
   // toString
   public String toString() {
      String formato = nombre.toUpperCase() + "\n";
      for (Cuenta unaCuenta : lista) {
         formato += unaCuenta + "\n";
      }
      return formato;
   }
   
   // Buscar cuenta con saldo menor
   public String saldoMenor() {
      Cuenta min = lista.get(0);
      for (int i = 1; i < lista.size(); i++) {
         Cuenta unaCuenta = lista.get(i);
         if (unaCuenta.getSaldo() < min.getSaldo()) {
            min = unaCuenta;
         }
      }
      return min.toString();
   }
   
   // Busca cuenta por su numero. Devuelve el indice, -1 si no la encuetra
   public boolean cuentaExiste(int numero) {
      for (int i = 0; i < lista.size(); i++) {
         Cuenta estaCuenta = lista.get(i);
         if (estaCuenta.getNumero() == numero) {
            return true;
         }
      }
      return false;
   }
   
   // Borra la cuenta indicada por su numero
   public void bajaCuenta(int numero) {
      Iterator<Cuenta> iterador = lista.iterator();
      while (iterador.hasNext()) {
         Cuenta estaCuenta = iterador.next();
         if (estaCuenta.getNumero() == numero) {
            iterador.remove();
         }
      }
   }
   
   private Cuenta copiaCuenta(Cuenta unaCuenta) {
      Cuenta otraCuenta = new Cuenta(unaCuenta.getNumero(), unaCuenta.getSaldo(), unaCuenta.getTitular());
      return otraCuenta;
   }
   
   // Método nuevaCuenta para que a partir de un Scanner y un objeto de la Clase Banco,
   // pregunte el número de la cuenta que se quiere crear, compruebe que no exista, pida el resto de datos y la cree.

   public static void nuevaCuenta(Scanner leerDatos, Banco elBanco) {
      int numero = 0;
      do {
         System.out.print("Introduce el numero de la cuenta: ");
         leerDatos.useLocale(Locale.US);
         numero = leerDatos.nextInt();
      } while (elBanco.cuentaExiste(numero));
      
      System.out.print("Introduce el saldo de la cuenta: ");
      double saldo = leerDatos.nextDouble();
      System.out.print("Introduce el titular de la cuenta: ");
      String titular = leerDatos.next();
      
      elBanco.addCuenta(numero, saldo, titular);
   }
   
}