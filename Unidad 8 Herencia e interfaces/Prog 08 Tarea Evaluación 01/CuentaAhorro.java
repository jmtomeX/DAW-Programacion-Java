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

// Cuenta de ahorro: subclase de Cuenta
public class CuentaAhorro extends Cuenta {
   // Constructor
   public CuentaAhorro(Cliente titular, double depositoInicial) {
      super(titular, depositoInicial);
      depositoInicial = depositoInicial;
   // Si el deposito inicial es mayor a 3000 euros, el banco regalará 100 euros
      if(depositoInicial > 3000) {
         ingreso(100);
      }
   }
   
   // Sobreescribe el método retirada de la clase padre
   // Devolverá false y dejará el saldo sin modificar, si la retida se produce devolverá true
   //Recibe como parámetro double cantidad y devuelve  un boleano.
   @Override
   public boolean retirada(double cantidad) {
   // El banco carga una comisión de 2 euros por cada retirada de dinero
      int comision = 2;
      double saldoFinal = saldo - (cantidad  + comision);
   // No permitirá retiradas si el saldo final es menor a 10 euros.
      if(saldoFinal > 10) {
         saldo = saldoFinal;
         return true;
      }
      return false;
   
   }
    
   @Override      
   // Sobreescribe el método ingreso de la clase padre
   // Se permitirán ingresos de cualquier cantidad sin comisión
   //Recibe como parámetro double cantidad.
   public void ingreso(double cantidad) {
      saldo += cantidad;
   }
   
   // Se pagarán intereses y se añadirán al saldo de la cuenta
   //Recibe como parámetro double tasa y devuelve un double con los intereses.
   public double addInteres(double tasa){
      double intereses = saldo * (tasa/100);
      ingreso(intereses);
      return intereses;
   }
}