/*
Crea la clase Loro a partir de la clase Ave para que cumpla las siguientes características:

1. Tendrá un atributo más de tipo String denominado region. Se deberá inicializar en el constructor a partir del valor
   indicado como parámetro.
2. El método trinar devolverá el siguiente texto: "HOLA Piopio HOLA"
3. Tendrá el método deDondeEs. No necesita parámetros y devolverá un String indicando la región de la que es el loro:
    - Si region es igual a "N" la región será "Norte"
    - Si region es igual a "S" la región será "Sur"
    - Si region es igual a "E" la región será "Este"
    - Si region es igual a "O" la región será "Oeste"
    - Para el resto de valores devolverá "Desconocido"
*/

public class Loro extends Ave {
   String region;

   public Loro(char sexo, int edad, String region) {
      super(sexo, edad);
      this.region = region;
   }
   public String trinar() {
      return "HOLA Piopio HOLA";
   }
   public String deDondeEs() {
      region = region.toUpperCase();
      switch(region) {
         case "N":
            return "Norte";
        
         case "S":
            return "Sur";
      
         case "E":
            return "Este";
      
         case "O":
            return "Oeste";
      
         default:
            return "Desconocido";
      }
   }
}