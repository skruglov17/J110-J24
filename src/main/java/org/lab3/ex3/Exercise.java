package src.main.java.org.lab3.ex3;

import java.util.ArrayList;

public class Exercise {

    public static void startEx() throws Exception {

        LinkedList linkedList = new LinkedList();
        linkedList.addHead("10");
        linkedList.addHead("9");
        linkedList.addHead("8");
        linkedList.addHead("7");
        linkedList.addHead("6");
        linkedList.addHead("5");
        linkedList.addHead("4");
        linkedList.addHead("3");
        linkedList.addHead("2");
        linkedList.addHead("1");
        linkedList.addHead("0");
        linkedList.addHead("-1");
        linkedList.add("11");

        LinkedList secondLinkedList = new LinkedList();
        secondLinkedList.add("101");
        secondLinkedList.add("102");
        secondLinkedList.add("103");
        secondLinkedList.add("104");
        secondLinkedList.add("105");
        secondLinkedList.add("106");
        secondLinkedList.add("107");
        secondLinkedList.add("108");
        secondLinkedList.add("109");
        secondLinkedList.add("110");

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
                                        14 - Удаление заданного значения из списка
                                        15 - Поглощение списка другим списком с добавлением значений второго в начало первого списка
                                        16 - Поглощение списка другим списком с добавлением значений второго в конец первого списка
        */

        linkedList.action(13);

    }
}
