import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        List<String> numbers = phoneBook.get(lastName);
        if (numbers == null) {
            numbers = new ArrayList<>();
        }
        numbers.add(phoneNumber);
        phoneBook.put(lastName, numbers);
    }

    public List<String> get(String lastName) {
        List<String> numbers = phoneBook.get(lastName);
        if (numbers == null) {
            numbers = new ArrayList<>();
        }
        return numbers;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook1 = new PhoneBook();

        phoneBook1.add("Иванов", "1111111111");
        phoneBook1.add("Петров", "2222222222");
        phoneBook1.add("Сидоров", "3333333333");
        phoneBook1.add("Иванов", "4444444444");

        List<String> numbers1 = phoneBook1.get("Иванов");
        List<String> numbers2 = phoneBook1.get("Петров");
        List<String> numbers3 = phoneBook1.get("Кузнецов");

        System.out.println("Номера телефонов для фамилии Иванов:");
        for (String number : numbers1) {
            System.out.println(number);
        }

        System.out.println("Номера телефонов для фамилии Петров:");
        for (String number : numbers2) {
            System.out.println(number);
        }

        System.out.println("Номера телефонов для фамилии Кузнецов:");
        for (String number : numbers3) {
            System.out.println(number);
        }
    }
}
