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
    // Buscar todas las cuentas de un mismo titular
       // Las devuelve como un objeto banco con nombre "Cuentas del titular: nombreTitular"
   public Banco cuentasTitular(String titular) {
      Banco bancoTitular = new Banco("Cuentas del titular: " + titular);
      for(Cuenta unaCuenta: lista){
         String elTitular = unaCuenta.getTitular();
         if(elTitular.equals(titular)) {
            Cuenta copia = new Cuenta(unaCuenta);
            bancoTitular.lista.add(copia);
         }
      }
   
      return bancoTitular;
   }
   
}