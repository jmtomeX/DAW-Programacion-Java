// clase que representa un tipo específico de empleado, 
// un abogado
public class Abogado extends Empleado {   
   // Devuelve el salario de un abogado
   // Gana 35000 euros al año en vez de 20000
   @Override
   public double getSalario() {
      return 35000.0;
   }
   
   // Devuelve el color del formulario para pedir las vacaciones.
   // Los abogados usan el rosa en vez de el amarillo.
   @Override
   public String getFormularioVacaciones() {
      return "rosa";
   }
   
   // Simula la tarea de los abogados: demandar.
   public void litiga() {
      System.out.println("Nos vemos en el juzgado");
   }
}