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

public class Adivina1 {

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
      String jugar;
      
      // Siempre se juega una partida antes de preguntas si se quiere seguir
      // Cuando todo el código del bucle se repite al menos una vez
      // mejor utilizar el do-while
      do {
         int resultado = jugarPartida(leerTeclado);
         
         // Se actualizan las estadísticas
         // También se puede usar Math.min(mejorPartida, resultado);
         // Si son iguales no merece la pena cambiar el valor
         if (resultado < mejorPartida) {
            mejorPartida = resultado;
         }
         numPartidas++;
         numIntentos += resultado;
         
         System.out.print("¿Quieres jugar otra vez (S/N)? ");
         jugar = leerTeclado.next().toUpperCase();
      } while (jugar.startsWith("S"));    // Mejor que charAt(0) o substring(0, 1)
      
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
      
      //System.out.println("El número es " + numAdivinar);     // Comentar o borrar las líneas de ayuda
      
      // Pide el primer número
      int num = introNum(leerTeclado);
      int intentos = 1;
      
      // Se repite mientras no se adivine
      while (num != numAdivinar) {
         // Si hay código que se repite en todos los if hay que sacarlo fuera       
         String pista = "";
         if (num > numAdivinar) {
            pista = "menor";            
         } else if (num < numAdivinar) {
            pista = "mayor";
         }
         System.out.println("El número es " + pista + ".");
         num = introNum(leerTeclado);
         intentos++;         
      }
      
      // Se ha adivinado el número
      System.out.println("Has adivinado en " + intentos + " intentos.");
      return intentos;
   }
   
   public static int introNum (Scanner leerTeclado) {
      System.out.print("Adivina el número: ");
      return leerTeclado.nextInt();
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
}