/*
Modifica el código que se plantea para que la ventana que se muestre sea la siguiente:

Ten en cuenta que:

    La ventana principal tiene unas dimensiones de 300 x 300, se ubica en la posición 800 x 400
    y cuando se cierra el programa finaliza.
    Los nombres de los botones se leen de un array de Strings.
    El layout que se utiliza es GridLayout.

*/

import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica

public class ClaseInterfazGraficaSimple3 {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      String[] opciones = {"AÑADIR", "MOSTRAR", "BORRAR", "SALIR"};
      
      ClaseInterfazGraficaSimple3 gui = new ClaseInterfazGraficaSimple3(opciones);
   }

   // Constructor
   public ClaseInterfazGraficaSimple3(String[] botones) {
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("EJERCICIO 3");
      ventana.setSize(300, 300);
      ventana.setLocation(800, 400);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(new GridLayout(2,2));
   
      // Crea y configura los componentes
      for (int i = 0; i < botones.length; i++) {
         JButton boton = new JButton(botones[i]);
         ventana.add(boton);
      }
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
}