/*
Crea la clase ComparadorArea para que implemente correctamente la interfaz Comparator y cuando se ejecute el siguiente código el
array se ordene según el área de los tríangulos, de menor a mayor y si el área es igual en función de la base también de menor a mayor:


 El resultado será:

[Triangulo(A321): 4.0 x 3.0, Triangulo(C321): 5.0 x 2.0, Triangulo(A123): 2.0 x 5.0, Triangulo(B123): 3.0 x 4.0]
[Triangulo(A123): 2.0 x 5.0, Triangulo(C321): 5.0 x 2.0, Triangulo(B123): 3.0 x 4.0, Triangulo(A321): 4.0 x 3.0]
*/

public class Triangulo {
   private String id;
   private double base;
   private double altura;
   
   public Triangulo(String id, double base, double altura) {
      this.id = id;
      this.base = base;
      this.altura = altura;
   }
   
   public String toString() {
      return "Triangulo(" + id + "): " + base + " x " + altura;
   }
   
   public double getArea() {
      return base * altura;
   }

   public double getBase() {
      return base;
   }
}

