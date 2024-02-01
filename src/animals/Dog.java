package animals;

public class Dog extends Animal {
    private static int dogCount;
    private String dogName;

    public Dog(String dogName) {
        super();
        dogCount++;
        this.dogName = dogName;
    }

    @Override
    public void run(int distance) {
        if (distance > 0 && distance <= 500) {
            System.out.println("Пёс " + dogName + " пробежал " + distance + " метров");
        }
        if (distance > 500)
            System.out.println("Пёс " + dogName + " пробежал 500 метров и устал");
    }

    @Override
    public void swim(int distance) {
        if (distance > 0 && distance <= 10) {
            System.out.println("Пёс " + dogName + " проплыл " + distance + " метров");
        }
        if (distance > 10)
            System.out.println("Пёс " + dogName + " проплыл 10 метров и вылез на берег");
    }

    public static void printQuantityOfDogs() {
        System.out.println("Количество собак : " + dogCount);
    }
}
