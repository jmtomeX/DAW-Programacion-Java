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

// Clase Banco
import java.util.*;
import java.io.*;

public class Banco {
   
   // Atributos
   private ArrayList<Cuenta> cuentas; // ArrayList de cuentas de cualquier tipo
   private double interesAhorro; // Interés para las cuentas de ahorro
   
   // Constructor
   // Inicializa el ArrayList. 
   public Banco() {
      cuentas = new ArrayList<Cuenta>();
      interesAhorro = 0.0;
   }
      
   // Método que lee las cuentas desde un Scanner y las guarda en el ArrayList
   // Ten en cuenta que en el fichero hay cuentas de la clase CuentaAhorro y otras de la clase CuentaCorriente
   //Recibe como parámetro un Scanner leerDatos para leer por teclado y devuelve un entero con el número de cuentas 
   public int cargarFichero(Scanner leerDatos) {
      int numeroCuentas = 0;
      while(leerDatos.hasNextLine()) {
         String linea = leerDatos.nextLine();
         Scanner leerLinea = new Scanner(linea);
         leerLinea.useLocale(Locale.US); // Notación americana, números con punto decimal
         while(leerLinea.hasNext()) {
            String dni = leerLinea.next();
            String nombre = leerLinea.next();
            double saldoCuenta =leerLinea.nextDouble();
            String tipoCuenta = leerLinea.next();
            numeroCuentas++;
             //Creamos el cliente
            Cliente unCliente = new Cliente(dni, nombre);
         //Creamos el tipo de cuenta, comprobamos que sea una cuenta corriente
            if(tipoCuenta.equals("C")) {
               CuentaCorriente unaCuenta = new CuentaCorriente(unCliente, saldoCuenta);
               cuentas.add(unaCuenta); //la añadimos al arrayList
              //Creamos el tipo de cuenta, sino es cuenta corriente será de cuenta de ahorro.
            }else {
               CuentaAhorro unaCuenta = new CuentaAhorro(unCliente, saldoCuenta);
               cuentas.add(unaCuenta); //la añadimos al arrayList
            }
         }
      }
      return numeroCuentas;
   }
    
   // Formatea el contenido del banco
   // Devuelve los datos de la cuenta con el siguiente formato
   //                 B A N C O (hueco de 25)
   // Intereses de las cuentas de ahorro: 0.0%
   //
   // CuentaCorriente: 11111111A (Alicia)   Saldo  500,50
   // ...
   public String toString() {
      String salidaDatos = "\n";
      salidaDatos += String.format("%25s\n", "B A N C O");
      salidaDatos += "Intereses de las cuentas de ahorro: " + interesAhorro + "% \n" + "\n";
      //Recorremos la lista para mostrar las cuentas 
      for(Cuenta unaCuenta : cuentas) {
         salidaDatos += unaCuenta.toString() + "\n"; 
      }
      return salidaDatos;
   }
   
   // Método que busca una cuenta por el DNI,devuelve la primera cuenta que coincide con el DNI indicado
   // Devuelve el indice que coincide con el DNI indicado, en caso contrario devuelve -1
   // Recibe un String dniCuenta y devuelve un int.
   public int buscarCuenta(String dniCuenta) {
      int indice = -1;
      for(Cuenta unaCuenta: cuentas) {
         indice++;
         if(unaCuenta.titular.getDni().equals(dniCuenta)) {
            return indice;
         }
      }
      return -1;
   }
  
   // Método qeu ingresa una cantidad en la cuenta con el DNI indicado
   // Busca el DNI en el ArrayList. Si lo encuentra, realiza el ingreso en la cuenta y devuelve true
   // En caso contrario devuelve false, utiliza el método buscarCuenta(), e ingreso().
   // Recibe como parámetros String idCuenta, double cantidad y develve un boolean.
   private boolean ingreso(String idCuenta, double cantidad) {
      int indiceCuenta = buscarCuenta(idCuenta);
      if(indiceCuenta != -1) { //Si el indice es -1 quedrá decir que no existe
         Cuenta unaCuenta = cuentas.get(indiceCuenta); // se le pide la cuenta con su indice 
         unaCuenta.ingreso(cantidad);
         return true;
      }         
      return false;
   }
    
   
   // Método que retira una cantidad de la cuenta con el DNI indicado
   // Busca el DNI en el ArrayList. Si lo encuentra, realiza la retirada de dinero.
   // Si ésta se realiza sin roblemas devuelve true, en caso contrario devuelve false
   // Recibe como parámetros String idCuenta, double cantidad y devuelve un boleano.
   private boolean retirada(String idCuenta, double cantidad) {
      int indiceCuenta = buscarCuenta(idCuenta);
      if(indiceCuenta != -1) {
         Cuenta unaCuenta = cuentas.get(indiceCuenta);
         unaCuenta.retirada(cantidad);
         // Si el objeto es una cuneta de ahorro, usamos el casting para guadarlo como CuentaAhorro para usar sus métodos 
         if(unaCuenta instanceof CuentaAhorro) {
            CuentaAhorro CAhorro = (CuentaAhorro) unaCuenta;
            return true; 
         // Si el objeto es una cuneta de corriente, usamos el casting para guadarlo como CuentaCorriente para usar sus métodos        
         }else if (unaCuenta instanceof CuentaCorriente) {
            CuentaCorriente CCorriente = (CuentaCorriente) unaCuenta;   
           
            return unaCuenta.retirada(cantidad);// si se cumple devuelve true
         }         
      }
      return false;
   }
     
   // Realiza una transferencia entre 2 cuentas.
   // Utiliza los metodos ingreso y retirada
   // Si alguno de los DNIs no existe o no se puede realizar la retirada devolverá false, en caso contrario devuelve true
   //Recibe como parámetros String dniOrigen, String dniDestino, double cantidad y devuelve un boleano.
   public boolean transferencia(String dniOrigen, String dniDestino, double cantidad) {
      int cuentaDniOrigen = buscarCuenta(dniOrigen);
      int cuentaDniDestino = buscarCuenta(dniOrigen);
     //Si las cuentas existen procederemos la transferencia.
      if(cuentaDniOrigen != -1 && cuentaDniDestino != -1) {
         retirada(dniOrigen,cantidad); 
         ingreso(dniDestino, cantidad);
         return true;      
      }
      return false;
   }
 
      
   // Método que paga el interés indicado a todas las cuentas de ahorro
   // Recibe como parámetro double interes y devuelve un double con el interes total pagado.
   public double addInteres(double interes) {
     // Si el objeto es una cuneta de ahorro, usamos el casting para guadarlo como CuentaAhorro para usar sus métodos
      interesAhorro = interes;
      double totalInteres = 0.0;
      for(Cuenta unaCuenta: cuentas) { 
         if(unaCuenta instanceof CuentaAhorro) {
            CuentaAhorro CAhorro = (CuentaAhorro) unaCuenta;   
            totalInteres += CAhorro.addInteres(interesAhorro);
         }         
      } 
      return totalInteres;
   }
     
      
   // Resetea el número de retiradas de las cuentas corrientes, devuelve el número de cuentas que ha reseteado
   // No recibe parámetros y devuelve el total de las cuentas reseteadas.
   public int reset() {
      int totalCuentasReset = 0;
      for(Cuenta unaCuenta: cuentas) { 
         if(unaCuenta instanceof CuentaCorriente) {
            CuentaCorriente CCorriente = (CuentaCorriente) unaCuenta;   
            CCorriente.reseteaNumeroRetiradas();
            totalCuentasReset++;
         }         
      } 
      return totalCuentasReset;
   } 
    
   // Ordena las cuentas según el saldo, no recibe parámetros ni devuelve
   public void ordenarCuentas() {
      Collections.sort(cuentas);
   }
   

   // Elimina todas las cuentas del cliente indicado, utilizará el método equals de la clase Cliente
   // Recibe un objeto Cliente elCliente y devuelve el total de cuentas borradas
   public int eliminarCliente(Cliente elCliente) {
      Iterator<Cuenta> it = cuentas.iterator();
      int cuentasBorradas = 0;
      while(it.hasNext()) {
         Cuenta unaCuenta = it.next();
         if(unaCuenta.titular.equals(elCliente)) {
            it.remove();
            cuentasBorradas++;
         }
      }
      return cuentasBorradas;
   }
}


