public class Cuenta {
   private int numero;
   private double saldo;
   private String titular;
   public Cuenta(  int numero, double saldo, String titular){
      setNumero(numero);
      setSaldo(saldo);
      setTitular(titular);
   }
   public void setNumero(int numero){
      this.numero = numero;
   }    
   public void setSaldo(double saldo){
      this.saldo = saldo;
   }    
   public void setTitular(String titular){
      this.titular = titular;
   }    
   public int getNumero(){
      return numero;
   }    
   public double getSaldo(){
      return saldo;
   }    
   public String getTitular(){
      return titular;
   }    
   public String toString(){
      return numero + " "+ saldo + " " + titular;
   }    
   public double ingresar(double cantidad){
      saldo += cantidad;
      return saldo;
   }    
   public boolean retirar(double cantidad){
      if(cantidad<= saldo){
         return true;
      }
      return false;
   }    
}