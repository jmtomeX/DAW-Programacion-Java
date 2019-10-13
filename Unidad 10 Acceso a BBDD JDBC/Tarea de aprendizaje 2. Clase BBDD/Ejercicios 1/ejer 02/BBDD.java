/*
   Clase que gestiona una BBDD
   
   Crea el método getEmpleado111 dentro de la clase BBDD. No recibe ningún parámetro y devuelve los
   datos del empleado con código 111 en un objeto de la clase Empleado.
   
   Para ello, se usará el usuario desvan con la contraseña desvan.
   Recuerda configurar correctamente la dirección IP de la BBDD.
   
   La consulta que debemos realizar es:
   
   SELECT * FROM empleados WHERE codigo = 111
   
   La consulta devolverá por cada empleado los siguientes datos en este mismo orden:
   
   codigo: número entero
   nombre: cadena de caracteres
   hijos: número entero
   retencion: número entero
   cuenta: cadena de caracteres
   fnacimiento: cadena de caracteres

*/

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
   public Empleado getEmpleado111() throws SQLException {
      Connection conn = conexion();
      
      // Cramos el objeto statement ejecutamos la consulta y obtenemos los resultados
      Statement stmt = conn.createStatement();
      String consulta = "SELECT * FROM empleados WHERE codigo = 111"; 
      ResultSet rs = stmt.executeQuery(consulta);
     
     // Procesamos le resultado y lo devolvemos
      Empleado empleado111 = null;
      if(rs.next()) {
         int codigo = rs.getInt(1);
         String nombre = rs.getString(2);
         int hijos = rs.getInt(3);
         int retencion = rs.getInt(4);
         String cuenta = rs.getString(5);
         String fecha = rs.getString(6);
         empleado111 = new Empleado(codigo, nombre, hijos, retencion, cuenta, fecha);
      }
     
      conn.close();
     
      return empleado111;
   }
}