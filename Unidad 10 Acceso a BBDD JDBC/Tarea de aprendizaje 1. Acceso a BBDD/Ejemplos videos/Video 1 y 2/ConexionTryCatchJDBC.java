/*
   Ejemplo de conexión a una BBDD Oracle Express XE
   LAs excepciones se gestionan con Try-Catch
*/

import java.sql.*;

public class ConexionTryCatchJDBC {
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
   
      // datos necesarios para establecer la conexión con la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@192.168.0.29:1521:xe ";
      String usuario = "hr";
      String password = "hr";
      
      Connection conn = null;
      try { 
      
         // Paso 1: Cargar el driver de la BBDD elegida
         // A partir de la versión Java 6 y JDBC4 se carga automáticamente
         // Exige gestionar la excepción ClassNotFoundException
         Class.forName(driver);
             
         // Paso 2: Crear la conexión
         // Exige gestionar la excepción SQLException
         conn = DriverManager.getConnection(url, usuario, password);
         
         // Paso 3: Realizar la consulta y procesarla
         // Creamos un objeto DatabaseMetaData y obtenemos información sobre la BBDD
         DatabaseMetaData meta = conn.getMetaData();
         System.out.println("Versión del JDBC driver " + meta.getDriverVersion());
         System.out.println("Nombre del producto " + meta.getDatabaseProductName());
         System.out.println("Versión del producto " + meta.getDatabaseProductVersion());
         
      } catch (ClassNotFoundException excepcion) {
         System.out.println("Problemas con el driver: " + excepcion.getMessage());
         
      } catch (SQLException excepcion) {
         System.out.println("Problemas con la conexión: " + excepcion.getMessage());
         
      } catch (Exception excepcion) {
         System.out.println("Otros problemas: " + excepcion.getMessage());
      }
      
      // Paso 4: Cerrar conexión
      if (conn != null) { 
         conn.close();
      }
   }
}