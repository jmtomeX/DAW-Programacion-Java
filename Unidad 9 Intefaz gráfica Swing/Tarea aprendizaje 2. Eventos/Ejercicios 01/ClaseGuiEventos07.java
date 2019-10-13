/*
Corrige el código que se plantea para que la ventana que se muestra sea interactiva:

Cuando una caja de texto obtenga el foco, su fondo cambiará al color indicado y cuando lo pierda
volverá a ser blanco:

 En este caso, se implementará la interfaz FocusListener con los siguientes métodos:

    focusGained
    focusLost

Para modificar el color de fondo de una caja de texto se utilizará el método 
setBackground(Color.GREEN). Los colores se identifican mediante las constantes de la clase Color.
*/

import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica
import java.awt.event.*;   // Eventos
import java.util.*;
import java.io.*;

public class ClaseGuiEventos07 implements FocusListener {

   // Se puede incluir el main en la clase
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("colores.txt"));
      
      ClaseGuiEventos07 gui = new ClaseGuiEventos07(leerFichero);
   }

   // Constructor
   public ClaseGuiEventos07(Scanner leerDatos) {
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("EJERCICIO 7");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(300, 150);
      ventana.setLocation(600, 200);
      ventana.setLayout(new GridLayout(3, 1));
   
      // Crea y configura los componentes
      while (leerDatos.hasNext()) {
         String texto = leerDatos.next();
         JTextField cajaTexto = new JTextField(texto);
         ventana.add(cajaTexto);
         
         // REGISTRAR UN OBJETO DE LA CLASE OYENTE EN LAS CAJAS DE TEXTO
         cajaTexto.addFocusListener(this);
      }
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   // Desarrolla los métodos de la interfaz FocusListener
   
   // Cuando una caja de texto gane el foco de la ventana se cambiará el color de fondo por el indicado
   @Override
   public void focusGained(FocusEvent evento) {
      Object objetoFocus = evento.getSource();
      JTextField cajaTextoFocus = (JTextField) objetoFocus;
      String texto = cajaTextoFocus.getText();
      if (texto.equals("ROJO")) {
         cajaTextoFocus.setBackground(Color.RED);
         return;
      }
      if (texto.equals("VERDE")) {
         cajaTextoFocus.setBackground(Color.GREEN);
         return;
      }
      if (texto.equals("AZUL")) {
         cajaTextoFocus.setBackground(Color.BLUE);
         return;
      }
   }
   @Override
   // Cuando una caja de texto pierda el foco de la ventana su color de fondo volverá a ser blanco    
   public void focusLost(FocusEvent evento) {
      Object objetoFocus = evento.getSource();
      JTextField cajaTextoFocus = (JTextField) objetoFocus;
      String texto = cajaTextoFocus.getText();
      cajaTextoFocus.setBackground(Color.WHITE);   
   }
}