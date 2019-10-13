/*
Crea el método getEmpleadosEmpiezan dentro de la clase BBDD. Recibe una letra y devuelve un array
de objetos de la clase Empleado con la información de todos los empleados cuyo nombre empieza por
la letra indicada.

Para ello, se usará el usuario desvan con la contraseña desvan.
Recuerda configurar correctamente la dirección IP de la BBDD.
La consulta que debemos realizar es:

SELECT * FROM empleados WHERE nombre LIKE 'X%'

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
   
   public ArrayList<Empleado> getEmpleadosEmpiezan() throws SQLException {
      Connection conn = conexion();
      
      // Creamos el objeto Statement, ejecutamos la consulta y obtenemos los resultados
      String consulta = "SELECT * FROM empleados WHERE nombre LIKE ?";
      PreparedStatement stat = conn.prepareStatement(consulta);
     
      Scanner teclado = new Scanner(System.in);
      System.out.print(" Letra inicial: ");
      String letra = teclado.next();
      letra = letra.toUpperCase() + "%";
       
      stat .setString(1, letra);
      ResultSet rs = stat.executeQuery(); 
      
      // Procesamos los resultados y lo guardamos en una lista
      ArrayList<Empleado> resultado = new ArrayList<Empleado>();
      while (rs.next()) {
         int codigo = rs.getInt("codigo");
         String nombre = rs.getString("nombre");
         int hijos = rs.getInt("hijos");
         int retencion = rs.getInt("retencion");
         String cuenta = rs.getString("cuenta");
         String fecha = rs.getString("fnacimiento");
         Empleado unEmpleado = new Empleado(codigo, nombre, hijos, retencion, cuenta, fecha);
         resultado.add(unEmpleado);
      }
   
      conn.close();
      return resultado;
   }
}