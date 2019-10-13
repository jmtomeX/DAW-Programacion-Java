/*
   Ejemplo de trabajo con una BBDD Oracle Express XE
*/

import java.sql.*;
import java.util.*;

public class BBDDMain {
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
   
      // Creamos un objeto para gestionar la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe ";
      String usuario = "hr";
      String password = "hr";
      
      ClaseBBDD oracleBBDD = new ClaseBBDD(driver, url, usuario, password);          
      
      // Obtenemos información sobre la BBDD
      String datos = oracleBBDD.getVersion();
      System.out.println(datos);
   
      // Obtenemos estadísticas sobre los empleados
      datos = oracleBBDD.getEstadisticas();
      System.out.println(datos);    
      
      // Obtenemos información sobre un país
      Pais unPais = oracleBBDD.mostrarMexico();
      System.out.println(unPais);
      
      // Obtenemos información sobre los paises de tabla countries
      datos = oracleBBDD.stringCountries();
      System.out.println(datos);
      System.out.println();
      
      ArrayList<Pais> lista = oracleBBDD.arraylistCountries();
      System.out.println(lista);
      System.out.println();
      
      Pais[] array = oracleBBDD.arrayCountries();
      System.out.println(Arrays.toString(array));
      System.out.println();
      
      // Insertamos un nuevo país
      String idPais = "ES";
      String nombrePais = "España";
      int idRegion = 1;
      boolean resultado = oracleBBDD.insertarPais(idPais, nombrePais, idRegion);
      
      if (resultado) {
         System.out.println("Los datos se han introducido correctamente");
      } else {
         System.out.println("Problemas al introducir los datos");
      }
      
      // Borramos el país
      resultado = oracleBBDD.borrarPais(idPais);
      if (resultado) {
         System.out.println("Los datos se han borrado correctamente");
      } else {
         System.out.println("Problemas al borrar los datos");
      }
   }
}