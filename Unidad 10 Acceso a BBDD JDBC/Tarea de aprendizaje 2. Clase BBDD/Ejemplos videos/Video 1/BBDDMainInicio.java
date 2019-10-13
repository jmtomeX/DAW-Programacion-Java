/*
   Ejemplo de trabajo con una BBDD Oracle Express XE
*/

import java.sql.*;
import java.util.*;

public class BBDDMainInicio {
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
   
      // Creamos un objeto para gestionar la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe ";
      String usuario = "hr";
      String password = "hr";
      
      ClaseBBDDInicio oracleBBDD = new ClaseBBDDInicio(driver, url, usuario, password);          
      
      // Obtenemos información sobre la BBDD
      oracleBBDD.getVersion();
   
      // Obtenemos estadísticas sobre los empleados
      oracleBBDD.getEstadisticas(); 
      
      // Obtenemos información sobre un país
      oracleBBDD.mostrarMexico();
      System.out.println();
      
      // Obtenemos información sobre los paises de tabla countries
      oracleBBDD.mostrarCountries();
      System.out.println();
      
      // Insertamos un nuevo país
      String idPais = "ES";
      String nombrePais = "España";
      int idRegion = 1;
      oracleBBDD.insertarPais(idPais, nombrePais, idRegion);
      
      // Borramos el país
      oracleBBDD.borrarPais(idPais);
   }
}