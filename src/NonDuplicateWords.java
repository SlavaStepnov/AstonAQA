import java.util.*;

public class NonDuplicateWords {
    public static void main(String[] args) {
        String[] words = {"red", "blue", "orange", "red", "white",
                          "blue", "black", "orange", "green", "red",
                          "white", "black", "orange", "blue", "red"};

        //находим уникальные слова и выводим их в консоль
        Set<String> uniqueWords = new HashSet<>();
        for (String w : words) {
            uniqueWords.add(w);
        }

        for (String word : uniqueWords) {
            System.out.println(word);
        }

        //считаем повторения
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                wordCount.put(word, count + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        //выводим слова и их количество
        for (String word : wordCount.keySet()) {
            int count = wordCount.get(word);
            System.out.println(word + ": " + count);
        }
    }
}
