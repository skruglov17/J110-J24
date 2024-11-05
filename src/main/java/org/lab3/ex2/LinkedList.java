package src.main.java.org.lab3.ex2;

public class LinkedList {

    private Node head;
    private Node tail;

    //добавление значения в начало списка
    public void addHead(String data) {
        Node node = new Node(data);
        //Проверка есть ли ноды в списке
        if(head == null) {
            head = tail = node;
        } else {
            //Если ноды есть
            head.previous = node;
            node.next = head;
            head = node;
        }
    }

    //добавление всех значений заданного массива в начало списка
    public void addHead(String[] data) {
        for (int i = data.length-1; i >= 0; i--) {
            Node node = new Node(data[i]);
            if(head == null) {
                head = tail = node;
            } else {
                //Если ноды есть
                head.previous = node;
                node.next = head;
                head = node;
            }
        }
    }

    //извлечение значения из начала списка без его удаления из списка
    public String extractHead(){
        if(head != null) {
            return head.data;
        } else return "Список пуст!";
    }

    //извлечение значения из начала списка с удалением из списка
    public String extractWithDeleteHead(){
        if(head != null) {
            String data = extractHead();
            if(head.next != null) {
                head = head.next;
                Node temp = new Node();
                temp = head.previous;
                temp.next = null;
                head.previous = null;
            } else head = null;
            return data;
        } else return "Список пуст!";
    }

    //добавление значения в конец списка
    public void add(String data) {
        Node node = new Node(data);
        //Проверка есть ли ноды в списке
        if(head == null) {
            addHead(data);
        } else {
            //Если ноды есть
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
    }

    //извлечение значения из конца списка без его удаления
    public String extractTail() {
        if(tail != null) {
            return tail.data;
        } else return "Список пуст!";
    }

    //извлечение значения из конца списка с удалением
    public String extractWithDeleteTail(){
        if(tail != null) {
            String data = extractTail();
            tail = tail.previous;
            tail.next = null;
            return data;
        } else return "Список пуст!";
    }

    //определение, содержит ли список заданное значение, или нет
    public Boolean checkData(String data) {
        Node temp = head;
        while(temp != null) {
            if(temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //определение, является ли список пустым, или нет
    public Boolean checkFill() {
        if(head != null) return true;
        else return false;
    }

    //удаление заданного значения из списка
    public void deleteData(String data) {
        Node temp = new Node();
        temp = head;
        while(temp != null) {
            if(temp.data.equals(data)) {
                //Если звено первое в списке
                if(temp == head) {
                    if(head.next != null) {
                        head = head.next;
                        head.previous = null;
                    } else {
                        head = tail = null;
                    }
                }
                //Если звено в конце
                else if(temp == tail) {
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



    //выполнение действия, заданного в параметре метода, для каждого значения из списка
        /*
            Action - действие. Значения:
                                        1  - Добавление значения в начало списка
                                        3  - Добавление значения в конец списка
                                        4  - Проверка наличия значения в списке:
                                                true  - значение присутствует в списке
                                                false - значение отсутствует в списке
                                        12 - Удаление заданного значения из списка
        */

    //Выполнение действий на добавление
    public void action(int action, String data) {
        switch (action) {
            case 1:
                addHead(data);
                break;
            case 3:
                add(data);
                break;
            case 4:
                System.out.println(checkData(data));
                break;
            case 12:
                deleteData(data);
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

        /*
        Action - действие. Значения:
                                    2  - Добавление значения в конец списка
        */
    //Выполнение действий на добавление массивов
    public void action(int action, String[] list) {
        switch (action) {
            case 2:
                addHead(list);
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

        /*
            Action - действие. Значения:
                                        4  - Проверка списка на пустоту:
                                                true - список содержит ноды
                                                false - список пуст
                                        5  - Вывод значения из начала списка
                                        6  - Вывод значения из начала списка с последующим удалением
                                        7  - Вывод значения из конца списка
                                        8  - Вывод значения из конца списка с последующим удалением
                                        9  - Вывод всех значений списка
                                        10 - Вывод всех значений списка наоборот
        */
    //Выполнение действий на извлечение данных
    public void action(int action) {
        switch (action) {
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
                System.out.println(toReverseString());
                break;
            default:
                System.out.println("Передайте корректное значение действия!");
        }
    }

    //печать всех значений списка
    @Override
    public String toString() {
        if(head != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(head.data);
            LinkedList.Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
                sb.append(", ").append(temp.data);
            }
            sb.append("]");
            return sb.toString();
        } else return "[]";
    }

    //печать всех значений списка наоборот
    public String toReverseString() {
        if(tail != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(tail.data);
            LinkedList.Node temp = tail;
            while(temp.previous != null) {
                temp = temp.previous;
                sb.append(", ").append(temp.data);
            }
            sb.append("]");
            return sb.toString();
        } else return "[]";
    }

    //Нода списка
    private class Node{

        private Node next;
        private String data;
        private Node previous;

        //конструкторы
        public Node() {

        }

        public Node(String data) {
            this.data = data;
        }
    }
}
