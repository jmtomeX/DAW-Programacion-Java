  /******************************************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  20/05/2019.
 Módulo:  Programación.
 Tarea:   PROG10 Tarea de evaluación 01. Realiza un programa en Java
  
  Descripción del programa:  Ventana de dialogo para modificar los datos de un jugador  
  Enlace auto evaluación: https://drive.google.com/file/d/1B-f7rbueBcQh2vEZqbSF6ue_lTb6AvzX/view?usp=sharing                              
                                
*******************************************************************************************************************/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class DialogoModificar implements ActionListener {
   
   //Atributos
   private JDialog dialogo;
   private JComboBox<Jugador> jugadores;
   private JTextField cajaAltura;
   private JTextField cajaPeso;
   private JTextField cajaPosicion;
   private JTextField cajaEquipo;
   private JButton cambiar;
   private ClaseBBDD estaBBDD;
   
   // Constructor
   public DialogoModificar(ClaseBBDD unaBBDD) {
   
      this.estaBBDD = unaBBDD;
      
      // Creamos y configuramos un JDialog
      dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      dialogo.setLocationRelativeTo(null);// dialogo al centro de la pantalla
      
      // Creamos un contenedor para organizar la zona norte 
      JPanel norte = new JPanel(new FlowLayout());
      norte.add(new JLabel("Jugador"));
      
   
      // TAREA 1:
      // Carga el desplegable jugadores con los jugadores de la BBDD
     // Guardamos el ArrayList en un array y lo cargamos en el desplegable
      try{
         ArrayList<Jugador> listaJugadores = estaBBDD.arrayListJugadores();
         
         Jugador[] arrayJugadores = new Jugador[listaJugadores.size()];
         listaJugadores.toArray(arrayJugadores);
         jugadores = new JComboBox<Jugador>(arrayJugadores);  
      }catch (SQLException excepcion) {
         JOptionPane.showMessageDialog(null, "Problemas al cargar los equipos: " + excepcion.getMessage());
      }
   
      norte.add(jugadores);
      jugadores.addActionListener(this);
      dialogo.add(BorderLayout.NORTH, norte);
      
      // Creamos un contenedor para organizar la zona centro 
      JPanel centro = new JPanel();
      centro.setLayout(new GridLayout(2, 4));
      centro.add(new JLabel("Altura: "));
      cajaAltura = new JTextField(15);
      // Creamos unobjeto de la clase Verificador y se lo añadimos  a la caja de texto con el método setInputVerifier
      cajaAltura.setInputVerifier(new Verificador());
      centro.add(cajaAltura);
      centro.add(new JLabel("Peso: "));
      cajaPeso = new JTextField(15);
      // Creamos unobjeto de la clase Verificador y se lo añadimos  a la caja de texto con el método setInputVerifier
      cajaPeso.setInputVerifier(new Verificador());
      centro.add(cajaPeso);
      centro.add(new JLabel("Posición: "));
      cajaPosicion = new JTextField(15);
      centro.add(cajaPosicion);
      centro.add(new JLabel("Equipo: "));
      cajaEquipo = new JTextField(15);
      centro.add(cajaEquipo);
      dialogo.add(BorderLayout.CENTER, centro);
      
      // Creamos el botón y lo añadimos a la ventana principal
      cambiar = new JButton("CAMBIAR");
      cambiar.addActionListener(this);
      dialogo.add(BorderLayout.SOUTH, cambiar);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   @Override
   public void actionPerformed(ActionEvent evento) {
   
      // TAREA 2:
      // Cuando se elige un jugador, se cargan sus datos en las cajas de texto
      // Si se pulsa el botón, se pide la confirmación y luego se actualizan los datos de ese jugador
       // Identificamos y ejecutamos la opción CAMBIAR
      // Identificamos la opción pulsada
      
      
     // Cogemos los datos del Jugador seleccionado
      Jugador jugadorSeleccionado = (Jugador) jugadores.getSelectedItem();
      
   // Nombre del jugador
      String nombre = jugadorSeleccionado.getNombre();
        
      if (evento.getSource() == cambiar) { 
      // Recogemos los datos de la caja de texto
         String altura = cajaAltura.getText();
         String pesoSt = cajaPeso.getText();
               
       // Si la cajaPeso está vacia no se ha seleccionado un jugador, si ya se ha seleccionado
       // y la caja está vacia pedira un número entero por medio del verificador
         if ((pesoSt != null) && (pesoSt.equals(""))) {
            JOptionPane.showMessageDialog(null, "Las cajas de texto están vacias", "Selecciona un jugador!", JOptionPane.ERROR_MESSAGE);
            return;   
         }
               
         int pesoJug =  Integer.parseInt(pesoSt); // Se pasa a entero el peso
         String posicion = cajaPosicion.getText();
         String equipo = cajaEquipo.getText(); 
           
      // Se pide confirmacion
         int opcion = JOptionPane.showConfirmDialog(null,"Cambiar: " + nombre,  "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (opcion == JOptionPane.YES_OPTION) {
         
            try {
                          
               if (estaBBDD.cambiarJugador(nombre, altura, pesoJug, posicion, equipo)) {
                                  
                  JOptionPane.showMessageDialog(null, "Los datos se han introducido correctamente");
               } else {
                  JOptionPane.showMessageDialog(null, "Error al introducir los datos");
               }
            } catch (SQLException excepcion) {
               JOptionPane.showMessageDialog(null, "Problemas con la BBDD: " + excepcion.getMessage());
            }
             
             
         } else { // opciones NO_OPTION o CANCEL_OPTION
            JOptionPane.showMessageDialog(null,"Se ha cancelado el cambio de datos.");
         }
         return;
      }
    // Cargamos los datos del Jugador en las cajas de texto
    // Con un objeto Jugador usamos los métodos de la clase jugador
      cajaAltura.setText(jugadorSeleccionado.getAltura());
   // Pasamos el peso a cadena de carácteres 
      String peso =String.valueOf(jugadorSeleccionado.getPeso());
      cajaPeso.setText(peso);
      cajaPosicion.setText(jugadorSeleccionado.getPosicion());
      cajaEquipo.setText(jugadorSeleccionado.getEquipo());
   }
   
     // Creamos una subclase de InputVerifier
   private class Verificador extends InputVerifier {
      // Creamos una subclase de InputVerifier
      @Override
      public boolean verify(JComponent componente) {
         if (componente instanceof JTextField) {
            JTextField cajaTexto = (JTextField) componente;
            String texto = cajaTexto.getText();      
            try {
               Integer.parseInt(texto);
               return true;
            } catch (Exception e) {
               JOptionPane.showMessageDialog(cajaTexto, "Introduce un número entero");
               return false;
            }
         }
         return false;
      }
   }
   
}
