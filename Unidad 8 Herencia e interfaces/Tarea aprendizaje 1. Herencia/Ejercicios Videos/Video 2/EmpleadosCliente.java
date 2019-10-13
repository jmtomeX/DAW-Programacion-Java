// Programa para estudiar la herencia en la POO
//
// Fijate que cada empleado tiene sus propios resultados a partir del mimo método
// Además, tienen métodos particulares

public class EmpleadosCliente {
   public static void main(String[] args) {
      System.out.println("Empleado: ");
      Empleado aitor = new Empleado(10);
      System.out.print(aitor.getHoras() + " horas a la semana, ");
      System.out.printf("%.2f euros, ", aitor.getSalario());
      System.out.print(aitor.getdiasVacaciones() + " días de vacaciones, usando el formulario ");
      System.out.println(aitor.getFormularioVacaciones());
      System.out.println();
      
      System.out.println("Asistente: ");
      Asistente juan = new Asistente();
      System.out.print(juan.getHoras() + " horas a la semana, ");
      System.out.printf("%.2f euros, ", juan.getSalario());
      System.out.print(juan.getdiasVacaciones() + " días de vacaciones, usando el formulario ");
      System.out.println(juan.getFormularioVacaciones());
      juan.conciertaCita("15:00");
      System.out.println();
      

      System.out.println("Abogado: ");
      Abogado sara = new Abogado(5);
      System.out.print(sara.getHoras() + " horas a la semana, ");
      System.out.printf("%.2f euros, ", sara.getSalario());
      System.out.print(sara.getdiasVacaciones() + " días de vacaciones, usando el formulario ");
      System.out.println(sara.getFormularioVacaciones());
      sara.litiga();
      System.out.println();
      
      
      System.out.println("Asistente Legal: ");
      AsistenteLegal ane = new AsistenteLegal();
      System.out.print(ane.getHoras() + " horas a la semana, ");
      System.out.printf("%.2f euros, ", ane.getSalario());
      System.out.print(ane.getdiasVacaciones() + " días de vacaciones, usando el formulario ");
      System.out.println(ane.getFormularioVacaciones());
      ane.conciertaCita("10:00");
      ane.completaInformeLegal();
      System.out.println();

   }
}