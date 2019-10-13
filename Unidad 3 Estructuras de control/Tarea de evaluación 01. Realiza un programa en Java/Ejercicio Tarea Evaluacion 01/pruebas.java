public class pruebas{
   public static void main(String[] args) {
      notaFinal(3,3);
   }
      
   public static double notaFinal(int notaExamen, int puntosExtra ){
      final int NOTA_MAXIMA = 100;
      int  notaTotal = notaExamen + puntosExtra;
      if(notaTotal >  NOTA_MAXIMA){
         notaTotal = 100;
      }
      System.out.println("Nota final = " + notaTotal + " / 100");
      return notaTotal;
   }

}