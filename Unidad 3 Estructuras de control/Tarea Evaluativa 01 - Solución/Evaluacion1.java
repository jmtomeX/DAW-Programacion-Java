/*
   Calcula la nota final de un estudiante
*/
import java.util.*;
public class Evaluacion1 {

   // Constantes
   public static final int MAX_EXAMEN = 100;
   public static final int MAX_PRESENCIALES = 30;
   public static final int PARCIAL = 0;
   public static final int FINAL = 1;
   
   /*
      Método principal
   */
   public static void main(String[] args) {
   
      Scanner leerTeclado = new Scanner(System.in);
      
      presentacion();
          
      double alumna1 = calcularNota(leerTeclado);
      
      obtenerEscala(alumna1);
   }
   
   /*
      Método que explica el funcionamiento del programa
   */
   public static void presentacion() {
      System.out.println("Este programa lee las calificaciones de exámenes y tareas");
      System.out.println("y calcula la nota final del módulo.");
      System.out.println("También podría hacerlo para 2 estudiantes y comparar sus notas. Funcionaría sin problemas.");
      System.out.println();
   }
   
   /*
      Método que calcula la nota de un estudiante
   */
   public static double calcularNota(Scanner leerTeclado) {
      
      //System.out.printf("Parcial: ");
      double examenParcial = examen(PARCIAL, leerTeclado);
      
      //System.out.printf("Final: ");
      double examenFinal = examen(FINAL, leerTeclado);
      
      double notaTareas = tareas(leerTeclado);
      
      double nota = examenParcial + examenFinal + notaTareas;     
      System.out.printf("La calificación total obtenida es: %.1f\n", nota);
      
      return nota;
   }
   
   /*
      Calcula la aportación de un examen a la nota final
   */
   public static double examen(int tipoExamen, Scanner leerDatos) {
   
      // Utiliza un entero para distinguir entre el parcial y el final
      // Más elegante si pasamos directamente el texto que queremos mostrar como parámetro

      if (tipoExamen == PARCIAL) {
         System.out.println("Parcial :");
      } else {
         System.out.println("Final :");
      }
      
      // Lee el peso y la nota obtenida en el examen
      System.out.print("Introduce el peso del examen (0-100): ");
      int peso = leerDatos.nextInt();      
      System.out.print("Introduce la calificación del examen (0-100): ");
      int nota = leerDatos.nextInt();
      
      // Lee si ha obtenido puntos extra. En caso afirmativo,
      // lee los puntos y controla que la calificación no sea mayor que MAX_EXAMEN
      System.out.print("¿Has obtenido puntos extra (1=Si, 2=No)? ");
      int extra = leerDatos.nextInt();
      if (extra == 1) {
         System.out.print("Introduce el total de puntos extra: ");
         int puntosExtra = leerDatos.nextInt();
         
         // Controla los puntos extra máximos
         nota = nota + puntosExtra;
         if (nota > MAX_EXAMEN) {
            nota = MAX_EXAMEN;
         }
      }
      
      // Calcula la nota ponderada y muestra los resultados por consola
      double notaPonderada = (double) nota * peso / MAX_EXAMEN;
      System.out.println("Nota final = " + nota + " / " + MAX_EXAMEN); 
      System.out.printf("Nota final ponderada = %.1f / %d\n", notaPonderada, peso);
      System.out.println();
      
      return notaPonderada;
   }
   
   /*
      Calcula la aportación de las tareas a la nota final
   */
   public static double tareas (Scanner leerTeclado) {
      System.out.println("Tareas: ");
      
      // Casi igual a lo que aparece en el método examen: método para evitar redundancias
      System.out.print("Introduce el peso de las tareas (0-100): ");
      int peso = leerTeclado.nextInt();

      // Lee el número de tareas y utiliza el algoritmo acumulador
      // para calcular la nota obtenida total y la nota máxima total
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
      
      // Lee el número de presenciales, calcula su nota y controla que no sea mayor que MAX_PRESENCIALES
      System.out.print("Introduce el número de presenciales a las que has atendido: ");
      int presenciales = leerTeclado.nextInt();
      int notaPresenciales = presenciales * 5;
      if (notaPresenciales > MAX_PRESENCIALES) {
         notaPresenciales = MAX_PRESENCIALES;
      }   
      System.out.println("Nota de las presenciales = " + notaPresenciales + " / " + MAX_PRESENCIALES);
      
      nota = nota + notaPresenciales;
      notaMaxima = notaMaxima + MAX_PRESENCIALES;
      
      // Mismos cálculos, printf y println que en el método examen: método para evitar redundancias
      System.out.println("Nota final = " + nota + " / " + notaMaxima);     
      double notaPonderada = (double) nota * peso / notaMaxima;
      System.out.printf("Nota final ponderada = %.1f / %d\n", notaPonderada, peso);
      System.out.println();
      
      return notaPonderada;
   }
   
   /*
      Pasa la nota final a una escala del 0 al 4 y muestra el mensaje correspondiente
   */
   public static void obtenerEscala(double nota) {
      
      // Sobra la primera condición de los else
      // Estaría más elegante con 2 únicos println al final y fuera de los if
      if (nota >= 85) {
         System.out.println("La nota final en una escala del 0 al 4 es al menos: " + 3.0);
         System.out.println("Excelente trabajo");
      } else if (nota >= 75) {   // La primera condición (nota < 85) es redundante. Se cumple siempre
         System.out.println("La nota final en una escala del 0 al 4 es al menos: " + 2.0);
         System.out.println("Gran trabajo");
      } else if (nota >= 60) {
         System.out.println("La nota final en una escala del 0 al 4 es al menos: " + 0.7);
         System.out.println("Todavía tienes trabajo por hacer");
      } else {
         System.out.println("La nota final en una escala del 0 al 4 es al menos: " + 0.0);
         System.out.println("Otra vez será");
      }
   }
}