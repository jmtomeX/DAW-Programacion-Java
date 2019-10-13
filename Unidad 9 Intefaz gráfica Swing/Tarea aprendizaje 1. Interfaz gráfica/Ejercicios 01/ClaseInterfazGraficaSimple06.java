/*
Modifica el código que se plantea para que la ventana que se muestre sea la siguiente:

Ten en cuenta que:

    La ventana principal tiene unas dimensiones de 300 x 150, se ubica en la posición 600 x 200 y cuando se cierra
    el programa finaliza.
    Los nombres de las cajas de texto se leen del fichero colores.txt.
    El layout que se utiliza es GridLayout.

*/
import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica
import java.util.*;
import java.io.*;

public class ClaseInterfazGraficaSimple06 {

   // Se puede incluir el main en la clase
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("colores.txt"));
      
      ClaseInterfazGraficaSimple06 gui = new ClaseInterfazGraficaSimple06(leerFichero);
   }

   // Constructor
   public ClaseInterfazGraficaSimple06(Scanner leerDatos) {
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("EJERCICIO 5");
      ventana.setLocation(600, 200);
      ventana.setSize(300, 150);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(new GridLayout(3, 1));
   
      // Crea y configura los componentes
      
      while (leerDatos.hasNext()) {
         String color = leerDatos.next();
         JTextField cajaTexto = new JTextField(color);
         ventana.add(cajaTexto);
      }
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
}