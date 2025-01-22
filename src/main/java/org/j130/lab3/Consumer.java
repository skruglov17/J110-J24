package org.j130.lab3;

import java.util.Random;

public class Consumer {

    private int quantity;

    public Consumer(int quantity) {
        Random random = new Random();
        quantity = random.nextInt(10) + 1;
    }

    public void takeProducts(int quantity){
        

    }

}
