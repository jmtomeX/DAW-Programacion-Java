import java.util.*;

public class Main {
   public static void main(String[] args) {
      ArrayList<Animal> animales = new ArrayList<Animal>();
      animales.add(new Mamifero());
      animales.add(new Animal());
      animales.add(1, new Reptil());
      animales.add(new Perro());

      for (Animal unAnimal : animales) {
         System.out.println(unAnimal);
         unAnimal.metodo2();
         unAnimal.metodo1();
      }
   }
}