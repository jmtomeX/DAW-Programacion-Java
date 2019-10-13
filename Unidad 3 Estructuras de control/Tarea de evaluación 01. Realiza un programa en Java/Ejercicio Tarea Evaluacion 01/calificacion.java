/***********************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  07/11/2018.
 Módulo:  Programación.
 Tarea:   PROG03 Tarea de evaluación 01. Realiza un programa en Java
 
 Descripción del programa: Realizaremos el siguiente programa en el que tendremos que utilizar
 estructuras condicionales IF-ELSE, mientras seguimos practicando el uso de variables, bucles
 FOR y métodos con paso de parámetros y sentencia return así como, las funcionalidades de las
 clases de las librerías de java.
 El programa permitirá calcular la nota media de un estudiante a partir de la calificación del
 examen final, el examen parcial y las tareas realizadas durante el curso.
 
 Enlace aoutoevaluación: https://drive.google.com/open?id=1Xi3kTOXZL381qgkUkQWTw8f-L5-SvR0L
 
*************************************************************************************************/ 
import java.util.*;
//Última version   06/11/2018 20:00   
public class calificacion {
   public static final int NOTA_MAXIMA = 100;//Nota o puntuación  máxima que se le da.
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
    
      //Presentación
      introduccion();
      double alumn1 = notaMediaFinal(notaParcial(teclado),notaFinal(teclado ), notaTareas(teclado));
      double alumn2 = notaMediaFinal(notaParcial(teclado),notaFinal(teclado), notaTareas(teclado));
      resultadosAlumnos(alumn1,alumn2);
   }
   //*****************MÉTODOS************************
   //metodo para mostrar la presentación del programa
   public static void introduccion() {
      System.out.println("Este programa lee las calificaciones de exámenes y tareas");
      System.out.println("y calcula la nota final del módulo para un estudiante.");
      System.out.println("También podría hacerlo para 2 estudiantes y comparar sus notas. Funcionaría sin problemas\n");
   }
   //Calcular la nota parcial.
   public static double notaParcial(Scanner teclado) {
      int contador = 1;
      System.out.println("Parcial:");  
      double nota = calculosComunes(teclado, contador);
      return nota;
   }
   //Calcular la nota final.
   public static double notaFinal(Scanner teclado) {
      int contador = 2;
      System.out.println("Final:");
      double nota = calculosComunes(teclado ,contador);
      return nota;
   }
   //Método con los calculos comunes
   public static double calculosComunes(Scanner teclado, int contador) {
      int pesoExamen =examenPeso(teclado, contador);
      double notaFinal = notaFinal( calificacion(teclado) ,puntosExtra(teclado) ,contador , NOTA_MAXIMA);
      double notaTotalParcial= notaPonderada( notaFinal,pesoExamen, NOTA_MAXIMA); 
      return notaTotalParcial;
   }
   //Calcular la nota de las tareas.
   public static double notaTareas(Scanner teclado) {
      int contador = 3;
      System.out.println("Tareas:");
      int pesoTareas = examenPeso(teclado, contador);
      int notasTareas[] = numeroTareas(teclado);  
      double notaFinalTareas = notaFinal(notasTareas[0] ,presenciales(teclado) ,contador ,(notasTareas[1] + 30));//parte de  Nota final = "100" / 160
      double mediaTareas = notaPonderada(notaFinalTareas ,pesoTareas ,(notasTareas[1] + 30));  
      return mediaTareas;
   }
  //Método para pedir y dar el peso del examen 
   public static int examenPeso(Scanner teclado, int cont) {
      //Variable con condición para cambiar el texto usamos el método replace de la clase String
      String cabeceraPeso = "Introduce el peso del examen (0-100): ";
      if(cont == 3){
         System.out.print(cabeceraPeso.replace("del examen" ,"de las tareas"));
      }else{
         System.out.print(cabeceraPeso);
      }
      int pesoExamen = teclado.nextInt();
      if(pesoExamen > 100){//Comprobamos que el peso este entre 0 y 100.
         pesoExamen =100;//Si no está a 100 puntos lo ponemos a 100
      }
      return pesoExamen;
   }
    //Método para añadir la calificación del examen.
   public static int calificacion(Scanner teclado) {
      System.out.print("Introduce la calificación del examen (0-100): ");
      int notaCalificacion = teclado.nextInt();
      return notaCalificacion; 
   }
    //Método para preguntar y añadir los putos extras, si tiene puntos extras inserta un 1, si no un 2.
   //No se añade ninguna seguridad si añade otro valor porque no se indica.
   public static int puntosExtra(Scanner teclado) {
      int puntosExtra = 0;
      System.out.print("¿Has obtenido puntos extra (1=Si, 2=No)? ");
      int respuesta = teclado.nextInt();
      if(respuesta == 1){
         System.out.print("Introduce el total de puntos extra: ");
         puntosExtra = teclado.nextInt();
      }
      else if(respuesta < 1 || respuesta > 2){
         System.out.println("ERROR -->> No has metido bien el parámetro.");
      }
      return puntosExtra;          
   }
       //Método para calcular la nota final. se utiliza la nota del examen + puntos extra o clases presenciales, el contador para
   //ver en que sección estamos ya sea parcial, final, o tareas.
   //y la nota máxima.
   public static int notaFinal(int notaExamen, int puntosExtra, int contador, int notaMax) {
      int notaMaxima = 100;
      int  notaTotal = notaExamen + puntosExtra;
      if(notaTotal >  100 && contador != 3){//comprobamos la posicion, si es difente a 3 la nota total no pasa de los 100 puntos.
         notaTotal = 100;
      }else{
         notaMaxima = notaMax;//Si la posición es 3 la nota máxima será la que entre en la función y no 100.
      }
      System.out.println("Nota final = " + notaTotal + " / " + notaMaxima);
      return notaTotal;
   }
    //Método para sacar la nota media, el cálculo se hace multiplicando la notaFinal por el peso del examen entre 100.
   public static double notaPonderada(double notaFinal, int peso, int puntuacionMax) {
      double notaMedia = ((notaFinal * peso) / puntuacionMax);
      System.out.printf("Nota final ponderada = %.1f / ", notaMedia);
      System.out.println(peso + "\n");
      return notaMedia;
   }
    //3º Parte del ejercicio
   //Calcular la nota de las tareas.
   //
   //método para calcular el numero de tareas y calcular el resultado de la
   //puntuación máxima y la obtenida, se ha utilizado un array por que no veo el modo de sacarlo de otro modo.
   public static int[] numeroTareas(Scanner teclado){
      System.out.print("Introduce el número de tareas: ");
      int numTareas = teclado.nextInt();
      int puntObtenidaToTal = 0;
      int puntMaxTotal = 0; 
      for(int i = 1; i <= numTareas; i++){
         System.out.print("Tarea " + i + ": Introduce la puntuación obtenida y la puntuación máxima:");
         int puntObtenida = teclado.nextInt();
         int puntMax =teclado.nextInt(); 
         puntObtenidaToTal += puntObtenida ;
         puntMaxTotal += puntMax;    
      }
      return new int[] {puntObtenidaToTal, puntMaxTotal};
   }
   //Método para calcular la nota de las presenciales.
   public static int presenciales(Scanner teclado) {
      System.out.print("Introduce el número de presenciales a las que has atendido: ");
      int numPresenciales = 0;
      int notasPresenciales = 0;
      if (teclado.hasNextInt()){
         numPresenciales = teclado.nextInt();
      //Cada presencial vale 5 puntos por lo que se multiplica por 5 el número de presenciales.
         notasPresenciales = numPresenciales * 5;
         System.out.println("Nota de las presenciales = "+  notasPresenciales + " / 30 ");
      }else if (teclado.hasNextDouble()) {
         System.out.println("No has insertador un número entero, reinicia el programa");
      } else {
         System.out.println("No has insertador un número entero, reinicia el programa");
      }
      return notasPresenciales;
   }
   //Metodo para calcular las nota media total.
   public static double notaMediaFinal(double notaMedia1, double notaMedia2 ,double notaMedia3) {
      double notaMediaTotal = notaMedia1 + notaMedia2 + notaMedia3;//Suma las medias
      System.out.printf("La calificación total obtenida es: %.1f \n" , notaMediaTotal);//Usamos el método printf para mostrar un decimal %.1f
      String mensajeEvaluativo = "";
      double escala = 0.0;
      if(notaMediaTotal < 60){
         mensajeEvaluativo = "Otra vez será";
         escala = 0.0;
      }/*else if(notaMediaTotal >= 60 && notaMediaTotal <= 74.99){    Este sobra
         mensajeEvaluativo = "Todavía tienes trabajo por hacer";
         escala = 0.7;
      */}else if(notaMediaTotal >= 75 && notaMediaTotal <= 84.99){ 
         mensajeEvaluativo = "Gran trabajo";
         escala = 2.0;
      }else if(notaMediaTotal >= 85 ){
         mensajeEvaluativo = "Excelente trabajo";
         escala = 3.0;
      }
      System.out.println("La nota final en una escala del 0 al 4 es al menos: " + escala );
      System.out.println(mensajeEvaluativo);
      System.out.println();
      return notaMediaTotal; 
   }
   public static void resultadosAlumnos(double alum1 ,double alum2) {
      double notaAlta = Math.max(alum1 ,alum2); 
      String texto = "La nota más alta ha sido del alumno1 con un total de %.1f puntos.";
      if(alum1 > alum2){
         System.out.printf(texto ,notaAlta);
      }else if(alum1 == alum2){
         System.out.printf("Las notas han sido iguales con %.1f puntos.", notaAlta );
      }else{
         System.out.printf(texto ,notaAlta);
      }
   }
}