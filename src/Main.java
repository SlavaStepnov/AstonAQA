public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple(), 2);

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruit(new Orange(), 2);

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());

        System.out.println("Вес коробки яблок №1 : " + appleBox1.getWeight());
        System.out.println("Вес коробки яблок №2 : " + appleBox2.getWeight());
        System.out.println("Вес коробки апельсинов №1 : " + orangeBox1.getWeight());

        System.out.println("Сравнение коробок с яблоками №1 и апельсинами №1: " + appleBox1.compare(orangeBox1));
        System.out.println("Сравнение коробок яблок №1 и №2 : " + appleBox1.compare(appleBox2));

        appleBox1.moveFruits(appleBox2);

        System.out.println("Вес коробки яблок №1 после пересыпания: " + appleBox1.getWeight());
        System.out.println("Вес коробки яблок №2 после пересыпания: " + appleBox2.getWeight());
    }
}