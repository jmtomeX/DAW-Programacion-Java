import java.util.*;
import java.io.*;

public class CuentaTest {
   public static void main(String[] args) {
      
      Cuenta cuenta1 = new Cuenta(233, 111.11, "Silvia");
      Cuenta cuenta2 = new Cuenta(322, 555, "Aitor");
      Cuenta cuenta3 = new Cuenta(233, 222.22, "Silvia");
      if (!cuenta1.equals(cuenta2)) System.out.println("DIFERENTES");
      if (cuenta1.equals(cuenta3)) System.out.println("IGUALES");
   }
}