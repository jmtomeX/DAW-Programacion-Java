/*
De los ejemplos que hemos estudiado elige el que mejor se adapta a la siguiente consulta, modifícalo y obten los datos solicitados
con el formato exigido.
Para ello, se usará el usuario desvan con la contraseña desvan. Recuerda configurar correctamente la dirección IP de la BBDD.

El programa mostrará el código y el nombre de todos los trabajadores en la tabla empleados.

La consulta que debemos realizar es:
SELECT codigo, nombre FROM empleados
donde codigo será un número entero y nombre una cadena de caracteres
Los datos se mostrarán con el siguiente formato:

codigo(hueco de 10, alineado a la izquierda)nombre
*/



import java.sql.*;         // Trabajar con BBDD

public class Ejercicio_08 {
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
   
   
      // Datos necesarios para establecer la conexión con la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe ";
      String usuario = "desvan";
      String password = "desvan";
        
      // Crear la conexión
      Connection conn = DriverManager.getConnection(url, usuario, password);
      
      // Crear el objeto Statement, ejecutar consulta y obtener resultados
      Statement stmt = conn.createStatement();
      
      String consulta = "SELECT codigo, nombre FROM empleados";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Procesar resultados
      while (rs.next()) {  
         // System.out.println(rs.getInt(1) + "  " + rs.getString(2));
         System.out.printf("%-10d%s\n", rs.getInt("codigo"), rs.getString("nombre"));
      }
        
      // Cerrar conexión  
      conn.close();  
   }
}