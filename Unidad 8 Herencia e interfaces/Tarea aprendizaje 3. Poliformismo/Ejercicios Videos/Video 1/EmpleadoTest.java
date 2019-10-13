// Programa para estudiar la herencia y el polimorfismo en la POO

public class EmpleadoTest {
   public static void main(String[] args) {
   
      // Trabajamos con la clase Empleado
      Empleado unEmpleado = new Empleado(5);
      System.out.println("EMPLEADO");
      System.out.println("Horas/semana: " + unEmpleado.getHoras());
      System.out.printf("Salario: %.2f\n", unEmpleado.getSalario());
      System.out.printf("Días de vacaciones: %d\n", unEmpleado.getDiasVacaciones());
      System.out.printf("Formulario: %s\n", unEmpleado.getFormularioVacaciones());
      System.out.println();
      
      // Trabajamos con la clase Abogado
      Abogado unAbogado = new Abogado(3);
      System.out.println("ABOGADO");
      System.out.println("Horas/semana: " + unAbogado.getHoras());
      System.out.printf("Salario: %.2f\n", unAbogado.getSalario());
      System.out.printf("Días de vacaciones: %d\n", unAbogado.getDiasVacaciones());
      System.out.printf("Formulario: %s\n", unAbogado.getFormularioVacaciones());
      unAbogado.litiga();
      System.out.println();
      
      // Aplicamos el polimorfismo
      // Podemos crear un objeto de la clase Abogado y guardarlo en un objeto de una clase padre (Empleado)
      // Solo podemos usar los métodos de la clase Empleado
      // Creamos un objeto Abogado con todas sus funcionalidades
      // pero solo podemos usar las funcionalidades de la clase Empleado
      Empleado otroEmpleado = new Abogado(3);
      
      System.out.println("ABOGADO");
      System.out.println("Horas/semana: " + otroEmpleado.getHoras());
      System.out.printf("Salario: %.2f\n", otroEmpleado.getSalario());
      System.out.printf("Días de vacaciones: %d\n", otroEmpleado.getDiasVacaciones());
      System.out.printf("Formulario: %s\n", otroEmpleado.getFormularioVacaciones());
      
      // Los métodos de la clase Abogado darán error a no ser que apliquemos el casting
      Abogado otroAbogado = (Abogado) otroEmpleado;
      otroAbogado.litiga();
   }
}