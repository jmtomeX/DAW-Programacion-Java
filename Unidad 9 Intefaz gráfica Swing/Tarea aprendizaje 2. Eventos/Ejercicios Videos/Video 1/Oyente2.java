// Cuando se pulsa sobre un componente se produce el evento ActionEvent
// y se ejecuta el método actionPerformed de la interfaz ActionListener. 
//
// Cuando creamos una clase que implementa la interfaz ActionListener y reescribimos su método
// Estamos definiendo lo que queremos que ocurra cuando se produzca el evento ActionEvent
// A esta clase se le llama clase oyente
//
// Luego habrá que conectar un objeto de esta clase con el componente concreto que nos interesa controlar
// Si lo conectamos con un botón, cuando se pulse ese botón se ejecutará este código
// Es lo mismo que hacíamos con la interfaz Comparator. Creabamos clases con diferentes comportamientos de orden 
// y cuando usabamos sort utilizabamos una o utro para ordenar de maneras distintas

import java.awt.event.*;   // Eventos
import javax.swing.*;      // Componentes

// Se crea una clase que tiene el comportamiento del interfaz ActionListener
// Se reescribe el método actionPerformed con el código que queremos que se ejecute cuando se pulse el componente
public class Oyente2 implements ActionListener {

   // Si ocurre el evento ActionEvent muestra un mensaje
   @Override
   public void actionPerformed(ActionEvent event) {
      JOptionPane.showMessageDialog(null, "¡Has pulsado el botón 2!");
   }
}