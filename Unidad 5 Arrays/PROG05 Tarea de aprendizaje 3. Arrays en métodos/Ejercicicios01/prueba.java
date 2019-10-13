import java.util.*;
public class prueba {
   public static void main(String[] args) {     
      Scanner teclado = new Scanner(System.in);
      System.out.println("Menu\n1.Suma\n2.Resta\n3.Multiplica\n4.Divide");
      int  num = 0;
      double result = 0, num1 =45 , num2 = 54;
      
      num = teclado.nextInt();
      switch(num){
         case 1: result = num1 + num2;
            break;
         case 2: result = num1 - num2;
            break;
         case 3: result = num1 * num2;
            break;
         case 4: result = num1 / num2;
            break;
      }
      System.out.print(result);
   }
}