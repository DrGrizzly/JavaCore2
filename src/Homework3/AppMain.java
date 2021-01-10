package Homework3;

import java.util.HashMap;

public class AppMain {
    private static String[] fruits = {"Яблоко", "Груша", "Мандарин", "Яблоко", "Персик",
                                      "Вишня", "Груша", "Банан", "Киви", "Абрикос"};

    private static HashMap<String, Integer> fruitHashMap = new HashMap<>();

    private static void fillHashMap(){
        for (String fruit : fruits) {
            int count = fruitHashMap.computeIfAbsent(fruit, cnt -> 0);
            fruitHashMap.put(fruit, ++count);
        }
    }

    private static void printUnique(){
        System.out.println("Вывод уникальных значений: ");
        //Вывод в консоль уникальных слов
        fruitHashMap.forEach((fruit, cnt) -> {
            if (cnt == 1) {
                System.out.println(fruit);
            }
        });
    }

    private static void printDuplicate(){
        //Вывод одинаковых слов с количеством совпадений
        fruitHashMap.forEach((fruit, cnt) -> {
            if (cnt > 1) {
                System.out.printf("Слово %s повторяется %d раз(а) %n", fruit, cnt);
            }
        });
    }

    public static void main(String[] args) {
        //Заполним список
        fillHashMap();
        printUnique();
        printDuplicate();
        //Задание 2
        PhoneDict phonebook = new PhoneDict();
        phonebook.add("Валера", "+79125503300");
        phonebook.add("Марина", "+79229880101");
        phonebook.add("Иван", "+79058501300");
        phonebook.add("Иван", "+79081001001");
        System.out.printf("Номер телефона Марины: %s %n", phonebook.get("Марина"));
        System.out.printf("Номер телефона Ивана: %s %n", phonebook.get("Иван"));
    }

}
