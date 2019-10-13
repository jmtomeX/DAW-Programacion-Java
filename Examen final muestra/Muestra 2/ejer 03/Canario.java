/*
Crea la clase Canario a partir de la clase Ave para que cumpla las siguientes características:

1. Tendrá un atributo más de tipo double denominado size. Se deberá inicializar en el constructor a partir del valor indicado como parámetro.
2. El método trinar mostrará por consola el siguiente texto: "Piopio - Piopio"
3. Tendrá el método tipoCanario. No necesita parámetros y devolverá un String indicando el tipo de canario:
    - Si size es mayor que 30 el tipo será "Grande"
    - Si size es mayor o igual que 15 y menor o igual a 30 el tipo será "Mediano"
    - Si size es menor que 15 el tipo será "Enano"
*/

public class Canario extends Ave {
   private double size;
   
   public Canario(char sexo, int edad, double size) {
      super(sexo, edad);
      this.size = size;
   }

   @Override
      public String trinar() {
      return "Piopio - Piopio";
   }
   
   public String tipoCanario() {
      String tipo = "Enano";
      if(size > 30) {
         tipo = "Grande";
      } else if(size >= 15) {
         tipo = "Mediano";
      }
      return tipo;
   }
}