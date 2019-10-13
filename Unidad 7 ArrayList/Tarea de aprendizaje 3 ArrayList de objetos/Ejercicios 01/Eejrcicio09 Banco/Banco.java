import java.util.*;

public class Banco {
   // Atributos
   private String nombre;
   private ArrayList<Cuenta> lista;

   // Constructor
   public Banco(String nombre) {
      this.nombre = nombre;
      lista = new ArrayList<Cuenta>();
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
   // CREA EL METODO AQUI
   public String saldoMenor() {
   Cuenta min = lista.get(0);
   for(int i = 1; i < lista.size(); i++){
      Cuenta unaCuenta  =lista.get(i);
      if (unaCuenta.getSaldo() < min.getSaldo()){
         min = unaCuenta;
      }
   }
   return min.toString();
   }
   
}