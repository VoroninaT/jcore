package lesson4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"Those", "who", "cannot", "change", "their", "minds", "cannot", "change", "anything"};

        System.out.println();
        System.out.println("Задан массив строк:");
        System.out.println("===================");
        for (String str : arr1) {
            System.out.print(str + " ");
        }
        System.out.println();


        System.out.println();
        System.out.println("Подсчитано количество повторения каждого слова:");
        System.out.println("===============================================");
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String str1 : arr1) {
            wordsCount.put(str1, wordsCount.getOrDefault(str1, 0) + 1);
        }
        wordsCount.entrySet()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Список уникальных слов без повторов:");
        System.out.println("====================================");
        Set<String> unique = new HashSet<>(Arrays.asList(arr1));
        unique.forEach(System.out::println);

        System.out.println();

        // Task2

        Phonebook phonebook = new Phonebook();
        phonebook.addContact ("Иванов", "+7 900 800 70 10");
        phonebook.addContact("Иванов", "+7 900 800 70 20");
        phonebook.addContact("Петров", "+7 900 800 70 30");
        phonebook.addContact("Сидоров", "+7 900 800 70 40");


        String nameForSearch = "Иванов";

        System.out.println();
        System.out.println("Ищем телефоны по фамилии: " + nameForSearch);

        List<String> searchResult = phonebook.search(nameForSearch);

        System.out.println();
        System.out.println("Нашли: ");
        for (String phone : searchResult) {
            System.out.println(phone);
        }

        System.out.println();
    }


}
