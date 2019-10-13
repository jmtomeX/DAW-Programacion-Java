 /***********************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  21/03/2019.
 Módulo:  Programación.
 Tarea:   PROG08 Tarea de evaluación 01. Realiza un programa en Java
 
 Descripción del programa:Esta tarea se centra en el desarrollo y uso de nuestras propias clases,
 aunque manejaremos también ArrayLists y ficheros. En este caso, trabajaremos aspectos más
 avanzados como la herencia, las clases abstractas, los interfaces o el polimorfísmo.
 
     
 Enlace aoutoevaluación: https://drive.google.com/file/d/1DTpnaF7Ut6mJGJ42pPfNhO1oqqZDy3DK/view?usp=sharing
     
*************************************************************************************************/ 

// Clase Cliente
// Solo hay que reescribir el método equals
// Devolverá true si es un Cliente con el mismo nombre y DNI
// false en caso contrario

public class Cliente {
   
   private  String dni;
   private  String nombre;
   
   public Cliente(String dni, String nombre) {
      this.dni = dni;
      this.nombre = nombre;
   }
   
   public Cliente() {
      dni = "";
      nombre = "";
   }
   public Cliente(Cliente otroCliente) {
      this(otroCliente.dni, otroCliente.nombre);
   }
   
   public String getDni() {
      return dni;
   }
   
   public String toString() {
      return String.format("%s (%s)", dni, nombre);
   }
   //método que sobreescribe equals
   @Override
   public boolean equals(Object obj){
      if(obj instanceof Cliente) {
         Cliente unCliente = (Cliente) obj;
         return  dni.equals(unCliente.dni) && nombre.equals(unCliente.nombre);
      }
      return false;
   }
}