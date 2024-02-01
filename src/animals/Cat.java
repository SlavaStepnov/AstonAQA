package animals;

public class Cat extends Animal {
    private static int catCount;
    private String catName;
    private boolean satiety = false;
    private int needToEat;

    public Cat (String catName, int needToEat) {
        super();
        catCount++;
        this.catName = catName;
        this.needToEat = needToEat;
    }

    @Override
    public void run (int distance) {
        if (distance > 0 && distance <= 200) {
            System.out.println("Кот " + catName + " пробежал " + distance + " метров");
        }
        if (distance > 200)
            System.out.println("Кот " + catName + " пробежал 200 метров и устал");
    }

    @Override
    public void swim (int distance) {
        System.out.println("Коты не умеют плавать");
    }

    public static void printQuantityOfCats () {
        System.out.println("Количество котов : " + catCount);
    }

    public void eatFood (Plate plate) {
        if (satiety)
            System.out.println("Кот " + catName + " не голоден");
        else if (plate.getAmountOfFood() >= needToEat && satiety == false) {
            plate.decreaseAmountOfFood(needToEat);
            satiety = true;
            System.out.println("Кот " + catName + " поел "
                    + needToEat + " грамм корма");
        } else
            System.out.println("Кот " + catName + " не поел, потому что ему не хватило ");
    }

    public void satietyInfo () {
        if (satiety) System.out.println("Кот " + catName + " поел и больше не голоден");
        else System.out.println("Кот " + catName + " не поел и требует, чтобы его срочно покормили");
    }
}
