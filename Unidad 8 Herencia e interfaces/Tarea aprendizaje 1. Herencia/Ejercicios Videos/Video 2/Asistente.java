// clase que representa un tipo específico de empleado, 
// un asistente.
// en este caso no se tiene en cuenta la antigüedad
public class Asistente extends Empleado {

   public Asistente() {
      // La llamada a super debe ser la primera línea de código
      super(0);
   } 
   // Los asistentes conciertan citas a horas dadas
   // Este método simula la realización de esa tarea
   //
   // String hora - hora a la que ocurrirá la cita
   public void conciertaCita(String hora) {
      System.out.println("Se ha concertado una cita a las: " + hora);
   }
}