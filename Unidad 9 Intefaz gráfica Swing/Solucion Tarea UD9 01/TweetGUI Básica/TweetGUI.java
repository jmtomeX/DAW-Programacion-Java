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
   private final String[] MENUS = {"AÑADIR", "BORRAR", "MOSTRAR"};
   private final String[] OPCIONES_ADD = {"Cargar fichero", "Añadir un tweet"};
   private final String[] OPCIONES_BORRAR = {"Borrar tweets de un usuario"};
   private final String[] OPCIONES_MOSTRAR = {"Mostrar todos los tweets", "Mostrar los tweets más antiguos", "Mostrar los tweet que contienen una palabra"};

   // Atributos: todos los componentes del interfaz gráfico
   private JFrame ventana;
   private JTextArea cajaTexto;
   private TweetBD unTweetBD;

   
   // Constructor de la ventana principal con los menús
   public TweetGUI () {
   
      ventana = new JFrame("Gestión de Tweets");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      // Creamos la barra de menús y la asignamos a la ventana principal
      JMenuBar BarraMenu = crearBarraMenu();
      ventana.setJMenuBar(BarraMenu);
        
      // Creamos una caja de texto con scroll y la asignamos a la ventana principal
      // Mostramos la presentación del programa
      cajaTexto = new JTextArea();
      JScrollPane scrollPane = new JScrollPane(cajaTexto);
      mostrarPresentacion();
      ventana.add(scrollPane);
      
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
       
      // Creamos los diferentes menús y los guardamos en un array
      JMenu[] menus = new JMenu[MENUS.length];
      for (int i = 0; i < menus.length; i++) {
         menus[i] = new JMenu(MENUS[i]);
         barraMenu.add(menus[i]);
      }
      
      // Creamos los items para cada submenú        
      // Las opciones las leemos de los diferentes arrays
      crearSubmenu(menus[0], OPCIONES_ADD);
      crearSubmenu(menus[1], OPCIONES_BORRAR);
      crearSubmenu(menus[2], OPCIONES_MOSTRAR);
     
      return barraMenu;
   }
   
   // Crea las opciones de un menú a partir de las cadenas de caracteres de un array
   // Parámetros:
   //    JMenu menu: menu cuyas opciones se van a crear
   //    String[] opciones: distintas opciones del menú
   private void crearSubmenu(JMenu menu, String[] opciones) {
      for ( int i = 0; i < opciones.length; i++) {
         String opcion = opciones[i];
         JMenuItem opcionMenu = new JMenuItem(opcion);
         menu.add(opcionMenu);
         opcionMenu.addActionListener(this);                     
      }
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
      
      if(opcion.equals(OPCIONES_ADD[0])) {                     // Opción "Cargar fichero"
         cargarDatos();
         ventana.pack();
         
      } else if(opcion.equals(OPCIONES_ADD[1])) {              // Opción "Añadir tweet"
         DialogoAdd dialogo = new DialogoAdd(unTweetBD);
         
      } else if(opcion.equals(OPCIONES_BORRAR[0])) {           // Opción "Borrar tweets"
         DialogoBorrar dialogo = new DialogoBorrar(unTweetBD);
         
      } else if(opcion.equals(OPCIONES_MOSTRAR[0])) {          // Opción "Mostrar tweets"
         String mensaje = unTweetBD.toString();
         cajaTexto.setText(mensaje);
         
      } else if(opcion.equals(OPCIONES_MOSTRAR[1])) {          // Opción "Mostrar anteriores"
         DialogoAnterioresCombo dialogo = new DialogoAnterioresCombo(unTweetBD, cajaTexto);
         
      } else if(opcion.equals(OPCIONES_MOSTRAR[2])) {          // Opción "Buscar tweets"
         String texto = JOptionPane.showInputDialog(null, "Palabra que quieres buscar: ");
         if (texto != null) {
            TweetBD resultados = unTweetBD.buscarTweets(texto);
            cajaTexto.setText(resultados.toString());
         }
      }
   }
}