 /******************************************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  20/05/2019.
 Módulo:  Programación.
 Tarea:   PROG10 Tarea de evaluación 01. Realiza un programa en Java
  
 Descripción del programa: Esta tarea se centra en el manejo desde un programa con interfaz gráfica de la información
 almacenada en un base de datos. Para ello, crearemos una clase que se encargará de todas las consultas con la BBDD 
 y la usaremos en diferentes puntos de la interfaz gráfica.
 
 Menú del programa
 
 Enlace auto evaluación:  https://drive.google.com/file/d/1B-f7rbueBcQh2vEZqbSF6ue_lTb6AvzX/view?usp=sharing                             
                                
*******************************************************************************************************************/

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.text.*;       // Para usar DefaultCaret

public class InterfazGrafica implements ActionListener {

   // Se puede incluir el main en la clase
   public static void main (String args[])  throws FileNotFoundException, ClassNotFoundException, SQLException {
   
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@IP:1521:xe ";
      String ip = "";
      String usuario = "";
      String password = "";
   
      // TAREA 1
      // Leer la ip, el usuario y la contraseña del fichero config.dat y
      // define correctamente los parámetros para la conexión
      Scanner leerFichero = new Scanner(new File("config.dat"));
      while(leerFichero.hasNext()) {
         ip = leerFichero.next();
         usuario = leerFichero.next();
         password = leerFichero.next();
      }
      // Reemplazamos el texto IP por la ip
      url = url.replace("IP", ip);
      ClaseBBDD miBBDD = new ClaseBBDD(driver, url, usuario, password);
   
      InterfazGrafica gui = new InterfazGrafica(miBBDD);
   }

   // Atributos
   private JFrame ventana;
   private JTextArea areaTexto;
   private ClaseBBDD estaBBDD;

   // Constructor
   public InterfazGrafica(ClaseBBDD unaBBDD) {
   
      this.estaBBDD = unaBBDD;
   
      // Crea y configura la ventana principal
      ventana = new JFrame();   
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(450, 260);
      
      // Mejoras añadidas al frame
      ventana.setLocationRelativeTo(null);// Ventana al centro de la pantalla
      ventana.setIconImage (new ImageIcon(getClass().getResource("icono.png")).getImage());
      
      ventana.setTitle("ESTADISTICAS NBA");
   
      // Crea la barra de menús. Se añade con setJMenuBar
      JMenuBar menus = crearMenuBar();
      ventana.setJMenuBar(menus);
      
      // Crea la área de texto con scroll y la añade a la ventana principal
      areaTexto = new JTextArea();
      areaTexto.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
      DefaultCaret caret = (DefaultCaret) areaTexto.getCaret();
      caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
      JScrollPane scroll = new JScrollPane(areaTexto);
      ventana.add(scroll);
      
      //Mejoras para el area de texto
      UIManager.put("TextArea.margin", new Insets(10, 10, 10, 10));
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   private JMenuBar crearMenuBar() {
   
      // Para crear menús primero debemos crear una barra de menús (JMenuBar)
      JMenuBar barraMenu = new JMenuBar();
      
      // Creamos un menú y lo añadimos a la barra de menús
      JMenu menu1 = new JMenu("REGISTROS");
      barraMenu.add(menu1);
   
      String[] opciones = {"Añadir", "Modificar"};
      for (int i = 0; i < opciones.length; i++) {
         String opcion = opciones[i];
         JMenuItem opcionMenu = new JMenuItem(opcion);
         menu1.add(opcionMenu);
         opcionMenu.addActionListener(this);
      }
   
      // Creamos otro menú
      JMenu menu2 = new JMenu("CONSULTAS");
      String[] opciones2 = {"Mostrar jugadores", "Mostrar estadísticas", "Mostrar BBDD"};
      for (int i = 0; i < opciones2.length; i++) {
         String opcion = opciones2[i];
         JMenuItem opcionMenu = new JMenuItem(opcion);
         menu2.add(opcionMenu);
         opcionMenu.addActionListener(this);
      }   
      
      barraMenu.add(menu2);
      
      return barraMenu;
   }

   // Implementamos la interfaz ActionListener
   @Override
   public void actionPerformed(ActionEvent evento) {
   
      // Identificamos la opción pulsada y la mostramos en la caja de texto
      JMenuItem opcion = (JMenuItem) evento.getSource();
      String textoOpcion = opcion.getText();
      
      if (textoOpcion.equals("Mostrar BBDD")) {
         // TAREA 2
         // Realiza la consulta a la BBDD y muestra la información en un JOptionPane
         try {
            String consultaVersion = estaBBDD.getBBDD();
            JOptionPane.showMessageDialog(null, consultaVersion);
         } catch (SQLException excepcion) {
            JOptionPane.showMessageDialog(null, "Problemas con la BBDD: " + excepcion.getMessage());
         }
         return;
      }
      
      if (textoOpcion.equals("Mostrar jugadores")) {
      
         DialogoJugador miDialogo = new DialogoJugador(estaBBDD);
         return;
      }
      
      if (textoOpcion.equals("Mostrar estadísticas")) {
      
         DialogoEstadisticas miDialogo = new DialogoEstadisticas(estaBBDD, areaTexto);
         return;
      }
      
      if (textoOpcion.equals("Añadir")) {
      
         DialogoInsertar miDialogo = new DialogoInsertar(estaBBDD);
         return;
      }
      
      if (textoOpcion.equals("Modificar")) {
      
         DialogoModificar miDialogo = new DialogoModificar(estaBBDD);
         return;
      }
   }
}