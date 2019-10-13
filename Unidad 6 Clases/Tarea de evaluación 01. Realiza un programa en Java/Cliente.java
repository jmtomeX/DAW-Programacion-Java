// Clase Cliente

// Atributos
public class Cliente{
   private String nombre;
   private String calle;
   private String ciudad;
   private String provincia;
   private String codigoPostal;

// Constructores

   public Cliente(String nombre, String calle, String ciudad, String provincia, String codigoPostal){
      setNombre(nombre);
      setCalle(calle);
      setCiudad( ciudad); 
      setProvincia(provincia);
      setcodigoPostal(codigoPostal);
   }
   public Cliente(Cliente unCliente){
      this(unCliente.getNombre(), unCliente.getCalle(), unCliente.getCiudad(), unCliente.getProvincia(), unCliente.getcodigoPostal());
   }
   
// Métodos 
   public String getNombre(){
      return nombre;
   }
   public String getCalle(){
      return calle;
   }
   public String getCiudad(){
      return ciudad; 
   }
   public String getProvincia(){
      return provincia;
   }
   public String getcodigoPostal(){
      return codigoPostal;
   }
   
   public void setNombre (String nombre) {
      this.nombre = nombre;
   }
   public void setCalle (String calle) {
      this.calle = calle;
   }
   public void setCiudad(String ciudad) {
      this.ciudad = ciudad; 
   }
   public void setProvincia(String provincia) {
      this.provincia = provincia;
   }
   public void setcodigoPostal(String codigoPostal) {
      this.codigoPostal = codigoPostal;
   } 
// Formatea la dirección de la siguiente manera:
                     // nombre
                     // calle
                     // ciudad, provincia codigoPostal
   public String toString(){
      String formatoTexto = "";
      formatoTexto = nombre + "\n";
      formatoTexto += calle + "\n";
      formatoTexto += ciudad + ", " + provincia + " " +  codigoPostal + "\n";
      return formatoTexto;
   }                       
}
