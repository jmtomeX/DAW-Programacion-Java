import java.util.*;
import java.io.*;

public class Banco {
   // Atributos
   private String nombre;
   private ArrayList<Cuenta> lista;

   // Constructor
   public Banco(String nombre) {
      this.nombre = nombre;
      lista = new ArrayList<Cuenta>();
   }
   
   public Banco(String nombre, Scanner leerFichero){
      this.nombre = nombre;
      lista = new ArrayList<Cuenta>();
      while (leerFichero.hasNext()) {
         int numero = leerFichero.nextInt();
         double saldo = leerFichero.nextDouble();
         String titular = leerFichero.next();
         Cuenta unaCuenta = new Cuenta(numero, saldo, titular);
         lista.add(unaCuenta);
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
}