/*
 El resultado será:

      LORO
      Sexo: F Edad: 10
      HOLA Piopio HOLA
      Region: Sur
*/

public class LoroMain {

   public static void main(String[] args) {
   
      Loro unLoro = new Loro('F', 10, "S");
   	
      System.out.println("LORO");
      System.out.println(unLoro);
      System.out.println(unLoro.trinar());
      System.out.println("Region: " + unLoro.deDondeEs());
   }
}