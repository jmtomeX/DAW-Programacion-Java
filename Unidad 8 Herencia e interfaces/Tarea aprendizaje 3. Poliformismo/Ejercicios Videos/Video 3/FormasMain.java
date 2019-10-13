// Programa para estudiar la herencia y el polimorfismo en la POO

public class FormasMain {

   public static void main(String[] args) {
      
      // El polimorfismo también se aplica a los interfaces
      // Podemos crear un array de interfaces y llenarla con objetos de clases que implementan ese interfaz
      // Solo podremos usar los métodos de la interfaz
      FormaCalculable[] formas = new FormaCalculable[3];
      formas[0] = new Rectangulo(18, 18);
      formas[1] = new Triangulo(30, 30, 30);
      formas[2] = new Circulo(12);
      
      // Trabajamos con el array como si fueran elementos iguales
      // Según el objeto que elijamos se ejecutará el código que le corresponde
      // Para ejecutar métodos particulares de una clase tendremos que usar el casting
      for (int i = 0; i < formas.length; i++) {
         FormaCalculable unaForma = formas[i];
         System.out.printf("Area = %.2f, Perímetro = %.2f\n", formas[i].calcularArea(), formas[i].calcularPerimetro());
         System.out.println(formas[i]);
         
         // Si el objeto es un Circulo, usamos el casting para guadarlo como Circulo
         // Así podemos usar sus métodos
         if (formas[i] instanceof Circulo) {
            Circulo unCirculo = (Circulo) formas[i];
            System.out.println("CIRCULO");
            System.out.println("Radio: " + unCirculo.getRadio());
         }
         System.out.println();
      }
   }
}