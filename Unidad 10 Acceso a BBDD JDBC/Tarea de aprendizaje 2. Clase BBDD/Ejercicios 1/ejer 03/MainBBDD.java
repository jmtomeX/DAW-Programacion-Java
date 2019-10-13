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
      
      // Obtenemos información sobre todos los Empleados
      ArrayList<Empleado> listaEmpleados = oracleBBDD.getEmpleados();
      System.out.println(listaEmpleados);
   }
}

/*
Si en el main del programa principal creamos un objeto BBDD y ejecutamos el método:

El resultado será:

[11    Juan Ignacio Martinez    0   10  12341234121234567890     1960-02-01 00:00:00.0,
1     José Luis Pérez          2   12  12342233121122334455     1964-04-12 00:00:00.0,
..., 64738 Andrés Morales Martín    3   7   22341154116231563690     1964-01-20 00:00:00.0]
*/