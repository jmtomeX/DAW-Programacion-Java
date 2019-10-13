// Clase para la interfaz gráfica de nuestro programa

import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica

public class ClaseInterfazGraficaSimple {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      ClaseInterfazGraficaSimple gui = new ClaseInterfazGraficaSimple();
   }

   // Atributos
   private JFrame ventana;
   private JButton boton1;
   private JButton boton2;

   // Constructor
   public ClaseInterfazGraficaSimple() {
   
      // Crea y configura la ventana principal
      ventana = new JFrame();   
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLocation(100, 50);
      ventana.setSize(300, 120);
      ventana.setTitle("UNA VENTANA");
      ventana.setLayout(new FlowLayout());
   
      // Crea y configura los componentes
      boton1 = new JButton();
      boton1.setText("BOTON 1");
      boton1.setBackground(Color.BLUE);
      ventana.add(boton1);
      
      // Crea objeto Oyente que define lo que se hará cuando se genere un evento ActionEvent
      Oyente pulsarBoton1 = new Oyente();
      Oyente2 pulsarBoton2 = new Oyente2();
      // Se asigna para que se ejecute solo cuando se pulse el botón 1
      boton1.addActionListener(pulsarBoton1);
           
      boton2 = new JButton();
      boton2.setText("BOTON 2");
      boton2.setBackground(Color.RED);
      ventana.add(boton2);
      
      // Se asigna para que se ejecute también cuando se pulse el botón 2
      boton2.addActionListener(pulsarBoton2);
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }   
}