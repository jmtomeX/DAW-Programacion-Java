/*
    Partiendo de la última versión de la clase Empleado de nuestros vídeos, crea la subclase Chofer con las siguientes
    características:

    >Cobra la mitad del salario más 50 euros por cada viaje que hace. Usará un atributo viajes para llevar la cuenta.
    >Al constructor además de la antigüedad se le pasará el número de viajes que ha realizado.
    >Tiene el metodo adicional viajar. Recibirá el número de viajes que ha hecho, actualizará el atributo viajes
    y mostrará por consola el siguiente mensaje: "Mas viajes al bolsillo"

*/
public class Chofer extends Empleado {
   private int viajes;
 
   public Chofer(int antiguedad, int viajes) {
      super(antiguedad);
      this.viajes = viajes;
   }
   
   @Override
   public double getSalario() {
      double salarioBase = super.getSalario();
      salarioBase = salarioBase / 2 + (50 * viajes);
      return salarioBase;
   }
   
   public void viajar(int viajes) {
      this.viajes = viajes;
      System.out.println( "Mas viajes al bolsillo");   
   }
}