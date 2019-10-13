/*
Ejercicio 05

Modifica el código que se plantea para que la ventana que se muestre sea la siguiente:

Ten en cuenta que:

    La ventana principal utiliza el BorderLayout.
    Se crea un JPanel con GridLayout para organizar todos los botones en la zona sur de la ventana principal.
    La etiqueta "Escribe los que quieras..."  estará en la zona norte y el área de texto en la zona central.

*/

import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica

public class ClaseInterfazGraficaSimple {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      String[] opciones = {"MAYUSCULAS", "MINUSCULAS", "NEGRITA",};
      
      ClaseInterfazGraficaSimple gui = new ClaseInterfazGraficaSimple(opciones);
   }
   
   //Atributos
   JTextArea cajaTexto;
   JPanel panelBotones;

   // Constructor
   public ClaseInterfazGraficaSimple(String[] botones) {
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("EJERCICIO");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(new BorderLayout());
   
      // Crea y configura los componentes
      JLabel etiqueta = new JLabel("Escribe lo que quieras...");
      ventana.add(etiqueta, BorderLayout.NORTH);
      
      cajaTexto = new JTextArea(10, 50);
      ventana.add(cajaTexto, BorderLayout.CENTER);
      
      panelBotones = new JPanel(new GridLayout(1, 3));
      ventana.add(panelBotones, BorderLayout.SOUTH);
      for (int i = 0; i < botones.length; i++) {
         String texto = botones[i];
         JButton boton = new JButton(texto);
         panelBotones.add(boton);
      }
      ventana.add(panelBotones, BorderLayout.SOUTH);
      // Al final. Cuando se haya creado todo se visualiza
      ventana.pack();
      ventana.setVisible(true);
   }
}