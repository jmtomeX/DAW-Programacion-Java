// clase que representa un tipo específico de empleado, 
// un asistente.
public class Asistente extends Empleado {
   // Los asistentes conciertan citas a horas dadas
   // Este método simula la realización de esa tarea
   //
   // String hora - hora a la que ocurrirá la cita
   public void conciertaCita(String hora) {
      System.out.println("Se ha concertado una cita a las: " + hora);
   }
}