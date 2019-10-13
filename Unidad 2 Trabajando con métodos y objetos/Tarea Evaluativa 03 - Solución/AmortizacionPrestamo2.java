// Programa que realiza y muestra los cálculos para un prestamo

import java.util.*;
public class AmortizacionPrestamo2 {

   // Crea al menos una constante para valores que no cambian durante la ejecución del programa
   public static final int INICIO = 5, FIN = 10;
   public static final double MIN = 2.0, MAX = 5.0, INCREMENTO = 0.5;
   public static final int DECIMALES = 2;  
   
   // Método principal: se estructura utilizando métodos que realizan las tareas principales
   public static void main(String[] args) {
      
      // Describe lo que hace el programa    
      presentacion();

      // PARTE 1: Lee la cantidad para el préstamo.
      // Calcula y muestra las cuotas para intereses de 2 a 5 con incremento de 0,5
      // y plazos entre 5 y 10 años
      Scanner leerTeclado = new Scanner(System.in);
      double capital = muestraCuotas(leerTeclado);

      // PARTE 2: Lee el interés y la duración del préstamo y
      // Calcula y muestra los pagos desglosados para cada uno de los años
      muestraPagos(capital, leerTeclado);
   }

   // Método que describe lo que hace el programa   
   public static void presentacion() {
      System.out.println("Este es un programa para calcular las cuotas de un préstamo");
      System.out.println("Pedirá el capital del préstamo (euros), el interés anual a pagar (%) y su duración (años)");
      System.out.println("Calculará para cada año, el capital pendiente y la cuota a pagar, intereses y amortización");
      System.out.println("Empezamos ya");
      System.out.println();
   }
      
   // Método que calcula y muestra las cuotas para intereses de 2 a 5 con incremento de 0,5
   // y plazos entre 5 y 10 años
   public static double muestraCuotas(Scanner teclado) {
      System.out.print("Introduce la cantidad solicitada para el préstamo: ");
      double prestamo = teclado.nextDouble();
       
      System.out.println("Estas son las cuotas a pagar para diferentes intereses y plazos");     
      for (int duracion = INICIO; duracion <= FIN; duracion++) {
         System.out.print(duracion + " Años \t");
         
         double i = 2.0;
         for (int j = 1; j <= 7; j++) {
            double cuota = calculaCuota(prestamo, i / 100, duracion);
            double cuotaRedondeada = redondear(cuota);
            System.out.print(cuotaRedondeada + "(" + i + "%) \t");
            i = i + 0.5;
         }
         
         System.out.println();
      }
      System.out.println();
      return prestamo;
   }

   // Método que lee el interés y la duración del préstamo y
   // calcula y muestra los pagos desglosados para cada uno de los años
   // Utiliza el algoritmo acumulador: capitalPendiente se inicializa fuera del for y se actualiza dentro
   public static void muestraPagos(double capital, Scanner teclado) {
    
      System.out.print("Introduce el interés anual que se aplicará al préstamo en %: ");
      double interes = teclado.nextDouble();
      
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
         
         // Calcula el nuevo capital pendiente
         capitalPendiente -= amortizacion;
      }
   }

   // Método que calcula la fórmula de la cuota para evitar redundancias   
   public static double calculaCuota(double capital, double i, int plazo) {
      return (capital * i / (1 - Math.pow(1 + i, - plazo)));
   }
   
   // Método que redondea el resultado a 2 decimales para mostrarlo por consola
   // Alguno de los números de la división debe ser un double para que haya decimales
   public static double redondear(double num) {
      return (double) Math.round(num * 100) / 100;
   }
}