/*
   Ejemplo de conexión a una BBDD Oracle Express XE
*/

import java.sql.*;

public class ConsultaPreparada {
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
   
      // Datos necesarios para establecer la conexión con la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@192.168.0.29:1521:xe ";
      String usuario = "hr";
      String password = "hr";
            
      // Cargar el driver de la BBDD elegida
      // A partir de la versión Java 6 y JDBC4 se carga automáticamente
      // Exige gestionar la excepción ClassNotFoundException
      Class.forName(driver);
          
      // Crear la conexión
      // Exige gestionar la excepción SQLException
      // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.35:1521:xe","hr","hr");
      Connection conn = DriverManager.getConnection(url, usuario, password);
      
      // Crear y ejecutar una consulta preparada
      System.out.println("\nCONSULTA PREPARADA");
      String consulta = "SELECT * FROM COUNTRIES WHERE REGION_ID = ?";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
      // Obtenemos los valores, los introducimos en la consulta y la ejecutamos
      int idRegion = 1;
      stat.setInt(1, idRegion);
      ResultSet rs = stat.executeQuery();
      
      // Procesar los resultados
      while (rs.next()) {  
         System.out.println(rs.getString("COUNTRY_ID") + "  " + rs.getString("COUNTRY_NAME") + "  " + rs.getString("REGION_ID"));
      }
      
      // Insertar datos con una consulta preparada
      System.out.println("\nINSERTAR DATOS");
      consulta = "INSERT INTO countries (country_id, country_name, region_id) VALUES (?, ?, ?)";
      stat = conn.prepareStatement(consulta);
      
      // Obtenemos los valores, los introducimos en la consulta y la ejecutamos
      String idPais = "ES";
      String nombrePais = "España";
      idRegion = 1;
      stat.setString(1, idPais);
      stat.setString(2, nombrePais);
      stat.setInt(3, idRegion);
      int resultado = stat.executeUpdate();
      System.out.println(resultado);
      
      // Borramos el dato anterior
      System.out.println("\nDELETE");
      consulta = "DELETE FROM countries WHERE country_id = ?";
      stat = conn.prepareStatement(consulta);
      
      // Obtenemos los valores, los introducimos en la consulta y la ejecutamos
      idPais = "ES";
      stat.setString(1, idPais);
      resultado = stat.executeUpdate();
      System.out.println(resultado);
   
      // Cerrar conexión  
      conn.close();  
   }
}