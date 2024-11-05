package src.main.java.org.lab3.ex1;

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
            node.next = head;
            head = node;

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
            Node temp = new Node();
            temp = head;
            while(temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
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

    //печать всех значений списка
    @Override
    public String toString() {
        if(head != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(head.data);
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
                sb.append(", ").append(temp.data);
            }
            sb.append("]");
            return sb.toString();
        } else return "[]";
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
                    } else {
                        head = tail = null;
                    }
                }
                //Если звено в конце
                else if(temp == tail) {
                    Node temp_delete = new Node();
                    temp_delete = head;
                    while(temp_delete.next != tail) {
                        temp_delete = temp_delete.next;
                    }
                    tail = temp_delete;
                    tail.next = null;
                }
                //Если звено в середине
                else {
                    Node temp_delete = new Node();
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

    //выполнение действия, заданного в параметре метода, для каждого значения из списка
        /*
            Action - действие. Значения:
                                        1  - Добавление значения в начало списка
                                        2  - Добавление значения в конец списка
                                        3  - Проверка наличия значения в списке:
                                                true  - значение присутствует в списке
                                                false - значение отсутствует в списке
                                        4  - Проверка списка на пустоту:
                                                true - список содержит ноды
                                                false - список пуст
                                        5  - Вывод значения из начала списка
                                        6  - Вывод значения из начала списка с последующим удалением
                                        7  - Вывод значения из конца списка
                                        8  - Вывод значения из конца списка с последующим удалением
                                        9  - Вывод всех значений списка
                                        10 - Удаление заданного значения из списка
        */
    public void action(int action, String data) {
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



    //Нода списка
    private class Node {

        private String data;
        private Node next;

        //Конструкторы ноды
        public Node() {

        }
        public Node(String data) {
            this.data = data;
        }
    }
}

