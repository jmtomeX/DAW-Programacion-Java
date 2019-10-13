/*
Añade el código necesario para que la ventana que se muestra sea interactiva:
Cuando se pulse el botón se pedirá el radio de un círculo:
y se cálculará el perímetro:
*/
import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica
import java.awt.event.*;    // Eventos

public class ClaseGuiEventos09 implements ActionListener {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      
      ClaseGuiEventos09 gui = new ClaseGuiEventos09();
   }
   
   // Constructor
   public ClaseGuiEventos09() {
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("EJERCICIO");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLocation(800, 400);
      ventana.setLayout(new BorderLayout());
   
      // Crea y configura los componentes
      JLabel etiqueta = new JLabel("Comprueba lo que hace el boton");
      ventana.add(etiqueta, BorderLayout.NORTH);
      JButton boton = new JButton("PULSAR");
      ventana.add(boton, BorderLayout.SOUTH);
         
      // REGISTRAR UN OBJETO DE LA CLASE OYENTE EN EL BOTON
      boton.addActionListener(this);
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.pack();
      ventana.setVisible(true);
   }
   
   // IMPLEMENTAR LA INTERFAZ ActionListener. SOBREESCRIBIR EL METODO actionPerformed
   @Override
   public void actionPerformed(ActionEvent evento) {
      double radio;
      radio = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce el radio de un circulo"));
      double perimetro =Math.round(2 * Math.PI * radio);
      JOptionPane.showMessageDialog(null,  String.format("Perímetro: %.1f", perimetro)); 
   }
}