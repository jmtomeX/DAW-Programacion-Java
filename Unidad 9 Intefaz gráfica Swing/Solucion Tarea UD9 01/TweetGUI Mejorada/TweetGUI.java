/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2019
  Modulo:   Programación.
  UD:       UD9 Interfaces gráficas (Swing).
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa: El programa trabajará con un objeto TweetBD que almacena información sobre tweets
      Para ello, proporcionará una interfaz gráfica que permitirá trabajar con esos tweets.
      Las opciones serán:
         1. Cargar fichero
         2. Añadir un tweet
         3. Borrar tweets
         4. Mostrar tweets
         5. Tweets anteriores
         6. Tweets de un tema
                                
*******************************************************************************************************************/
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// Definición de la clase TweetGUI que define la ventana principal de la aplicación
public class TweetGUI implements ActionListener {

   // Método principal. Lo incluimos en la clase principal
   public static void main(String[] args) {
      TweetGUI programa = new TweetGUI();
   }

   // Constantes
   private final int ADD = 0;
   private final int BORRAR = 1;
   private final int MOSTRAR = 2;
   
   // Array de 2 dimensiones. Array de arrays de String
   private final String[][] OPCIONES = {
      {"AÑADIR", "Cargar fichero", "Añadir un tweet"},
      {"BORRAR", "Borrar tweets de un usuario"}, 
      {"MOSTRAR", "Mostrar todos los tweets", "Mostrar los tweets más antiguos", "Mostrar los tweet que contienen una palabra"}
   };

   // Atributos: todos los componentes del interfaz gráfico
   private JFrame ventana;
   private JTextArea cajaTexto;
   private TweetBD unTweetBD;

   
   // Constructor de la ventana principal con los menús
   public TweetGUI () {
   
      ventana = new JFrame("Gestión de Tweets");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // MEJORAS al JFrame
      ventana.setLocationRelativeTo(null);// Ventana al centro de la pantalla
      ventana.setIconImage (new ImageIcon(getClass().getResource("icono.jpg")).getImage());  // Cambiar el logo de la ventana
         
      // Creamos la barra de menús y la asignamos a la ventana principal
      JMenuBar BarraMenu = crearBarraMenu();
      ventana.setJMenuBar(BarraMenu);
        
      // Creamos una caja de texto con scroll y la asignamos a la ventana principal
      // Mostramos la presentación del programa
      cajaTexto = new JTextArea();
      JScrollPane scrollPane = new JScrollPane(cajaTexto);
      mostrarPresentacion();
      ventana.add(scrollPane);
      
      // MEJORAS para el área de texto
      UIManager.put("TextArea.margin", new Insets(10, 10, 10, 10));     // Definimos un padding al area de texto
      Font fuente = new Font("Calibri", 3, 15);    // Creamos una fuente nueva para añadirla al area de texto
      cajaTexto.setFont(fuente);
      cajaTexto.setForeground(Color.WHITE);
      cajaTexto.setBackground(Color.BLACK);
      cajaTexto.setEditable(false);          // Para no dejar escribir
      // cajaTexto.setLineWrap(true);           // Para ajustar las líneas horizontalmente
      
      // Creamos el TweetBD
      unTweetBD = new TweetBD("Tweets del fichero");
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      ventana.pack();
      ventana.setVisible(true);
   }
   
   // Crea los diferentes menús de la ventana principal
   private JMenuBar crearBarraMenu() {
   
      // Creamos la barra de menús
      JMenuBar barraMenu = new JMenuBar();
       
      // Creamos los diferentes menús con sus opciones a partir de una array de 2 dimensiones
      for (int i = 0; i < OPCIONES.length; i++) {
         String tituloMenu = OPCIONES[i][0];
         JMenu menu = new JMenu(tituloMenu);
         barraMenu.add(menu);
         for (int j = 1; j < OPCIONES[i].length; j++) {
            String opcion = OPCIONES[i][j];
            JMenuItem opcionMenu = new JMenuItem(opcion);
            menu.add(opcionMenu);
            opcionMenu.addActionListener(this);  
         }
      }
     
      return barraMenu;
   }
   
   // Muestra la descripción del programa en el área de texto
   private void mostrarPresentacion() {
      String mensaje = "Este programa permite trabajar con una lista de tweets\n";
      mensaje += "Utiliza las clase Tweet y TweetBD\n";
      mensaje += "Lee tweets del fichero tweets.txt\n";
      mensaje += "Mediante un menú permite elegir diferentes opciones\n";
      mensaje += "Cuando se elige finalizar, muestra \"Fin del programa\"\n\n";
      cajaTexto.setText(mensaje);
   }  
   
   // Conecta con el fichero tweets.txt y carga los tweets en el atributo unTweetBD
   // Utiliza try-catch para gestionar las excepciones
   private void cargarDatos() {
      Scanner ficheroEntrada = null;
      try {
         ficheroEntrada = new Scanner(new File("tweets.txt"));
         unTweetBD.cargarTweets(ficheroEntrada);
         int size = unTweetBD.getNumeroTweets();
         String mensaje = "Se han leído " + size + " tweets\n\n";
         mensaje += "El tweet más reciente es:\n" + unTweetBD.TweetMasReciente() + "\n\n";
         cajaTexto.setText(mensaje);
      } catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Error al leer el fichero");
      }
      if (ficheroEntrada != null) {
         ficheroEntrada.close();
      }
   }
   
   // Identifica la opción que se ha pulsado y ejecuta la acción correspondiente
   public void actionPerformed(ActionEvent evento) {
   
      JMenuItem opcionPulsada = (JMenuItem) evento.getSource();
      String opcion = opcionPulsada.getText();
      
      if(opcion.equals(OPCIONES[ADD][1])) {                     // Opción "Cargar fichero"
         cargarDatos();
         ventana.pack();
         
      } else if(opcion.equals(OPCIONES[ADD][2])) {              // Opción "Añadir tweet"
         DialogoAdd dialogo = new DialogoAdd(unTweetBD);
         
      } else if(opcion.equals(OPCIONES[BORRAR][1])) {           // Opción "Borrar tweets"
         DialogoBorrar dialogo = new DialogoBorrar(unTweetBD);
         
      } else if(opcion.equals(OPCIONES[MOSTRAR][1])) {          // Opción "Mostrar tweets"
         String mensaje = unTweetBD.toString();
         cajaTexto.setText(mensaje);
         
         //MEJORA
         cajaTexto.setCaretPosition(0);               // Colocar el cursor al inicio del area de texto
         
      } else if(opcion.equals(OPCIONES[MOSTRAR][2])) {          // Opción "Mostrar anteriores"
         DialogoAnterioresCombo dialogo = new DialogoAnterioresCombo(unTweetBD, cajaTexto);
         
      } else if(opcion.equals(OPCIONES[MOSTRAR][3])) {          // Opción "Buscar tweets"
         String texto = JOptionPane.showInputDialog(null, "Palabra que quieres buscar: ");
         if (texto != null) {
            TweetBD resultados = unTweetBD.buscarTweets(texto);
            cajaTexto.setText(resultados.toString());
         }
      }
   }
}