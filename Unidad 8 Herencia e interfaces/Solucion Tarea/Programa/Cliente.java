/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2019
  Modulo:   Programación.
  UD:       UD8 Herencia e interfaces.
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa:   Definición de la clase Cliente
                              Gestionará el DNI y el nombre de un cliente
                                
*******************************************************************************************************************/

public class Cliente {
   
   // Atributos
   private String dni;
   private String nombre;
   
   // Constructores
   // Recibe un DNI y un nombre e inicializa los atributos de la clase.
   public Cliente(String dni, String nombre) {
      this.dni = dni;
      this.nombre = nombre;
   }
   
   // Constructor copia
   // Recibe un Cliente e inicializa los atributos de la clase mediante el constructor anterior.
   public Cliente(Cliente unCliente) {
      this(unCliente.dni, unCliente.nombre);
   }
   
   // Devuelve el DNI del cliente
   public String getDni() {
      return dni;
   }

   // Método toString. Sobreescribe el método heredado de la clase Object.
   // Devuelve los datos del cliente con el siguiente formato
   // dni (nombre)
   @Override
   public String toString() {
      return String.format("%s (%s)", dni, nombre);
   }
   
   // Método equals. Sobreescribe el método heredado de la clase Object.
   // Devuelve true si el objeto es un Cliente con el mismo nombre y DNI
   // false en caso contrario
   @Override   
   public boolean equals(Object objeto) {
      if (objeto instanceof Cliente) {
         Cliente unCliente = (Cliente) objeto;
         if (dni.equals(unCliente.dni) && nombre.equals(unCliente.nombre)) {
            return true;
         }
      }
      return false;
   }
}