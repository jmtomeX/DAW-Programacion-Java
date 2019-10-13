import java.util.*;
public class AmortizacionPrestamo02{
   public static void main(String[] args){
      bienVenida();
      double cantidadPrestamo = (pedirCantidadPrestamo(new Scanner(System.in)));
      calcularPrestamo(cantidadPrestamo);
      System.out.println(pedirInteresYAnnos(new Scanner(System.in)));
   }
   //métodos
   /***********************1º Parte ejercicio *********************************/
   //Método para mostrar mensaje de bienvenida
   public static void bienVenida(){
      System.out.println("Este es un programa para calcular las cuotas de un préstamo");
      System.out.println("Pedirá el capital del préstamo (euros), el interés anual a pagar (%) y su duración (años)");
      System.out.println("Calculará para cada año, el capital pendiente y la cuota a pagar, intereses y amortización\nEmpezamos ya\n");
   } 
   //Método para pedir la cantidad solicitada
   public static double pedirCantidadPrestamo(Scanner teclado){
      System.out.print("Introduce la cantidad solicitada para el préstamo:");
      double cantidad = teclado.nextDouble();
      return cantidad;
   }  
   //Método para calcular el prestamo
   public static void calcularPrestamo(double cantidadPres){
      final double INTERES_MIN = 2.0;
      final double INTERES_MAX = 5.0;
      System.out.println("Estas son las cuotas a pagar para diferentes intereses y plazos");
      for(int annos = 5; annos <= 10; annos++){//para dar los años 
         System.out.print(annos + " Años\t");
         for(double interes = INTERES_MIN; interes <= INTERES_MAX; interes += 0.5){//para dar los interes y hacer el cálculo
           // Se a creado un método para realizar el redondeo como pide el ejercicio
            System.out.print(redondeoDecimales(calculoCuotaAnual(cantidadPres,interes, annos)) + "("+ interes + "%)" + "\t");
         }
         System.out.println();
      }     
   }
  
   //Método para calcular la cuota anual
   public static double calculoCuotaAnual(double cantidadPrestamo, double interes, int annos){
      double cuotaAnual = 0;
            //formula para calcular la cuota anual, usamos Math.pow para elevar
      cuotaAnual = (cantidadPrestamo * (interes/100)) / (1 - (Math.pow( (1 + interes/100), -annos)));
      return cuotaAnual; 
   }
   //Método para calcular el redondeo de decimales
   public static double redondeoDecimales(double numero){
      numero= (double)Math.round(numero * 100d) / 100d;
      return numero;
   }
    /***********************2º Parte ejercicio *********************************/
   //Método para calcular Interes
   public static double pedirInteresYAnnos(Scanner teclado){
      System.out.print("Introduce el interés anual que se aplicará al préstamo en %:");
      double tipoInteres = teclado.nextDouble();
      System.out.print("Introduce el número de años que va a durar el préstamo:");
      double numeroAnnos = teclado.nextDouble();
      //calcular el interes
      for(int annos = 1; annos <= numeroAnnos; annos++ ){
         double interes = capitalPendiente
      }
      
      return tipoInteres + numeroAnnos;
   }
   
   //interés = capital pendiente * (interés del Préstamo/100)
 
 //Año: 1
    //Capital Pendiente: 10000.0
    //Cuota Anual: 2214.81
    //Intereses a pagar: 350.0
    //Amortización: 1864.81
   
}