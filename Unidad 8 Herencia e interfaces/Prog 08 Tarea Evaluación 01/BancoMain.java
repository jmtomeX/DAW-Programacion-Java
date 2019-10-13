 /***********************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  21/03/2019.
 Módulo:  Programación.
 Tarea:   PROG08 Tarea de evaluación 01. Realiza un programa en Java
 
 Descripción del programa:Esta tarea se centra en el desarrollo y uso de nuestras propias clases,
 aunque manejaremos también ArrayLists y ficheros. En este caso, trabajaremos aspectos más
 avanzados como la herencia, las clases abstractas, los interfaces o el polimorfísmo.
 
     
 Enlace aoutoevaluación: https://drive.google.com/file/d/1DTpnaF7Ut6mJGJ42pPfNhO1oqqZDy3DK/view?usp=sharing
     
*************************************************************************************************/ 

/*
    Programa principal
    Se utilizará para probar las clases desarrolladas
    Se puede comentar el código que todavía no se puede ejecutar
*/
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class BancoMain {

   public static final String FIN = "0";
   public static final String MOSTRAR = "1";
   public static final String INTERESES = "2";
   public static final String TRANSFERENCIA = "3";
   public static final String BORRAR = "4";
   
   public static void main(String[] args) {
   
      Scanner leerTeclado = new Scanner(System.in);
      
      presentacion();
      
      Banco unBanco = new Banco();
      cargarCuentas(unBanco, leerTeclado);
      
      String opcion;
      do {
         opcion = elegirOpcion(leerTeclado);
         switch (opcion) {
            case FIN:
               System.out.println("Fin del programa"); ;   
               break;
            case MOSTRAR:
               unBanco.ordenarCuentas();
               System.out.println(unBanco);   
               break;
            case INTERESES:
               pagarIntereses(unBanco, leerTeclado);
               break;
            case TRANSFERENCIA:
               realizarTranferencia(unBanco, leerTeclado);
               break;
            case BORRAR:
               eliminarCliente(unBanco, leerTeclado);
               break;
            default:
               System.out.println("Opción incorrecta");
               break;
         }
      } while (!opcion.equals(FIN));
   }
    
   public static void presentacion() {
      System.out.println("Este programa permite trabajar con las cuentas de un banco");
      System.out.println("Utiliza las clase Cliente, Cuenta, CuentaAhorro, CuentaCorriente y Banco");
      System.out.println("Lee las cuentas iniciales del fichero cuentas.txt");
      System.out.println("Mediante un menú permite elegir diferentes opciones");
      System.out.println("Al final guarda las cuentas en el fichero cuentas.txt");
      System.out.println();
   }
   
   public static String elegirOpcion(Scanner consola) {
      System.out.println("\n******* MENU *******");
      System.out.println("1. Mostrar cuentas ordenadas\n2. Pagar intereses");
      System.out.println("3. Realizar transferencia\n4. Eliminar cliente");
      System.out.print("Elige tu opción (0 para acabar): ");
      String opcion = consola.next();
      return opcion;
   }
   
   public static void cargarCuentas(Banco unBanco, Scanner leerDatos) {
   
      File fichero = null;
      do {
         System.out.print("Nombre del fichero: ");
         String nombre = leerDatos.next();
         fichero = new File(nombre);
      } while (!fichero.canRead());
      
      Scanner leerFichero = null;
   
      int numCuentas = 0;
      try {
         leerFichero = new Scanner(fichero);
         numCuentas = unBanco.cargarFichero(leerFichero);
      } catch (Exception e) {
         System.out.println("Se ha producido un error " + e.getMessage());
      }
      if (leerFichero != null) {
         leerFichero.close();
      }
      System.out.println("Se han añadido " + numCuentas + " cuentas");
   }
  
   // Opción 2
   public static void pagarIntereses(Banco unBanco, Scanner leerTeclado) {
      System.out.println("Es fin de mes. Vamos a pagar intereses...");
      System.out.print("Interes a pagar: ");
      double interes = leerTeclado.nextDouble();  
      double total = unBanco.addInteres(interes);
      System.out.print("En total se han pagado " + total + " euros");
      unBanco.reset();
   }
  
   // Opción 3
   public static void realizarTranferencia(Banco unBanco, Scanner leerTeclado) {
      System.out.println("CUENTA ORIGEN: ");
      String dniOrigen = leerDni(leerTeclado); 
      System.out.println("CUENTA DESTINO: ");
      String dniDestino = leerDni(leerTeclado);
      System.out.print("Cantidad: ");
      double cantidad = leerTeclado.nextDouble();
      
      boolean resultado = unBanco.transferencia(dniOrigen, dniDestino, cantidad);
      if (resultado) {
         System.out.println("Transferencia realizada con Éxito");
      } else {
         System.out.println("Problemas con la transferencia");
      }
   }
   
   public static String leerDni(Scanner leerTeclado) {
      Pattern formatoDni = Pattern.compile("[0-9]{8}[A-Z]");
      String dni = null;
      Matcher comparaFormato = null;
      do {
         System.out.print("Introduce DNI válido: ");
         dni = leerTeclado.next();  
         comparaFormato = formatoDni.matcher(dni);
      } while (!comparaFormato.matches());
      return dni;
   }
    
   // Opción 4
   public static void eliminarCliente(Banco unBanco, Scanner leerTeclado) {
      System.out.println("DATOS DEL CLIENTE ");
      String dni = leerDni(leerTeclado);   
      System.out.print("Nombre del cliente: ");
      String nombre = leerTeclado.next();
      Cliente elCliente = new Cliente(dni, nombre);
      
      int borrados = unBanco.eliminarCliente(elCliente);
      System.out.println("Se han borrado " + borrados + " cuentas");
   }
  
}