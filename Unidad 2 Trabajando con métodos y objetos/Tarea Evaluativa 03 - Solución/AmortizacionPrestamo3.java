/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2018
  Modulo:   Programación.
  UD:       UD2 Estructura de un programa informático.
  Tarea:    Tarea Evaluación 03. Realiza un programa en Java.
  
  Descripción del programa:   Programa que realiza y muestra los cálculos para un prestamo
                              haciendo uso de métodos, variables, bucles FOR y las sentencias print y println.
  
  Enlace autoevaluación: 
                                
*******************************************************************************************************************/

import java.util.*;

public class AmortizacionPrestamo3 {
   public static final int INICIO = 5;
   public static final int FIN = 10;
   
   // Método principal: se estructura utilizando métodos que realizan las tareas principales
   // No se puede utilizar println
   public static void main(String[] args) {
            
      presentacion();
      
      Scanner leerTeclado = new Scanner(System.in);
      double capital = pedirDato("Introduce la cantidad solicitada para el préstamo: ", leerTeclado);
      
      muestraCuotas(capital);
           
      muestraPagos(capital, leerTeclado);
   }
   
   public static void presentacion() {
      System.out.println("Este es un programa para calcular las cuotas de un préstamo");
      System.out.println("Pedirá el capital del préstamo (euros), el interés anual a pagar (%) y su duración (años)");
      System.out.println("Calculará para cada año, el capital pendiente y la cuota a pagar, intereses y amortización");
      System.out.println("Empezamos ya");
      System.out.println();
   }
   
   // Método que calcula y muestra las cuotas para intereses de 2 a 5 con incremento de 0,5
   // y plazos entre 5 y 10 años
   // Recibe un único parámetro y no devuelve nada:
   // double capital: la cantidad que se ha pedido para el préstamo
   public static void muestraCuotas(double prestamo) {   
      System.out.println("Estas son las cuotas a pagar para diferentes intereses y plazos");     
      for (int duracion = INICIO; duracion <= FIN; duracion++) {
         System.out.print(duracion + " Años \t");
         for (double i = 2.0; i <= 5.0; i += 0.5) {
            System.out.print(redondear(calculaCuota(prestamo, i / 100, duracion)) + "(" + i + "%) \t");
         }
         System.out.println();
      }
      System.out.println();
   }
   
   // Método que lee el interés y la duración del préstamo y
   // calcula y muestra los pagos desglosados para cada uno de los años
   // Utiliza el algoritmo acumulador: capitalPendiente se inicializa fuera del for y se actualiza dentro
   // Recibe 2 parámetros:
   // double capital: la cantidad que se ha pedido para el préstamo
   // Scanner teclado: objeto para leer datos por teclado
   public static void muestraPagos(double capital, Scanner teclado) {
    
      double interes = pedirDato("Introduce el interés anual que se aplicará al préstamo en %: ", teclado);
      
      System.out.print("Introduce el número de años que va a durar el préstamo: ");
      int duracion = teclado.nextInt();
      
      double cuota = calculaCuota(capital, interes / 100, duracion);
         
      double capitalPendiente = capital;
      for(int anio = 1; anio <= duracion; anio++) {         
         double intereses = capitalPendiente * interes / 100;
         double amortizacion = cuota - intereses;
         
         System.out.println("Año: " + anio);
         System.out.println("\tCapital Pendiente: " + redondear(capitalPendiente));
         System.out.println("\tCuota Anual: " + redondear(cuota));
         System.out.println("\tIntereses a pagar: " + redondear(intereses));
         System.out.println("\tAmortización: " + redondear(amortizacion));
         
         capitalPendiente -= amortizacion;
      }
   }
   
   // Método que pide la cantidad del préstamo. Recibe 2 parámetros:
   // String mensaje: una cadena de caracteres con el mensaje que se quiere mostrar por consola
   // Scanner teclado: objeto para pedir datos por teclado
   // return double: el dato introducido por teclado   
   public static double pedirDato(String mensaje, Scanner teclado) {   
      System.out.print(mensaje);
      return teclado.nextDouble();
   }

   // Método que calcula la fórmula de la cuota para evitar redundancias
   // Recibe 3 parámetros:
   // double capital: la cantidad que se ha solicitado para el préstamo
   // double interes: interés en tanto por uno que se le va a aplicar
   // int duracion: años que va a durar el préstamo
   // return double: la cuota anual que se debe pagar
   public static double calculaCuota(double capital, double interes, int duracion) {
      return (capital * interes / (1 - Math.pow(1 + interes, - duracion)));
   }
   
   // Método que redondea el resultado a 2 decimales para mostrarlo por consola
   // Recibe un párametro:
   // double num: valor que se quiere redondear
   // return double: devuelve el valor redondeado
   public static double redondear(double num) {
      return Math.round(num * 100) / 100.0;
   }
}