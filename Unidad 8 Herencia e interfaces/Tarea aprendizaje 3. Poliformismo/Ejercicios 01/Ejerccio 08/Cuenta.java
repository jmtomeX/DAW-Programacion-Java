public class Cuenta {
   public int numero;
   public double saldo;
   public String titular;

   public Cuenta(int numero, double saldo, String titular) {
      this.numero = numero;
      this.saldo = saldo;
      this.titular = titular;
   }
   
   public String toString() {
      return titular + "(" + numero + "): " + saldo + " euros";    
   }
   // Desarrolla el método equals para que cuando se ejecute el siguiente código identifique
   // las cuentas con el mismo número y titular sin tener en cuenta el saldo:

   public boolean equals(Cuenta unaCuenta) {
      if(numero == unaCuenta.numero && titular.equals(unaCuenta.titular)) 
         return true;
   
      return false;
   }
}