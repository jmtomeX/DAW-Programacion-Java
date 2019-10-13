/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2018
  Modulo:   Programación.
  UD:       UD3 Estructuras de control.
  Tarea:    Tarea Evaluación 03. Realiza un programa en Java.
  
  Descripción del programa:   Programa para adivinar un número generado al azar entre 1 MAX_NUM
                              Se puede jugar todas las veces que se quiera
  
  Enlace autoevaluación: 
                                
*******************************************************************************************************************/
import java.util.*;

public class Adivina3 {
   
   // Constante. Hay que usarla siempre que queramos utilizar el valor 100
   public static final int MAX_NUM = 100;
   
   /*
      Método principal
   */
   public static void main(String[] args) {
   
      Scanner leerTeclado = new Scanner(System.in);
      presentacion();
      
      // Utilizamos el valor 1000000 para inicializar la variable mejorPartida
      // y así tener un valor con el que comparar la primera partida
      int numPartidas = 0, numIntentos = 0, mejorPartida = 1000000;
      
      // Siempre se juega una partida antes de preguntas si se quiere seguir
      // Cuando todo el código del bucle se repite al menos una vez
      // mejor utilizar el do-while
      do {
         int resultado = jugarPartida(leerTeclado);
         mejorPartida = Math.min(mejorPartida, resultado);
         numPartidas++;
         numIntentos += resultado;
      } while (jugarOtraVez(leerTeclado));
      
      mostrarEstadisticas(numPartidas, numIntentos, mejorPartida);
   }
   
   /*
      Presentación del programa
      No necesita parámetros y no devuelve ningún valor
   */
   public static void presentacion() {
      System.out.println("El programa genera un número aleatorio del 1 al " + MAX_NUM);
      System.out.println("El usario o usuaria debe adivinarlo");
      System.out.println("El programa le dará pistas cada vez que falle");
      System.out.println();
   }

   /*
      Comprueba si quiere seguir jugando
      Parámetros:
         Scanner leerTeclado: objeto para leer datos por teclado
      Devuelve true si quiere seguir jugando, false en caso contrario
   */
   
   public static boolean jugarOtraVez(Scanner leerTeclado) {
      System.out.print("¿Quieres jugar otra vez (S/N)? ");
      String jugar = leerTeclado.next().toUpperCase();
      return jugar.startsWith("S");    // Mejor que charAt(0) o substring(0, 1)
   }

   /*
      Muestra los resultados de las partidas
      Parámetros:
         int numPartidas: número de partidas jugadas
         int numIntentos: número de intentos que se han necesitados
         int mejorPartida: número de intentos de la mejor partida
      No devuelve ningún valor         
   */
   public static void mostrarEstadisticas(int numPartidas, int numIntentos, int mejorPartida) {
      System.out.println();
      System.out.println("Resultados del juego:");
      System.out.println("Partidas jugadas: " + numPartidas);
      System.out.println("Intentos realizados: " + numIntentos);
      
      // Si dividimos 2 enteros el resultado es un entero
      // Hay que utilizar el casting para convertir uno de los números a double
      System.out.printf("Intentos por partida: %.1f\n", (double) numIntentos / numPartidas);
      System.out.println("Mejor partida: " + mejorPartida);
   }
   
   /*
      Juega una partida: genera un número al azar y pide al usuario o usuaria
      que lo adivine. Da pistas, dice si el número a adivinar es mayor o menor
      Parámetros:
         Scanner leerTeclado para leer datos por teclado
      Return: un entero con el número de intentos que se han necesitado
   */
   public static int jugarPartida(Scanner leerTeclado) {
   
      Random numAleatorio = new Random();
      int numAdivinar = numAleatorio.nextInt(MAX_NUM) + 1;
      
      System.out.println("Adivina un número del 1 al " + MAX_NUM);
      
      //System.out.println("El número es " + numAdivinar);
      
      int num, intentos = 0;
      do {
         num = introNumValido(leerTeclado);
         intentos++;

      } while (!adivina(num, numAdivinar));
      
      System.out.println("Has adivinado en " + intentos + " intentos.");
      return intentos;
   }

   // Pide números hasta que el número introducido este entre 1 y 100
   // Parámetros:
   //    Scanner leerTeclado para leer datos por teclado
   //    Return: un entero entre 1 y 100
   public static int introNumValido(Scanner leerTeclado) {
      System.out.print("Adivina el número: ");
      int num = introNumEntero(leerTeclado);
      while (num < 1 || num > MAX_NUM) {
         System.out.print("Debe ser un número entre 1 y " + MAX_NUM + ": ");
         num = introNumEntero(leerTeclado);
      }
      return num;
   }

   // Pide datos hasta que se introduzca un número entero   
   public static int introNumEntero(Scanner leerTeclado) {
      while (!leerTeclado.hasNextInt()) {
         String dato = leerTeclado.next();
         System.out.print("El dato debe ser un número entero: ");         
      }
      return leerTeclado.nextInt();
   }

   /*
      Comprueba si se ha adivinado el número y si no da pistas
      Dice si el número a adivinar es mayor o menor
      Parámetros:
         int num: número introducido
         int numAdivinar: número que hay que adivinar
         int intentos: intentos que se han necesitados
      Return: true si adivina el número, false en caso contrario
   */  
   public static boolean adivina(int num, int numAdivinar) {
   
      // Si los números son iguales devuelve true y el bucle acaba
      // En caso contrario da pistas
      if (num == numAdivinar) {
         return true;
      } else if (num > numAdivinar) {
         System.out.println("El número es menor.");
         return false;         
      }
      System.out.println("El número es mayor.");
      return false;
   }
}