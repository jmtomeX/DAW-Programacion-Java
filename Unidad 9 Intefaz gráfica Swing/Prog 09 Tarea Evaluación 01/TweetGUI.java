/**************************************************************************************************************************

  Nombre:  Jose Mari Tome Mejias.
 Fecha :  12/04/2019.
 Módulo:  Programación.
 Tarea:   PROG09 Tarea de evaluación 01. Realiza un programa en Java
  
  Descripción del programa: Lee una serie de tweets del fichero tweet.txt y los guarda en un objeto TweetBD,
                            las llevará a cabo mediante una interfaz gráfica.
                            En concreto, proporcionará un menú que permitirá trabajar con los tweets de un objeto TweetBD.

 Enlace auto evaluación: https://drive.google.com/file/d/1Gmgy4Odx7X0CJ19XLj4m0ftr2UVb5dR5/view?usp=sharing                            
                                
**************************************************************************************************************************/

import java.util.*;
import java.io.*;
import java.util.regex.*; // Para poder usar patrones
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // Para poder usar eventos

public class TweetGUI implements ActionListener {

   
   // Método principal
   // Es un resumen del programa
   public static void main(String[] args) throws FileNotFoundException {
      TweetBD estaTweetBD = new TweetBD("Tweets del fichero");   
      TweetGUI gui = new TweetGUI(estaTweetBD);
     
   
   }
   //Atributos 
   private JTextArea areaTexto;
   private TweetBD estaTweetBD;
   private  JFrame ventana;
   private JScrollPane scrollPane;
   
   //Constructor
   public TweetGUI(TweetBD unaTweetBD) {
      // Inicializamos el atributo unaTweetBD con la TweetBD indicada
      // Guardamos los datos sobre los que queremos trabajar en una variable de clase
      // para poder trabajar sobre ella desde cualquier método de la clase
      this.estaTweetBD = unaTweetBD;
         
      // Crea y configura la ventana principal
      ventana = new JFrame();   
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(450, 260);
      // colocamos el logo de twiter en la ventana principal en vez del de java
      ventana.setIconImage (new ImageIcon("icono.jpg").getImage());
      ventana.setTitle("Gestión de Tweets");
      
      // Centramos la ventana principal en el centro de la pantalla  
      // Se obtienen las dimensiones en pixels de la pantalla.
      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
      // Se obtienen las dimensiones en pixels de la ventana.
      Dimension dimensioVentana = ventana.getSize();
      // Un calculo para situar la ventana en el centro de la pantalla.
      ventana.setLocation((pantalla.width - dimensioVentana.width) / 2,(pantalla.height - dimensioVentana.height) / 2);
           
      // Crea la barra de menús. Se añade con setJMenuBar
      JMenuBar menus = crearMenuBar();
      ventana.setJMenuBar(menus);
     
      // Definimos un padding al area de texto
      UIManager.put("TextArea.margin", new Insets(10,10,10,10));
      
      // Crea la caja de texto y la añade a la ventana principal
      areaTexto = new JTextArea(intro());
      
      // Creamos una fuente nueva para añadirla al area de texto
      Font fuente = new Font("Calibri", 3, 15);
      areaTexto.setFont(fuente); 
      areaTexto.setForeground(Color.BLUE); 
      
      ventana.add(areaTexto);
      //Añadimos un sroll para poder ver todo el contenido
      scrollPane = new JScrollPane(areaTexto);
      ventana.add(scrollPane);
      
   // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   // Método para crear los menús devolverá una barra de menus con 3 menús
   private JMenuBar crearMenuBar() {
   
      // Para crear menús primero debemos crear una barra de menús (JMenuBar)
      JMenuBar barraMenu = new JMenuBar();
      
      // Creamos un menú y lo añadimos a la barra de menús MENÚ 1
      JMenu menu1 = new JMenu("AÑADIR");
      barraMenu.add(menu1);
      // Creamos 2 opciones para el menú y las añadimos
      // Registramos la clase oyente en cada opción
      String[] opcionesMenu1 = {"Cargar fichero", "Añadir un tweet"};
      for (int i = 0; i < opcionesMenu1.length; i++) {
         String opcion = opcionesMenu1[i];
         JMenuItem opcionMenu = new JMenuItem(opcion);
         menu1.add(opcionMenu);
         opcionMenu.addActionListener(this);
      }
   
      // Creamos otro menú MENÚ 2
      JMenu menu2 = new JMenu("BORRAR");      
      barraMenu.add(menu2);
      // Creamos la opción para el menú y la añadimos
      // Registramos la clase oyente al menú
      JMenuItem opcionMenu2 = new JMenuItem("Borrar tweets de un usuario");
      menu2.add(opcionMenu2);
      opcionMenu2.addActionListener(this);
      
   
   // Creamos otro menú MENÚ 3
      JMenu menu3 = new JMenu("MOSTRAR");      
      barraMenu.add(menu3);
      // Creamos 3 opciones para el menú y las añadimos
      // Registramos la clase oyente en cada opción
      String[] opcionesMenu3 = {"Mostrar todos los tweets", "Mostrar los tweets más antiguos", "Mostrar los tweets que contienen una palabra"};
      for (int i = 0; i < opcionesMenu3.length; i++) {
         String opcion = opcionesMenu3[i];
         JMenuItem opcionMenu3 = new JMenuItem(opcion);
         menu3.add(opcionMenu3);
         opcionMenu3.addActionListener(this);
      }
      return barraMenu;
   }

   // Implementamos la interfaz ActionListener
   @Override
    public void actionPerformed(ActionEvent evento) {
     
   // Identificamos la opción pulsada y la comparamos
      JMenuItem opcion = (JMenuItem) evento.getSource();
      String textoOpcion = opcion.getText();
      
      if (textoOpcion.equals("Cargar fichero")) {       
         Scanner ficheroEntrada = null;
        // Se utiza un try catch para las excepciones
         try {
            ficheroEntrada = new Scanner(new File("tweets.txt"));
         // Utiliza el método de la clase TweetBD para cargar los tweets
            estaTweetBD.cargarTweets(ficheroEntrada);
         } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error al leer el fichero");
         }
         if (ficheroEntrada != null) {
            ficheroEntrada. close();
         }
         
       // Se muestran los números de tweets y el más reciente.
       // Utiliza los métodos de la clase TweetBD para mostrar cuantos tweets se han leído y el más reciente
         String numeroTweets = Integer.toString(estaTweetBD.getNumeroTweets());
         areaTexto.append("Se han leído " + numeroTweets + " tweets\n\n");
         areaTexto.append(estaTweetBD.TweetMasReciente().toString());
         return;
      }
      
      // Mostramos todos los tweets, utiliza el método de la clase TweetBD 
      if (textoOpcion.equals("Mostrar todos los tweets")) {
         areaTexto.append(estaTweetBD.toString() + "\n");
         return;
      }  
      
      // Borramos los tweets del usuario seleccionado, utiliza el método de la clase TweetBD 
      if(textoOpcion.equals("Borrar tweets de un usuario")) {
         DialogoBorrarUsuario dialogoBorrar = new DialogoBorrarUsuario(estaTweetBD, areaTexto);
         return;
      }
      
      // Añadimos un Tweet nuevo a través de una ventana nueva con JDialog
      if(textoOpcion.equals("Añadir un tweet")) {
         DialogoAnhadirTweet dialogoAnhadir = new DialogoAnhadirTweet(estaTweetBD, areaTexto);
         return;
      }
      
      // Mostramos los tweets mas antiguos a partir del que seleccionamos a través de una ventana nueva con JDialog
      if(textoOpcion.equals("Mostrar los tweets más antiguos")) {
         DialogoTweetsAntiguos dialogoAntiguos = new DialogoTweetsAntiguos(estaTweetBD, areaTexto);
         return;
      }
    
       // Mostramos los tweets con una palabra que se insertará en una caja de texto
       // a través de una ventana nueva con JDialog, utiliza el método de la clase TweetBD 
      if(textoOpcion.equals("Mostrar los tweets que contienen una palabra")) {
         String palabra = JOptionPane.showInputDialog(null, "Palabra que quieres buscar: ");   
      // Con append añadimos al area de texto, ventana principal los tweets recogidos
         areaTexto.append("\n" + estaTweetBD.buscarTweets(palabra).toString() + "\n"); 
         return;
      }
   }
      
   // Método que devuelve un String con el intro del programa
   public String intro() {
      String cadena = "Este programa permite trabajar con una lista de tweets\nUtiliza la clase Tweet y TweetBD\n";
      cadena += "Lee tweets del fichero tweets.txt\nMediante un menu permite elegir diferentes opciones\n";
      cadena +="Cuando se elige finalizar, muestra \"Fin del programa\"\n\n";
      return cadena;
   }   
}
