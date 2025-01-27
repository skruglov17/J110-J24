package org.j130.lab3.ex2;

import java.util.Random;

public class Writer {

    private String name;

    public Writer(int idName) {
        this.name = "ID " + idName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void write(DataBase dataBase){
        while(true){
            System.out.println("Писатель " + name + " хочет подключился к БД. На базе читателей: " + dataBase.getCountReaders() + ", писателей: " + dataBase.getCountWriters());
            dataBase.write(this);
            try {
                Thread.sleep(new Random().nextInt(10000) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
