/*
   Ejemplo de consulta a una BBDD Oracle Express XE
*/
/*
De los ejemplos que hemos estudiado elige el que mejor se adapta a la siguiente consulta, modifícalo y obten los
datos solicitados con el formato exigido.

Para ello, se usará el usuario desvan con la contraseña desvan. Recuerda configurar correctamente la dirección IP de la BBDD.

El programa pedirá una letra, la pasará a mayúsculas y mostrará el código, el nombre y el número de cuenta de los empleados
cuyo nombre empieza por esa letra.

La consulta que debemos realizar es:

SELECT codigo, nombre, cuenta FROM empleados WHERE nombre LIKE 'X%'

donde codigo será un número entero, nombre una cadena de caracteres y cuenta otra.

Los datos se mostrarán con el siguiente formato:

nombre (codigo): cuenta

Un posible resultado será:

Letra inicial: a
Alfonso Gutierrez Lopez (67890): 12563478001234567890
Andrés Morales Martín (64738): 22341154116231563690
*/


import java.sql.*;         // Trabajar con BBDD
import java.util.*;

public class Ejercicio_07 {
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
      Scanner teclado = new Scanner(System.in);
      // Datos necesarios para establecer la conexión con la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String usuario = "desvan";
      String password = "desvan";
            
   
      Class.forName(driver);
   
      Connection conn = DriverManager.getConnection(url, usuario, password);
      
      String consulta = "SELECT codigo, nombre, cuenta FROM empleados WHERE nombre LIKE ?";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
      System.out.print(" Letra inicial: ");
      String letra = teclado.next();
      letra = letra.toUpperCase() + "%";
       
      stat .setString(1, letra);
      ResultSet rs = stat.executeQuery(); 
      
      /*
      donde codigo será un número entero, nombre una cadena de caracteres y cuenta otra.
         Los datos se mostrarán con el siguiente formato:
         nombre (codigo): cuenta
      */
   
      while (rs.next()) {  
         System.out.println( rs.getString("NOMBRE") + ": (" + rs.getInt("CODIGO") + ") " + rs.getString("CUENTA"));
      }
      
      conn.close();  
   }
}