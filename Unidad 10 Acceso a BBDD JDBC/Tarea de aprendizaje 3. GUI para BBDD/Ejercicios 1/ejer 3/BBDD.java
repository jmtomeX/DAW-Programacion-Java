/*
   Clase que gestiona una BBDD
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
   
   // Devuelve los datos del empleado con código 111 en un objeto de la clase Empleado
   // SELECT * FROM empleados WHERE codigo = 111
   // codigo, hijos y retencion: enteros
   // nombre, cuenta y fnacimiento: cadenas de caracteres
   public Empleado getEmpleado111() throws SQLException {
   
      Connection conn = conexion();
      
      // Crear el objeto Statement, ejecutar consulta y obtener resultados
      Statement stmt = conn.createStatement();
      
      String consulta = "SELECT * FROM empleados WHERE codigo = 111";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Procesar el resultado y guardarlo en un objeto de la clase Empleado
      Empleado empleado111 = null;
      if (rs.next()) {
         int codigo = rs.getInt("codigo");
         String nombre = rs.getString("nombre");
         int hijos = rs.getInt("hijos");
         int retencion = rs.getInt("retencion");
         String cuenta = rs.getString("cuenta");
         String fecha = rs.getString("fnacimiento");
         empleado111 = new Empleado(codigo, nombre, hijos, retencion, cuenta, fecha);
      }
      
      conn.close();
      
      return empleado111;
   }
   
   // Devuelve un ArrayList con la información de todos los empleados de la BBDD
   public ArrayList<Empleado> getEmpleados() throws SQLException {
   
      Connection conn = conexion();
      
      // Crear el objeto Statement, ejecutar consulta y obtener resultados
      Statement stmt = conn.createStatement();
      
      String consulta = "SELECT * FROM empleados";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Procesar resultados y guardarlos en una lista de objetos Empleado
      ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
      while (rs.next()) {  
         int codigo = rs.getInt("codigo");
         String nombre = rs.getString("nombre");
         int hijos = rs.getInt("hijos");
         int retencion = rs.getInt("retencion");
         String cuenta = rs.getString("cuenta");
         String fecha = rs.getString("fnacimiento");
         Empleado unEmpleado = new Empleado(codigo, nombre, hijos, retencion, cuenta, fecha);
         listaEmpleados.add(unEmpleado);
      }
      
      conn.close();
      
      return listaEmpleados;
   }
   
   // Devuelve un array con los datos de los empleados cuyo nombre empieza por la letra indicada
   // SELECT * FROM empleados WHERE nombre LIKE 'A%'
   public Empleado[] getEmpleadosEmpiezan(String letra) throws SQLException {
      
      Connection conn = conexion();
      
      // Consultar datos con una consulta preparada
      String consulta = "SELECT * FROM empleados WHERE nombre LIKE ?";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
      // Introducimos los valores recibidos en la consulta y la ejecutamos
      stat.setString(1, letra + "%");
      ResultSet rs = stat.executeQuery();

      // Procesar resultados y guardarlos en una lista de objetos Empleado
      ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
      while (rs.next()) {  
         int codigo = rs.getInt("codigo");
         String nombre = rs.getString("nombre");
         int hijos = rs.getInt("hijos");
         int retencion = rs.getInt("retencion");
         String cuenta = rs.getString("cuenta");
         String fecha = rs.getString("fnacimiento");
         Empleado unEmpleado = new Empleado(codigo, nombre, hijos, retencion, cuenta, fecha);
         listaEmpleados.add(unEmpleado);
      }
      
      // Guardamos el ArrayList en un array
      int longi = listaEmpleados.size();
      Empleado[] arrayEmpleados = new Empleado[longi];
      listaEmpleados.toArray(arrayEmpleados);
      
      // Cerramos la conexión
      conn.close();
      
      // Devolvemos el array
      return arrayEmpleados;
   }
   
   // Se inserta un departamento en la BBDD
   // INSERT INTO departamentos (codigo, nombre) VALUES (XX, XX)
   public boolean insertarDepartamento(int codigo, String nombre) throws SQLException {
      
      Connection conn = conexion();
      
      // Consultar datos con una consulta preparada
      String consulta = "INSERT INTO departamentos (codigo, nombre) VALUES (?, ?)";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
      // Introducimos los valores recibidos en la consulta y la ejecutamos
      stat.setInt(1, codigo);
      stat.setString(2, nombre);
      int resultado = stat.executeUpdate();
      
      conn.close();
      
      return resultado == 1;
   }
   
   // Se borra el departamento Sistemas
   public boolean borrarDepartamento(String nombre) throws SQLException {
      
      Connection conn = conexion();
      
      // Consultar datos con una consulta preparada
      String consulta = "DELETE FROM departamentos WHERE nombre = ?";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
      // Introducimos los valores recibidos en la consulta y la ejecutamos
      stat.setString(1, nombre);
      int resultado = stat.executeUpdate();

      conn.close();
      
      return resultado == 1;
   }
}