public class EmpleadosMain{
   public static void main(String[] args) {
      System.out.println("Chofer: ");
      Chofer raul = new Chofer(10, 50);
      raul.viajar(100);
      System.out.println(raul.getHoras() + " horas a la semana, ");
      System.out.printf("%.2f euros, \n", raul.getSalario());
      System.out.println(raul.getdiasVacaciones() + " dias de vacaciones, usando el formulario ");
      System.out.println(raul.getFormularioVacaciones());
      
      System.out.println("Comercial: ");
      Comercial lidia = new Comercial(5);
      System.out.println(lidia.getHoras() + " horas a la semana, ");
      System.out.printf("%.2f euros, \n", lidia.getSalario());
      System.out.print(lidia.getdiasVacaciones() + " dias de vacaciones, usando el formulario ");
      System.out.println(lidia.getFormularioVacaciones());
      lidia.publicitar(); 
   }
}