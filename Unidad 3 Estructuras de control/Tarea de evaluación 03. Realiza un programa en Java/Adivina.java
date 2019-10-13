 /***********************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  30/11/2018.
 Módulo:  Programación.
 Tarea:   PROG03 Tarea de evaluación 03. Realiza un programa en Java
 
 Descripción del programa: El objetivo de esta tarea es realizar un programa que genere un número al azar del 1 al 100
 y que de pistas para que el usuario o usuaria lo adivine.
 Para ello, tendremos que utilizar estructuras condicionales y repetitivas, mientras seguimos practicando el uso de variables,
 bucles FOR y métodos con paso de parámetros y sentencia return así como, las funcionalidades de las clases de las librerías de java.
 
 Enlace aoutoevaluación: https://drive.google.com/file/d/1ujB6R2ND8hQU1jqXtTMl_zGduiyA2jBV/view?usp=sharing
     
*************************************************************************************************/ 

import java.util.*;
public class Adivina {
   public static final int INTENTOS_MAX = 1000000;
   public static int partidasJugadas = 0;
   public static int mejorPartida = INTENTOS_MAX;
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      int totalIntentosJugando = 0;
      introduccion();
      mostrarEstadisticas(jugarPartida(teclado, totalIntentosJugando));
   }
   //Método para mostrar la introducción.
   public static void introduccion() {
      System.out.println("El programa genera un número aleatorio del 1 al 100");
      System.out.println("El usuario o usuaria debe adivinarlo");
      System.out.println("El programa le dará pistas cada vez que falle");
   }
   //Generará un número utilizando la clase Random y pedirá adivinarlo el número de 1 a 100;
   public static int jugarPartida (Scanner teclado , int totalIntentosJugando) {
      Random r = new Random(20);
      String seguirJugando;
      int numeroAdivina;
      int numero;
      do {
         partidasJugadas++;
         numeroAdivina = r.nextInt(100) + 1;
         System.out.println("Adivina un número del 1 al 100");
         int intentosPartida = 0;
         do {  
         //Se pide al usuario que inserte un número 
            System.out.print("Adivina el número entero: ");
            numero = comprobarEntero(teclado);
            while(numero <= 0 || numero > 100 ) {//comprobar que el número sea entre 0 y 100.
               System.out.println("Adivina un número del 1 al 100");
               System.out.print("Adivina el número entero: ");
               numero = comprobarEntero(teclado);   
            }
            intentosPartida++;   
         //Damos mensaje y pista.  
            if(numero < numeroAdivina) {
               System.out.println("El número es mayor.");
            }else if(numero > numeroAdivina) {
               System.out.println("El número es menor.");
            }else {
               System.out.println("Has adivinado en "+ intentosPartida + " intentos.");
            }
          //Comprobamos que los número sean iguales, mientras que sean distintos seguimos o inferiores a 1000000 jugadas del usuario.
         }while(numero != numeroAdivina || totalIntentosJugando >= INTENTOS_MAX);//dowhile para adivinar el usuario el número
         mejorPartida = Math.min(intentosPartida, mejorPartida);//******************************************************** 
         totalIntentosJugando += intentosPartida;             
         //preguntamos si se quiere seguir jugando
         System.out.println("¿Quieres jugar otra vez (S/N)?");
         seguirJugando = teclado.next();
         seguirJugando = seguirJugando.toLowerCase();
      }while(seguirJugando.startsWith("s"));//dowhile salir del juego o no
      return totalIntentosJugando;
   }//FIN jugarPartida()
   //comprobamos el número que sea entero
   public static int comprobarEntero(Scanner teclado){
      while(!teclado.hasNextInt()) {
         teclado.next();
         System.out.print("Adivina el número entero: ");
      }
      int numero =teclado.nextInt(); 
      return numero;
   }//Fin comprobarEntero()
   //Método para mostrar las estadisticas
   public static void mostrarEstadisticas(int intentos) {
      System.out.println("Resultados del juego:");
      System.out.println("Partidas jugadas: " + partidasJugadas);
      System.out.println("Intentos realizados: " + intentos);
      System.out.printf("Intentos por partida: %.1f\n",(double)intentos/partidasJugadas);
      System.out.println("Mejor partida: " + mejorPartida);
   }//FIN mostrarEstadisticas()   
}