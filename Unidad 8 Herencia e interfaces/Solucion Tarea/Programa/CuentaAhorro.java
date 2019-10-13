/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2019
  Modulo:   Programación.
  UD:       UD8 Herencia e interfaces.
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa:   Definición de la clase CuentaAhorro
                              Utilizará los atributos y métodos heredados de Cuenta
                              Sobreescribirá los métodos abstractos ingreso y retirada 
                                
*******************************************************************************************************************/

public class CuentaAhorro extends Cuenta {
   // No necesita nuevos atributos
   
   // Constructor
   // Llama al constructor de la superclase para inicializar los atributos titular y saldo
   // Si el deposito inicial es mayor a 3000, se ingresará en la cuenta 100 más
   public CuentaAhorro(Cliente titular, double depositoInicial) {
      super(titular, depositoInicial);
      if (depositoInicial > 3000) {
         ingreso(100);
      }
   }

   // Sobreescribe el método de la superclase
   // El banco carga una comisión de 2 por cada retirada de dinero
   // No se permitirán retiradas si el saldo final es menor a 10. 
   // Parámetros: 
   //    double cantidad: euros que se van a sacar de la cuenta
   // Si la retida se produce devolverá true, en caso contrario false
   @Override
   public boolean retirada(double cantidad) {
      double nuevoSaldo = saldo - cantidad - 2;       // Calcula el saldo final
      if (nuevoSaldo < 10) {
         return false;
      }
      saldo = nuevoSaldo;                             // Actualiza el valor del atributo saldo
      return true;
   }
      
   // Se permitirán ingresos de cualquier cantidad sin comisión
   // Parámetros: 
   //    double cantidad: euros que se van a sacar de la cuenta
   @Override
   public void ingreso(double cantidad) {
      saldo = saldo + cantidad;
   }

   // Se pagarán intereses y se añadirán al saldo de la cuenta
   // Parámetros: 
   //    double tasa: interés en % que se va a pagar a la cuenta
   // Se devolverán los intereses pagados
   public double addInteres(double tasa) {
      double interes = tasa * saldo / 100;
      ingreso(interes);
      return interes;
   }
}