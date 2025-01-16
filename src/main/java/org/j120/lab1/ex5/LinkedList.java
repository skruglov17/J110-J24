package org.j120.lab1.ex5;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Двусвязанный список.
 * Состоит из нод и имеет ссылки на первую и последнюю ноды списка.
 * Имеет прямую и обратную связь между нодами.
 */
public class LinkedList<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private boolean reverse;

    /**
     * Определение направления чтения коллекции
     * @param reverse - Направление чтения.
     * @return true - Обратное чтение.
     * @return false - Прямое чтение.
     */
    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    /**
     * Добавление значения в начало списка.
     *
     * @param data - Данные ноды.
     */
    public void addHead(T data) {
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
        if (head == null) {
            head = node;
            tail = node;
        } else {
            //Если ноды есть
            head.previous = node;
            node.next = head;
            head = node;
        }
    }

    /**
     * Добавление всех значений заданного массива в начало списка.
     *
     * @param data - Массив данных.
     */
    public void addHead(T[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            addHead(data[i]);
        }
    }

    /**
     * Добавление коллекции в начало списка.
     *
     * @param collection - Коллекция данных.
     */
    public void addHead(ArrayList<T> collection) {
        for (int i = (collection.size() - 1); i >= 0; i--) {
            addHead(collection.get(i));
        }
    }

    /**
     * Извлечение значения из начала списка без его удаления из списка.
     *
     * @return data - Данные первой ноды.
     */
    public T extractHead() {
        if (head != null) {
            return (T) head.data;
        } else return null;
    }

    /**
     * Извлечение значения из начала списка с удалением из списка.
     *
     * @return data - Данные первой ноды.
     */
    public T extractWithDeleteHead() {
        if (head != null) {
            T data = extractHead();
            if (head.next != null) {
                head = head.next;
                Node temp = new Node();
                temp = head.previous;
                temp.next = null;
                head.previous = null;
            } else head = null;
            return data;
        } else return null;
    }

    /**
     * Добавление значения в конец списка.
     *
     * @param data - данные ноды.
     */
    public void add(T data) {
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
        if (head == null) {
            addHead(node);
        } else {
            //Если ноды есть
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
    }

    /**
     * Добавление массива значений в конец списка.
     *
     * @param data - данные ноды.
     */
    public void add(T[] data) {
        for (int i = 0; i < data.length; i++) {
            add(data[i]);
        }
    }

    /**
     * Добавление коллекции значений в конец списка.
     *
     * @param collection - данные ноды.
     */
    public void add(ArrayList<T> collection) {
        for (int i = 0; i < collection.size(); i++) {
            add(collection.get(i));
        }
    }

    /**
     * Извлечение значения из конца списка без его удаления.
     *
     * @return data - Данные последней ноды.
     */
    public T extractTail() {
        if (tail != null) {
            return (T) tail.data;
        } else return null;
    }

    /**
     * Извлечение значения из конца списка с удалением.
     *
     * @return data - Данные последней ноды.
     */
    public T extractWithDeleteTail() {
        if (tail != null) {
            T data = extractTail();
            tail = tail.previous;
            tail.next = null;
            return data;
        } else return null;
    }

    /**
     * Определение, содержит ли список заданное значение, или нет.
     *
     * @param data - Данные для поиска.
     * @return true - данные присутствуют в списке.
     * @return false - данные отсутствуют в списке.
     */
    public Boolean checkData(T data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
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
        if (head != null) return true;
        else return false;
    }

    /**
     * Удаление заданного значения из списка.
     *
     * @param data - Данные для удаления.
     */
    public void deleteData(T data) {
        Node temp = new Node();
        temp = head;
        while (temp != null) {
            if (temp.data == data) {
                //Если звено первое в списке
                if (temp == head) {
                    if (head.next != null) {
                        head = head.next;
                        head.previous = null;
                    } else {
                        head = null;
                        tail = null;
                    }
                }
                //Если звено в конце
                else if (temp == tail) {
                    tail = tail.previous;
                    tail.next = null;
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
        if (head != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(head.data);
            Node temp = head;
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
        if (tail != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(tail.data);
            Node temp = tail;
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
        first.head.previous = second.tail;
        second.tail.next = first.head;
        first.head = second.head;
        second.head = null;
        second.tail = null;
    }

    /**
     * Поглощение списка другим списком с добавлением значений второго в конец первого списка
     *
     * @param first  - Первый список.
     * @param second - Второй список.
     */
    public static void addLinkedList(LinkedList first, LinkedList second) {
        second.head.previous = first.tail;
        first.tail.next = second.head;
        first.tail = second.tail;
        second.head = null;
        second.tail = null;
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
    public void action(int action, T data) {
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
    public void action(int action, T[] list) {
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
    public void action(int action, ArrayList<T> collection) {
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
     *               16  - Поглощение списка другим списком с добавлением значений второго в начало первого списка.
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

    @Override
    public Iterator<T> iterator() {
        return new linkedListIterator<>(head, tail, reverse);
    }

    /**
     * Нода списка.
     */
    private static class Node<T> {

        private Node<T> next;
        private T data;
        private Node<T> previous;

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
        public Node(T data) {
            this.data = data;
        }
    }

    private static class linkedListIterator<T> implements Iterator<T> {
        Node head;
        Node tail;
        Boolean reverse;

        public linkedListIterator(Node head, Node tail, Boolean reverse) {
            if (reverse==false) {
                this.head = head;
                this.tail = null;
            } else {
                this.tail = tail;
                this.head = null;
            }
            this.reverse = reverse;
        }

        @Override
        public boolean hasNext() {
            return head != null | tail != null;

        }

        @Override
        public T next() {
            if (head != null) {
                T value = (T) head.data;
                head = head.next;
                return value;
            } else {
                T value = (T) tail.data;
                tail = tail.previous;
                return value;
            }
        }
    }
}