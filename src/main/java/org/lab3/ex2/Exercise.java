package src.main.java.org.lab3.ex2;

import java.util.ArrayList;

public class Exercise {


    public static void startEx() throws Exception {

        LinkedList linkedList = new LinkedList();
        linkedList.add("0");
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("6");
        linkedList.add("7");
        linkedList.add("8");
        linkedList.add("9");
        linkedList.add("10");

        //Выполнение действия, заданного в параметре метода, для каждого значения из списка
        /*
            Action - действие. Значения:
                                        1  - Добавление значения в начало списка
                                        2  - Добавление всех значений заданного массива в начало списка
                                        3  - Добавление всех значений заданной коллекции в начало списка
                                        4  - Добавление значения в конец списка
                                        5  - Добавление всех значений заданного массива в конец списка
                                        6  - Добавление всех значений заданной коллекции в конец списка
                                        7  - Проверка наличия значения в списке:
                                                true  - значение присутствует в списке
                                                false - значение отсутствует в списке
                                        8  - Проверка списка на пустоту:
                                                true - список содержит ноды
                                                false - список пуст
                                        9  - Вывод значения из начала списка
                                        10  - Вывод значения из начала списка с последующим удалением
                                        11  - Вывод значения из конца списка
                                        12  - Вывод значения из конца списка с последующим удалением
                                        13 - Вывод всех значений списка
                                        14 - Вывод всех значений списка наоборот
                                        15 - Удаление заданного значения из списка
                                        16 - Поглощение списка другим списком с добавлением значений второго в начало первого списка
                                        17 - Поглощение списка другим списком с добавлением значений первого в начало второго списка
        */

        linkedList.action(2, new String[]{"-5", "-4", "-3", "-2", "-1"});
        linkedList.action(13);

        ArrayList<String> collection = new ArrayList<String>();
        collection.add("11");
        collection.add("12");
        collection.add("13");
        collection.add("14");
        collection.add("15");
        collection.add("16");

        linkedList.action(6, collection);
        linkedList.action(13);

        LinkedList linkedListSecond = new LinkedList();
        linkedListSecond.add("17");
        linkedListSecond.add("18");
        linkedListSecond.add("19");
        linkedListSecond.add("20");
        linkedListSecond.add("21");

        linkedList.action(17, linkedList, linkedListSecond);
        linkedList.action(13);
    }
}
