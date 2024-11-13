package src.main.java.org.lab3.ex3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Развёрнутый односвязанный список.
 * Состоит из нод и имеет ссылки на первую и последнюю ноды списка.
 * Имеет только прямую связь между нодами.
 */
public class LinkedList implements LinkedListInterface {

    private Node head;
    private Node tail;

    /**
     * Получение первой ноды списка.
     * @return head - Первая нода списка.
     */
    public Node getHead() {
        return head;
    }

    /**
     * Определение первой ноды списка.
     * @param head - Первая нода списка.
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Получение последней ноды списка.
     * @return tail - Последняя нода списка.
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Определение последней ноды списка.
     * @param tail - Последняя нода списка.
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * Добавление значения в начало списка.
     * @param data - значение для добавления.
     */
    public void addHead(String data) {
        //Проверка наличия нод
        if (getHead() == null) {
            setHead(new Node());
            getHead().setData(data);
            setTail(getHead());
        } else {
            //Делаем проверку возможности добавления данных в существующую ноду
            if (getHead().checkEmptyIndexArray()) getHead().setData(data);
            //Если нода полная, создаём новую
            else {
                Node temp = new Node();
                temp.setData(data);
                temp.setNext(getHead());
                setHead(temp);
            }
        }
    }

    /**
     * Добавление всех значений заданного массива в начало списка.
     * @param data - Массив данных.
     */
    public void addHead(String[] data) {
        //Всегда создаём новую ноду, которая будет первой
        Node temp = new Node();
        temp.setNext(getHead());
        setHead(temp);
        //Положим в неё переданные данные
        for (int i = 0; i <= data.length-1; i++) {
            addHead(data[i]);
        }
    }

    /**
     * Добавление коллекции в начало списка.
     * @param collection - Коллекция данных.
     */
    public void addHead(ArrayList<String> collection){
        for(int i = 0; i <= (collection.size()-1); i++) {
            addHead(collection.get(i));
        }
    }

    /**
     * Извлечение значения из начала списка без его удаления из списка.
     * @return Массив первой ноды.
     */
    public String extractHead() {
        return Arrays.toString(getHead().getData());
    }

    /**
     * Извлечение значения из начала списка с удалением из списка.
     * @return Массив первой ноды.
     */
    public String extractHeadWithDelete() {
        String data = Arrays.toString(getHead().getData());
        setHead(getHead().getNext());
        return data;
    }

    /**
     * Добавление значения в конец списка.
     * @param data - значение для добавления.
     */
    public void add(String data) {
        //Проверка наличия нод
        if (getHead() == null) {
            setHead(new Node());
            getHead().setData(data);
            setTail(getHead());
        } else {
            //Делаем проверку возможности добавления данных в существующую ноду
            if (getTail().checkEmptyIndexArray()) getTail().setData(data);
            //Если нода полная, создаём новую
            else {
                Node temp = new Node();
                temp.setData(data);
                getTail().setNext(temp);
                setTail(temp);
            }
        }
    }

    /**
     * Добавление массива значений в конец списка.
     * @param data - данные ноды.
     */
    public void add(String[] data) {
        for (int i = 0; i <= data.length-1; i++) {
            add(data[i]);
        }
    }

    /**
     * Добавление коллекции значений в конец списка.
     * @param collection - данные ноды.
     */
    public void add(ArrayList<String> collection) {
        for (int i = 0; i < collection.size(); i++) {
            add(collection.get(i));
        }
    }

    /**
     * Извлечение значения из конца списка без его удаления из списка.
     * @return Массив последней ноды.
     */
    public String extractTail() {
        return Arrays.toString(getTail().getData());
    }

    /**
     * Извлечение значения из конца списка с удалением из списка.
     * @return Массив последней ноды.
     */
    public String extractTailWithDelete() {
        String data = Arrays.toString(getTail().getData());
        Node temp = getHead();
        while(temp.getNext() != getTail()) {
            temp = temp.getNext();
        }
        setTail(temp);
        getTail().setNext(null);
        return data;
    }

    /**
     * Определение, содержит ли список заданное значение, или нет.
     * @param data - Значение для поиска.
     * @return true - Значение присутствует в списке.
     * @return false - Значение отсутствует в списке.
     */
    public boolean checkData(String data) {
        Node temp = getHead();
        while(temp != null) {
            for (int i = 0; i < temp.getData().length; i++) {
                if(data == temp.getData()[i]) return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    /**
     * Определение, является ли список пустым, или нет
     * @return true - Список содержит ноды.
     * @return false - Список пуст.
     */
    public boolean checkFill() {
        if(getHead() != null) return true;
        else return false;
    }

    public void deleteData(String data) {
        Node temp = new Node();
        temp = getHead();
        while (temp != null) {
            for (int i = 0; i < temp.getData().length; i++) {
                if(data.equals(temp.getData()[i])) {
                    temp.getData()[i] = null;
                }
            }
            temp = temp.getNext();
        }
    }

    /**
     * Поглощение списка другим списком с добавлением значений второго в начало первого списка.
     * @param first - Первый список.
     * @param second - Второй список.
     */
    public static void addHeadLinkedList(LinkedList first, LinkedList second) {
        second.getTail().setNext(first.getHead());
        first.setHead(second.getHead());
        second.setHead(null);
        second.setTail(null);
    }

    /**
     * Поглощение списка другим списком с добавлением значений первого в конец второго списка
     * @param first - Первый список.
     * @param second - Второй список.
     */
    public static void addLinkedList(LinkedList first, LinkedList second) {
        first.getTail().setNext(second.getHead());
        first.setTail(second.getTail());
        second.setHead(null);
        second.setTail(null);
    }

    /**
     * Печать всех значений списка.
     * @return toString - список данных через запятую всех нод списка.
     */
    @Override
    public String toString() {
        if(getHead() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(Arrays.toString(getHead().getData()));
            Node temp = getHead();
            while(temp.getNext() != null) {
                temp = temp.getNext();
                sb.append(", ").append(Arrays.toString(temp.getData()));
            }
            sb.append("]");
            return sb.toString();
        } else return "[]";
    }

    /**
     * Выполнение действия, заданного в параметре метода, для каждого значения из списка.
     * @param action - действие.
     *               1  - Добавление значения в начало списка.
     *               4  - Добавление значения в конец списка.
     *               7  - Проверка наличия значения в списке:
     *                       true  - значение присутствует в списке.
     *                       false - значение отсутствует в списке.
     *               14 - Удаление заданного значения из списка.
     * @param data - Данные для действия.
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
            case 14:
                deleteData(data);
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

    /**
     * Выполнение действий на добавление массивов.
     * @param action - действие.
     *      *               2  - Добавление значения в конец списка.
     *                      5  - Добавление всех значений заданного массива в конец списка
     * @param list - Массив данных.
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
     * @param action - действие.
     *      *               3  - Добавление значения в конец списка.
     *                      6  - Добавление всех значений заданной коллекции в конец списка
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
     * @param action - действие. Значения:
     *                                         8  - Проверка списка на пустоту:
     *                                                 true - список содержит ноды.
     *                                                 false - список пуст.
     *                                         9  - Вывод значения из начала списка.
     *                                         10  - Вывод значения из начала списка с последующим удалением.
     *                                         11  - Вывод значения из конца списка.
     *                                         12  - Вывод значения из конца списка с последующим удалением.
     *                                         13  - Вывод всех значений списка.
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
                System.out.println(extractHeadWithDelete());
                break;
            case 11:
                System.out.println(extractTail());
                break;
            case 12:
                System.out.println(extractTailWithDelete());
                break;
            case 13:
                System.out.println(toString());
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

    /**
     * Выполнение действий со списками.
     * @param action - действие.
     *      *               15  - Поглощение списка другим списком с добавлением значений второго в начало первого списка.
     *                      16  - Поглощение списка другим списком с добавлением значений первого в конец второго списка.
     * @param first - Первый список.
     * @param second - Второй список.
     */
    public void action(int action, LinkedList first, LinkedList second) {
        switch (action) {
            case 15:
                addHeadLinkedList(first, second);
                break;
            case 16:
                addLinkedList(first, second);
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

    /**
     * Нода списка. Не может существовать вне списка. Содержит дату и ссылку на следующую ноду.
     * Если ссылка равна null, то это последняя нода списка.
     */
    private class Node {

        private String[] data;
        private Node next;

        /**
         * Конструктор ноды без данных.
         */
        public Node() {
            this.data = new String[ARRAY_SIZE];
        }

        /**
         * Конструктор ноды с данными.
         * @param data - данные, которые будет хранить нода.
         */
        public Node(String[] data) {
            this.setData(data);
        }

        /**
         * Получение данных ноды.
         * @return data - Массив данных.
         */
        public String[] getData() {
            return data;
        }

        /**
         * Определение данных ноды.
         * @param data - Массив данных.
         */
        public void setData(String[] data) {
            this.data = new String[ARRAY_SIZE];
            for (int i = 0; i < data.length; i++) {
                this.data[i] = data[i];
            }
        }

        /**
         * Проверка наличия свободного места в массиве ноды.
         * @return true - Место есть.
         * @return false - Места нет.
         */
        public boolean checkEmptyIndexArray() {
            if(getData() != null) {
                for (int i = 0; i < getData().length; i++) {
                    if(getData()[i] == null) return true;
                }
                return false;
            }
            return true;
        }

        /**
         * Добавление данных в ноду. Проверка возможности наполнения уже должна быть выполнена.
         * @param data - Данные для загрузки в массив.
         */
        public void setData(String data) {
            if(getData() !=null) {
                for (int i = 0; i < getData().length; i++) {
                    if (getData()[i] == null) {
                        getData()[i] = data;
                        break;
                    }
                }
            } else {
                this.data = new String[ARRAY_SIZE];
                this.data[0] = data;
            }
        }

        /**
         * Получение следующей ноды списка.
         * @return next - Следующая нода списка.
         */
        public Node getNext() {
            return next;
        }

        /**
         * Определение следующей ноды списка.
         * @param next - Следующая нода списка.
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }
}


