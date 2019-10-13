public class Empleado {
	private String nombre;
	private String numSeguridadSocial;
	
	public Empleado(String nombre, String numero) {
		this.nombre = nombre;
		numSeguridadSocial = numero;
	}
	
	public String toString() {
		return nombre + " (" + numSeguridadSocial + ")";
	}
   
    public boolean equals(Object objeto) {
      if (objeto instanceof Empleado) {
         Empleado unEmpleado = (Empleado) objeto;
         if (nombre.equals(unEmpleado.nombre) && numSeguridadSocial.equals(unEmpleado.numSeguridadSocial)) {
            return true;
         }
      }
      return false;
    }
}