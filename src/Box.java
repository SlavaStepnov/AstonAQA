import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public float getWeight() {
        if(fruits.isEmpty()) return 0f;
        else
            return fruits.get(0).getWeight() * fruits.size();
    }
    /*
     могу так делать, потому что здесь жесткое условие
     на тип фруктов в коробке : вес любого элемента
     будет таким же как и у первого
     Можно было сделать более стандартно :

     public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }
    но мне кажется, что используемый вариант будет
    быстрее при большом количестве элементов ArrayList
    */

    public boolean compare(Box<?> boxToCompare) {
        return Math.abs(this.getWeight() - boxToCompare.getWeight()) < 0.0001;
    }

    public void moveFruits(Box<T> boxToMoveTo) {
        if (this == boxToMoveTo)
            System.out.println("Нельзя переложить из коробки в неё же");
        boxToMoveTo.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    //2 метода добавления для одного фрукта и для
    //заданного количества
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addFruit(T fruit, int amount) {
        for (int i = 0; i < amount; i++) {
            fruits.add(fruit);
        }
    }
}
