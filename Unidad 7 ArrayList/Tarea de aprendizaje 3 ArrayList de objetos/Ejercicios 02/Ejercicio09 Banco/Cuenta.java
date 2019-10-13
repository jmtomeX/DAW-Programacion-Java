public class Cuenta {
   public int numero;
   public double saldo;
   public String titular;

   public Cuenta(int numero, double saldo, String titular){
      setNumero(numero);
      setSaldo(saldo);
      setTitular(titular);
   }
    
   public int getNumero(){
      return numero;
   }
    
   public double getSaldo() {
      return saldo;
   }
    
   public String getTitular() {
      return titular;
   }
    
   public void setNumero(int numero){
      this.numero = numero;
   }
    
   public void setSaldo(double saldo) {
      this.saldo = saldo;
   }
    
   public void setTitular(String titular) {
      this.titular = titular;
   }
   public String toString() {
      return numero + " " + saldo + " " + titular;
   } 
}