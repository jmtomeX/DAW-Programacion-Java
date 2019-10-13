/*
Corrige el código que se plantea para que la ventana que se muestra sea interactiva:
Cuando se el ratón entre en una caja de texto su color cambiará por el indicado. Cuando salga, 
volverá a ponerse en blanco:
Se usará la interfaz MouseListener. Solo habrá que desarrollar los mouseEntered y mouseExited.
El color de las cajas de texto se cambiarán con el método setBackground.
*/
import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica
import java.util.*;
import java.io.*;
import java.awt.event.*;

public class ClaseColores implements MouseListener {

   // Se puede incluir el main en la clase
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("colores.txt"));
      
      ClaseColores gui = new ClaseColores(leerFichero);
   }

   // Constructor
   public ClaseColores(Scanner leerDatos) {
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("EJERCICIO");
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
         cajaTexto.addMouseListener(this);
      }
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   // Desarrolla los métodos de la interfaz MouseListener
   public void mousePressed(MouseEvent evento) {    
   }
   
   public void mouseReleased(MouseEvent evento) {
   
   }
   
   // Cuando se entre en una caja de texto, se identificará la caja y se le cambiará el color
   public void mouseEntered(MouseEvent evento) {
      Object objetoMouse = evento.getSource();
      JTextField cajaTextoMouse = (JTextField) objetoMouse;
      String texto = cajaTextoMouse.getText();
      if (texto.equals("ROJO")) {
         cajaTextoMouse.setBackground(Color.RED);
         return;
      }
      if (texto.equals("VERDE")) {
         cajaTextoMouse.setBackground(Color.GREEN);
         return;
      }
      if (texto.equals("AZUL")) {
         cajaTextoMouse.setBackground(Color.BLUE);
         return;
      }
   
   }
   
   // Cuando se salga de una caja de texto, se identificará la caja y se le cambiará el color
   public void mouseExited(MouseEvent evento) {
      Object objetoMouse = evento.getSource();
      JTextField cajaTextoMouse = (JTextField) objetoMouse;
      cajaTextoMouse.setBackground(Color.WHITE); 
   }
   
   public void mouseClicked(MouseEvent evento) {
   }
}