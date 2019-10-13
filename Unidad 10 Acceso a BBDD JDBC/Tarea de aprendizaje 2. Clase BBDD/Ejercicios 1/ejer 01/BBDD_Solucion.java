/*
   Clase que gestiona una BBDD
*/

import java.sql.*;
import java.util.*;

public class BBDD_Solucion {
   
   // ATRIBUTOS
   private String driver;
   private String url;
   private String usuario;
   private String password;   
   
   // Constructor
   public BBDD(String driver, String url, String usuario, String password) {
      this.driver = driver;
      this.url = url;
      this.usuario = usuario;
      this.password = password;
   }   
   
   // Realiza y devuelve la conexión con la BBDD
   private Connection conexion() throws SQLException {
   
      // Crear la conexión
      Connection conn = DriverManager.getConnection(url, usuario, password);
      return conn;
   }
   
   // Recibe el valor de la retención y devuelve un String con
   // el número de cuenta, el nombre y la retención de los empleados
   // cuya retención es mayor o igual a la indicada.
   // El formato será:
   // nombre: cuenta (retencion)
   //
   // SELECT cuenta, nombre, retencion FROM empleados WHERE retencion >= ?
   // cuenta: cadena de caracteres
   // nombre: cadena de caracteres
   // retencion: entero
   public String empleadosRetencionMayor(int retencion) throws SQLException {
      
      Connection conn = conexion();
      
      // Consultar datos con una consulta preparada
      String consulta = "SELECT cuenta, nombre, retencion FROM empleados WHERE retencion >= ?";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
      // Introducimos los valores recibidos en la consulta y la ejecutamos
      stat.setInt(1, retencion);
      ResultSet rs = stat.executeQuery();
      
      String formato = "";
      while (rs.next()) {  
         formato += rs.getString(2) + ": " + rs.getString(1) + " (" + rs.getString(3) +")\n";
      }
      
      // Cerramos la conexión
      conn.close();
      
      // Devolvemos los datos
      return formato;
   }
}