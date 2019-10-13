 /******************************************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  20/05/2019.
 Módulo:  Programación.
 Tarea:   PROG10 Tarea de evaluación 01. Realiza un programa en Java
  
 Descripción del programa:  Definición de la clase Jugador 
 Enlace auto evaluación: https://drive.google.com/file/d/1B-f7rbueBcQh2vEZqbSF6ue_lTb6AvzX/view?usp=sharing                              
                                
*******************************************************************************************************************/

public class Jugador {

   // ATRIBUTOS
   private int codigo;
   private String nombre;
   private String procedencia;
   private String altura;
   private int peso;
   private String posicion;
   private String equipo;
   
   // Constructor
   public Jugador(int codigo, String nombre, String procedencia, String altura, int peso, String posicion, String equipo) {
      this.codigo = codigo;
      this.nombre = nombre;
      this.procedencia = procedencia;
      this.altura = altura;
      this.peso = peso;
      this.posicion = posicion;
      this.equipo = equipo;
   }

   // Método toString
   @Override
   public String toString() {
      return nombre + " (" + equipo + ")";
   }
   
   // Métodos consultores
   public int getCodigo() {
      return codigo;
   }
   
   public String getNombre() {
      return nombre;
   }
   
   public String getAltura() {
      return altura;
   }
   
   public int getPeso() {
      return peso;
   }
   
   public String getPosicion() {
      return posicion;
   }
   
   public String getEquipo() {
      return equipo;
   }
}