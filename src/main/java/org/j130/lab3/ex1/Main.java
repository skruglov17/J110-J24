package org.j130.lab3.ex1;

public class Main {

    public static void main(String[] args) {

        //Создадим склад
        Warehouse warehouse = new Warehouse(50);
        System.out.println("Склад готов!");

        //Создадим поставщиков
        for (int i = 1; i <= 3; i++) {
            int idName = i;
            new Thread(() -> {
                Supplier supplier = new Supplier(idName);
                supplier.loadingWarehouse(warehouse);
            }).start();
        }
        System.out.println("Поставщики готовы!");

        //Создадим потребителей
        for (int i = 1; i <= 6; i++) {
            int idName = i;
            new Thread(() -> {
                Consumer consumer = new Consumer(idName);
                consumer.unloadingWarehouse(warehouse);
            }).start();
        }
        System.out.println("Потребители готовы!");
        System.out.println("Склад начал свою работу!");
    }
}
