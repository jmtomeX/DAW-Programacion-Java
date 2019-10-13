/*
Crea el método mostrar(). Se le pasará:

    un número

Escribirá la tabla de multiplicar de ese número.

mostrar(4);

1 x 4 = 4
2 x 4 = 8
...
10 x 4 = 40
*/
public class Ejercicio07{
   public static void main(String[] args){
    
      mostrar(4);
   }
   public static void mostrar(int num){
      for(int i = 1; i <=10; i++){
         System.out.println(i + " x " + num + " = " + i * num);
      }
   }
}