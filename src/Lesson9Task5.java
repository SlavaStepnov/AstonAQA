import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lesson9Task5 {
    public static void main(String[] args) {
        List<String> logins = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Введите логин : ");
            String login = sc.nextLine();
            //чтобы выйти из цикла, нужно передать пустую строку
            if (login.isEmpty()) {
                break;
            }

            logins.add(login);
        }

        List<String> filteredLogins = logins.stream()
                .filter(login -> login.startsWith("f"))
                .collect(Collectors.toList());

        System.out.println("Логины, начинающиеся на букву f:");
        for (String element : filteredLogins) {
            System.out.println(element);
        }
    }
}
