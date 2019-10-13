/*
Crea el método mostrar(). Se le pasarán 3 parámetros:
    Número de filas
    Número de columnas
    Una letra

Escribirá por consola un cuadrado de filas por columnas con la letra indicada.

mostrar(4, 6, "X");

CUADRADO
X X X X X X 
X X X X X X 
X X X X X X 
X X X X X X 
*/
import java.util.*;
public class Ejercicio15{
   public static void main(String[] args){
      Scanner teclado = new Scanner(System.in);
      int numF = 0;
      int numC = 0;
      char caract ;
      System.out.print("Número de filas: ");
      numF = teclado.nextInt();
      System.out.print("Número de columnas: ");
      numC = teclado.nextInt();
      System.out.println("Introduzca una letra: ");
      caract = teclado.next().charAt(0);
      System.out.println("CUADRADO");
   
   
      mostrar(numF, numC, caract);
   }
   public static void mostrar(int numFilas, int numcolum, char letra){
      for(int i = 1; i <= numFilas; i++){
         for(int j = 1; j <= numcolum; j++){
            System.out.print(letra);
         }
         System.out.println();
      }
   }
}
