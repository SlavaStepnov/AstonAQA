package geometry;

public class Main {
    public static void main(String[] args) {

        //Как в этой задаче реализовать дефолтные методы
        //я не понял, поэтому без них

        Circle circle = new Circle(5, "Белый", "Черный");
        circle.info();

        Rectangle rectangle = new Rectangle(2, 3, "Красный", "Синий");
        rectangle.info();

        Triangle triangle = new Triangle(3,4,5,"Фиолетовый","Оранжевый");
        triangle.info();
    }
}
