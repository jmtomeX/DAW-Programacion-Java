/*
   Trabajo con una BBDD Oracle Express XE
   
   usuario: desvan
   contraseña: desvan
   configurar la IP de BBDD con la que estamos trabajando
*/

import java.sql.*;

public class MainBBDD {
   public static void main (String args[]) throws SQLException {
   
      // Creamos un objeto para gestionar la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe ";
      String usuario = "desvan";
      String password = "desvan";
      BBDD oracleBBDD = new BBDD(driver, url, usuario, password);          
            
      // Insertamos un nuevo departamento
      if (oracleBBDD.insertarSistemas()) {
         System.out.println("Los datos se han introducido correctamente");
      } else {
         System.out.println("Problemas al introducir los datos");
      }
   }
}