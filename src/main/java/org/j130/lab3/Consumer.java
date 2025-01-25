package org.j130.lab3;

import java.util.Random;

public class Consumer {

    private int quantity;
    private String name;

    public Consumer(int name) {
        this.name = Integer.toString(name);
        this.quantity = new Random().nextInt(10) + 1;
    }

    public void unloadingWarehouse(Warehouse warehouse){
        while(true){
            System.out.println("Потребитель " + name + " пришёл на склад за товаром в количестве " + this.quantity + " шт. На складе " + warehouse.getQuantity() + " шт.");
            warehouse.unloadingWarehouse(this.quantity, this.name);
            try {
                Thread.sleep(new Random().nextInt(1000) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
