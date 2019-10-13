/*
Crea la clase EmpleadoComision a partir de la clase Empleado para que cumpla las siguientes características:

1. Tendrá 2 atributos más de tipo doble denominados ventas y comision. Se deberán inicializar en el constructor
   a partir de los valores indicados como parámetro.
2. El método salario devolverá el resultado de la siguiente operación: ventas * comision / 100
3. El método toString devolverá el siguiente texto: nombre (numSeguridadSocial) Ventas: ventas Comision:
   comision. Tanto las ventas como la comisión se mostrarán con 2 decimales.
*/

public class EmpleadoComision extends Empleado {
   double ventas;
   double comision;
   public EmpleadoComision(String nombre, String numero, double ventas, double comision ) {
      super(nombre, numero);
      this.ventas = ventas;
      this.comision = comision;
   }
    
   public double salario() {
      return ventas * comision / 100;
   }
    
   public String toString() {
      //return super.toString() + String.format(" Paga/hora: %.2f Horas: %.2f", ventas, comision);
      return super.toString() + String.format(" Ventas %.2f Comision: %.2f", ventas, comision);
            //Javier Salas (111111JJ) Ventas: 60000,00 Comision: 40,00
   
   }
}