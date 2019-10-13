/*
   Ejemplo de clase que gestiona una BBDD
*/

import java.sql.*;
import java.util.*;

public class ClaseBBDDInicio {
   
   // ATRIBUTOS
   private String driver;
   private String url;
   private String usuario;
   private String password;
   
   
   // Constructor
   public ClaseBBDDInicio(String driver, String url, String usuario, String password) throws ClassNotFoundException {
      
      // Inicializamos los atributos con los valores recibidos como parámetros
      this.driver = driver;
      this.url = url;
      this.usuario = usuario;
      this.password = password;
      
      // Cargamos el driver de la BBDD elegida si la versión lo requiere
      Class.forName(driver);    
      
   }   
   
   // Realiza y devuelve la conexión con la BBDD
   private Connection conexion() throws SQLException {
   
      Connection conn = DriverManager.getConnection(url, usuario, password);
      return conn;
   }
   
   // Obtenemos información sobre la BBDD mediante DatabaseMetaData 
   public void getVersion() throws SQLException {
      Connection conn = conexion();
      
      DatabaseMetaData meta = conn.getMetaData();
      System.out.println("Versión del JDBC driver " + meta.getDriverVersion());
      System.out.println("Nombre del producto " + meta.getDatabaseProductName());
      System.out.println("Versión del producto " + meta.getDatabaseProductVersion());
      
      conn.close();
   }
   
   // Obtenemos estadísticas sobre los empleados de la BBDD
   public void getEstadisticas() throws SQLException {
      Connection conn = conexion();
      
      // Creamos el objeto Statement, ejecutamos la consulta y obtenemos los resultados
      Statement stmt = conn.createStatement();
      String consulta = "SELECT COUNT(*), MAX(salary), MIN(salary), AVG(salary) FROM employees";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Procesamos el resultado y lo mostramos por consola
      if (rs.next()) {  
         System.out.println("Número de empleados: " + rs.getInt(1));
         System.out.println("Salario máximo: " + rs.getInt(2));
         System.out.println("Salario mínimo: " + rs.getInt(3));
         System.out.println(String.format("Salario medio: %.2f\n", rs.getDouble(4)));
      }
      
      conn.close();
   }
   
   // Muestra los datos de un país de la BBDD
   public void mostrarMexico() throws SQLException {
   
      Connection conn = conexion();
      
      // Creamos el objeto Statement, ejecutamos la consulta y obtenemos los resultados
      Statement stmt = conn.createStatement();
      String consulta = "SELECT * FROM countries WHERE country_id = 'MX'";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Procesamos el resultado y lo mostramos por consola
      String mexico = null;
      if (rs.next()) {  
         System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3));
      }
      
      conn.close();
   }
   
   // Muestra la información de todos los paises de la BBDD
   public void mostrarCountries() throws SQLException {
   
      Connection conn = conexion();
      
      // Creamos el objeto Statement, ejecutamos la consulta y obtenemos los resultados
      Statement stmt = conn.createStatement();
      String consulta = "SELECT * FROM countries";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Procesamos el resultado y lo mostramos por consola
      while (rs.next()) {  
         System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3));
      }
      
      conn.close();
   }
   
   // Se inserta un nuevo país en la tabla countries
   public void insertarPais(String idPais, String nombrePais, int idRegion) throws SQLException {
      
      Connection conn = conexion();
      
      // Creamos una consulta preparada para insertar los datos
      String consulta = "INSERT INTO countries (country_id, country_name, region_id) VALUES (?, ?, ?)";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
      // Introducimos en la consulta los valores recibidos como parámetros y la ejecutamos
      stat.setString(1, idPais);
      stat.setString(2, nombrePais);
      stat.setInt(3, idRegion);
      int resultado = stat.executeUpdate();
      
      conn.close();
      
      if (resultado == 1) {
         System.out.println("Los datos se han introducido correctamente");
      } else {
         System.out.println("Problemas al introducir los datos");
      }
   }
   
   // Se borra un país de la tabla countries
   public void borrarPais(String idPais) throws SQLException {
      
      Connection conn = conexion();
      
      // Creamos una consulta preparada para borrar los datos
      String consulta = "DELETE FROM countries WHERE country_id = ?";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
      // Introducimos en la consulta los valores recibidos como parámetros y la ejecutamos
      stat.setString(1, idPais);
      int resultado = stat.executeUpdate();
      
      conn.close();
      
      if (resultado == 1) {
         System.out.println("Los datos se han borrado correctamente");
      } else {
         System.out.println("Problemas al borrar los datos");
      }
   } 
}