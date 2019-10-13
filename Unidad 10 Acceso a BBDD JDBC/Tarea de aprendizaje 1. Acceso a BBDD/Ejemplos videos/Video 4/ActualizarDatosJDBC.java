/*
   Ejemplo de conexión a una BBDD Oracle Express XE
*/

import java.sql.*;

public class ActualizarDatosJDBC {
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
   
      // Datos necesarios para establecer la conexión con la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String usuario = "hr";
      String password = "hr";
          
      // Crear la conexión
      Connection conn = DriverManager.getConnection(url, usuario, password);
   
      
      // INSERT: devuelve el número de filas actualizadas
      System.out.println("\nINSERT");
      String consulta = "INSERT INTO countries (country_id, country_name, region_id) VALUES ('ES', 'España', 1)";
      Statement stmt = conn.createStatement();
      int resultado = stmt.executeUpdate(consulta);
      System.out.println(resultado);
      
      // UPDATE
      System.out.println("\nUPDATE");
      consulta = "UPDATE countries SET country_id = 'SP' WHERE country_id = 'ES'";
      resultado = stmt.executeUpdate(consulta);
      System.out.println(resultado);      
   
      // DELETE
      System.out.println("\nDELETE");
      consulta = "DELETE FROM countries WHERE country_id = 'SP'";
      resultado = stmt.executeUpdate(consulta);
      System.out.println(resultado);   
        
      // Cerrar conexión  
      conn.close();  
   }
}