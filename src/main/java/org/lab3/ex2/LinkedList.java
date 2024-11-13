package src.main.java.org.lab3.ex2;

import java.util.ArrayList;
import java.util.List;

/**
 * Двусвязанный список.
 * Состоит из нод и имеет ссылки на первую и последнюю ноды списка.
 * Имеет прямую и обратную связь между нодами.
 */
public class LinkedList {

    private Node head;
    private Node tail;

    /**
     * Получение первой ноды списка.
     *
     * @return head - Первая нода списка.
     */
    public Node getHead() {
        return head;
    }

    /**
     * Определение первой ноды списка.
     *
     * @param head - Первая нода списка.
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Получение последней ноды списка.
     *
     * @return tail - Последняя нода списка.
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Определение последней ноды списка.
     *
     * @param tail - Последняя нода списка.
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * Добавление значения в начало списка.
     *
     * @param data - Данные ноды.
     */
    public void addHead(String data) {
        Node node = new Node(data);
        addHead(node);
    }

    /**
     * Добавление ноды в начало списка.
     *
     * @param node - Нода для включения в начало списка.
     */
    public void addHead(Node node) {
        //Проверка есть ли ноды в списке
        if (getHead() == null) {
            setHead(node);
            setTail(node);
        } else {
            //Если ноды есть
            getHead().previous = node;
            node.next = getHead();
            setHead(node);
        }
    }

    /**
     * Добавление всех значений заданного массива в начало списка.
     *
     * @param data - Массив данных.
     */
    public void addHead(String[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            addHead(data[i]);
        }
    }

    /**
     * Добавление коллекции в начало списка.
     *
     * @param collection - Коллекция данных.
     */
    public void addHead(ArrayList<String> collection) {
        for (int i = (collection.size() - 1); i >= 0; i--) {
            addHead(collection.get(i));
        }
    }

    /**
     * Извлечение значения из начала списка без его удаления из списка.
     *
     * @return data - Данные первой ноды.
     */
    public String extractHead() {
        if (getHead() != null) {
            return getHead().data;
        } else return "Список пуст!";
    }

    /**
     * Извлечение значения из начала списка с удалением из списка.
     *
     * @return data - Данные первой ноды.
     */
    public String extractWithDeleteHead() {
        if (getHead() != null) {
            String data = extractHead();
            if (getHead().next != null) {
                setHead(getHead().next);
                Node temp = new Node();
                temp = getHead().previous;
                temp.next = null;
                getHead().previous = null;
            } else setHead(null);
            return data;
        } else return "Список пуст!";
    }

    /**
     * Добавление значения в конец списка.
     *
     * @param data - данные ноды.
     */
    public void add(String data) {
        Node node = new Node(data);
        add(node);
    }

    /**
     * Добавление ноды в конец списка.
     *
     * @param node - Нода для включения в конец списка.
     */
    public void add(Node node) {
        //Проверка есть ли ноды в списке
        if (getHead() == null) {
            addHead(node);
        } else {
            //Если ноды есть
            node.previous = getTail();
            getTail().next = node;
            setTail(node);
        }
    }

    /**
     * Добавление массива значений в конец списка.
     *
     * @param data - данные ноды.
     */
    public void add(String[] data) {
        for (int i = 0; i < data.length; i++) {
            add(data[i]);
        }
    }

    /**
     * Добавление коллекции значений в конец списка.
     *
     * @param collection - данные ноды.
     */
    public void add(ArrayList<String> collection) {
        for (int i = 0; i < collection.size(); i++) {
            add(collection.get(i));
        }
    }

    /**
     * Извлечение значения из конца списка без его удаления.
     *
     * @return data - Данные последней ноды.
     */
    public String extractTail() {
        if (getTail() != null) {
            return getTail().data;
        } else return "Список пуст!";
    }

    /**
     * Извлечение значения из конца списка с удалением.
     *
     * @return data - Данные последней ноды.
     */
    public String extractWithDeleteTail() {
        if (getTail() != null) {
            String data = extractTail();
            setTail(getTail().previous);
            getTail().next = null;
            return data;
        } else return "Список пуст!";
    }

    /**
     * Определение, содержит ли список заданное значение, или нет.
     *
     * @param data - Данные для поиска.
     * @return true - данные присутствуют в списке.
     * @return false - данные отсутствуют в списке.
     */
    public Boolean checkData(String data) {
        Node temp = getHead();
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * Определение, является ли список пустым, или нет.
     *
     * @return true - список содержит данные.
     * @return false - список пуст.
     */
    public Boolean checkFill() {
        if (getHead() != null) return true;
        else return false;
    }

    /**
     * Удаление заданного значения из списка.
     *
     * @param data - Данные для удаления.
     */
    public void deleteData(String data) {
        Node temp = new Node();
        temp = getHead();
        while (temp != null) {
            if (temp.data.equals(data)) {
                //Если звено первое в списке
                if (temp == getHead()) {
                    if (getHead().next != null) {
                        setHead(getHead().next);
                        getHead().previous = null;
                    } else {
                        setHead(null);
                        setTail(null);
                    }
                }
                //Если звено в конце
                else if (temp == getTail()) {
                    setTail(getTail().previous);
                    getTail().next = null;
                }
                //Если звено в середине
                else {
                    temp.previous.next = temp.next;
                    temp.next.previous = temp.previous;
                }
            }
            temp = temp.next;
        }
    }

    /**
     * Печать всех значений списка.
     *
     * @return значения всех нод списка.
     */
    @Override
    public String toString() {
        if (getHead() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(getHead().data);
            LinkedList.Node temp = getHead();
            while (temp.next != null) {
                temp = temp.next;
                sb.append(", ").append(temp.data);
            }
            sb.append("]");
            return sb.toString();
        } else return "[]";
    }

    /**
     * Печать всех значений списка наоборот.
     *
     * @return значения всех нод списка.
     */
    public String toReverseString() {
        if (getTail() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(getTail().data);
            LinkedList.Node temp = getTail();
            while (temp.previous != null) {
                temp = temp.previous;
                sb.append(", ").append(temp.data);
            }
            sb.append("]");
            return sb.toString();
        } else return "[]";
    }

    /**
     * Поглощение списка другим списком с добавлением значений второго в начало первого списка.
     *
     * @param first  - Первый список.
     * @param second - Второй список.
     */
    public static void addHeadLinkedList(LinkedList first, LinkedList second) {
        first.getHead().previous = second.getTail();
        second.getTail().next = first.getHead();
        first.setHead(second.getHead());
        second.setHead(null);
        second.setTail(null);
    }

    /**
     * Поглощение списка другим списком с добавлением значений второго в конец первого списка
     *
     * @param first  - Первый список.
     * @param second - Второй список.
     */
    public static void addLinkedList(LinkedList first, LinkedList second) {
        second.getHead().previous = first.getTail();
        first.getTail().next = second.getHead();
        first.setTail(second.getTail());
        second.setHead(null);
        second.setTail(null);
    }

    /**
     * Выполнение действия, заданного в параметре метода, для каждого значения из списка.
     *
     * @param action - действие.
     *               1  - Добавление значения в начало списка.
     *               4  - Добавление значения в конец списка.
     *               7  - Проверка наличия значения в списке:
     *               true  - значение присутствует в списке.
     *               false - значение отсутствует в списке.
     *               15 - Удаление заданного значения из списка.
     * @param data   - Данные для действия.
     */
    public void action(int action, String data) {
        switch (action) {
            case 1:
                addHead(data);
                break;
            case 4:
                add(data);
                break;
            case 7:
                System.out.println(checkData(data));
                break;
            case 15:
                deleteData(data);
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

    /**
     * Выполнение действий на добавление массивов.
     *
     * @param action - действие.
     *               *               2  - Добавление значения в конец списка.
     *               5  - Добавление всех значений заданного массива в конец списка
     * @param list   - Массив данных.
     */
    public void action(int action, String[] list) {
        switch (action) {
            case 2:
                addHead(list);
                break;
            case 5:
                add(list);
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

    /**
     * Выполнение действий на добавление коллекций.
     *
     * @param action     - действие.
     *                   *               3  - Добавление значения в конец списка.
     *                   6  - Добавление всех значений заданной коллекции в конец списка
     * @param collection - Коллекция данных.
     */
    public void action(int action, ArrayList<String> collection) {
        switch (action) {
            case 3:
                addHead(collection);
                break;
            case 6:
                add(collection);
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

    /**
     * Выполнение действий на извлечение данных.
     *
     * @param action - действие. Значения:
     *               8  - Проверка списка на пустоту:
     *               true - список содержит ноды.
     *               false - список пуст.
     *               9  - Вывод значения из начала списка.
     *               10  - Вывод значения из начала списка с последующим удалением.
     *               11  - Вывод значения из конца списка.
     *               12  - Вывод значения из конца списка с последующим удалением.
     *               13  - Вывод всех значений списка.
     *               14 - Вывод всех значений списка наоборот.
     */
    public void action(int action) {
        switch (action) {
            case 8:
                System.out.println(checkFill());
                break;
            case 9:
                System.out.println(extractHead());
                break;
            case 10:
                System.out.println(extractWithDeleteHead());
                break;
            case 11:
                System.out.println(extractTail());
                break;
            case 12:
                System.out.println(extractWithDeleteTail());
                break;
            case 13:
                System.out.println(toString());
                break;
            case 14:
                System.out.println(toReverseString());
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

    /**
     * Выполнение действий со списками.
     *
     * @param action - действие.
     *               *               16  - Поглощение списка другим списком с добавлением значений второго в начало первого списка.
     *               17  - Поглощение списка другим списком с добавлением значений первого в конец второго списка.
     * @param first  - Первый список.
     * @param second - Второй список.
     */
    public void action(int action, LinkedList first, LinkedList second) {
        switch (action) {
            case 16:
                addHeadLinkedList(first, second);
                break;
            case 17:
                addLinkedList(first, second);
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

    /**
     * Нода списка.
     */
    private class Node {

        private Node next;
        private String data;
        private Node previous;

        /**
         * Конструктор ноды без данных.
         */
        public Node() {

        }

        /**
         * Конструктор ноды с данными.
         *
         * @param data - Данные ноды.
         */
        public Node(String data) {
            this.data = data;
        }
    }
}
