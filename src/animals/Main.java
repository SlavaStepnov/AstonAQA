package animals;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Aleksey", 20);
        Cat cat2 = new Cat("Vova", 25);
        Animal animal1 = new Animal();
        Dog dog1 = new Dog("Bobik");


        animal1.run(30);
        cat1.run(201);
        cat2.run(200);
        dog1.run(500);
        dog1.run(501);
        cat1.swim(40);
        dog1.swim(5);
        dog1.swim(15);

        Animal.printQuantityOfAnimals();
        Cat.printQuantityOfCats();
        Dog.printQuantityOfDogs();

        System.out.println(); //переходим к миске и корму

        Cat[] cats = new Cat[4];
        cats[0] = cat1;
        cats[1] = cat2;
        cats[2] = new Cat("Oleg", 30);
        cats[3] = new Cat("Gennady", 25);

        Plate plate = new Plate();
        plate.increaseAmountOfFood(74);

        for (Cat cat : cats) {
            cat.eatFood(plate);
        }

        plate.info();

        for (Cat cat : cats) {
            cat.satietyInfo();
        }
    }
}
