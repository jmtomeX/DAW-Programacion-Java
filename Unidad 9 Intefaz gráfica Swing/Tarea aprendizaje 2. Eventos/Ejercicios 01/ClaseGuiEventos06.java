/*
Corrige el código que se plantea para que la ventana que se muestra sea interactiva:

Cuando se pulse un botón, se mostrará un mensaje indicando el botón que se ha pulsado 
de la siguiente manera:
"Seha pulsado MOSTRAR"
*/

import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica
import java.awt.event.*;   // Eventos


public class ClaseGuiEventos06  implements ActionListener {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      String[] opciones = {"AÑADIR", "MOSTRAR", "BORRAR", "SALIR"};
      
      ClaseGuiEventos06 gui = new ClaseGuiEventos06(opciones);
   }

   // Constructor
   public ClaseGuiEventos06(String[] botones) {
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("EJERCICIO 3");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(300, 300);
      ventana.setLocation(800, 400);
      ventana.setLayout(new GridLayout(2, 2));
   
      // Crea y configura los componentes
      for (int i = 0; i < botones.length; i++) {
         String texto = botones[i];
         JButton boton = new JButton(texto);
         ventana.add(boton);
         
         // REGISTRAR UN OBJETO DE LA CLASE OYENTE EN TODOS LOS BOTONES
         boton.addActionListener(this);
      }
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   // Implementamos la interfaz ActionListener. Sobreescribimos el método actionPerformed
   // Cuando se pulse un boton, se identificará el botón, se obtendrá su texto
   // y se abrirá un JOptionPane con el mensaje "Se ha pulsado textoBoton"

   @Override
   public void actionPerformed(ActionEvent evento) {
      Object objetoPulsado = evento.getSource();
      JButton botonPulsado = (JButton) objetoPulsado;
      String texto = botonPulsado.getText();
      JOptionPane.showMessageDialog(null, "Se ha pulsado " + texto);
   }
   
}