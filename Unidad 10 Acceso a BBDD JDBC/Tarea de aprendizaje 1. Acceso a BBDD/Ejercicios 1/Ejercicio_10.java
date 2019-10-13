/*
De los ejemplos que hemos estudiado elige el que mejor se adapta a la siguiente consulta,
modifícalo y obten los datos solicitados con el formato exigido.
Para ello, se usará el usuario desvan con la contraseña desvan.
Recuerda configurar correctamente la dirección IP de la BBDD.
El programa pedirá el número de hijos y mostrará el nombre y el número de hijos de los empleados
con más hijos que los indicados.

La consulta que debemos realizar es:
SELECT nombre, hijos FROM empleados WHERE hijos > XX

donde nombre es una cadena de caracteres, hijos un número entero y XX el valor que se ha introducido
por teclado.

Los datos se mostrarán con el siguiente formato:
nombre: hijos

Un posible resultado será:
Número de hijos: 2
Francisca Colate Gonzalez:  3
María Pascual Rojo:  3
Andrés Morales Martín:  3
*/

import java.sql.*;         // Trabajar con BBDD
import java.util.*;

public class Ejercicio_10 {
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
      
      Scanner teclado = new Scanner(System.in);
      
   // Datos necesarios para establecer la conexión con la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe ";
      String usuario = "desvan";
      String password = "desvan";
        
      // Crear la conexión
      Connection conn = DriverManager.getConnection(url, usuario, password);
      
      // Crear el objeto Statement, ejecutar consulta y obtener resultados
      Statement stmt = conn.createStatement();
      
      /*
       El programa pedirá el número de hijos y mostrará el nombre y el número de hijos de los empleados
       con más hijos que los indicados.
       La consulta que debemos realizar es:
       SELECT nombre, hijos FROM empleados WHERE hijos > XX
       donde nombre es una cadena de caracteres, hijos un número entero y XX el valor que se ha introducido
       por teclado.
   
      */
      
      String consulta = "SELECT nombre, hijos FROM empleados WHERE hijos > ?";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
      System.out.print("Número de hijos: "); 
      int numeroHijos = teclado.nextInt();
      stat.setInt(1, numeroHijos);
      ResultSet rs = stat.executeQuery();
      
      // Procesar resultados
      while (rs.next()) {  
         // System.out.println(rs.getInt(1) + "  " + rs.getString(2));
         System.out.println(rs.getString("nombre") + ": " + rs.getString("hijos"));
      }
        
      // Cerrar conexión  
      conn.close();  
   }
}