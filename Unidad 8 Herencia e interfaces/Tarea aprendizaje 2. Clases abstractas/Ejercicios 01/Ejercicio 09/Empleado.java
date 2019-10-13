public abstract class Empleado {
   private String nombre;
   private String numSeguridadSocial;
	
   public Empleado(String nombre, String numero) {
      this.nombre = nombre;
      numSeguridadSocial = numero;
   }
	
   abstract double salario();
	
   public String toString() {
      return nombre + " (" + numSeguridadSocial + ")";
   }
}