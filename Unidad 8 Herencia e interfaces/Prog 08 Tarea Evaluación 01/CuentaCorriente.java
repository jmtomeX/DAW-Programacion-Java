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

// Cuenta Corriente: subclase de cuenta
public class CuentaCorriente extends Cuenta {
   // Atributos
   private int numeroRetiradas;
   // Cuenta el número de retiradas mensuales. Las 3 primeras no tienen comisión
   // Constructor
   public CuentaCorriente(Cliente titular, double saldo) {
      super(titular, saldo);
      numeroRetiradas = 0;
   }
      
   // Resetea el número de retiradas a 0.
   public void reseteaNumeroRetiradas() {
      numeroRetiradas = 0;
   }

   // Sobreescribe el método de la clase padre
   // El banco carga una comisión de 2 euros. Las 3 primeras están exentas
   // No permite saldos negativos. La retirada no se producirá y devolverá false, si todo va bien devolverá true.
     //Recibe como parámetro double cantidad y devuelve  un boleano.
   @Override
   public boolean retirada(double cantidad) { 
    // El banco carga una comisión de 2 euros.
      int comision = 2;
    // Las 3 primeras están exentas
      if(numeroRetiradas <= 3) {
         comision = 0;
      }
     //Si tiene menos de 4 retiradas no hay comisión.
    // No permite saldos negativos. Si la cantidad es igual o menor al saldo dejará
    //Se tendra en cuenta la comision
      if((cantidad  + comision) < saldo) {
         saldo -=  cantidad + comision;
         numeroRetiradas++;
         return true;
      }
      return false;
   }

   // Sobreescribe el método de la clase padre
   //Recibe como parámetro double cantidad.
   @Override  
   public void ingreso(double cantidad) {
   // Se permitirán ingresos de cualquier cantidad. La comisión será de 1 euro
      int comision = 1;
      saldo +=  cantidad - comision;
   }
}