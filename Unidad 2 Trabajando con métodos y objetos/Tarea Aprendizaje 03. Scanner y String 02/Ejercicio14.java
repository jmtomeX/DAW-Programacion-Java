/*
Escribe un programa que pida el número de notas que va a introducir.

A continuación, pedirá cada una de las notas y mostrará por consola la nota más alta introducida. Puedes utilizar el método Math.max().

Por ejemplo:

Introduce el numero de notas que quieres introducir: 
4
Introduce la nota 1: 
8
Introduce la nota 2: 
2
Introduce la nota 3: 
5
Introduce la nota 4: 
6
La nota más alta es: 8
*/
import java.util.*;
public class Ejercicio14 {
   public static void main(String[] args) {
      System.out.println(notas(new Scanner(System.in)));
       
   }
   
   public static String notas(Scanner teclado) {
      System.out.println("Introduce el numero de notas que quieres introducir:"); 
      int numeroNotas = teclado.nextInt();
      int nota = 0;
      int notaAlta = 0;
      for(int i = 1; i <= numeroNotas;i++){
         System.out.println("Introduce la nota " + i +":");
         nota = teclado.nextInt();
         notaAlta = Math.max(nota, notaAlta);
      }
      
      return " La nota más alta es:" +   notaAlta ;
   }
}