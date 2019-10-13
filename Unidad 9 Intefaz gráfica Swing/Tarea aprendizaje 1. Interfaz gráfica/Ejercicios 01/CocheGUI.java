/*
Escribe el código de una interfaz gráfica para que la ventana que se muestre sea la siguiente:

Ten en cuenta que:

    La ventana principal tiene un tamaño de 300 x 150, utiliza el BorderLayout y  cuando se cierra el programa acaba.
    Se crea un JPanel con GridLayout para organizar las etiquetas y las cajas de texto en la zona centro de la ventana principal.
    Las etiquetas se crean a partir de un array de String.
    El botón estará en la zona sur y la etiqueta "Vas a dar de alta..." en la zona norte.
    
    

*/

// Importamos las librerias necesarias
import java.awt.*;
import javax.swing.*;

public class CocheGUI {

   // Programa principal
   public static void main(String[] args) {
       
      String[] opciones = {"Marca: ", "Modelo: ", "Año: "};
      
      CocheGUI gui = new CocheGUI(opciones);
   }
   
   // Atributos
   JTextField[] cajasTexto;

   // Constructor
   public CocheGUI(String[] etiquetas) {
   
   // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("AÑADIR COCHE");
      ventana.setSize(300, 150);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(new BorderLayout());
      
   // Crea y configura la etiqueta de la zona norte
      JLabel etiqueta = new JLabel("Vas a dar de alta un nuevo coche");
      ventana.add(etiqueta, BorderLayout.NORTH);
      
      // Crea y configura la zona centro. Se leen las etiquetas del array etiquetas
      // Las cajas de texto se guardan en el array cajasTexto 
      JPanel centro = new JPanel(new GridLayout(3, 2));
      cajasTexto = new JTextField[etiquetas.length];
      for (int i = 0; i < etiquetas.length; i++) {
         String textoEtiqueta = etiquetas[i];
         centro.add(new JLabel(textoEtiqueta));
         cajasTexto[i] = new JTextField(10);
         centro.add(cajasTexto[i]);
      }
      ventana.add(centro, BorderLayout.CENTER);
      // Crea y configura el botón de la zona sur
      JButton boton = new JButton("CREAR");
      ventana.add(boton, BorderLayout.SOUTH);
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
}