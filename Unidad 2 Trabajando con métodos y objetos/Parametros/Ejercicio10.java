/*
Crea el método mostrar(). Se le pasarán 2 parámetros:

    una cadena de carácteres
    un número

Escribirá por consola el texto el número de veces indicado.

mostrar("Hola", 4);

Hola Hola Hola Hola
*/
public class Ejercicio10{
   public static void main(String[] args){
      mostrar("Hola", 4);
   }
   
   public static void mostrar(String text, int num){
      for(int i = 1; i <= num; i++){
         System.out.print(text + " ");
      }
   }
}