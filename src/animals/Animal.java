package animals;

public class Animal {
    private static int animalCount;
    public Animal() {
        animalCount++;
    }

    public void run (int distance) {
        System.out.println("Животное пробежало " + distance + " метров");
    }

    public void swim (int distance) {
        System.out.println("Животное проплыло " + distance + " метров");
    }

    public static void printQuantityOfAnimals() {
        System.out.println("Количество животных : " + animalCount);
    }
}
