public class EmpleadoHorasMain {

   public static void main(String[] args) {
   
      EmpleadoHoras iker = new EmpleadoHoras("Iker Zamora", "111111JJ", 25);
      iker.addHoras(100);
      System.out.println(iker);
      System.out.println(iker.salario());
   }
}