// Clase que gestiona una BBDD

import java.sql.*;
import java.util.*;

public class BBDD {
   
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
   
   // Añade los métodos aquí
   
/*
Crea el método empleadosRetencionMayor dentro de la clase BBDD. Recibe un entero con el valor de la retención y devuelve un String con el número de cuenta,
el nombre y la retención de los empleados cuya retención es mayor o igual a la indicada.
Para ello, se usará el usuario desvan con la contraseña desvan. Recuerda configurar correctamente la dirección IP de la BBDD.

La consulta que debemos realizar es:
SELECT cuenta, nombre, retencion FROM empleados WHERE retencion >= XX
donde retencion será un número entero y nombre y cuenta cadenas de caracteres
*/
   public String empleadosRetencionMayor(int retencion)  throws SQLException {
      Connection conn = conexion();
             
      String consulta = "SELECT cuenta, nombre, retencion FROM empleados WHERE retencion >= ?";
      PreparedStatement stat = conn.prepareStatement(consulta); 
        
      stat.setInt(1, retencion);
      ResultSet rs = stat.executeQuery();
      String formato = "";
      while(rs.next()) {
      // El formato del String devuelto por cada empleado será:
      // nombre: cuenta (retencion)
         formato += rs.getString("NOMBRE") + ": " + rs.getString("CUENTA") + " (" + rs.getInt("RETENCION") + ")\n";
      }
   
      conn.close();
      return formato;
   }
   
}