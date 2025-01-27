package org.j130.lab3.ex2;

public class Main {

    public static void main(String[] args) {

        //Создадим базу данных
        DataBase dataBase = new DataBase();
        System.out.println("База данных готова!");

        //Создадим читателей
        for (int i = 1; i <= 5; i++) {
            int idName = i;
            new Thread(() -> {
                Reader reader = new Reader(idName);
                reader.read(dataBase);
            }).start();
        }
        System.out.println("Поставщики готовы!");

        //Создадим писателей
        for (int i = 1; i <= 3; i++) {
            int idName = i;
            new Thread(() -> {
                Writer writer = new Writer(idName);
                writer.write(dataBase);
            }).start();
        }
        System.out.println("Потребители готовы!");
        System.out.println("Склад начал свою работу!");
    }
}
