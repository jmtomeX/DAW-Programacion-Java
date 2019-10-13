/*
Corrige el código que se plantea para que la ventana que se muestra sea interactiva:

Una vez introducido un texto, cuando se pulse el botón, se obtendrá el número de letras:
*/
import java.awt.*;            // Componentes de dibujo
import javax.swing.*;         // Componentes de una interfaz gráfica
import java.awt.event.*;

public class ClaseGuiEventos06 implements ActionListener {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      ClaseGuiEventos06 gui = new ClaseGuiEventos06();
   }

   // Atributos
   private JFrame ventana;
   private JButton boton;
   private JLabel resultado;
   private JTextField texto;

   // Constructor
   public ClaseGuiEventos06() {
   
      // Crea y configura la ventana principal
      ventana = new JFrame();
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLocation(500, 500);
      ventana.setTitle("EJERCICIO 2");
      ventana.setLayout(new BorderLayout());
   
      // Crea y configura los componentes
      ventana.add(new JLabel("Escribe un texto"), BorderLayout.WEST);
      texto = new JTextField(15);
      ventana.add(texto, BorderLayout.CENTER);
   
      boton = new JButton();
      boton.setText("CONTAR");
      ventana.add(boton, BorderLayout.NORTH);
      
      // REGISTRAR UN OBJETO DE LA CLASE OYENTE EN EL BOTON
      boton.addActionListener(this);
   
      resultado = new JLabel("Número de letras del texto");
      ventana.add(resultado, BorderLayout.SOUTH);
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.pack();
      ventana.setVisible(true);
   }
   
   // Implementamos la interfaz ActionListener. Sobreescribimos el método actionPerformed
   // Leemos el texto introducido en la caja de texto, obtenemos el número de letras
   // y lo mostramos en la etiqueta resultado
   @Override
   public void actionPerformed(ActionEvent evento) {
      String textoIntroducido = texto.getText();
      int longString = textoIntroducido.length();
      resultado.setText("Número de letras: " + longString);
   }
}