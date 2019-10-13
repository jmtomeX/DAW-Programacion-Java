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

public class DialogoJugador implements ActionListener {
   
   //Atributos
   private ClaseBBDD estaBBDD;
   private JDialog dialogo;
   private JComboBox<String> posicion;
   private JComboBox<String> procedencia;
   private JTextArea areaTexto;
   private JButton boton;
   
   public DialogoJugador(ClaseBBDD unaBBDD) {
   
      this.estaBBDD = unaBBDD;
      
      // Creamos y configuramos un JDialog
      dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      dialogo.setLocationRelativeTo(null);// dialogo al centro de la pantalla
      
      // Creamos un contenedor para la zona norte   
      JPanel norte = new JPanel(new GridLayout(2, 2));
      dialogo.setSize(500, 500);
      norte.add(new JLabel("Procedencia: "));
      
      // TAREA 1:
      // Carga el desplegable procedencia con las posibles procedencias de los jugadores de la BBDD
      try {
         String[] arrayProcedencias = estaBBDD.arrayProcedencia();
         procedencia = new JComboBox<String>(arrayProcedencias);
      }catch (SQLException excepcion) {
         JOptionPane.showMessageDialog(null, "Problemas al cargar los equipos: " + excepcion.getMessage());
      }
      norte.add(procedencia);     
      norte.add(new JLabel("Posición: "));
      String[] posiciones = {"C", "F", "G"};
      posicion = new JComboBox<String>(posiciones);
      norte.add(posicion);
      dialogo.add(BorderLayout.NORTH, norte);
      
      // Creamos un área de texto y la añadimos a la zona centro
      areaTexto = new JTextArea(10, 30);
      areaTexto.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
      DefaultCaret caret = (DefaultCaret) areaTexto.getCaret();
      caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
      areaTexto.setEditable(false); // Para no dejar escribir
      JScrollPane scroll = new JScrollPane(areaTexto);
      dialogo.add(BorderLayout.CENTER, scroll);
         
      // Creamos el botón y lo añadimos a la ventana principal
      JButton boton = new JButton("MOSTRAR");
      boton.addActionListener(this);
      dialogo.add(BorderLayout.SOUTH, boton);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   @Override
   public void actionPerformed(ActionEvent evento) {
      areaTexto.setText("");
      
      // TAREA 2: Obtiene las condiciones introducidas y
      // muestra en el área de texto los jugadores que las cumplen
      // Guardamos la procedencia seleccionada
      String procedenciaSeleccionada = (String) procedencia.getSelectedItem();
      
      // Guardamos la posición seleccionada
      String posicionSeleccionada = (String) posicion.getSelectedItem();
      try {
         areaTexto.setText(estaBBDD.selectJugadores(procedenciaSeleccionada, posicionSeleccionada));  
      } catch (SQLException excepcion) {
         JOptionPane.showMessageDialog(null, "Problemas con la BBDD: " + excepcion.getMessage());
      }
      return;
   }
}