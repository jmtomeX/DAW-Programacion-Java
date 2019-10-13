/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2019
  Modulo:   Programación.
  UD:       UD8 Herencia e interfaces.
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa:   Definición de la clase abstracta Cuenta
                              Gestionará el titular y el saldo de una cuenta
                              Implementa la interfaz Comparable para poder ordenar por el DNI, de menor a mayor,
                              y si el DNI es igual por el saldo (de mayor a menor)
                                
*******************************************************************************************************************/
abstract class Cuenta implements Comparable<Cuenta> {

   // Atributos
   // Se definen como protected para que sean accesibles desde las clases
   protected Cliente titular;
   protected double saldo;
   
   // Constructor
   // Recibe un Cliente y un saldo e inicializa los atributos de la clase.
   // Como los objetos se pasan por referencia, hacemos una copia
   // para asegurarnos que los datos no sean accesibles desde fuera de la clase
   public Cuenta(Cliente titular, double saldo) {
      Cliente copia = new Cliente(titular);
      this.titular = copia;
      this.saldo = saldo;
   }

   // Método toString
   // Devuelve los datos de la cuenta con el siguiente formato
   // nombreClaseCuenta(hueco de 15): dni (nombre)(hueco de 20) Saldo saldo(hueco de 8 con 2 decimales)
   // CuentaCorriente: 11111111A (Alicia)   Saldo  500,50
   // Para obtener el nombre de la clase puedes usar this.getClass().getName()
   public String toString() {
      String formato = String.format("%-15s: %-20s Saldo%8.2f", this.getClass().getName(), titular, saldo);
      return formato;
   }
   
   // Devuelve true si los DNIs son iguales, false en caso contrario.
   public boolean mismoDni(String dni) {
      String esteDni = titular.getDni();
      return esteDni.equals(dni);
   }
   
   // Método de la interfaz Comparable
   // Permite comparar una cuenta con otra pasada como parámetro.
   // Primero por el DNI indicando cuál es menor y debe ir delante
   // Si el DNI es igual por el saldo indicando cuál es mayor y debe ir delante
   // Si debe ir delante devolverá un valor < que 0, si debe ir detrás uno > 0 y si son iguales 0
   @Override
   public int compareTo (Cuenta otraCuenta) {
      String dni = this.titular.getDni();
      String otroDni = otraCuenta.titular.getDni();
      int orden = dni.compareTo(otroDni);       // Si son iguales devuelve 0, si dni debe ir delante devuelve < 0 y si debe ir detrás > 0
      Double otroSaldo = otraCuenta.saldo;
      
      // Si 2 cuentas pertenecen al mismo titular las ordena por saldo de mayor a menor
      if (orden == 0) {
         if (saldo > otroSaldo) {
            return -1;           // Debe ir delante
         }
         if (saldo < otroSaldo) {
            return 1;            // Debe ir detrás
         }
      }
      return orden;              // Debe hacer lo que digan los DNI
   }

   // Cada tipo de cuenta lo desarrollará de manera diferente
   public abstract boolean retirada(double cantidad);
   public abstract void ingreso(double cantidad);
}