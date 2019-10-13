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
 
   // Añade los métodos aquí
   /*
   Crea el método borrarSistemas dentro de la clase BBDD. No recibe ningún parámetro y trata de borrar el 
   departamento Sistemas con el código 7 de la BBDD. Devuelve true si la operación se ejecuta correctamente,
   false en caso contrario.
Para ello, se usará el usuario desvan con la contraseña desvan. Recuerda configurar correctamente la dirección IP de la BBDD.

La consulta que debemos realizar es:

DELETE FROM departamentos WHERE nombre = 'Sistemas'
   */
   
   public boolean borrarSistemas()  throws SQLException {
   
      Connection conn = conexion();
      
      Statement stmt = conn.createStatement();
      String consulta = "DELETE FROM departamentos WHERE nombre = 'Sistemas'";
    
      int resultado = stmt.executeUpdate(consulta);
      
      conn.close();
      
      if(resultado != 0) {
         return true;
      }
      return false;
   }
}