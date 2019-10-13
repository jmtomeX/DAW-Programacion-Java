/*Escribe el código de una interfaz gráfica para que la ventana que se muestre sea la siguiente:

Ten en cuenta que:

    La ventana principal tendrá un tamaño de 400 x 150, utiliza BorderLayout y  cuando se cierra el programa acaba.
    Se crea un JPanel con FlowLayout para organizar las etiquetas, la caja de texto y el JComboBox en la zona centro.
    La caja de texto tendrá un tamaño de 10 caracteres.
    El botón se ubicará en la zona sur.
*/
import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica

public class CirculoGUI {

   // Programa principal
   public static void main(String[] args) {
      String[] colores = {"Blanco", "Negro", "azul", "Verde"}; 
      CirculoGUI gui = new CirculoGUI(colores);
   }
   
   // COMPLETAR LA CLASE

   // Atributos 
   JTextField radio;
   JComboBox<String> color;
    // Constructor 
   public CirculoGUI(String[] colores) {
    
    // Crea y configura la ventana principal
      JFrame ventana = new JFrame("ELEGIR CIRCULO");
      ventana.setSize(400, 150);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(new BorderLayout());
      
      JPanel panelCentral = new JPanel (new FlowLayout());
      // Se crea y configura la etiqueta y la caja de texto para el radio
      panelCentral.add(new JLabel("Radio:"));
      panelCentral.add(new JTextField(10));
      
      // Se crea y configura la etiqueta y el JComboBox para el color
      panelCentral.add(new JLabel("Color:"));
      color = new JComboBox<String>(colores);
      panelCentral.add(color);
      ventana.add(panelCentral, BorderLayout.CENTER);
      // Crea y configura los botones
      ventana.add(new JButton("BUSCAR"), BorderLayout.SOUTH);
      
      // Cuando se crea todo se visualiza
      ventana.setVisible(true);
   }
}