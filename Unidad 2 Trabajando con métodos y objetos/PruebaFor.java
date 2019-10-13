public class PruebaFor{
   public static void main(String[] args) {
     
      //añadimos los números
      for(double i = 0.5; i <= 10; i+= 0.5){
         System.out.println(i);
           
      }
      
      final double INTERES_MIN = 2.0;
      final double INTERES_MAX = 5.0;
      for(int i = 5; i <= 10; i++){
         for(double interes = INTERES_MIN; interes <= INTERES_MAX; interes += 0.5){
            System.out.print(i + " Años\t" + interes );
         }
         System.out.println();
      }
      int interes = 3;
      int annos = 2;
      System.out.println( Math.pow(  interes, annos));
      
   
   }
}