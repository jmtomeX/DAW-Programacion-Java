// clase que representa un tipo específico de empleado, 
// un abogado
// Queremos que su sueld también dependa de la antiguedad, 1000 euros por cada año
// Los atributos de la superclase no son accesibles desde las subclase. 2 alternativas:
// Declararlas protected en la superclase
// Crear y utilizar los métodos set y get

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
      // return salarioBase + 15000.0 + 1000 * super.getAntiguedad();
      return salarioBase + 15000.0 + 1000 * antiguedad;
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