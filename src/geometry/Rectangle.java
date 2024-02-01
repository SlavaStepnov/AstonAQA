package geometry;

public class Rectangle implements Calculation {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }


    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public void info() {
        System.out.println("Периметр прямоугольника : " + calculatePerimeter());
        System.out.println("Площадь прямоугольника : " + calculateArea());
        System.out.println("Цвет заливки : " + fillColor);
        System.out.println("Цвет границы : " + borderColor);
        System.out.println();
    }
}
