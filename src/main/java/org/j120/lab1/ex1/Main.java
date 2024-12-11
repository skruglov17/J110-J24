package src.main.java.org.j120.lab1.ex1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {

        PhoneNumber phoneNumber1 = new PhoneNumber("981", "0234567"),
                phoneNumber2 = new PhoneNumber("981", "0123456"),
                phoneNumber3 = new PhoneNumber("7890", "012345"),
                phoneNumber4 = new PhoneNumber("7890", "012345");


        System.out.println("Выведем наши номера");
        System.out.println(phoneNumber1);
        System.out.println(phoneNumber2);
        System.out.println(phoneNumber3);
        System.out.println(phoneNumber4);
        System.out.println();

        System.out.println("Создадим Сет и выведем её с проверкой добавления существующих объектов");
        Set<PhoneNumber> phoneNumbers = new HashSet<>();
        phoneNumbers.add(phoneNumber1);
        phoneNumbers.add(phoneNumber1);
        phoneNumbers.add(phoneNumber2);
        phoneNumbers.add(phoneNumber2);
        phoneNumbers.add(phoneNumber3);
        phoneNumbers.add(phoneNumber3);
        phoneNumbers.add(phoneNumber4);
        phoneNumbers.add(phoneNumber4);
        for (PhoneNumber phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
        System.out.println();

        System.out.println("Создадим ХэшМап и выведем её с проверкой добавления существующих объектов");
        HashMap<PhoneNumber, Integer> phoneNumbers1 = new HashMap<>();
        phoneNumbers1.put(phoneNumber1, 1);
        phoneNumbers1.put(phoneNumber1, 2);
        phoneNumbers1.put(phoneNumber2, 3);
        phoneNumbers1.put(phoneNumber2, 4);
        phoneNumbers1.put(phoneNumber3, 5);
        phoneNumbers1.put(phoneNumber3, 6);
        phoneNumbers1.put(phoneNumber4, 7);
        phoneNumbers1.put(phoneNumber4, 8);
        System.out.println(phoneNumbers1);


    }
}
