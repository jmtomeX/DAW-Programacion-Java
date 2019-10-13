/*
   Clase que gestiona una BBDD
   Crea el método insertarSistemas dentro de la clase BBDD. No recibe ningún parámetro y trata de insertar
   el departamento Sistemas con el código 7 en la BBDD. Devuelve true si la operación se ejecuta correctamente,
   false en caso contrario.
   Para ello, se usará el usuario desvan con la contraseña desvan. Recuerda configurar correctamente la dirección
   IP de la BBDD.
   La consulta que debemos realizar es:

   INSERT INTO departamentos (codigo, nombre) VALUES (7, 'Sistemas')
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
   public boolean insertarSistemas() throws SQLException {
   
   // creamos la conexion
      Connection conn = conexion();
   
   // creamos la consulta y la ejecutamos
      String consulta = "INSERT INTO departamentos (codigo, nombre) VALUES (8, 'Mantenimiento')";
      Statement stat = conn.createStatement();
      int resultado = stat.executeUpdate(consulta);
   
      conn.close();
   
      return resultado == 1;
   } 
}