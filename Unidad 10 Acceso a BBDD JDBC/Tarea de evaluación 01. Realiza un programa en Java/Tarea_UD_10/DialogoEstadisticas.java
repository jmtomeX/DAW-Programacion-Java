 /******************************************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  20/05/2019.
 Módulo:  Programación.
 Tarea:   PROG10 Tarea de evaluación 01. Realiza un programa en Java
  
  Descripción del programa: Ventana de dialogo para mostrar jugadores     
  Enlace auto evaluación: https://drive.google.com/file/d/1B-f7rbueBcQh2vEZqbSF6ue_lTb6AvzX/view?usp=sharing                              
                                
*******************************************************************************************************************/


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.text.*;       // Para usar DefaultCaret

public class DialogoEstadisticas implements ActionListener {
   
   //Atributos
   private ClaseBBDD estaBBDD;
   private JDialog dialogo;
   private JComboBox<String> equipos;
   private JTextArea areaTexto;
   
   // Constructor
   public DialogoEstadisticas(ClaseBBDD unaBBDD, JTextArea areaTexto) {
   
      this.estaBBDD = unaBBDD;
      this.areaTexto = areaTexto;
      
      // Creamos y configuramos un JDialog
      dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      dialogo.setLocationRelativeTo(null);// dialogo al centro de la pantalla
       
      areaTexto.setEditable(false); // Para no dejar escribir   
      
      // Añadimos una etiqueta a la zona norte       
      dialogo.add(BorderLayout.NORTH, new JLabel("MOSTRAR ESTADISTICAS DE UN EQUIPO"));
      
      // Creamos un contenedor para organizar la zona centro
      JPanel centro = new JPanel(new FlowLayout());
      centro.add(new JLabel("Equipo: "));
      
      // TAREA 1:
      // Carga el desplegable equipos con los equipos de la BBDD
      
      try{
         String[] arrayEquipos = estaBBDD.arrayEquipos();
         equipos = new JComboBox<String>(arrayEquipos);
      }catch (SQLException excepcion) {
         JOptionPane.showMessageDialog(null, "Problemas al cargar los equipos: " + excepcion.getMessage());
      }
      
      equipos.addActionListener(this);
      centro.add(equipos);
      dialogo.add(BorderLayout.CENTER, centro);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   @Override
   public void actionPerformed(ActionEvent evento) {
      areaTexto.setText("");
   
      // TAREA 2: identifica el equipo que se ha seleccionado, obtiene las estadísticas de sus jugadores y
      // las muestra en la area de texto.
      String equipoSeleccionado = (String) equipos.getSelectedItem();
      try{
         areaTexto.setText(estaBBDD.selectEstadisticas(equipoSeleccionado));
      }catch(SQLException excepcion) {
         JOptionPane.showMessageDialog(null, "Problemas con la BBDD: " + excepcion.getMessage());
      }
      return;
   }
}