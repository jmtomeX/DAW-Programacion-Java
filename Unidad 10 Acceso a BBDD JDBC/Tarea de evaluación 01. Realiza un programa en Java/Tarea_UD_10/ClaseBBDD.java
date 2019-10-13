/******************************************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  20/05/2019.
 Módulo:  Programación.
 Tarea:   PROG10 Tarea de evaluación 01. Realiza un programa en Java
  
  Descripción del programa: Definición de la clase BBDD. Gestionará el acceso, consultas y modificaciones a la base de datos
  
  Enlace auto evaluación: https://drive.google.com/file/d/1B-f7rbueBcQh2vEZqbSF6ue_lTb6AvzX/view?usp=sharing                           
                                
*******************************************************************************************************************/

import java.sql.*;
import java.util.*;

public class ClaseBBDD {
   
   // ATRIBUTOS
   private String driver;
   private String url;
   private String usuario;
   private String password;
   private Connection conn; 
   
   // Constructor
   public ClaseBBDD(String driver, String url, String usuario, String password) {
      this.driver = driver;
      this.url = url;
      this.usuario = usuario;
      this.password = password;
      
   }   
   
   // Realiza y devuelve la conexión con la BBDD
   private Connection conexion() throws SQLException {
   
      // Crear la conexión
      conn = DriverManager.getConnection(url, usuario, password);
   
      return conn;
   
   }
   
   // Obtenemos información sobre la BBDD con la que estamos trabajando 
   public String getBBDD() throws SQLException {
      Connection conn = conexion();
     // Creamos un objeto DatabaseMetaData y obtenemos información sobre la BBDD
      DatabaseMetaData meta = conn.getMetaData();
      conn.close();
      
      return "Versión del producto " + meta.getDatabaseProductVersion(); 
   }
   
 
   // Devuelve un array de Strings con los nombres de los equipos baloncesto de la BBDD
   // Consulta que debemos ejecutar: SELECT nombre FROM equipos ORDER BY nombre
   public String[] arrayEquipos() throws SQLException {
      Connection conn = conexion();
      // Creamos el objeto Statement, ejecutamos la consulta y obtenemos resultados.
      Statement stmt = conn.createStatement();
      String consulta = "SELECT nombre FROM equipos ORDER BY nombre";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Creamos un arrayList ya que no sabemos el tamaño de los datos
      ArrayList<String> listaEquipos = new ArrayList<String>();
      while(rs.next()) {
         String nombreEquipo = rs.getString(1);
         listaEquipos.add(nombreEquipo);
      }
      // Convertimos el ArrayList a un Array
      // Creamos un array con el tamaño del ArrayList
      // Guardamos el contenido del ArrayList en el Array
      String[] arrayEquipos = new String[listaEquipos.size()];
      listaEquipos.toArray(arrayEquipos);
      
      return arrayEquipos;
   }
   
   
   // Devuelve un ArrayList de objetos Jugador con los datos de todos los jugadores de la BBDD
   // Consulta: SELECT * FROM jugadores ORDER BY nombre
   // Por cada jugador obtendremos los siguientes datos en el orden dado
   // codigo: un número entero
   // nombre, procedencia y altura: cadenas de caracteres
   // peso: un número entero
   // posicion y equipo: cadenas de caracteres
   public ArrayList<Jugador> arrayListJugadores() throws SQLException {
      Connection conn = conexion();
   // Creamos el objeto Statement
      Statement stmt = conn.createStatement();
   // Ejecutamos la consulta
      String consulta = "SELECT * FROM jugadores ORDER BY nombre";
   // Obtenemos los resultados
      ResultSet rs = stmt.executeQuery(consulta);
   
   // Procesamos los resultados 
      ArrayList<Jugador> resultadoJugador = new ArrayList<Jugador>();
      while(rs.next()) {
         int codigo = rs.getInt(1);
         String nombre = rs.getString(2);
         String procedencia = rs.getString(3);
         String  altura = rs.getString(4);
         int peso = rs.getInt(5);
         String  posicion = rs.getString(6);
         String  equipo = rs.getString(7);
        // Los guardamos en una lista de objetos Jugador 
         Jugador unJugador = new Jugador(codigo, nombre, procedencia, altura, peso, posicion, equipo);
         resultadoJugador.add(unJugador);
      }
      conn.close();
      
      return resultadoJugador;
   }
   
   // Devuelve un array de String con las posibles procedencias de los jugadores de la BBDD
   // Consulta: SELECT DISTINCT procedencia FROM jugadores
   // El primer elemento de este array además se incluirá la palabra "Todas" que indicará cualquier procedencia
   public String[] arrayProcedencia() throws SQLException {
      
      Connection conn = conexion();
      
   // Creamos el objeto Statement, ejecutamos la consulta y obtenemos los resultados
      Statement stmt = conn.createStatement();
      String consulta = "SELECT DISTINCT procedencia FROM jugadores";
      ResultSet rs = stmt.executeQuery(consulta);
      
      // Procesamos el resultado y lo guardamos en una lista de tipo String
      ArrayList<String> procedencias = new ArrayList<String>();
      procedencias.add("Todas");
      while(rs.next()) {
         String procedenciaSt = rs.getString("PROCEDENCIA");
         procedencias.add(procedenciaSt);
      }
      
      conn.close();
      
      // Guardamos la lista en un array
      String[] arrayProcedencias = new String[procedencias.size()];
      procedencias.toArray(arrayProcedencias);
      
      return arrayProcedencias;
   }
   
   // Devuelve un String con el nombre, la procedencia y la posición de todos los jugadores seleccionados
   // Tanto nombre como procedencia y posicion son cadenas de caracteres
   public String selectJugadores(String procedencia, String posicion) throws SQLException {
      
      String consulta = "";
      String resultadoJugadores = "";
      boolean tipoConsulta;  
   // Para que LIKE funcione correctamente hay que añadir un % delante y detrás de la letra a buscar
   // La consulta quedaría: SELECT * FROM jugadores WHERE posicion LIKE "F%"
   // Se le añade al método consultaDatosJugadores()
   
      // Creamos una consulta preparada para insertar los datos
      // Si procedencia es igual a "Todas", la consulta: SELECT * FROM jugadores WHERE posicion LIKE ?
      if (procedencia.equals("Todas")) {
         tipoConsulta = false; // Si es false se le pasa solo el parámetro posición
         consulta = "SELECT * FROM jugadores WHERE posicion LIKE ?";
      
      
         // Usamos el método  consultaDatosJugadores para obtener los datos de los jugadores
         // se le asignan los datos a un String para trabajar con ellos
         resultadoJugadores = consultaDatosJugadores(consulta, procedencia, posicion, tipoConsulta);
             
      }else {  // Para el resto de procedencias: SELECT * FROM jugadores WHERE posicion LIKE ? AND procedencia = ?
         tipoConsulta = true; // Si es true se le pasan 2 parámetros a la consulta, posición y procedencia
         consulta = "SELECT * FROM jugadores WHERE posicion LIKE ? AND procedencia = ?";
         
         // Usamos el método  consultaDatosJugadores para obtener los datos de los jugadores
         // se le asignan los datos a un String para trabajar con ellos
         
         resultadoJugadores = consultaDatosJugadores(consulta, procedencia, posicion, tipoConsulta);
      }
      return resultadoJugadores;      
   }
   
   // Método que recoge la consulta  y devuelve un String con los datos de los jugadores.
   // Recibe 3 párametros String consulta, String procedencia, String posicion
   // Devuelve un String con el resultado.
   private String consultaDatosJugadores(String consulta, String procedencia, String posicion, boolean tipoConsulta) throws SQLException {
     
      Connection conn = conexion();
      
      // Creamos una consulta preparada para recoger los datos que recibe como parámetro la consulta
      PreparedStatement stat = conn.prepareStatement(consulta);
         
      stat.setString(1,posicion + "%");
      
      // Si la consulta es distinta a PROCEDENCIA "Todas" usará para la consulta la procedencia que pedirá la consulta.
      if(tipoConsulta) {
         stat.setString(2, procedencia);
      }
         
   // Obtenemos los datos de la consulta 
      ResultSet rs = stat.executeQuery();
      String  resultadoJugadores = String.format("%-18s%-18s%25s\n", "NOMBRE", "PROCEDENCIA", "POSICION");
      String nombreJugador = "";
      while(rs.next()) {
         nombreJugador = rs.getString("NOMBRE");
         String procedenciaJugador = rs.getString("PROCEDENCIA");
         String posicionJugador = rs.getString("POSICION");
         
         resultadoJugadores += String.format("%-18s%-18s%25s\n", nombreJugador, procedenciaJugador, posicionJugador);
      }
      conn.close();
      
      // Si el resultado obtenido por la consulta está vacío avisará de ello
      if(nombreJugador.equals("")){
         resultadoJugadores = "No hay ningún jugador con esas características.";
      }
      
      return resultadoJugadores;
   }
   
   
   // Devuelve un string con las estadísticas de los jugadores del equipo elegido
   // Introducirá un título:
   // NOMBRE(hueco de 22, alineado a la izquierda)REBOTES(hueco de 10, alineado a la derecha)TAPONES(hueco de 10, alineado a la derecha)
   // Luego los datos, uno por línea con el mismo formato
   // Consulta:
   // SELECT round(AVG(rebotes_por_partido), 2), round (AVG(tapones_por_partido),2), jugadores.nombre FROM estadisticas 
   // INNER JOIN jugadores ON jugadores.codigo = estadisticas.jugador 
   // INNER JOIN equipos ON jugadores.nombre_equipo = equipos.nombre 
   // WHERE equipos.nombre = ? 
   // GROUP BY jugadores.nombre
   // jugadores.nombre es una cadena de caracteres
   // round(AVG(rebotes_por_partido), 2) y round (AVG(tapones_por_partido),2) números decimales

   public String selectEstadisticas(String equipoElegido) throws SQLException {
   // NOMBRE(hueco de 22, alineado a la izquierda)REBOTES(hueco de 10, alineado a la derecha)TAPONES(hueco de 10, alineado a la derecha)
      String  estadisticasEquipos = String.format("%-22s%10s%10s\n", "NOMBRE", "REBOTES", "TAPONES");
   // Luego los datos, uno por línea con el mismo formato
      Connection conn = conexion();
   // Creamos la consulta
      String consulta = "SELECT round(AVG(rebotes_por_partido), 2) AS  REBOTES_POR_PARTIDO, round(AVG(tapones_por_partido),2) AS TAPONES_POR_PARTIDO, jugadores.nombre FROM estadisticas ";
      consulta += "INNER JOIN jugadores ON jugadores.codigo = estadisticas.jugador ";
      consulta += "INNER JOIN equipos ON jugadores.nombre_equipo = equipos.nombre ";
      consulta += "WHERE equipos.nombre = ? ";
      consulta += "GROUP BY jugadores.nombre";
      
      // Creamos una consulta preparada para recoger los datos 
      PreparedStatement stat = conn.prepareStatement(consulta);
       
   // Introducimos en la consulta los valores recibidos como parámetros y la ejecutamos   
      stat.setString(1,equipoElegido);
      
      ResultSet rs = stat.executeQuery();
     
   // Introducimos en la consulta los valores recibidos como parámetros y la ejecutamos
      while(rs.next()) {
         String nombreEquipo = rs.getString("NOMBRE");
         double rebotesEquipo = rs.getDouble("REBOTES_POR_PARTIDO");
         double taponesEquipo =  rs.getDouble("TAPONES_POR_PARTIDO");
         
         estadisticasEquipos += String.format("%-22s%10s%10s\n", nombreEquipo, rebotesEquipo, taponesEquipo);
      }
     
      conn.close();
      return estadisticasEquipos;
   }
   
   // Se inserta un nuevo partido en la BBDD con los valores pasados. Utilizará 2 consultas
   // Consulta 1: SELECT MAX(codigo) FROM partidos
   // Nos permite obtener el último código utilizado.
   // Será un número entero y para el nuevo registro usaremos el siguiente
   // Consulta 2: INSERT INTO partidos (codigo, equipo_local, equipo_visitante, puntos_local, puntos_visitante, temporada) VALUES (?, ?, ?, ?, ?, ?)
   public boolean insertarPartido(String local, String visitante, int ptosLocal, int ptosVisitante, String temporada) throws SQLException{
   
      Connection conn = conexion();
   // Creamos el objeto Statement
      Statement stmt = conn.createStatement();
   // Creamos la consulta para obtener el último código usado.
      String consulta = "SELECT MAX(codigo) FROM partidos";
      ResultSet rs = stmt.executeQuery(consulta);
      int codigoMayor = 0;
      while (rs.next()){
         codigoMayor = rs.getInt(1);
      }
     
      codigoMayor++; // Usamos el siguiente número usado.
      
   // Creamos la consulta preparada para insertar los datos.
      String consulta2 = "INSERT INTO partidos (codigo, equipo_local, equipo_visitante, puntos_local, puntos_visitante, temporada) VALUES (?, ?, ?, ?, ?, ?)";
      PreparedStatement stat = conn.prepareStatement(consulta2);
   // Introducimos en la consulta los valores recibidos como parámetros y la ejecutamos
      stat.setInt(1,codigoMayor);
      stat.setString(2, local);
      stat.setString(3, visitante);
      stat.setInt(4, ptosLocal);
      stat.setInt(5, ptosVisitante);
      stat.setString(6, temporada);
      
      // Obtenemos si el resultado de la consulta se ha completado, devulve 1 si se ha cumplido
      int resultado = stat.executeUpdate();   
      
      conn.close();
      
      return resultado == 1;
   }
   
   // Se modifican los datos de un jugador con los valores pasados
   // Consulta: UPDATE jugadores SET altura = ?, peso = ?, posicion = ?, nombre_equipo = ? WHERE nombre = ?
   // Devolverá true si la operación se realiza y false en caso contrario 
   public boolean cambiarJugador(String nombre, String altura, int peso, String posicion, String equipo) throws SQLException {
     
      Connection conn = conexion();
    // Creamos una consulta preparada para insertar los datos
      String consulta ="UPDATE jugadores SET altura = ?, peso = ?, posicion = ?, nombre_equipo = ? WHERE nombre = ?";
      PreparedStatement stat = conn.prepareStatement(consulta);
      
    // Creamos una consulta preparada para cambiar los datos del jugador
      stat.setString(1, altura);
      stat.setInt(2, peso);
      stat.setString(3, posicion);
      stat.setString(4, equipo);
      stat.setString(5, nombre);
      int resultado = stat.executeUpdate();
      
      conn.close();
   
      return resultado == 1;
   }
   
}
