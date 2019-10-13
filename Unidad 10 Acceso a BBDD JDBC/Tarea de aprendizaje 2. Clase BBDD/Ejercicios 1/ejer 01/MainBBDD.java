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
      
      // Obtenemos información de los empleados con retención mayor que 10 y la mostramos
      int retencion = 10;
      String resultado = oracleBBDD.empleadosRetencionMayor(retencion);
      System.out.println(resultado);
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

// Obtenemos información de los empleados con retención mayor que 10 y la mostramos
int retencion = 10;
System.out.println(oracleBBDD.empleadosRetencionMayor(retencion));

El resultado será:

Juan Ignacio Martinez: 12341234121234567890 (10)
José Luis Pérez: 12342233121122334455 (12)
Manuel Lopez Marín: 55443322110099887766 (10)
Alfonso Gutierrez Lopez: 12563478001234567890 (12)
Encarna Lopez Lopez: 99118822773344665500 (10)
Rosa Lorite Lopez: 52341234521214567890 (10)
Lola Martinez Contreras: 22341224121224567820 (11)
*/