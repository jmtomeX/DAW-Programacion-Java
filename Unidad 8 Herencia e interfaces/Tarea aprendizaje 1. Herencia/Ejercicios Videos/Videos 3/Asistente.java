// clase que representa un tipo específico de empleado, 
// un asistente.
// en este caso no se tiene en cuenta la antigüedad
// Mejor mantener el atributo y modificar los métodos para cambiar el comportamiento
public class Asistente extends Empleado {

   public Asistente(int antiguedad) {
      // La llamada a super debe ser la primera línea de código
      super(antiguedad);
   }
   
   @Override
   public double getSalario() {
      return super.getSalario() + 400 * antiguedad;
   } 
   
   @Override
   public int getBonus() {
      return 0;
   }
   
   // Los asistentes conciertan citas a horas dadas
   // Este método simula la realización de esa tarea
   //
   // String hora - hora a la que ocurrirá la cita
   public void conciertaCita(String hora) {
      System.out.println("Se ha concertado una cita a las: " + hora);
   }
}