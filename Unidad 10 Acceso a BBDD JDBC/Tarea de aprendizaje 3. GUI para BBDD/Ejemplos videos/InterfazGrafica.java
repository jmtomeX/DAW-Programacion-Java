/*
 * GUI con menú para manejar la BBDD
 */

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;       // Para poder usar DefaultCaret
import java.awt.event.*;
import java.sql.*;

public class InterfazGrafica implements ActionListener {

   // Método main
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
   
      // Configuramos los datos para conectarmos a nuestra BBDD y creamos el objeto ClaseBBDD
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe ";
      String usuario = "hr";
      String password = "hr";      
      ClaseBBDD miBBDD = new ClaseBBDD(driver, url, usuario, password);
   
      // Creamos la interfaz gráfica
      InterfazGrafica gui = new InterfazGrafica(miBBDD);
   }

   // Atributos
   private JFrame ventana;
   private JTextArea areaTexto;
   ClaseBBDD estaBBDD;

   // Constructor
   public InterfazGrafica(ClaseBBDD unaBBDD) {
      
      // Guardamos el objeto recibido como parámetro en el atributo estaBBDD
      // Será accesible desde cualquier método de la interfaz gráfica
      this.estaBBDD = unaBBDD;
   
      // Crea y configura la ventana principal
      ventana = new JFrame();   
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(450, 260);
      ventana.setTitle("MENU BBDD");
   
      // Crea la barra de menús. Se añade con setJMenuBar
      JMenuBar menus = crearMenuBar();
      ventana.setJMenuBar(menus);
      
      // Crea la caja de texto con scroll y la añade a la ventana principal
      // Se desactiva el autoscroll
      areaTexto = new JTextArea();
      DefaultCaret caret = (DefaultCaret) areaTexto.getCaret();
      caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
      JScrollPane scroll = new JScrollPane(areaTexto);
      ventana.add(scroll);
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   private JMenuBar crearMenuBar() {
   
      // Para crear menús primero debemos crear una barra de menús (JMenuBar)
      JMenuBar barraMenu = new JMenuBar();
      
      // Creamos un menú y lo añadimos a la barra de menús
      JMenu menu1 = new JMenu("REGISTROS");
      barraMenu.add(menu1);
   
      String[] opciones = {"Insertar", "Borrar"};
      for (int i = 0; i < opciones.length; i++) {
         String opcion = opciones[i];
         JMenuItem opcionMenu = new JMenuItem(opcion);
         menu1.add(opcionMenu);
         opcionMenu.addActionListener(this);       // Para que cuando se pulse una opción se ejecute actionPerformed
      }
      
      // Creamos otro menú.
      JMenu menu2 = new JMenu("CONSULTAS");      
   
      String[] opciones2 = {"Mostrar estadísticas", "Mostrar Mexico", "Mostrar paises"};
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
   // Definimos el código que se debe ejecutar cuando se produzca un evento ActionEvent
   // No podemos lanzar las excepciones cn Throws. Debemos gestionarlas con try-catch
   @Override
   public void actionPerformed(ActionEvent evento) {
   
      // Identificamos la opción pulsada
      JMenuItem opcion = (JMenuItem) evento.getSource();
      String textoOpcion = opcion.getText();
      
      if (textoOpcion.equals("Mostrar estadísticas")) {
         try {
            String estadisticas = estaBBDD.getEstadisticas();        // Realiza la consulta
            JOptionPane.showMessageDialog(null, estadisticas);
         } catch (SQLException excepcion) {
            JOptionPane.showMessageDialog(null, "Problemas con la BBDD: " + excepcion.getMessage());
         }
         return;
      }
      
      
      if (textoOpcion.equals("Mostrar Mexico")) {
         try {
            Pais mexico = estaBBDD.mostrarMexico();                  // Realiza la consulta
            
            // La consulta devuelve un objeto Pais. Podemos usar todos los métodos de esa clase
            areaTexto.setText("\tPAIS\n");
            areaTexto.append("ID: " + mexico.getId() + "\n");
            areaTexto.append("País: " + mexico.getNombre() + "\n");
            areaTexto.append("Región: " + mexico.getRegion() + "\n");
         } catch (SQLException excepcion) {
            JOptionPane.showMessageDialog(null, "Problemas con la BBDD: " + excepcion.getMessage());
         }
         
         return;
      }
      
      if (textoOpcion.equals("Mostrar paises")) {
         try {
            Pais[] paises = estaBBDD.mostrarCountries();             // Realiza la consulta
            
            // La consulta devuelve un array de objetos Pais.
            // Lo recorremos para mostrar información de cada uno de sus elementos
            areaTexto.setText("\tPAISES\n");
            for (Pais otroPais : paises) {
               areaTexto.append(otroPais + "\n");
            }
         } catch (SQLException excepcion) {
            JOptionPane.showMessageDialog(null, "Problemas con la BBDD: " + excepcion.getMessage());
         }
         
         return;
      }
      
      if (textoOpcion.equals("Insertar")) {
         DialogoInsertar miDialogo = new DialogoInsertar(estaBBDD);        // Se abre otra ventana
         return;
      }
      
      if (textoOpcion.equals("Borrar")) {
         DialogoBorrar miDialogo = new DialogoBorrar(estaBBDD);            // Se abre otra ventana
         return;
      }
   }
}