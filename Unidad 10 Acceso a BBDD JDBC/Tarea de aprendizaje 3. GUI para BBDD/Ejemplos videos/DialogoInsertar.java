/*
   Ventana de dialogo para la opción insertar
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DialogoInsertar implements ActionListener {
   
   //Atributos
   JTextField cajaPais;
   JTextField cajaRegion;
   ClaseBBDD estaBBDD;
   
   // Constructor
   public DialogoInsertar(ClaseBBDD unaBBDD) {
      
      // Guardamos el objeto recibido como parámetro en el atributo estaBBDD
      // Será accesible desde cualquier método de esta ventana
      this.estaBBDD = unaBBDD;
      
      // Creamos y configuramos un JDialog
      JDialog dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      
      // Creamos una etiqueta y la asignamos a la zona norte de la ventana principal   
      dialogo.add(BorderLayout.NORTH, new JLabel("Insertar país"));
      JPanel centro = new JPanel();
      
      // Creamos un contenedor secundario para organizar los componeetes de la zona centro
      // Lo añadimos a la ventana principal
      centro.setLayout(new GridLayout(2, 2));
      centro.add(new JLabel("País: "));
      cajaPais = new JTextField(15);
      centro.add(cajaPais);
      centro.add(new JLabel("Región: "));
      cajaRegion = new JTextField(15);
      centro.add(cajaRegion);
      dialogo.add(BorderLayout.CENTER, centro);
      
      // Creamos un botón y lo añadimos a la ventana principal
      JButton boton = new JButton("INSERTAR");
      boton.addActionListener(this);            // Para que cuando se pulse se ejecute actionPerformed
      dialogo.add(BorderLayout.SOUTH, boton);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Cuando se pulse el botón se leerán los datos introducidos en las cajas de texto
   // Se realizará el INSERT y se avisará si hay problemas
   @Override
   public void actionPerformed(ActionEvent evento) {
   
      String pais = cajaPais.getText();
      String region = cajaRegion.getText();
      int idRegion = Integer.parseInt(region);
      String idPais = pais.substring(0, 2).toUpperCase();
          
      try {
         if (estaBBDD.insertarPais(idPais, pais, idRegion)) {
            JOptionPane.showMessageDialog(null, "Los datos se han introducido correctamente");
         } else {
            JOptionPane.showMessageDialog(null, "Error al introducir los datos");
         }
      } catch (SQLException excepcion) {
         JOptionPane.showMessageDialog(null, "Problemas con la BBDD: " + excepcion.getMessage());
      }
   }
}