/*
   Ejemplo de ventana de dialogo
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dialogo08 implements ActionListener {
   
   //Atributos
   JTextField cajaTexto;
   JTextArea areaTexto;
   
   public Dialogo08() {
      
      // Creamos y configuramos un JDialog
      JDialog dialogo = new JDialog();
      dialogo.setLayout(new FlowLayout());
      
      
      // Creamos el formulario y lo añadimos a la ventana principal
      dialogo.add(new JLabel("Elige el fichero: "));
      cajaTexto = new JTextField(15);
      dialogo.add(cajaTexto);
      
      // Creamos el botón y lo añadimos a la ventana principal
      JButton boton = new JButton("ABRIR");
      boton.addActionListener(this);
      dialogo.add(boton);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   @Override
   public void actionPerformed(ActionEvent evento) {
      JOptionPane.showMessageDialog(null, "Vas a abrir un fichero");
   }
}