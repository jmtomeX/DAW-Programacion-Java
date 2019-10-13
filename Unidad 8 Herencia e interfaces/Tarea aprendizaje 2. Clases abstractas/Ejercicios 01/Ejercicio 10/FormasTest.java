// Utilizamos las clases que hemos creado.

public class FormasTest {

   public static void main(String[] args) {
   
      Rombo unRombo = new Rombo(10, 5);
      System.out.printf("ROMBO: Area = %.2f, Perímetro = %.2f\n", unRombo.calcularArea(), unRombo.calcularPerimetro());  

   }
}