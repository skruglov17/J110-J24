package src.main.java.org.j120.lab1.ex2;

import java.util.Iterator;

/**
 * Односвязанный список.
 * Состоит из нод и имеет ссылки на первую и последнюю ноды списка.
 * Имеет только прямую связь между нодами.
 */
public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    /**
     * Добавление значения в начало списка.
     * @param data - данные первой ноды списка к установке.
     */
    public void addHead(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        //Проверка есть ли ноды в списке
        if(head == null) {
            head = node;
            tail = node;
        } else {
            //Если ноды есть
            node.next = head;
            head = node;
        }
    }

    /**
     * Извлечение значения из начала списка без его удаления из списка.
     * @return data - данные первой ноды списка.
     */
    public T extractHead(){
        if(head != null) {
            return (T) head.data;
        } else return null;
    }


    /**
     * Извлечение значения из начала списка с удалением из списка.
     * @return data - данные первой ноды списка.
     */
    public T extractWithDeleteHead(){
        if(head != null) {
            T data = extractHead();
            if(head.next != null) {
                head = head.next;
            } else head = null;
            return data;
        } else return null;
    }

    /**
     * Добавление значения в конец списка.
     * @param data - данные последней ноды списка к установке.
     */
    public void add(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        //Проверка есть ли ноды в списке
        if(head == null) {
            addHead(data);
        } else {
            //Если ноды есть
            tail.next = node;
            tail = node;
        }
    }

    /**
     * Извлечение значения из конца списка без его удаления.
     * @return data - данные последней ноды списка.
     */
    public T extractTail() {
        if(tail != null) {
            return (T) tail.data;
        } else return null;
    }

    /**
     * Извлечение значения из конца списка с удалением.
     * @return data - данные последней ноды списка.
     */
    public T extractWithDeleteTail(){
        if(tail != null) {
            T data = extractTail();
            Node<T> temp = new Node<>();
            temp = head;
            while(temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            return data;
        } else return null;
    }

    /**
     * Определение, содержит ли список заданное значение.
     * @param data - данные, по которым осуществляется поиск.
     * @return true - данные присутствуют в списке.
     *        false - данные отсутствуют в списке.
     */
    public Boolean checkData(T data) {
        Node<T> temp = head;
        while(temp != null) {
            if(temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }

    /**
     * Определение, является ли список пустым, или нет.
     * @return true - список содержит ноды.
     *         false - список пуст.
     */
    public Boolean checkFill() {
        return head != null;
    }

    /**
     * Печать всех значений списка.
     * @return toString - список данных через запятую всех нод списка.
     */
    @Override
    public String toString() {
        if(head != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(head.data);
            Node<T> temp = head;
            while(temp.next != null) {
                temp = temp.next;
                sb.append(", ").append(temp.data);
            }
            sb.append("]");
            return sb.toString();
        } else return "[]";
    }

    /**
     * Удаление заданного значения из списка
     * @param data - данные, по которым осуществляется поиск всех нод с данными для последующего их удаления.
     */
    public void deleteData(T data) {
        Node<T> temp = new Node<>();
        temp = head;
        while(temp != null) {
            if(temp.data == data) {
                //Если звено первое в списке
                if(temp == head) {
                    if(head.next != null) {
                        head = head.next;
                    } else {
                        head = null;
                        tail = null;
                    }
                }
                //Если звено в конце
                else if(temp == tail) {
                    Node<T> temp_delete = new Node<>();
                    temp_delete = head;
                    while(temp_delete.next != tail) {
                        temp_delete = temp_delete.next;
                    }
                    tail = temp_delete;
                    tail.next = null;
                }
                //Если звено в середине
                else {
                    Node<T> temp_delete = new Node<>();
                    temp_delete = head;
                    while(temp_delete.next != temp) {
                        temp_delete = temp_delete.next;
                    }
                    temp_delete.next = temp.next;
                }
            }
            temp = temp.next;
        }
    }

    /**
     * Выполнение действия, заданного в параметре метода, для каждого значения из списка
     *         /*
     *
     * @param action - действие. Значения:
     *      *   1  - Добавление значения в начало списка.
     *      *   2  - Добавление значения в конец списка.
     *      *   3  - Проверка наличия значения в списке.
     *      *   4  - Проверка списка на пустоту.
     *      *   5  - Вывод значения из начала списка.
     *      *   6  - Вывод значения из начала списка с последующим удалением.
     *      *   7  - Вывод значения из конца списка.
     *      *   8  - Вывод значения из конца списка с последующим удалением.
     *      *   9  - Вывод всех значений списка.
     *      *   10 - Удаление заданного значения из списка.
     * @param data - данные, необходимые для выполнения действия
     */
    public void action(int action, T data) {
        switch (action) {
            case 1:
                addHead(data);
                break;
            case 2:
                add(data);
                break;
            case 3:
                System.out.println(checkData(data));
                break;
            case 4:
                System.out.println(checkFill());
                break;
            case 5:
                System.out.println(extractHead());
                break;
            case 6:
                System.out.println(extractWithDeleteHead());
                break;
            case 7:
                System.out.println(extractTail());
                break;
            case 8:
                System.out.println(extractWithDeleteTail());
                break;
            case 9:
                System.out.println(toString());
                break;
            case 10:
                deleteData(data);
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head);
    }


    /**
     * Нода списка. Не может существовать вне списка. Содержит дату и ссылку на следующую ноду.
     * Если ссылка равна null, то это последняя нода списка.
     */
    private static class Node<T> {
        T data;
        Node<T> next;
    }

    /**
     * Переопределение поведения списка.
     * @param <T>
     */
    private static class LinkedListIterator<T> implements Iterator<T> {
        Node<T> nextNode;

        public LinkedListIterator(Node<T> head) {
            this.nextNode = head;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            Node<T> temp = nextNode;
            nextNode = nextNode.next;
            return (T) temp.data;
        }
    }
}

