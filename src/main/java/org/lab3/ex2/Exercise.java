package src.main.java.org.lab3.ex2;

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

        //выполнение действия, заданного в параметре метода, для каждого значения из списка
        /*
            Action - действие. Значения:
                                        1  - Добавление значения в начало списка
                                        2  - Добавление всех значений заданного массива в начало списка
                                        3  - Добавление значения в конец списка
                                        4  - Проверка наличия значения в списке:
                                                true  - значение присутствует в списке
                                                false - значение отсутствует в списке
                                        5  - Проверка списка на пустоту:
                                                true - список содержит ноды
                                                false - список пуст
                                        6  - Вывод значения из начала списка
                                        7  - Вывод значения из начала списка с последующим удалением
                                        8  - Вывод значения из конца списка
                                        9  - Вывод значения из конца списка с последующим удалением
                                        10  - Вывод всех значений списка
                                        11 - Вывод всех значений списка наоборот
                                        12 - Удаление заданного значения из списка
        */

        linkedList.action(2, new String[]{"-5", "-4", "-3", "-2", "-1"});
        linkedList.action(9);
        linkedList.action(10);
    }
}
