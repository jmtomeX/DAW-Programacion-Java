/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2019
  Modulo:   Programación.
  UD:       UD8 Herencia e interfaces.
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa:   Definición de la clase CuentaCorriente
                              Utilizará los atributos y métodos heredados de Cuenta
                              Creará un nuevo atributo: numeroRetiradas
                              Sobreescribirá los métodos abstractos ingreso y retirada 
                                
*******************************************************************************************************************/

public class CuentaCorriente extends Cuenta {

   // Constantes para toda la clase
   private static final int RETIRADAS = 3;

   // Atributos
   // Cuenta el número de retiradas mensuales. Las 3 primeras no tienen comisión
   private int numeroRetiradas;
   
   // Constructor
   // Llama al constructor de la superclase para inicializar los atributos titular y saldo
   // Inicializa a 0 el nuevo atributo.
   public CuentaCorriente(Cliente titular, double depositoInicial) {
      super(titular, depositoInicial);
      numeroRetiradas = 0;
   }
   
   // Resetea el número de retiradas a 0.
   public void reseteaNumeroRetiradas() {
      numeroRetiradas = 0;
   }

   // Sobreescribe el método de la clase padre
   // El banco carga una comisión de 2. Las 3 primeras están exentas
   // No permite saldos negativos.
   // Parámetros: 
   //    double cantidad: euros que se van a sacar de la cuenta
   // Si la retida se produce devolverá true, en caso contrario false
   @Override
   public boolean retirada(double cantidad) {
      int comision = 0;
      if (numeroRetiradas >= RETIRADAS) {
         comision = 2;              // Si se ha hecho 3 o más retiradas la comisión será de 2 euros
      }
      
      double restar = cantidad + comision;
      if (saldo > restar) {
         saldo -= restar;
         numeroRetiradas++;
         return true;
      }
      
      return false;
   }
      
   // Se permitirán ingresos de cualquier cantidad. La comisións será de 1
   // Se asume que el ingreso será mayor que un euro
   // Parámetros: 
   //    double cantidad: euros que se van a sacar de la cuenta
   @Override
   public void ingreso(double cantidad) {
      saldo = saldo + cantidad - 1;
   }
}