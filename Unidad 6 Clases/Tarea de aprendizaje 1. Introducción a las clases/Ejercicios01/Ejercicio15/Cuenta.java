/*(0): 0.0 euros
1234 Pedro Arana 1000.67
Ana Albizu(22): 500.5 euros
Ingresa: 1000.5 Saldo: 1000.5
Retira: true Saldo: 500.5
Retira: false Saldo: 500.5
Ana Albizu(22): 500.5 euros

Tenemos la clase Cuenta con los siguientes métodos:
*/

// Constructores
public class Cuenta{
   private int numero;
   private double saldo;
   private String titular;


   public Cuenta(int numero, double saldo, String titular){
      setNumero(numero);
      setSaldo(saldo);
      setTitular(titular);   
   }
   public Cuenta(){
      this(0, 0.0, "");
   }
// Modificadores y consultores
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

// Devuelve un String con el siguiente formato: titular (numero): saldo euros
   public String toString(){
      if(titular.equals(null)){
         return "(" + numero + "): " + saldo + " euros"; 
      }else{
         return titular + "(" + numero + "): " + saldo + " euros"; 
      }
      
   }

// incrementará el saldo en la cantidad indicada y devolverá el total obtenido
   public double ingresar(double cantidad){
      return saldo += cantidad;
   }

// Si hay saldo suficiente reducirá el saldo en la cantidad indicada y devolverá true
// En caso contrario devolverá false.
   public boolean retirar(double cantidad){
      if(saldo >= cantidad){
         saldo -= cantidad;
         return true;
      }
      return false;     
   }
   
   //Métodp para enmarcar consulta
   public String enmarcar(){
      return "**********************************\n**********************************";
   }

}