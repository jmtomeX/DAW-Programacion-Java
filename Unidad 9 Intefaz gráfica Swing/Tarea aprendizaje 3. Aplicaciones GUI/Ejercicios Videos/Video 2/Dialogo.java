/*
   Ejemplo de ventana de dialogo
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dialogo implements ActionListener {
   
   //Atributos
   JTextField cajaTexto;
   JTextArea areaTexto;
   
   public Dialogo(JTextArea areaTexto) {
   
      this.areaTexto = areaTexto;
      
      // Creamos y configuramos un JDialog
      JDialog dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      dialogo.setSize(450, 260);
      // Creamos una etiqueta y la asigna a la ventana principal   
      dialogo.add(BorderLayout.NORTH, new JLabel("Mostrar registros"));
      JPanel centro = new JPanel();
      
      // Creamos el formulario y lo añadimos a la ventan principal
      centro.setLayout(new GridLayout(1, 2));
      centro.add(new JLabel("Elige un registro: "));
      cajaTexto = new JTextField();
      centro.add(cajaTexto);
      dialogo.add(BorderLayout.CENTER, centro);
      
      // Creamos el botón y lo añadimos a la ventana principal
      JPanel botonesPanel = new JPanel();
      botonesPanel.setLayout(new GridLayout(2,1 ));
     
      JButton boton = new JButton("MOSTRAR");
      boton.addActionListener(this);
      botonesPanel.add(boton);
      
      // Creamos el botón borrar
      JButton botonBorrar = new JButton("BORRAR");
      boton.addActionListener(this);
      botonesPanel.add(botonBorrar);
      
      
      dialogo.add(botonesPanel, BorderLayout.SOUTH);
      // Ajustamos la ventana a los componentes y la hacemos visible
     
      dialogo.setVisible(true);
   }
   
   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   @Override
   public void actionPerformed(ActionEvent evento) {
      String texto = cajaTexto.getText();
      JOptionPane.showMessageDialog(null, texto);
      areaTexto.append(texto + "\n");
      if(texto.equals("BORRAR")) {
      
      }
   }
}