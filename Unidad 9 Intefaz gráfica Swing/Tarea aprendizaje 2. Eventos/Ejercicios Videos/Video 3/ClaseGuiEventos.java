// Creamos una clase para la interfaz gráfica de nuestro programa
// Los componentes de la interfaz serán los atributos
// En el constructor se inicializarán todos esos componentes y se hará visible la ventana
// La clase implementa la interfaz ActionListener y la asigna a los componentes para detectar eventos ActionEvent
// y que se ejecute el código correspondiente
// El Oyente distingue que componente ha sido pulsado

import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica
import java.awt.event.*;   // Eventos

public class ClaseGuiEventos implements ActionListener {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      ClaseGuiEventos gui = new ClaseGuiEventos();
   }

   // Atributos
   private JFrame ventana;
   private JButton boton1;
   private JButton boton2;

   // Constructor
   public ClaseGuiEventos() {
   
      // Crea y configura la ventana principal
      ventana = new JFrame();   
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLocation(100, 50);
      ventana.setSize(300, 120);
      ventana.setTitle("UNA VENTANA");
      ventana.setLayout(new FlowLayout());
   
      // Crea y configura los componentes
      // Los asigna a la ventana principal
      boton1 = new JButton();
      boton1.setText("BOTON 1");
      boton1.setBackground(Color.BLUE);
      ventana.add(boton1);
           
      boton2 = new JButton();
      boton2.setText("BOTON 2");
      boton2.setBackground(Color.RED);
      ventana.add(boton2);
        
      // Asignamos el Oyente al boton1
      boton1.addActionListener(this);
      
      // Asignamos el Oyente al boton2
      boton2.addActionListener(this);
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   // Si ocurre el evento ActionEvent muestra un mensaje
   // Mediante el método getSource() identificamos que botón se ha pulsado
   // Estamos aprovechando el polimorfismo y deberemos usar el casting
   @Override
   public void actionPerformed(ActionEvent evento) {
      JButton boton = (JButton) evento.getSource();
      if (boton.getText().equals("BOTON 1")) {
         JOptionPane.showMessageDialog(null, "¡Se ha pulsado el botón 1!");
         return;
      }
      JOptionPane.showMessageDialog(null, "¡Se ha pulsado el botón 2!");
      
      // JOptionPane.showMessageDialog(null, "¡Se ha pulsado el " + boton.getText() + "!");
   }   
}