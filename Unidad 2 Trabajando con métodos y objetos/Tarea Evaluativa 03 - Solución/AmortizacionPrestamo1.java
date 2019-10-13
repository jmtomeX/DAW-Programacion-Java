// Programa que realiza y muestra los cálculos para un prestamo

import java.util.*;
public class AmortizacionPrestamo1 {
   
   public static void main(String[] args) {
      
      // Descibe lo que hace el programa    
      presentacion();

      // PARTE 1           
      // Lee la cantidad para el préstamo. Necesita librería java.util.*
      Scanner leerTeclado = new Scanner(System.in);
      System.out.print("Introduce la cantidad solicitada para el préstamo: ");
      double capital = leerTeclado.nextDouble();
      
      // Calcula y muestra las cuotas para intereses de 2 a 5 con incremento de 0,5
      // y plazos entre 5 y 10 años
      muestraCuotas(capital);

      // PARTE 2     
      // Lee el interés y la duración del préstamo      
      System.out.print("Introduce el interés anual que se aplicará al préstamo en %: ");
      double i = leerTeclado.nextDouble();
      double interes = i / 100;
      
      System.out.print("Introduce el número de años que va a durar el préstamo: ");
      int duracion = leerTeclado.nextInt();
      
      // Calcula y muestra los pagos desglosados para cada uno de los años
      // cuota: es fija y se calcula con la misma fórmula que antes
      // intereses = capitalPendiente * interes
      // amortizacion = cuota - intereses
      // capitalPendiente = capitalPendiente - cuotaAnual
      double cuota = calculaCuota(capital, interes, duracion);
         
      double capitalPendiente = capital;
      for(int anio = 1; anio <= duracion; anio++) {         
         // Calcula los intereses
         double intereses = capitalPendiente * interes;
         
         // Calcula la cuota de amortización
         double amortizacion = cuota - intereses;
         
         System.out.println("Año: " + anio);
         System.out.println("\tCapital Pendiente: " + capitalPendiente);
         System.out.println("\tCuota Anual: " + cuota);
         System.out.println("\tIntereses a pagar: " + intereses);
         System.out.println("\tAmortización: " + amortizacion);
         
         // Calcula el nuevo capital pendiente
         capitalPendiente -= amortizacion;
      }
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
   public static void muestraCuotas(double prestamo) {   
      System.out.println("Estas son las cuotas a pagar para diferentes intereses y plazos");     
      for (int duracion = 5; duracion <= 10; duracion++) {
         System.out.print(duracion + " Años \t");
         for (double i = 2.0; i <= 5.0; i = i + 0.5) {
            double interes = i / 100;
            double cuota = calculaCuota(prestamo, interes, duracion);
            System.out.print(cuota + "(" + i + "%) \t");
         }
         System.out.println();
      }
      System.out.println();
   }

   // Método que calcula la fórmula de la cuota para evitar redundancias   
   public static double calculaCuota(double capital, double i, int plazo) {
      double exponente = Math.pow(1 + i, - plazo);
      double cuota = capital * i / (1 - exponente);
      return cuota;
   }
}