/*
   Clase que gestiona una BBDD
*/

import java.sql.*;
import java.util.*;

public class ClaseBBDD {
   
   // ATRIBUTOS
   private String driver;
   private String url;
   private String usuario;
   private String password;   
   
   // Constructor
   public ClaseBBDD(String driver, String url, String usuario, String password) throws ClassNotFoundException {
   
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
   // La devolvemos como un String
   public String getVersion() throws SQLException {
   
      Connection conn = conexion();
      
      DatabaseMetaData meta = conn.getMetaData();
      String version = "Versión del JDBC driver " + meta.getDriverVersion() + "\n";
      version += "Nombre del producto " + meta.getDatabaseProductName() + "\n";
      version += "Versión del producto " + meta.getDatabaseProductVersion() + "\n";
      
      conn.close();
      return version;
   }
   
   // Obtenemos estadísticas sobre los empleados de la BBDD
   // Devolvemos los resultados en un String
   public String getEstadisticas() throws SQLException {
   
      Connection conn = conexion();
      
      // Creamos el objeto Statement, ejecutamos la consulta y obtenemos los resultados
      Statement stmt = conn.createStatement();      
      String consulta = "SELECT COUNT(*), MAX(salary), MIN(salary), AVG(salary) FROM employees";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Procesamos el resultado y lo guardamos en un String
      String resultado = "";
      if (rs.next()) {  
         resultado += "Número de empleados: " + rs.getInt(1) + "\n";
         resultado += "Salario máximo: " + rs.getInt(2) + "\n";
         resultado += "Salario mínimo: " + rs.getInt(3) + "\n";
         resultado += String.format("Salario medio: %.2f\n", rs.getDouble(4));
      }
      
      conn.close();
      
      return resultado;
   }

   // Obtiene los datos de un país de la BBDD
   // Los devuelve como un objeto de la clase Pais
   public Pais mostrarMexico() throws SQLException {
   
      Connection conn = conexion();
      
      // Creamos el objeto Statement, ejecutamos la consulta y obtenemos los resultados
      Statement stmt = conn.createStatement();      
      String consulta = "SELECT * FROM countries WHERE country_id = 'MX'";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Procesamos el resultado y lo guardamos en un String
      Pais unPais = null;
      if (rs.next()) {  
         String idPais = rs.getString("COUNTRY_ID");
         String nombrePais = rs.getString("COUNTRY_NAME");
         int idRegion = rs.getInt("REGION_ID");
         unPais = new Pais(idPais, nombrePais, idRegion);
      }
      
      conn.close();
      
      return unPais;
   }
   
   // Obtiene la información de todos los paises de la BBDD
   // Devuelve un array de objetos de la clase Pais
   public Pais[] mostrarCountries() throws SQLException {
   
      Connection conn = conexion();
      
      // Creamos el objeto Statement, ejecutamos la consulta y obtenemos los resultados
      Statement stmt = conn.createStatement();
      String consulta = "SELECT * FROM countries";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Procesamos el resultado y lo guardamos en un String
      ArrayList<Pais> paises = new ArrayList<Pais>();
      while (rs.next()) {  
         String idPais = rs.getString("COUNTRY_ID");
         String nombrePais = rs.getString("COUNTRY_NAME");
         int idRegion = rs.getInt("REGION_ID");
         Pais otroPais = new Pais(idPais, nombrePais, idRegion);
         paises.add(otroPais);
      }
      
      conn.close();
      
      // Guardamos el ArrayList en un Array
      Pais[] resultado = new Pais[paises.size()];
      paises.toArray(resultado);
      
      return resultado;
   }
   
   // Se inserta un nuevo país en la tabla countries
   public boolean insertarPais(String idPais, String nombrePais, int idRegion) throws SQLException {
      
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
   
      return resultado == 1;
   }
   
   // Se borra el país con el id indicado de la tabla countries
   public boolean borrarPais(String idPais) throws SQLException {
      
      Connection conn = conexion();
      
      // Creamos una consulta preparada para borrar los datos
      String consulta = "DELETE FROM countries WHERE country_id = ?";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
      // Introducimos en la consulta los valores recibidos como parámetros y la ejecutamos
      stat.setString(1, idPais);
      int resultado = stat.executeUpdate();
      
      conn.close();
   
      return resultado == 1;
   } 
}