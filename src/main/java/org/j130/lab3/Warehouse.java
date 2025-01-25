package org.j130.lab3;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {

    private AtomicInteger quantity;

    public Warehouse(int quantity) {
        this.quantity = new AtomicInteger(quantity);
    }

    public AtomicInteger getQuantity() {
        return quantity;
    }

    public void loadingWarehouse(int quantity, String name) {
        this.quantity.addAndGet(quantity);
        System.out.println("После загрузки поставщиком " + name + " количество на складе составило " + this.quantity + " шт.");
    }

    public synchronized void unloadingWarehouse(int quantity, String name) {
        while(this.quantity.get() < quantity) {
            System.out.println("Для потребителя " + name + " не хватает товара на складе. На складе осталось " + this.quantity + " шт. Не хватает " + (quantity - this.quantity.get()) + " шт.");
            try {
                Thread.sleep(new Random().nextInt(100) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            this.quantity.addAndGet(-quantity);
            Thread.sleep(new Random().nextInt(100) + 1);
            System.out.println("Потребитель " + name + " ушёл со склада с товаром в количестве " + quantity + " шт. На складе осталось " + this.quantity + " шт.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
