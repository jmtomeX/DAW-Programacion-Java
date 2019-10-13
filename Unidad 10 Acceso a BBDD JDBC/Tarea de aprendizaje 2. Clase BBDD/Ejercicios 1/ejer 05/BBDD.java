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
   /*
   Crea el método insertarSistemas dentro de la clase BBDD. No recibe ningún parámetro y trata de
   insertar el departamento Sistemas con el código 7 en la BBDD. Devuelve true si la operación se
   ejecuta correctamente, false en caso contrario.
   La consulta que debemos realizar es:   
   INSERT INTO departamentos (codigo, nombre) VALUES (7, 'Sistemas')
  
  La primera vez, el resultado será:
  Los datos se han introducido correctamente
   */
   // Añade los métodos aquí
   public boolean insertarSistemas() throws SQLException {
      Connection conn = conexion();
   
      String consulta = "INSERT INTO departamentos (codigo, nombre) VALUES (7, 'Sistemas')";
      Statement smtm = conn.createStatement();
      int resultado = smtm.executeUpdate(consulta);
     
      conn.close();
     
      if(resultado != 0) {
         return true;
      }
      return false;
   }
}