/*
Crea el método palabra().

Se le pasará una palabra y un número y mostrará un cuadrado como se muestra en el ejemplo.

palabra("hola", 6);

H H H H H H 
O O O O O O 
L L L L L L 
A A A A A A 
*/
public class Ejercicio03 {
   public static void main(String[] args) {
      palabra("Esternon", 65);
   }
   
   public static void palabra(String word, int repeticion){
      for(int i = 0; i < word.length(); i++){
         char caracter = (char)word.toUpperCase().charAt(i);
         for(int j = 1; j <= repeticion ; j++){
            System.out.print(caracter + " ");
         } 
         System.out.println();
      }
   }
   
   
   /*public static void palabra(String word, int repeticion){
      int cuentaLetras = word.length();
      word = word.toUpperCase();
      for(int j =1; j <= repeticion; j++){
         for(int i = 0; i < cuentaLetras; i++){
            char caracter =(char)word.charAt(i);
            System.out.print(caracter + " ");
         }
         System.out.println(); 
      }
   }*/
}