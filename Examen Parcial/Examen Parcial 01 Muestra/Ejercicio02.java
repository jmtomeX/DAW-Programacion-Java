public class Ejercicio02 {
   public static void main(String[] args) {
      String en = "mancha"; 
      String un = "lugar"; 
      String lugar = "dulcinea"; 
      String sancho = "en"; 
      String mancha = un; 
    
      verso(en, "lugar", lugar); 
      verso("un", sancho, mancha); 
      verso(mancha, un, en); 
      sancho += "?"; 
      verso(en, sancho, "un"); 
   } 

   public static void verso(String mancha, String en, String un) { 
      System.out.println(en + " " + un + " lugar de la " + mancha); 
   } 
}