// Programa para estudiar la herencia y el polimorfismo en la POO

public class EmpleadoCliente {

   public static void main(String[] args) {
      
      // Creamos una lista de objetos de la clase Empleado y almacenamos objetos de todas sus clases hijos
      // Solo podemos usar los métodos comunes, los de la clase Empleado
      // Podemos usar la lista como si fueran elementos del mismo tipo
      Empleado[] arrayEmpleados = {new Empleado(5), new Abogado(3), new Asistente(10), new AsistenteLegal(2)};
      
      for (Empleado unEmpleado : arrayEmpleados) {
         imprimirInfo(unEmpleado);
      }
   }
   
   // Método común. Le pasamos un objeto de la clase padre
   public static void imprimirInfo(Empleado elEmpleado) {

      // Métodos comunes
      System.out.println("Horas/semana: " + elEmpleado.getHoras());
      System.out.printf("Salario: %.2f\n", elEmpleado.getSalario());
      System.out.printf("Días de vacaciones: %d\n", elEmpleado.getDiasVacaciones());
      System.out.printf("Formulario: %s\n", elEmpleado.getFormularioVacaciones());
      
      // Métodos de las clases hijo
      // Para usarlos necesitamos saber que clase es y hacer casting
      if (elEmpleado instanceof Abogado) {
         System.out.println("ABOGADO");
         Abogado esAbogado = (Abogado) elEmpleado;
         esAbogado.litiga();
      } else if (elEmpleado instanceof AsistenteLegal) {
         System.out.println("ASISTENTE LEGAL");
         AsistenteLegal esAsistenteLegal = (AsistenteLegal) elEmpleado;
         esAsistenteLegal.conciertaCita("10:00");
         esAsistenteLegal.completaInformeLegal();
      } else if (elEmpleado instanceof Asistente) {
         System.out.println("ASISTENTE");
         Asistente esAsistente = (Asistente) elEmpleado;
         esAsistente.conciertaCita("12:00");
      } else if (elEmpleado instanceof Empleado) {
         System.out.println("EMPLEADO");
      } else {
         System.out.println("Esa categoría no existe");
      }
      System.out.println();
   }
}