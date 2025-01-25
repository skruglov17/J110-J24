package org.j130.lab3;

import java.util.Random;

public class Supplier {

    private int quantity;
    private String name;

    public Supplier(int name){
        this.name = Integer.toString(name);
        this.quantity = new Random().nextInt(50) + 1;
    }

    public void loadingWarehouse(Warehouse warehouse){
        while(true){
            System.out.println("Началась загрузка товара поставщиком " + name + " на склад в количестве " + this.quantity + " шт. На складе " + warehouse.getQuantity() + " шт.");
            warehouse.loadingWarehouse(this.quantity, this.name);
            try {
                Thread.sleep(new Random().nextInt(5000) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
