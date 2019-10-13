/*
Modifica el código que se plantea para que la ventana que se muestre sea la siguiente:

Ten en cuenta que:

    La ventana principal se ajusta al tamaño de los componentes, se ubica en la posición
     500 x 500 y cuando se cierra el programa finaliza.
    La caja de texto tiene un tamaño de 15 caracteres.
    El layout que se utiliza es BorderLayout: el botón se ubica en el sur, la etiqueta "Escribe un texto" en el oeste,
    la caja de texto en el centro y la etiqueta "Número de letras..." en el sur.

*/
import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica

public class ClaseInterfazGraficaSimple06 {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      ClaseInterfazGraficaSimple06 gui = new ClaseInterfazGraficaSimple06();
   }

   // Atributos
   private JFrame ventana;
   private JButton boton;
   private JLabel resultado;
   private JTextField texto;

   // Constructor
   public ClaseInterfazGraficaSimple06() {
   
      // Crea y configura la ventana principal
      ventana = new JFrame();
      ventana.setTitle("EJERCICIO 2");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLocation(500, 500);
      ventana.setLayout(new BorderLayout());
      
   
      // Crea y configura los componentes
      JLabel texto1 = new JLabel("Escribe un texto");
      ventana.add(texto1, BorderLayout.WEST);
      texto = new JTextField(15);
      ventana.add(texto, BorderLayout.CENTER);
   
      boton = new JButton();
      boton.setText("BOTON");
      ventana.add(boton, BorderLayout.NORTH);
   
      resultado = new JLabel("Número de letras del texto");
      ventana.add(resultado, BorderLayout.SOUTH);
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.pack();
      ventana.setVisible(true);
   }
}