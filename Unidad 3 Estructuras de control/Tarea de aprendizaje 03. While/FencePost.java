// Programa que resuelve problemas Fence-Ponce con bucles For y While

import java.util.*;

public class FencePost {
   public static final int FIN = -2;
   
   public static void main (String[] args) {
      contarHasta(10);
      contarHasta2(15);
      System.out.println();
      
      deletreaPalabra("abracadabra");
      deletreaPalabra("CSE142");
      System.out.println();
      
      Scanner teclado = new Scanner(System.in);
      sumarNumeros(teclado);
   }
   public static void contarHasta(int max){//método que le resta 1 al for y se lo pone fuera del for el último digito.
      for(int i = 1; i <= max - 1; i++) {
         System.out.print(i + ", "); 
      }
      System.out.print(max);
      System.out.println();
   }
   public static void contarHasta2(int max){//Método que imprime el 1 y el for empieza a imprimir la coma.
      System.out.print(1);
      for(int i = 2; i <= max - 1; i++) {
         System.out.print( ", " + i); 
      }
      System.out.println();
   }
   public static void deletreaPalabra(String palabra) {
      int longitud = palabra.length();      
      for(int i = 0; i < longitud - 1; i++) {
         System.out.print(palabra.charAt(i) + " - ");
      }   
      System.out.println(palabra.charAt(longitud-1));
   }
   
   public static void sumarNumeros(Scanner teclado){
      //Pedir un número
      System.out.print("Introduce un número: ");
      int numero = teclado.nextInt();      
   
      //Si número es distinto que FIN contar, sumar y pedir otro
      int suma = 0;
      int cont = 0;
      while(numero != FIN) {
         suma += numero;
         cont++;
         System.out.print("introduce un número: ");
         numero =teclado.nextInt();   
      }  
      System.out.println("Total: " + cont);
      System.out.print("Suma: " + suma);  
      //Si el número es igual a FIN acabar y mostrar totales.
   }
}
