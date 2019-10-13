public class Ejercicio01 {

   public static final int AGOSTO = 10;
   public static final int ABRIL = 5;
   public static final int JUNIO = 2;
   public static final String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
   public static void main(String[] args){
      System.out.println(MESES[JUNIO - 1]);
      System.out.println(MESES[AGOSTO - 1]);
      System.out.println(MESES[ABRIL - 1]);
      System.out.println(MESES[ABRIL]);
      System.out.println();
      for (String item : MESES) {
         System.out.println(item);
      }
   }
}