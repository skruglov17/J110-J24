package src.main.java.org.j110.lab3.ex1;

/**
 * Односвязанный список.
 * Состоит из нод и имеет ссылки на первую и последнюю ноды списка.
 * Имеет только прямую связь между нодами.
 */
public class LinkedList {

    private Node head;
    private Node tail;

    /**
     * Получение первой ноды списка.
     * @return head - первая нода списка.
     */

    public Node getHead() {
        return head;
    }

    /**
     * Установка первой ноды списка.
     * @param head - первая нода списка к установке.
     */

    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Получение последней ноды списка.
     * @return tail - последняя нода списка.
     */

    public Node getTail() {
        return tail;
    }

    /**
     * Установка последней ноды списка.
     * @param tail - последняя нода списка к установке.
     */

    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
    * Добавление значения в начало списка.
     * @param data - данные первой ноды списка к установке.
     */
    public void addHead(String data) {
        Node node = new Node(data);
        //Проверка есть ли ноды в списке
        if(getHead() == null) {
            setHead(node);
            setTail(node);
        } else {
            //Если ноды есть
            node.next = getHead();
            setHead(node);
        }
    }

    /**
    * Извлечение значения из начала списка без его удаления из списка.
     * @return data - данные первой ноды списка.
     */
    public String extractHead(){
        if(getHead() != null) {
            return getHead().data;
        } else return "Список пуст!";
    }


    /**
     * Извлечение значения из начала списка с удалением из списка.
     * @return data - данные первой ноды списка.
     */
    public String extractWithDeleteHead(){
        if(getHead() != null) {
            String data = extractHead();
            if(getHead().next != null) {
                setHead(getHead().next);
            } else setHead(null);
            return data;
        } else return "Список пуст!";
    }

    /**
     * Добавление значения в конец списка.
     * @param data - данные последней ноды списка к установке.
     */
    public void add(String data) {
        Node node = new Node(data);
        //Проверка есть ли ноды в списке
        if(getHead() == null) {
            addHead(data);
        } else {
            //Если ноды есть
            getTail().next = Node;
            setTail(node);
        }
    }

    /**
     * Извлечение значения из конца списка без его удаления.
     * @return data - данные последней ноды списка.
     */
    public String extractTail() {
        if(getTail() != null) {
            return getTail().data;
        } else return "Список пуст!";
    }

    /**
     * Извлечение значения из конца списка с удалением.
     * @return data - данные последней ноды списка.
     */
    public String extractWithDeleteTail(){
        if(getTail() != null) {
            String data = extractTail();
            Node temp = new Node();
            temp = getHead();
            while(temp.next != getTail()) {
                temp = temp.next;
            }
            setTail(temp);
            getTail().next = null;
            return data;
        } else return "Список пуст!";
    }

    /**
     * Определение, содержит ли список заданное значение.
     * @param data - данные, по которым осуществляется поиск.
     * @return true - данные присутствуют в списке.
     * @return false - данные отсутствуют в списке.
     */
    public Boolean checkData(String data) {
        Node temp = getHead();
        while(temp != null) {
            if(temp.data.equals(data)) {
                return true;
            }
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
        if(getHead() != null) return true;
        else return false;
    }

    /**
     * Печать всех значений списка.
     * @return toString - список данных через запятую всех нод списка.
     */
    @Override
    public String toString() {
        if(getHead() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(getHead().data);
            Node temp = getHead();
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
    public void deleteData(String data) {
        Node temp = new Node();
        temp = getHead();
        while(temp != null) {
            if(temp.data.equals(data)) {
                //Если звено первое в списке
                if(temp == getHead()) {
                    if(getHead().next != null) {
                        setHead(getHead().next);
                    } else {
                        setHead(null);
                        setTail(null);
                    }
                }
                //Если звено в конце
                else if(temp == getTail()) {
                    Node temp_delete = new Node();
                    temp_delete = getHead();
                    while(temp_delete.next != getTail()) {
                        temp_delete = temp_delete.next;
                    }
                    setTail(temp_delete);
                    getTail().next = null;
                }
                //Если звено в середине
                else {
                    Node temp_delete = new Node();
                    temp_delete = getHead();
                    while(temp_delete.next != temp) {
                        temp_delete = temp_delete.next;
                    }
                    temp_delete.next = temp.next);
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


    /**
     * Нода списка. Не может существовать вне списка. Содержит дату и ссылку на следующую ноду.
     * Если ссылка равна null, то это последняя нода списка.
     */
    private class Node {

        private String data;
        private Node next;

        /**
         * Конструктор ноды без данных.
         */
        public Node() {

        }

        /**
         * Конструктор ноды с данными.
         * @param data - данные, которые будет хранить нода.
         */
        public Node(String data) {
            this.data;
        }
    }
}

