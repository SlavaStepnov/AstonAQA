package animals;

public class Plate {
    private int amountOfFood;

    public void increaseAmountOfFood (int amountOfFood) {
        this.amountOfFood += amountOfFood;
    }

    public void decreaseAmountOfFood (int amountToDecrease) {
        amountOfFood -= amountToDecrease;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public void info() {
        System.out.println();
        System.out.println("Количество еды в миске : " + amountOfFood);
        System.out.println();
    }
}
