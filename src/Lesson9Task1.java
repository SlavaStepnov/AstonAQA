import java.util.Random;
import java.util.stream.IntStream;

public class Lesson9Task1 {
    public static void main(String[] args) {

        Random random = new Random();
        //количество случайных чисел
        int count = 10;

        //генерируем случайные числа и фильтруем только четные числа
        long evenCount = IntStream.generate(() -> random.nextInt(100) + 1)
                .limit(count)
                .filter(number -> number % 2 == 0)
                .count();

        System.out.println("Количество четных чисел: " + evenCount);
    }
}
