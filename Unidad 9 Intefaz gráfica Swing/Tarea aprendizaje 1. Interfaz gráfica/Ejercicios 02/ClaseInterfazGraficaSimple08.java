/*
Modifica el código que se plantea para que la ventana que se muestre sea la siguiente:

Ten en cuenta que:

    La ventana principal tiene unas dimensiones de 300 x 100, se ubica en la posición 800 x 400 y cuando se cierra 
    el programa finaliza.
    Los nombres de las etiquetas se leen de un ArrayList de Strings.
    El layout que se utiliza es GridLayout.

*/
import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica
import java.util.*;

public class ClaseInterfazGraficaSimple08 {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      ArrayList<String> opciones = new ArrayList<String>();
      opciones.add("NUEVO");
      opciones.add("ABRIR");
      opciones.add("CERRAR");
      
      ClaseInterfazGraficaSimple08 gui = new ClaseInterfazGraficaSimple08(opciones);
   }

   // Constructor
   public ClaseInterfazGraficaSimple08(ArrayList<String> etiquetas) {
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("EJERCICIO 4");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLocation(800, 400);
      ventana.setSize(300, 100);
      ventana.setLayout(new GridLayout(1,3));
   
      // Crea y configura los componentes
      for (int i = 0; i < etiquetas.size(); i++) {
         JLabel etiqueta = new JLabel(etiquetas.get(i));
         ventana.add(etiqueta);
      }
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
}