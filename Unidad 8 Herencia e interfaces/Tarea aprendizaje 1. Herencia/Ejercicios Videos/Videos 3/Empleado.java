// Clase que representa a un empleado estándar en una empresa
// Queremos que las vacaciones dependan de la antigüedad en la empresa, un día más por cada año
// Necesitamos añadir un atributo y un constructor
public class Empleado {
   protected int antiguedad;
   
   public Empleado (int antiguedad) {
      this.antiguedad = antiguedad;
   }

   // Devuelve la antigüedad del empleado
   public int getAntiguedad() {
      return antiguedad;
   }
 
   // Devuelve el numero de horas que trabaja el empleado
   public int getHoras() {
      return 40;
   }
   
   // Devuelve el salario del empleado.
   public double getSalario() {
      return 20000.0 + 3000;
   }
   
   // Devuelve el número de días de vacaciones al año del empleado.
   public int getdiasVacaciones() {
      return 20 + getBonus();
   }
   
   public int getBonus() {
      return antiguedad;
   }
   
   // Devuelve el color del formulario para pedir las vacaciones.
   public String getFormularioVacaciones() {
      return "amarillo";
   }
}