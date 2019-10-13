public class Empleado {

   // ATRIBUTOS
   int codigo;
   String nombre;
   int hijos;
   int retencion;
   String cuenta;
   String fecha;
   
   // Constructor
   public Empleado (int codigo, String nombre, int hijos, int retencion, String cuenta, String fecha) {
      this.codigo = codigo;
      this.nombre = nombre;
      this.hijos = hijos;
      this.retencion = retencion;
      this.cuenta = cuenta;
      this.fecha = fecha;
   }
   
   // Consultores
   public String getNombre() {
      return nombre;
   }
   
   public String getCuenta() {
      return cuenta;
   }
   
   public int getHijos() {
      return hijos;
   }
   
   public int getRetencion() {
      return retencion;
   }
   
   
   // Método toString
   @Override
   public String toString() {
      return nombre + " (" + codigo + ")";
   }
}