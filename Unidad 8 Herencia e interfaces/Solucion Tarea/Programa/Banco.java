/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2019
  Modulo:   Programación.
  UD:       UD8 Herencia e interfaces.
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa:   Definición de la clase Banco
                              Uno de sus atributos será un ArrayList de Cuentas
                              Utilizará el polimorfismo para trabajar con cuentas corrientes y cuentas de ahorro
                              Usará los métodos de las clases CuentaCorriente y CuentaAhorro para evitar sobreescribir código 
                                
*******************************************************************************************************************/
import java.util.*;
import java.util.Collections.*;
public class Banco {

   // Atributos
   private ArrayList<Cuenta> cuentas;   // ArrayList de cuentas de cualquier tipo
   private double interesAhorro;        // Interés para las cuentas de ahorro
   
   // Constructor
   // Inicializa los atributos de la clase. 
   public Banco() {
      cuentas = new ArrayList<Cuenta>();
      interesAhorro = 0;
   }
   
   // Lee las cuentas desde un fichero y las guarda en el ArrayList.
   // En el fichero hay cuentas de la clase CuentaAhorro y otras de la clase CuentaCorriente
   // Hay que usar diferente constructor para crear cada una de ellas
   // Parámetros: 
   //    Scanner leerDatos: conexión al fichero que se va a leer
   // Devolverá el número de cuentas que se han leído
   public int cargarFichero(Scanner leerDatos) {
      int cont = 0;
      while (leerDatos.hasNextLine()) {
         String linea = leerDatos.nextLine();
         Scanner leerLinea = new Scanner(linea);
         leerLinea.useLocale(Locale.ENGLISH);
         
         String dni = leerLinea.next();
         String nombre = leerLinea.next();
         Cliente nuevoCliente = new Cliente(dni, nombre);
         
         double saldo = leerLinea.nextDouble();
         String tipoCuenta = leerLinea.next();
         
         Cuenta nuevaCuenta = null;
         if (tipoCuenta.equals("A")) {
            nuevaCuenta = new CuentaAhorro(nuevoCliente, saldo);
         } else if (tipoCuenta.equals("C")) {
            nuevaCuenta = new CuentaCorriente(nuevoCliente, saldo);
         } 
         cuentas.add(nuevaCuenta);
         cont++;
      }
      return cont;
   }
   
   // Formatea el contenido del banco
   // Devuelve los datos de la cuenta con el siguiente formato
   //                 B A N C O (hueco de 25)
   // Intereses de las cuentas de ahorro: 0.0%
   //
   // CuentaCorriente: 11111111A (Alicia)   Saldo  500,50
   // ...

   public String toString() {
      String formato = String.format("%25s\n", "B A N C O");
      formato += "Intereses de las cuentas de ahorro: " + interesAhorro + "%\n\n";
      for (Cuenta unaCuenta : cuentas) {
         formato += unaCuenta + "\n";           // Usamos el método toString de Cuenta
      }
      return formato;
   }
   
   // Ordena las cuentas según el saldo
   // sort utiliza el método compareTo de la interfaz comparable para ordenar las cuentas
   public void ordenarCuentas() {
      Collections.sort(cuentas);
   }

   
   // Busca una cuenta por el DNI
   // Parámetros: 
   //    String dniCuenta: DNI que se quiere buscar
   // Devuelve la primera cuenta que coincide con el DNI indicado. En caso contrario devuelve -1
   private int buscarCuenta(String dniCuenta)  {
      for (int i = 0; i < cuentas.size(); i++) {
         Cuenta unaCuenta = cuentas.get(i);        // Obtenemos la cuenta que queremos comprobar
         if (unaCuenta.mismoDni(dniCuenta))  {
            return i;
         }
      }
      return -1;
   }
   
   // Ingresa una cantidad en la cuenta con el DNI indicado
   // Busca el DNI en el ArrayList. Si lo encuentra, realiza el ingreso en la cuenta
   // Se usa el método ingreso de la clase Cuenta.
   // Java determinará automáticamente el código que se ejecuta dependiendo del tipo de cuenta
   // Parámetros: 
   //    String dniCuenta: DNI de la cuenta en la que se quiere hacer el ingreso
   //    double cantidad: euros que se quieren ingresar
   // Devuelve true si el ingreso se realiza, en caso contrario devuelve false
   private boolean ingreso(String idCuenta, double cantidad) {
      int indice = buscarCuenta(idCuenta);
      if (indice >= 0) {
         Cuenta unaCuenta = cuentas.get(indice);
         unaCuenta.ingreso(cantidad);
         return true;
      }
      return false;
   }
   
   // Retira una cantidad de la cuenta con el DNI indicado
   // Busca el DNI en el ArrayList. Si lo encuentra, trata de realizar la retirada de dinero.
   // Se usa el método retirada de la clase Cuenta.
   // Java determinará automáticamente el código que se ejecuta dependiendo del tipo de cuenta
   // Parámetros: 
   //    String dniCuenta: DNI de la cuenta de la que se quiere hacer la retirada
   //    double cantidad: euros que se quieren retirar
   // Devuelve true si si la retirada se realiza correctamente, en caso contrario devuelve false
   private boolean retirada(String idCuenta, double cantidad) {
      int indice = buscarCuenta(idCuenta);
      if (indice >= 0) {
         Cuenta unaCuenta = cuentas.get(indice);
         return unaCuenta.retirada(cantidad);         // Si la retirada se realiza devolverá true
      }
      return false;
   }
   
   // Realiza una transferencia entre 2 cuentas.
   // Utiliza los metodos ingreso y retirada anteriores
   // Parámetros: 
   //    String dniOrigen: DNI de la cuenta de la que se quiere hacer la retirada
   //    String dniDestino: DNI de la cuenta en la que se quiere hacer el ingreso
   //    double cantidad: euros que se quieren transferir
   // Si alguno de los DNIs no existe o no se puede realizar la retirada devolverá false
   // En caso contrario devuelve true
   public boolean transferencia(String dniOrigen, String dniDestino, double cantidad) {
   
      if (buscarCuenta(dniDestino) != -1) {
         // Si la cuenta destino existe se realiza la retirada de la cantidad
         if (this.retirada(dniOrigen, cantidad)) {
            // Si la retirada tiene exito, se realiza el ingreso
            return this.ingreso(dniDestino, cantidad);         // Si el ingreso tiene exito se devuelve true
         }
      }
      return false;  
   }
   
   // Paga el interés indicado a todas las cuentas de ahorro
   // Se usa el método addInteres de la clase CuentaAhorro
   // Primero hay que identificar los objetos de esa clase y hacer casting
   // Parámetros: 
   //    double tasa: interés en % que se va a pagar a la cuenta
   // Se devolverán el total de intereses pagados
   public double addInteres(double interes) {
      interesAhorro = interes;
      double total = 0;
      for (Cuenta unaCuenta : cuentas) {
         if (unaCuenta instanceof CuentaAhorro)  {
            CuentaAhorro laCuenta = (CuentaAhorro) unaCuenta;
            total += laCuenta.addInteres(interesAhorro);
         }
      }
      return total;
   }
   
   // Resetea el número de retiradas de todas las cuentas corrientes
   // Se usa el método reseteaNumeroRetiradas de la clase CuentaCorriente
   // Primero hay que identificar los objetos de esa clase y hacer casting
   // Devuelve el número de cuentas que se han reseteado
   public int reset() {
      int total = 0;
      for (Cuenta unaCuenta : cuentas) {
         if (unaCuenta instanceof CuentaCorriente)  {
            CuentaCorriente laCuenta = (CuentaCorriente) unaCuenta;
            laCuenta.reseteaNumeroRetiradas();
            total++;
         }
      }
      return total;
   }
   
   // Elimina todas las cuentas del cliente indicado
   // Usamos el iterador para evitar problemas
   // Parámetros: 
   //    Cliente elCliente: Datos del cliente buscado
   // Se devolverán el total de cuentas borradas
   public int eliminarCliente(Cliente elCliente)  {
      int cont = 0;
      Iterator<Cuenta> iterador = cuentas.iterator();
      while (iterador.hasNext()) {
         Cuenta unaCuenta = iterador.next();       // Obtenemos la cuenta que queremos mirar
         Cliente unCliente = unaCuenta.titular;    // Obtenemos su titular
         if (unCliente.equals(elCliente))  {
            iterador.remove();
            cont++;
         }
      }
      return cont;
   }
}