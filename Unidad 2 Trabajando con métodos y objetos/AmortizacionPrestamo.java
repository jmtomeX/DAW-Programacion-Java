/* José Mari Tomé Mejías
   Programación
   Enlace archivo autoevaluación -->> https://drive.google.com/open?id=1OsyQmfkg3hLnJYzmX3oJRMb8ZxQ3gqlD
*/


import java.util.*;
public class AmortizacionPrestamo{
   public static double cantidadPrestamo;
   public static void main(String[] args){
      bienVenida();
      cantidadPrestamo = (pedirCantidadPrestamo(new Scanner(System.in)));
      calcularPrestamo(cantidadPrestamo);
      pedirInteresYAnnosCalcular(new Scanner(System.in),cantidadPrestamo);
   }
   //métodos
   /***********************1º Parte ejercicio *********************************/
   //Método para mostrar mensaje de bienvenida
   public static void bienVenida(){
      System.out.println("Este es un programa para calcular las cuotas de un préstamo");
      System.out.println("Pedirá el capital del préstamo (euros), el interés anual a pagar (%) y su duración (años)");
      System.out.println("Calculará para cada año, el capital pendiente y la cuota a pagar, intereses y amortización\nEmpezamos ya\n");
   } 
   //Método para pedir la cantidad solicitada, usa el Scanner(cantidad) y develve la cantidad.
   public static double pedirCantidadPrestamo(Scanner teclado){
      System.out.print("Introduce la cantidad solicitada para el préstamo:");
      double cantidad = teclado.nextDouble();
      return cantidad;
   }  
   //Método para calcular el préstamo, utiliza el parámetro cantidadPres.
   public static void calcularPrestamo(double cantidadPres){
      final double INTERES_MIN = 2.0;
      final double INTERES_MAX = 5.0;
      System.out.println("Estas son las cuotas a pagar para diferentes intereses y plazos");
      for(int annos = 5; annos <= 10; annos++){//para dar los años 
         System.out.print(annos + " Años\t");
         for(double interes = INTERES_MIN; interes <= INTERES_MAX; interes += 0.5){//para dar los intereses y hacer el cálculo
           // Se ha creado un método para realizar el redondeo como pide el ejercicio
            System.out.print(redondeoDecimales(calculoCuotaAnual(cantidadPres,interes, annos)) + "("+ interes + "%)" + "\t");
         }
         System.out.println();
      }     
   }
   //Método común
   //Método para calcular la cuota anual, utiliza los parámetros cantidadPrestamo, interes y annos y devuelve la cuota anual.  
   public static double calculoCuotaAnual(double cantidadPrestamo, double interes, int annos){
      double cuotaAnual = 0;
   //formula para calcular la cuota anual, usamos Math.pow para elevar
      cuotaAnual = (cantidadPrestamo * (interes/100)) / (1 - (Math.pow( (1 + interes/100), -annos)));
      return cuotaAnual; 
   }
   //Método común
   //Método para calcular el redondeo de decimales, utiliza el parámetro numero y devuelve el número.
   public static double redondeoDecimales(double numero){
      numero= (double)Math.round(numero * 100d) / 100d;
      return numero;
   }
    /************************2º Parte ejercicio ********************************/
   //Método para calcular el interes, la amortización y capital pendiente, utiliza el parámetro capitalPendiente y el Scanner(tipoInteres,numeroAnnos) no devuelve nada   
   public static void pedirInteresYAnnosCalcular(Scanner teclado, double capitalPendiente){
      System.out.print("Introduce el interés anual que se aplicará al préstamo en %:");
      double tipoInteres = teclado.nextDouble();
      System.out.print("Introduce el número de años que va a durar el préstamo:");
      double numeroAnnos = teclado.nextDouble();
      final double  CUOTAANUAL = calculoCuotaAnual(capitalPendiente, tipoInteres, (int)numeroAnnos);
      for(int annos = 1; annos <= numeroAnnos; annos++ ){
          //calcular el interes
         double interes = capitalPendiente * (tipoInteres/100);
         //calcular la amortización
         double amortizacion =  (CUOTAANUAL-interes);
         System.out.println("Año:" + annos);
         System.out.println("\tCapital Pendiente: " + redondeoDecimales(capitalPendiente));
         //calcular capital pendiente
         capitalPendiente -= amortizacion;
         System.out.println("\tCuota Anual: " + redondeoDecimales(CUOTAANUAL));
         System.out.println("\tIntereses a pagar: " + redondeoDecimales(interes));
         System.out.println("\tAmortización: " +  redondeoDecimales(amortizacion));
      }
   }   
}