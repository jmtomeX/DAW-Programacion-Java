// Programa con ejemplos de uso de return en los métodos
// Utiliza los métodos de la clase Math. Aplica la conversión de tipos o casting
// Crea y utiliza métodos con parámetros y return
// Trigonometría: areaRectangulo(), areaCirculo(), areaTriangulo()

public class EjemplosReturn {
   public static void main(String[] args) {
      // Calcula la potencia de un número elevado a otro
      //double resultado = Math.pow(2, 7);
      //System.out.println(resultado); 
      //System.out.println(Math.sqrt(34.6));              
      System.out.print("Área; " + redondear(areaCirculo(5)));
   }

    /*  // Calcula el área de una circulo a partir del radio
      System.out.println("Area del círculo: " + redondear(areaCirculo(5)));
      double radio = 2.4;
      double area = areaCirculo(radio);
      System.out.println("Area del círculo: " + redondear(area));
   
      // Calcula el área de un rectángulo a partir de su base y altura
      int areaRec = areaRectangulo(4, 6);
      System.out.println("Area del rectángulo = " + areaRec);
      System.out.println("Area del rectángulo = " + areaRectangulo(5, 2));
   
      // Calcula el área de un triangulo a partir de la base y la altura
      area = areaTriangulo(10, 4);
      System.out.println("Area del triángulo = " + area);
      double base = 5, altura = 2.4;
      System.out.println("Area del triángulo = " + redondear(areaTriangulo(base, altura)));
   }*/
   
   //Métodos
   
   // Calcula el área de una circulo a partir del radio
   public static double areaCirculo(double radio) {
      double area = Math.PI * radio * radio;
      
      return area;
   }
   
   // Redondea un número a 2 decimales
   public static double redondear (double num) {
      num = (double) Math.round(num * 100) / 100;
      return num;
   }
   /*
   // Calcula el área de una rectangulo a partir de 2 de sus lados
   public static int areaRectangulo (int base, int altura) {
      return base * altura;
   } 
   
   // Calcula el área de una triángulo a partir de la base y la altura
   public static double areaTriangulo (double base, double altura) {
      return base * altura / 2;
   }*/
}