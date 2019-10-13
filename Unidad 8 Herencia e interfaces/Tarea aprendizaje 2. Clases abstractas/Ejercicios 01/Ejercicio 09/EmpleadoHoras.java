/*
Crea la clase EmpleadoHorasa partir de la clase Empleado para que cumpla las siguientes características:

1. Tendrá 2 atributos más. El primero será de tipo doble y se denomina pagaHora el segundo será un int y se denominará horas.
 pagaHora se deberá inicializar en el constructor a partir del valore indicado como parámetro. horas se inicializará a 0 también
 en el constructor.
2. El método salario devolverá el resultado de la siguiente operación: horas * pagaHoras siempre que las horas trabajadas
sean menor o igual que 40. Si se trabja más de 40 horas, las horas extra se pagarán a 1.5 * pagaHora.
En estos casos el resultado será: 40 * pagaHoras + (horas - 40) * pagaHoras * 1.5
3. El método toString devolverá el siguiente texto: nombre (numSeguridadSocial) Paga/hora: pagaHora Horas: horas.
La paga por hora se mostrará con un decimales.
4. Se añadirá el método addHoras al que se le pasará un entero con el número de horas trabajadas y se las añadirá al atributo horas.

*/

//======>>>>>>> https://www.abrirllave.com/java/clases-abstractas.php
public class EmpleadoHoras extends Empleado {
    
   private double pagaHora;
   private int horas;
   
   public EmpleadoHoras(String nombre, String numero, double pagaHora) {
      super(nombre, numero);
      this.pagaHora = pagaHora;
      horas = 0;
   }
   
   public void addHoras(int horas) {
      this.horas += horas;
   }
	
   public double salario() {
      
      if (horas < 40) {		
         return pagaHora * horas;
      }
      return pagaHora * 40 + pagaHora * (horas - 40) * 1.5;
   }
	
   public String toString(){
      return super.toString() + String.format(" Paga/hora: %.1f Horas: %d", pagaHora, horas);
   }
}
