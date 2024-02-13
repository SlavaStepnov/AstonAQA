import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson9Task2 {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>(Arrays.asList("Highload", "High", "Load", "Highload"));

        //сколько раз "High" встречается в коллекции
        long count = collection.stream()
                .filter(str -> str.contains("High"))
                .count();
        System.out.println("Число вхождений High: " + count);

        //какой элемент в коллекции находится на первом месте
        String firstElement = collection.stream()
                .findFirst()
                .orElse("0");
        System.out.println("Первый элемент коллекции: " + firstElement);
    }
}
