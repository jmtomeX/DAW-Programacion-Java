// Importamos las librerias necesarias
import java.awt.*;
import javax.swing.*;

public class CirculoGUI {

   // Programa principal
   public static void main(String[] args) {
      String[] colores = {"Blanco", "Negro", "Azul", "Verde"}; 
      CirculoGUI gui = new CirculoGUI(colores);
   }
   /*
    Escribe el código de una interfaz gráfica para que la ventana que se muestre sea la siguiente:

    Ten en cuenta que:
    La ventana principal tendrá un tamaño de 400 x 150, utiliza BorderLayout y  cuando se cierra el programa acaba.
    Se crea un JPanel con FlowLayout para organizar las etiquetas, la caja de texto y el JComboBox en la zona centro.
    La caja de texto tendrá un tamaño de 10 caracteres.
    El botón se ubicará en la zona sur.

   */
   // COMPLETAR LA CLASE
   public CirculoGUI(String[] colores) {
   
   // Crea y configura la ventana princiopal
      JFrame ventana = new JFrame("ELEGIR CIRCULO");
      ventana.setSize(400, 150);
      ventana.setLayout(new BorderLayout());
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   
      JPanel panel = new JPanel(new FlowLayout());
      panel.add(new JLabel("Radio:"));
      panel.add(new JTextField(10));
   
      panel.add(new JLabel("Color: "));
      JComboBox color = new JComboBox<String>(colores);
      panel.add(color);
   
      ventana.add(panel, BorderLayout.CENTER);
      
      ventana.add(new JButton("BUSCAR"), BorderLayout.SOUTH);
      
      ventana.setVisible(true);
   }
}