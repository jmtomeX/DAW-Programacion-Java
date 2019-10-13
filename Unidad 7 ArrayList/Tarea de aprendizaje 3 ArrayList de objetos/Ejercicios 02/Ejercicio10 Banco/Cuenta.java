public class Cuenta {
   public int numero;
   public double saldo;
   public String titular;

   public Cuenta() {
      this(0, 0.0, "");    
   }

   public Cuenta(int numero, double saldo, String titular) {
      this.numero = numero;
      this.saldo = saldo;
      this.titular = titular;
   }
   
   public void setNumero(int numero) {
      this.numero = numero;    
   }
   
   public void setSaldo(double saldo) {
      this.saldo = saldo;    
   }

   public void setTitular(String titular) {
      this.titular = titular;    
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

   public String toString() {
      return titular + "(" + numero + "): " + saldo + " euros";    
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
}