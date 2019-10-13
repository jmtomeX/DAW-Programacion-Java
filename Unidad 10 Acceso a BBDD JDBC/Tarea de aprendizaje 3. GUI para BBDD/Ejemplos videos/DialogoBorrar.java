/*
   Ventana de dialogo para la opción borrar
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class DialogoBorrar implements ActionListener {
   
   //Atributos
   ClaseBBDD estaBBDD;
   JDialog dialogo;
   JComboBox<Pais> paises;
   JTextField cajaId;
   JTextField cajaNombre;
   JTextField cajaRegion;
   JButton borrar;
   
   // Constructor
   public DialogoBorrar(ClaseBBDD unaBBDD) {
      
      // Guardamos el objeto recibido como parámetro en el atributo estaBBDD
      // Será accesible desde cualquier método de esta ventana
      this.estaBBDD = unaBBDD;
      
      // Creamos y configuramos un JDialog
      dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());

      // Creamos un contenedor para organizar la zona norte de la ventana principal
      JPanel norte = new JPanel(new FlowLayout());
      norte.add(new JLabel("País: "));
      
      // Cargamos los paises en el desplegable en forma de array
      // Implicitamente el JComboBox usará el método toString de la clase Pais para mostrar los paises
      try {
         Pais[] arrayPaises = estaBBDD.mostrarCountries();
         paises = new JComboBox<Pais>(arrayPaises);
      } catch (SQLException excepcion) {
         JOptionPane.showMessageDialog(null, "Problemas al cargar los paises: " + excepcion.getMessage());
      }
      paises.addActionListener(this);     // Para que cuando se pulse un país se ejecute actionPerformed
      norte.add(paises);
      dialogo.add(BorderLayout.NORTH, norte);
      
      // Creamos un contenedor para organizar la zona centro de la ventana principal
      JPanel centro = new JPanel(new GridLayout(3, 2));
      centro.add(new JLabel("Código: "));
      cajaId = new JTextField(15);
      centro.add(cajaId);
      centro.add(new JLabel("Nombre: "));
      cajaNombre = new JTextField(15);
      centro.add(cajaNombre);
      centro.add(new JLabel("Region: "));
      cajaRegion = new JTextField(15);
      centro.add(cajaRegion);
      dialogo.add(BorderLayout.CENTER, centro);
      
      // Creamos un botón y lo añadimos a la ventana principal
      borrar = new JButton("BORRAR");
      borrar.addActionListener(this);           // Para que cuando se pulse se ejecute actionPerformed
      dialogo.add(BorderLayout.SOUTH, borrar);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   // Si se pulsa el botón se intentará borrar el país
   // En caso contrario, se habrá pulsado el desplegable y se cargarán los datos del país en las cajas de texto
   @Override
   public void actionPerformed(ActionEvent evento) {
   
      Pais paisSeleccionado = (Pais) paises.getSelectedItem();
      String idPais = paisSeleccionado.getId();
      
      // Comprobamos si se ha pulsado el boton borrar
      if (evento.getSource() == borrar) {     
         try {
            if (estaBBDD.borrarPais(idPais)) {
               JOptionPane.showMessageDialog(null, "Los datos se han borrado correctamente");
            } else {
               JOptionPane.showMessageDialog(null, "Error al borrar los datos");
            }
         } catch (SQLException excepcion) {
            JOptionPane.showMessageDialog(null, "Problemas con la BBDD: " + excepcion.getMessage());
         }
         return;
      }
      
      // Cargamos los datos del país en las cajas de texto
      // Con un objeto Pais podemos usar todos los métodos de la clase Pais
      cajaId.setText(idPais);
      cajaNombre.setText(paisSeleccionado.getNombre());
      cajaRegion.setText("" + paisSeleccionado.getRegion());
   }
}