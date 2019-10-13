/*
   Ejemplo de consulta a una BBDD Oracle Express XE
*/

import java.sql.*;         // Trabajar con BBDD

public class ConsultaJDBC {
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
   
      // Datos necesarios para establecer la conexión con la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@192.168.0.29:1521:xe ";
      String usuario = "hr";
      String password = "hr";
            
      // Paso 1: Cargar el driver de la BBDD elegida
      // A partir de la versión Java 6 y JDBC4 se carga automáticamente
      // Exige gestionar la excepción ClassNotFoundException
      Class.forName(driver);
          
      // Paso 2: Crear la conexión
      // Exige gestionar la excepción SQLException
      // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.35:1521:xe","hr","hr");
      Connection conn = DriverManager.getConnection(url, usuario, password);
      
      // Paso 3: Crear el objeto Statement, ejecutar consulta y obtener resultados
      // Devolverá los dtos en 3 columnas
      // COUNTRY_ID  COUNTRY_NAME   REGION_ID
      //    AR       Argentina         2
      //    AU       Australia         3
      //    BE       Belgium           1
      //    BR       Brazil            2
      // ...
   
      System.out.println("\nCONSULTA");
      Statement stmt = conn.createStatement();
      
      String consulta = "select * from countries";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Paso 4: Procesar resultados
      while (rs.next()) {  
         // System.out.println("Con indices: " + rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
         System.out.println("Con nombres: " + rs.getString("COUNTRY_ID") + "  " + rs.getString("COUNTRY_NAME") + "  " + rs.getString("REGION_ID"));
      }
      
      // Si queremos también podemos obtener información de las columnas
      System.out.println("\nMETADATOS");
      ResultSetMetaData metaData = rs.getMetaData();
      for (int i = 1; i <= metaData.getColumnCount(); i++) {
         String nombreColumna = metaData.getColumnLabel(i);
         int sizeColumna = metaData.getColumnDisplaySize(i);
         
         String  catalogo = metaData.getColumnTypeName(i);
         
         System.out.println(nombreColumna + " - " + sizeColumna + " - " + catalogo);
      } 
        
      // Paso 5: Cerrar conexión  
      conn.close();  
   }
}