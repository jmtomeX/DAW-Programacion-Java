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