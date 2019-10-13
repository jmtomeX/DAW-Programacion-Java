/*
Escribe el método cuadrado(). Se le pasará una palabra y dibujará un cuadrado como en el ejemplo:

cuadrado("hola");
----------
|a l o h |
|a l o h |
|a l o h |
|a l o h |
----------
*/

public class Ejercicio04 {
   public static void main(String[] args) {
      cuadrado("hola");
   }
   
   public static void cuadrado(String word){
      StringBuilder builder=new StringBuilder(word);       
      String sCadenaInvertida=builder.reverse().toString();
      for(int k = 0; k < word.length() *2 + 2; k++){
         System.out.print("-");
      }
      System.out.println();
      for(int j = 0; j < word.length(); j++){
         System.out.print("|");
         for(int i = 0; i < word.length(); i++){
            char caracter = (char)sCadenaInvertida.charAt(i);
            System.out.print(caracter + " ");
         }
         System.out.println("|");
      }
      for(int k = 0; k < word.length() * 2 + 2; k++){
         System.out.print("-");
      }
      
   }
}

/*
    for (int x=sCadena.length()-1;x>=0;x--)
    		sCadenaInvertida = sCadenaInvertida + sCadena.charAt(x);
*/