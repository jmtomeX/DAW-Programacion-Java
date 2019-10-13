 /***********************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  21/03/2019.
 Módulo:  Programación.
 Tarea:   PROG08 Tarea de evaluación 01. Realiza un programa en Java
 
 Descripción del programa:Esta tarea se centra en el desarrollo y uso de nuestras propias clases,
 aunque manejaremos también ArrayLists y ficheros. En este caso, trabajaremos aspectos más
 avanzados como la herencia, las clases abstractas, los interfaces o el polimorfísmo.
 
     
 Enlace aoutoevaluación: https://drive.google.com/file/d/1DTpnaF7Ut6mJGJ42pPfNhO1oqqZDy3DK/view?usp=sharing
     
*************************************************************************************************/ 

// Clase Cuenta
// Hay que convertirla en una clase abstracta de la que heredarán las clase CuentaAhorro y CuentaCorriente
// Tendrá 2 métodos abstractos que se desarrollarán en las clases hijas: retirada e ingreso

public abstract class  Cuenta implements Comparable<Cuenta> {

   protected Cliente titular;
   protected double saldo;
   
   public Cuenta(Cliente titular, double saldo) {
   
      Cliente copia = new Cliente(titular);
      this.titular = copia;
      this.saldo = saldo;
   }     
   
   public String toString() {
      String formato = String.format("%-15s: %-20s Saldo%10.2f", this.getClass().getName(), titular, saldo);
      return formato;
   }
   
   public boolean mismoDni(String dni) {
      String esteDni = titular.getDni();
      return esteDni.equals(dni);
   }
   
   public void setSaldo(double saldo) {
      this.saldo =  saldo;
   }
   // Cada tipo de cuenta lo desarrollará de manera diferente
   // Hasta que la clase sea abstracta estarán ocultos
   
   protected  boolean retirada(double cantidad);
   protected  void ingreso(double cantidad);
   
   // Debe implementar la interfaz Comparable para poder ordenar un array de Cuentas por el DNI,
   //de menor a mayor.
   @Override
   public int compareTo(Cuenta unaCuenta) {
   // ordena en orden alfabético de la A a la Z
   //Si el DNI es igual además ordenará por el saldo (de mayor a menor)
      String esteDni = this.titular.getDni();
      String otroDni = unaCuenta.titular.getDni();
      
   // Si son iguales devuelve 0, si dni debe ir delante devuelve  < 0
      int orden = esteDni.compareTo(otroDni);
    
    // Si 2 cuentas son iguales pertenecen al mismo titular las ordena por saldo de mayor a menor.  
      if(orden == 0) {
         if(saldo > unaCuenta.saldo) {
            return -1; // debe ir delante
         }
         if(saldo < unaCuenta.saldo) {
            return 1; // debe ir detrás
         }
      }
      return orden; // debe hacer lo que dian los dni    
   }
}
