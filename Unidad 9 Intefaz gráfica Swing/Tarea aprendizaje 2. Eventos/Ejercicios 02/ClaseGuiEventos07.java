/*
Corrige el código que se plantea para que la ventana que se muestra sea interactiva:

Cuando se pulse el botón "MAYUSCULAS" el texto pasará a muyúsculas y cuando se pulse "MINUSCULAS"
a minúsculas:
*/
import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica
import java.awt.event.*;  

public class ClaseGuiEventos07 implements ActionListener {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      
      ClaseGuiEventos07 gui = new ClaseGuiEventos07();
   }
   
   // Constantes
   String OPCION1 = "MAYUSCULAS";
   String OPCION2 = "MINUSCULAS";
   
   // Atributos
   JTextArea cajaTexto;

   // Constructor
   public ClaseGuiEventos07() {
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("EJERCICIO");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(new FlowLayout());
   
      // Crea y configura los componentes
      JLabel etiqueta = new JLabel("Escribe lo que quieras...");
      ventana.add(etiqueta, BorderLayout.NORTH);
      
      cajaTexto = new JTextArea(10, 50);
      ventana.add(cajaTexto, BorderLayout.CENTER);
      
      JButton boton1 = new JButton(OPCION1);
      ventana.add(boton1);
      
      // SE REGISTRA UN OBJETO DE LA CLASE OYENTE EN EL BOTON 1
      Oyente pulsarBoton1 = new Oyente();
      boton1.addActionListener(this);
      
      JButton boton2 = new JButton(OPCION2);
      ventana.add(boton2);
      
      // SE REGISTRA UN OBJETO DE LA CLASE OYENTE EN EL BOTON 2
      Oyente pulsarBoton2 = new Oyente();
      boton2.addActionListener(pulsarBoton2);
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.pack();
      ventana.setVisible(true);
   }
   
   // Implementamos la interfaz ActionListener para el botón 1. Sobreescribimos el método actionPerformed
   // Cuando se pulse el boton se pasará el texto escrito a mayúsculas
   @Override
   public void actionPerformed(ActionEvent evento) {
      String texto = cajaTexto.getText();
      texto = texto.toUpperCase();
      cajaTexto.setText(texto);
   }
   
   // Crear la clase Oyente para el botón 2
   // Se crea una clase que tiene el comportamiento del interfaz ActionListener
   // Cuando se pulse el boton se pasará el texto escrito a minúsculas
   private class Oyente implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent event) {
         String texto = cajaTexto.getText();
         texto = texto.toLowerCase();
         cajaTexto.setText(texto);
      }
   }
}