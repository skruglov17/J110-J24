package src.main.java.org.j120.lab1.ex5;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        //Создадим список чисел
        LinkedList<Integer> list = new LinkedList<>();
        list.addHead(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.addHead(0);

        //Создадим список строк
        LinkedList<String> list1 = new LinkedList<>();
        list1.addHead("r");
        list1.add("o");
        list1.add("g");
        list1.add("r");
        list1.add("a");
        list1.add("m");
        list1.addHead("P");


        System.out.println("Выведем наш список:");
        for (Integer a: list) {
            System.out.println(a);
        }
        System.out.println();
        for (String a: list1) {
            System.out.println(a);
        }
        System.out.println();

        System.out.println("Выведем наш список в обратном порядке");
        list.setReverse(true);
        for (Integer a: list) {
            System.out.println(a);
        }
        System.out.println();
        list1.setReverse(true);
        for (String a: list1) {
            System.out.println(a);
        }
        list.setReverse(false);
        list1.setReverse(false);
        System.out.println();

        System.out.println("Выведем список с остановкой на указанном значении:");
        for (Integer a: list){
            System.out.println(a);
            if(a == 4) break;
        }
        System.out.println();
        for (String a: list1){
            System.out.println(a);
            if(a.equals("g")) break;
        }
        System.out.println();

        System.out.println("Выведем список после заданного значения до конца:");
        Iterator<Integer> iterator =  list.iterator();
        while (iterator.hasNext()){
            if(iterator.next() == 3) {
                iterator.forEachRemaining(System.out::println);
            }
        }
        System.out.println();
        Iterator<String> iterator1 =  list1.iterator();
        while (iterator1.hasNext()){
            if(iterator1.next().equals("o")) {
                iterator1.forEachRemaining(System.out::println);
            }
        }

        System.out.println("Выведем список от конца до заданного значения:");
        list.setReverse(true);
        for (Integer a: list){
            System.out.println(a);
            if(a == 4) break;
        }
        System.out.println();
        list1.setReverse(true);
        for (String a: list1){
            System.out.println(a);
            if(a.equals("g")) break;
        }
        list.setReverse(false);
        list1.setReverse(false);
        System.out.println();

        System.out.println("Выведем список от заданного значения до начала:");
        list.setReverse(true);
        Iterator<Integer> iterator2 =  list.iterator();
        while (iterator2.hasNext()){
            if(iterator2.next() == 3) {
                iterator2.forEachRemaining(System.out::println);
            }
        }
        System.out.println();
        list1.setReverse(true);
        Iterator<String> iterator3 =  list1.iterator();
        while (iterator3.hasNext()){
            if(iterator3.next().equals("o")) {
                iterator3.forEachRemaining(System.out::println);
            }
        }
        list.setReverse(false);
        list1.setReverse(false);
        System.out.println();
    }
}
