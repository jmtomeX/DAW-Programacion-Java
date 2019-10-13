import java.util.regex.*;     // Para poder usar patrones  
import java.util.*;
import java.io.*;
public class Ejercicio08 {
   public static void main(String[] args)throws FileNotFoundException {
      ArrayList<String> lista = crearLista();
      System.out.println(lista);
   }
   public static ArrayList<String> crearLista() throws FileNotFoundException {
      ArrayList<String> lista = new ArrayList<String>();
      Scanner leerDatos = new Scanner(new File("fechas.txt"));
      Pattern formatoFecha = Pattern.compile("\\d{1,2}-\\d{1,2}-\\d{2}");
      while (leerDatos.hasNext()) {
         String fecha = leerDatos.next();
         Matcher comparaFormato = formatoFecha.matcher(fecha);
         if (comparaFormato.matches()) {
            lista.add(fecha);
         }
      }
      return lista;
   }
   
   
}