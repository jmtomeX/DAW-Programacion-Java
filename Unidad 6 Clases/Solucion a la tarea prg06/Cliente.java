/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2018
  Modulo:   Programación.
  UD:       UD6 Clases.
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa:   Definición de la clase cliente
                              Tendrá el nombre y la dirección para poderle enviar la factura
                                
*******************************************************************************************************************/

public class Cliente {

   // Atributos
   private String nombre;
   private String calle;
   private String ciudad;
   private String provincia;
   private String codigoPostal;

   /*
      Constructor: crea la dirección postal.
      Parámetros: 
         nombre: nombre del destinatario
         calle: la calle
         ciudad: la ciudad
         provincia: la provincia
         codigoPostal: el código postal
   */
   public Cliente(String nombre, String calle, String ciudad, String provincia, String codigoPostal) {  
      this.nombre = nombre;
      this.calle = calle;
      this.ciudad = ciudad;
      this.provincia = provincia;
      this.codigoPostal = codigoPostal;
   }
   
   // Constructor copia
   // Usa la palabra reservada this como constructor y no necesita métodos get
   // Puede acceder directamente a los atributos de un Cliente
   public Cliente(Cliente unCliente) {  
      this(unCliente.nombre, unCliente.calle, unCliente.ciudad, unCliente.provincia, unCliente.codigoPostal);
   }
   
   // Método que devuelve el nombre del cliente
   public String getNombre() {
      return nombre;
   }

   /*
      Formatea la dirección para mostrarla por pantalla o guardarla en un fichero.
      Return:
         Cadena con la dirección formateada
   */
   public String toString() {  
      return nombre + "\n" + calle + "\n" + ciudad + ", " + provincia + " " + codigoPostal;
   }
}