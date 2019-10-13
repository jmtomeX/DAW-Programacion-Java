 /******************************************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  20/05/2019.
 Módulo:  Programación.
 Tarea:   PROG10 Tarea de evaluación 01. Realiza un programa en Java
  
  Descripción del programa:  Ventana de dialogo para añadir un partido   
  Enlace auto evaluación: https://drive.google.com/file/d/1B-f7rbueBcQh2vEZqbSF6ue_lTb6AvzX/view?usp=sharing                              
                                
*******************************************************************************************************************/
  


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class DialogoInsertar implements ActionListener {
   
   //Atributos
   private JComboBox<String> equipoLocal;
   private JComboBox<String> equipoVisitante;
   private JTextField cajaPtosLocal;
   private JTextField cajaPtosVisitante;
   private JDialog dialogo;
   private ClaseBBDD estaBBDD;
   
   // Constantes
   private final String TEMPORADA = "18/19";
   
   public DialogoInsertar(ClaseBBDD unaBBDD) {
   
      this.estaBBDD = unaBBDD;
      
      // Creamos y configuramos un JDialog
      dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      dialogo.setLocationRelativeTo(null);// dialogo al centro de la pantalla
      
      // Creamos una etiqueta y la asigna a la ventana principal   
      dialogo.add(BorderLayout.NORTH, new JLabel("AÑADIR PARTIDO"));
      
      // Creamos un contenedor para organizar la zona centro
      JPanel centro = new JPanel();
      centro.setLayout(new GridLayout(2, 4));
      centro.add(new JLabel("Equipo local: "));
      
      // TAREA 1:
      // Carga los desplegables equipoLocal y equipoVisitante con los equipos de la BBDD
      // Cargamos los equipos local como visitante en los desplegables en forma de array
      try{
         String[] arrayEquipos = estaBBDD.arrayEquipos();
         equipoLocal = new JComboBox<String>(arrayEquipos);
         equipoVisitante= new JComboBox<String>(arrayEquipos);
      }catch (SQLException excepcion) {
         JOptionPane.showMessageDialog(null, "Problemas al cargar los equipos: " + excepcion.getMessage());
      }
   
      centro.add(equipoLocal);
      centro.add(new JLabel("Puntos: "));
      cajaPtosLocal = new JTextField("0");
       // Creamos unobjeto de la clase Verificador y se lo añadimos  a la caja de texto con el método setInputVerifier
      cajaPtosLocal.setInputVerifier(new Verificador());
      centro.add(cajaPtosLocal);
      centro.add(new JLabel("Equipo Visitante: "));
      centro.add(equipoVisitante);
      centro.add(new JLabel("Puntos: "));
      cajaPtosVisitante = new JTextField("0");
      
      // Creamos unobjeto de la clase Verificador y se lo añadimos  a la caja de texto con el método setInputVerifier
      cajaPtosVisitante.setInputVerifier(new Verificador());
      centro.add(cajaPtosVisitante);
      
      dialogo.add(BorderLayout.CENTER, centro);
      
      // Creamos el botón y lo añadimos a la ventana principal
      JButton boton = new JButton("AÑADIR");
      boton.addActionListener(this);
      dialogo.add(BorderLayout.SOUTH, boton);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   @Override
   public void actionPerformed(ActionEvent evento) {
   
      // TAREA 2: Obtiene los datos introducidos e inserta el nuevo partido
      // La temporada siempre será la indicada en la constante correspondiente
     // Seleccionamos el nombre del equipo local
      String localSeleccionado = (String) equipoLocal.getSelectedItem();    
      
   // Seleccionamos el nombre del equipo visitante
      String visitanteSeleccionado = (String) equipoVisitante.getSelectedItem();    
   
   
   // Obtenemos los datos de las cajas y las pasamos a enteros
      String puntosL = cajaPtosLocal.getText();
    
      String puntosV = cajaPtosVisitante.getText();
    
      if( localSeleccionado.equals(visitanteSeleccionado)) {
         JOptionPane.showMessageDialog(null, "Los equipos no pueden ser los mismos.");
         return;
      }
   
      int ptosLocal =  Integer.parseInt(puntosL);
      int ptosVisitante =  Integer.parseInt(puntosV);
      try {
         if (estaBBDD.insertarPartido(localSeleccionado, visitanteSeleccionado, ptosLocal, ptosVisitante, TEMPORADA)) {
            JOptionPane.showMessageDialog(null, "Los datos se han introducido correctamente");
         } else {
            JOptionPane.showMessageDialog(null, "Error al introducir los datos");
         }
      } catch (SQLException excepcion) {
         JOptionPane.showMessageDialog(null, "Problemas con la BBDD: " + excepcion.getMessage());
      }
   
   }
   
   // Creamos una subclase de InputVerifier, para comprobar que se inserta un entero
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