/*
   Trabajo con una BBDD Oracle Express XE
   
   usuario: desvan
   contraseña: desvan
   configurar la IP de BBDD con la que estamos trabajando
*/

import java.sql.*;
import java.util.*;

public class MainBBDD {
   public static void main (String args[]) throws SQLException {

      // Creamos un objeto para gestionar la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe ";
      String usuario = "desvan";
      String password = "desvan";
      BBDD oracleBBDD = new BBDD(driver, url, usuario, password);          
      
      // Borramos el departamento
      if (oracleBBDD.borrarSistemas()) {
         System.out.println("Los datos se han borrado correctamente");
      } else {
         System.out.println("Problemas al borrar los datos");
      }
   }
}



/*
La primera vez, el resultado será:
Los datos se han borrado correctamente
Las siguientes, el mensaje mostrado será:
Problemas al borrar los datos
*/