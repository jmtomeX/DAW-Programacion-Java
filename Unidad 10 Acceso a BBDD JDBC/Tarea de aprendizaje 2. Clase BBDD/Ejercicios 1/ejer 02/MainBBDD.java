/*
   Trabajo con una BBDD Oracle Express XE
   
   usuario: desvan
   contraseña: desvan
   configurar la IP de BBDD con la que estamos trabajando
*/

import java.sql.*;
import java.util.*;

public class MainBBDD {
   public static void main (String args[]) throws SQLException {

      // Creamos un objeto para gestionar la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe ";
      String usuario = "desvan";
      String password = "desvan";
      BBDD oracleBBDD = new BBDD(driver, url, usuario, password);          
      
      // Obtenemos información sobre el empleado con código 111
      Empleado elEmpleado = oracleBBDD.getEmpleado111();
      System.out.println(elEmpleado);
   }
}

/*
Si en el main del programa principal creamos un objeto BBDD y ejecutamos el método:

// Creamos un objeto para gestionar la BBDD
String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@192.168.2.39:1521:xe ";
String usuario = "desvan";
String password = "desvan";
BBDD oracleBBDD = new BBDD(driver, url, usuario, password);          

// Obtenemos información sobre el empleado con código 111
Empleado elEmpleado = oracleBBDD.getEmpleado111();
System.out.println(elEmpleado);

El resultado será:

111   Encarna Lopez Lopez      0   10  99118822773344665500     1968-03-15 00:00:00.0
*/