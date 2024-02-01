package geometry;

public class Triangle implements Calculation{
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        if (side1 + side2 > side3 &&
                side1 + side3 > side2 &&
                side2 + side3 > side1)  {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        } else System.out.println("Такого треугольника не существует");
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea() {
        double semiperimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - side1) *
                (semiperimeter - side2) * (semiperimeter - side3));
    }

    @Override
    public void info() {
        System.out.println("Периметр треугольника : " + calculatePerimeter());
        System.out.println("Площадь треугольника : " + calculateArea());
        System.out.println("Цвет заливки : " + fillColor);
        System.out.println("Цвет границы : " + borderColor);
        System.out.println();
    }
}
