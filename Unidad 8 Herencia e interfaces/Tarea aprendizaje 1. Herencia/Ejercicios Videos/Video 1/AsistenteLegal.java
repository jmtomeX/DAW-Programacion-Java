// clase que representa un tipo específico de Asistente, 
// un asistente legal.
public class AsistenteLegal extends Asistente{
   
   // Devuelve el salario de un aistente legal
   // Gana 25000 euros al año en vez de 20000
   @Override
   public double getSalario() {
      return 25000.0;
   }
 
   // Simula la tarea del asistente legal.
   public void completaInformeLegal() {
      System.out.println("Informe legal completado");
   }
}