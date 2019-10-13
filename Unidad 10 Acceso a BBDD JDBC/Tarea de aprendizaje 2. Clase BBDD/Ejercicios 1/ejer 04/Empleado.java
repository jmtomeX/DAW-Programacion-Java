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

   // Método toString
   @Override
   public String toString() {
      return String.format("%-6d%-25s%-4d%-4d%-25s%s", codigo, nombre, hijos, retencion, cuenta, fecha);
   }
}