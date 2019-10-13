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
   
   public Cuenta(Cuenta unaCuenta) {
      this(unaCuenta.numero, unaCuenta.saldo, unaCuenta.titular);
   }

   public int getNumero() {
      return numero;    
   }

   public double getSaldo() {
      return saldo;    
   }

   public String getTitular() {
      return titular;    
   }

   public double ingresar(double cantidad) {
      saldo += cantidad;
      return saldo;    
   }

   public boolean retirar(double cantidad) {
      if (saldo >= cantidad) {
         saldo -= cantidad;
         return true;
      } else {
         return false;
      }
   }
   
   public boolean equals(Object objeto) {
      if (objeto instanceof Cuenta) {
         Cuenta unCuenta = (Cuenta) objeto;
         if (titular.equals(unCuenta.titular) && numero == unCuenta.numero) {
            return true;
         }
      }
      return false;
   }
}