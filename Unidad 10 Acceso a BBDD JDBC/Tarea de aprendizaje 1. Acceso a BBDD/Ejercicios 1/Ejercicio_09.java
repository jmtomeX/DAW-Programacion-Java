/*
De los ejemplos que hemos estudiado elige el que mejor se adapta a la siguiente consulta,
modifícalo y obten los datos solicitados con el formato exigido.
Para ello, se usará el usuario desvan con la contraseña desvan.
Recuerda configurar correctamente la dirección IP de la BBDD.
  
Las consultas que debemos realizar son:

INSERT INTO departamentos (codigo, nombre) VALUES (?, ?)
DELETE FROM departamentos WHERE codigo = ?

donde codigo es un número entero y nombre una cadena de caracteres.

El resultado será:

Código: 7
Nombre: Sistemas
INSERT OK
DELETE OK
*/
import java.sql.*;
import java.util.*;

public class Ejercicio_09 {
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
      Scanner teclado = new Scanner(System.in);
      // Datos necesarios para establecer la conexión con la BBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String usuario = "desvan";
      String password = "desvan";
          
      // Crear la conexión
      Connection conn = DriverManager.getConnection(url, usuario, password);
      
      /*
       El programa da de alta a un nuevo departamento y luego lo borra.
       Pide el código y el nombre del nuevo departamento y lo añade.
       Luego lo borra. Comprobará si la operación se ha realizado bien o no.
      */
      String consulta = "INSERT INTO departamentos (codigo, nombre) VALUES (?, ?)";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
      System.out.print("Código: ");
      int codigo = teclado.nextInt();
      stat.setInt(1, codigo);
      
      System.out.print("Nombre: ");
      String nombre = teclado.next();
      stat.setString(2,nombre); 
      
      int resultado = stat.executeUpdate();
      if(resultado != 0) {
         System.out.println("INSERT OK");
      }
      consulta = "DELETE FROM departamentos WHERE codigo = ?";
      stat = conn.prepareStatement(consulta);
     
      stat.setInt(1, codigo);
      resultado = stat.executeUpdate();
      
      if(resultado != 0) {
         System.out.println("DELETE OK");
      }
     // Cerrar conexión  
      conn.close();  
   }
}