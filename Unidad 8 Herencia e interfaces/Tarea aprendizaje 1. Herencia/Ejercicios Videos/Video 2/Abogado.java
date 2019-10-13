// clase que representa un tipo específico de empleado, 
// un abogado
// Solo se hereda el constructor vacío
// Si creamos un constructor con parámetros en la superclase, no se hereda. Hay que crearla en cada subclase

public class Abogado extends Empleado {
  
   public Abogado(int antiguedad) {
      // La llamada a super debe ser la primera línea de código
      super(antiguedad);
   } 
   // Devuelve el salario de un abogado
   // Gana 35000 euros al año en vez de 20000
   @Override
   public double getSalario() {
      double salarioBase = super.getSalario();
      return salarioBase + 15000.0;
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