/*
 * Ejemplo de manejo de eventos de ratón
 */
import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;

public class EscuchaRaton extends JFrame implements MouseListener {

   // Programa principal
   public static void main(String[] args) {
      EscuchaRaton ventana = new EscuchaRaton();
      ventana.setTitle("Eventos de ratón");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.pack();
      ventana.setVisible(true);
   }

   // Atributos
   private JButton boton1;
   private JButton boton2;
   private JScrollPane scrollPane;
   private JTextArea areaTexto;

   // Constructor: crea nuevo marco miMarcoRaton
   //Definimos el JFrame
   public EscuchaRaton() {
      this.setLayout(new BorderLayout());
      addComponentes();
   
      // Registrar el oyente a los botones
      boton1.addMouseListener(this);
      boton2.addMouseListener(this);
   }
   
   // Creamos los componentes y los organizamos en el JFrame
   private void addComponentes() {
            
      JPanel norte = new JPanel(new FlowLayout());
      boton1 = new JButton("ACEPTAR");
      boton2 = new JButton("BOTON 2");
      norte.add(boton1);
      norte.add(boton2);
      this.add(norte, BorderLayout.NORTH);
      //al scroll se le añade el area de texto no al revés
      areaTexto = new JTextArea(10, 30);
      scrollPane = new JScrollPane(areaTexto);
      //Se le añade el scrollpane
      this.add(scrollPane, BorderLayout.CENTER);
   }

   // Desarrolla los métodos de la interfaz MouseListener
   // Se dejan en blanco el cuerpo de mouseEntered y de mouseExited
   //Se dejan abstractos para que no nos den error
   // No nos interesan en este ejemplo.

   public void mousePressed(MouseEvent e) {
      escribir("Botón de ratón pulsado", e) ;      
   }
   
   public void mouseReleased(MouseEvent e) {
      escribir("Botón de ratón liberado", e);
   }
   
   public void mouseEntered(MouseEvent e) {
   }
   
   public void mouseExited(MouseEvent e) {
   }
   
   public void mouseClicked(MouseEvent e) {
      escribir("Click en el botón del ratón", e);
   }

   // Escribir en el área de texto la descripción  que se recibe como parámetro
   void escribir(String texto, MouseEvent e) {
      areaTexto.append(texto + ".\n");
      
      // Comprobamos cuál de los dos botones es y lo escribimos
      JButton boton = (JButton) e.getSource();
      String nombre = boton.getText();
      if (nombre.equals(boton1.getText())) {
         areaTexto.append("Es el botón 1.\n");
      } else {
         areaTexto.append("Es el botón 2.\n");
      }
   }
}