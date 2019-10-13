import java.util.*;
import java.io.*;
public class Banco {
   // Atributos
   private String nombre;
   private ArrayList<Cuenta> lista;

   // Constructor

   //Crea el constructor de la clase Banco para que a partir del nombre que recibe como parámetro 
   //inicialice los atributos de la clase Banco (el nombre y la lista de cuentas).
   // Además, si el fichero nombre.txt se puede leer, añadirá los datos de todas las cuentas que tiene al fichero.
   public Banco(String nombre) throws FileNotFoundException {
      this.nombre = nombre;
      lista = new ArrayList<Cuenta>();
   
      boolean ficheroLeido = false;
      Scanner leerFichero = null;
      //Conectamos con el fichero
      File fichero = new File("nombre.txt");
      try {
         leerFichero = new Scanner(fichero);
         leerFichero.useLocale(Locale.US);
         if(fichero.canRead()) {
            int numero = 0;
            double saldo = 0.0;
            String titular = "";
            while(leerFichero.hasNextLine()) {
               numero = leerFichero.nextInt();
               saldo = leerFichero.nextDouble();
               titular = leerFichero.next();
               
               lista.add(new Cuenta(numero, saldo, titular));
            }
         }
      } catch (FileNotFoundException excepcion) { 
         System.out.println("Error al abrir el fichero");
         
      }finally {
         if(leerFichero != null) {
            leerFichero.close();
         }
      }
   
   }
   
   
   public void addCuenta(int numero, double saldo, String titular) {
      Cuenta unaCuenta = new Cuenta(numero, saldo, titular);
      lista.add(unaCuenta);
   }
   
   // toString
   public String toString() {
      String formato = nombre.toUpperCase() + "\n";
      for (Cuenta unaCuenta : lista) {
         formato += unaCuenta + "\n";
      }
      return formato;
   }
   // Buscar cuenta con saldo menor
   // CREA EL METODO AQUI
   public String saldoMenor() {
      Cuenta min = lista.get(0);
      for(int i = 1; i < lista.size(); i++){
         Cuenta unaCuenta  =lista.get(i);
         if (unaCuenta.getSaldo() < min.getSaldo()){
            min = unaCuenta;
         }
      }
      return min.toString();
   }
   
}