package geometry;

public class Circle implements Calculation{
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void info() {
        System.out.println("Периметр круга : " + calculatePerimeter());
        System.out.println("Площадь круга : " + calculateArea());
        System.out.println("Цвет заливки : " + fillColor);
        System.out.println("Цвет границы : " + borderColor);
        System.out.println();
    }
}
