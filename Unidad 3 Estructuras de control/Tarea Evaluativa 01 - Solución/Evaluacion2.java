/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2018
  Modulo:   Programación.
  UD:       UD3 Estructuras de control.
  Tarea:    Tarea Evaluación 01. Realiza un programa en Java.
  
  Descripción del programa:   Calcula la nota final de un estudiante a partir de sus calificaciones
                              en el examen parcial, en el examen final y en las tareas del curso
  
  Enlace autoevaluación: 
                                
*******************************************************************************************************************/
import java.util.*;

public class Evaluacion2 {
   
   // Constantes que se van a utilizar
   public static final int MAX_EXAMEN = 100;
   public static final int MAX_PRESENCIALES = 30;
   
   /*
      Método principal: calcula la calificación final de un alumno o alumna
      y muestra en qué escala está
      Podría hacerse para varios y comparar sus resultados
   */
   public static void main(String[] args) {
   
      Scanner leerTeclado = new Scanner(System.in);
      
      presentacion();
          
      double alumna1 = calcularNota(leerTeclado);
      
      obtenerEscala(alumna1);
      
      /*
      double alumna2 = calcularNota(leerTeclado);
      if (alumna1 > alumna2) {
         System.out.println("La calificación del primer estudiante es más alta");
      }
      */
   }
   
   /*
      Método presentacion: Explica lo que hace el programa
      No tiene parámetros y no devuelve ningún valor
   */
   public static void presentacion() {
      System.out.println("Este programa lee las calificaciones de exámenes y tareas");
      System.out.println("y calcula la nota final del módulo.");
      System.out.println("También podría hacerlo para 2 estudiantes y comparar sus notas. Funcionaría sin problemas.");
      System.out.println();
   }
   
   /*
      Método que calcula la calificación final de un estudiante
      Parámetros: Scanner leerTeclado para leer valores introducidos por teclado
      return: valor de tipo double con la nota final ponderada
   */
   public static double calcularNota(Scanner leerTeclado) {
   
      double examenParcial = examen("Parcial", leerTeclado);
      double examenFinal = examen("Final", leerTeclado);
      double notaTareas = tareas(leerTeclado);
      
      double nota = examenParcial + examenFinal + notaTareas;
      
      // Se utiliza printf para formatear la salida y redondear los resultados       
      System.out.printf("La calificación total obtenida es: %.1f\n", nota);
      
      return nota;
   }
   
   /*
      Calcula la aportación de un examen, parcial o final, a la nota final
      Parámetros:
         Scanner leerDatos para leer valores introducidos por teclado
         String periodo para distinguir si el examen es parcial o final
      return: valor de tipo double con la nota final ponderada del examen
   */
   public static double examen(String periodo, Scanner leerDatos) {
   
      System.out.println(periodo + ": ");
      
      int peso = leePeso(leerDatos, "del examen");
      
      System.out.print("Introduce la calificación del examen (0-100): ");
      int nota = leerDatos.nextInt();
      
      System.out.print("¿Has obtenido puntos extra (1=Si, 2=No)? ");
      int extra = leerDatos.nextInt();
      
      // Si hay puntos extra los lee y controla que la nota final no sea mayor que MAX_EXAMEN
      // Se leen y controlan los puntos extra solo si existen. if dentro de otro if
      if(extra == 1) {
         System.out.print("Introduce el total de puntos extra: ");
         int puntosExtra = leerDatos.nextInt();
         nota = nota + puntosExtra;
         
         // Este if se podría sustituir por
         nota = Math.min(nota, MAX_EXAMEN);
         /*
         if (nota > MAX_EXAMEN) {
            nota = MAX_EXAMEN;
         }
         */
      }
      
      double notaPonderada = calcularNota(nota, peso, MAX_EXAMEN);
      
      return notaPonderada;
   }
   
   /*
      Calcula la aportación de las tareas a la nota final
      Parámetros:
         Scanner leerTeclado para leer valores introducidos por teclado
      return: valor de tipo double con la nota final ponderada de las tareas
   */
   public static double tareas (Scanner leerTeclado) {
   
      System.out.println("Tareas: ");
      
      int peso = leePeso(leerTeclado, "de las tareas");

      System.out.print("Introduce el número de tareas: ");
      int tareas = leerTeclado.nextInt();
      
      int nota = 0;
      int notaMaxima = 0;
      for (int i = 1; i <= tareas; i++) {
         // Introduce los 2 valores seguidos y separados por un espacio. Con Scanner se leen igual
         System.out.print("Tarea " + i + ": Introduce la puntuación obtenida y la puntuación máxima: ");
         nota += leerTeclado.nextInt();
         notaMaxima += leerTeclado.nextInt();
      }
      
      System.out.print("Introduce el número de presenciales a las que has atendido: ");
      int presenciales = leerTeclado.nextInt();
      int notaPresenciales = presenciales * 5;
      
      // Controla que la nota de las presenciales no sea mayor que MAX_PRESENCIALES
      notaPresenciales = Math.min(notaPresenciales, MAX_PRESENCIALES);     
      System.out.println("Nota de las presenciales = " + notaPresenciales + " / " + MAX_PRESENCIALES);
      
      nota = nota + notaPresenciales;
      notaMaxima = notaMaxima + 30;
      
      double notaPonderada = calcularNota(nota, peso, notaMaxima);
      
      return notaPonderada;
   }

   /*
      Método que lee el peso del parcial, del final y de las tareas
      Parámetros:
         Scanner leerDatos para leer valores introducidos por teclado
         String tipo para distinguir si el peso es del parcial, del final o de las tareas
      return: valor de tipo double con la nota final ponderada del examen
   */   
   public static int leePeso(Scanner leerDatos, String tipo) {
      System.out.print("Introduce el peso " + tipo + " (0-100): ");
      int peso = leerDatos.nextInt();
      return peso;
   }
   
   /*
      Método que calcula la nota final ponderada del parcial, del final y de las tareas
      Parámetros:
         int nota: valor de la calificación obtenida
         int peso: peso de la calificación en la nota final total
         int notaMax: valor de la calificación máxima que se podía obtener
      return: valor de tipo double con el resultado de la nota ponderada
   */
   public static double calcularNota(int nota, int peso, int notaMax) { 
      double notaPonderada = (double) nota * peso / notaMax;     
      System.out.println("Nota final = " + nota + " / " + notaMax);     
      System.out.printf("Nota final ponderada = %.1f / %d\n", notaPonderada, peso);
      System.out.println();
      return notaPonderada;
   }
   
   /*
      Pasa la nota final a una escala del 0 al 4 y muestra el mensaje correspondiente
      Parámetros:
         int nota: valor de la nota final total
      No devuelve nada
   */
   public static void obtenerEscala(double nota) {
      double escala = 0;
      String mensaje = "";
      
      if (nota >= 85) {
         escala = 3.0;
         mensaje = "Excelente trabajo";
      } else if (nota >= 75) {   // Aquí llegan las notas menores de 85. Solo hay que mirar que sean mayores de 75
         escala = 2.0;
         mensaje = "Gran trabajo";
      } else if (nota >= 60) {
         escala = 0.7;
         mensaje = "Todavía tienes trabajo por hacer";
      } else {
         escala = 0.0;
         mensaje = "Otra vez será";
      }
      
      System.out.println("La nota final en una escala del 0 al 4 es al menos: " + escala);
      System.out.println(mensaje);
   }
   
} // Final de la clase