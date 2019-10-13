/*
Partiendo de la última versión de la clase Empleado de nuestros vídeos, crea la subclase Comercial con las
siguientes características:

    Gana 10000 euros más que el salario básico de los empleados
    Tiene el metodo adicional publicitar que mostrará por consola el siguiente mensaje: "Hay que venderse más!"
    Resto no cambia

Recuerda interactuar correctamente con la superclase usando super.

Comprobaremos la subclase con el siguiente código:
*/
public class Comercial extends Empleado {

   public Comercial(int antiguedad){
      super(antiguedad);
   }

   @Override
   public double getSalario() {
      double salarioBase = super.getSalario();
      return salarioBase + 10000;
   }

   public void publicitar() {
      System.out.println("Hay que venderse más!");
   }
}