package src.main.java.org.lab3.ex1;

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

        /**
         * Выполнение действия, заданного в параметре метода, для каждого значения из списка
         *         /*
         *
         * @param action - действие. Значения:
         *      *                                         1  - Добавление значения в начало списка
         *      *                                         2  - Добавление значения в конец списка
         *      *                                         3  - Проверка наличия значения в списке:
         *      *                                                 true  - значение присутствует в списке
         *      *                                                 false - значение отсутствует в списке
         *      *                                         4  - Проверка списка на пустоту:
         *      *                                                 true - список содержит ноды
         *      *                                                 false - список пуст
         *      *                                         5  - Вывод значения из начала списка
         *      *                                         6  - Вывод значения из начала списка с последующим удалением
         *      *                                         7  - Вывод значения из конца списка
         *      *                                         8  - Вывод значения из конца списка с последующим удалением
         *      *                                         9  - Вывод всех значений списка
         *      *                                         10 - Удаление заданного значения из списка
         * @param data - данные, необходимые для выполнения действия
         */

        linkedList.action(9, "");
    }
}
