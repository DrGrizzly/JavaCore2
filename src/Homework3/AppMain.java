package Homework3;

public class AppMain {
    String[] fruits = {"Яблоко", "Груша", "Мандарин", "Яблоко", "Персик",
                      "Вишня", "Груша", "Банан", "Киви", "Абрикос"};


    public static void main(String[] args) {

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
