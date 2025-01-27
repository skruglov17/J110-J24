package org.j130.lab3.ex2;

import java.util.Random;

public class Reader {

    private String name;

    public Reader(int idName) {
        this.name = "ID " + idName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void read(DataBase dataBase){
        while(true) {
            System.out.println("Читатель " + name + " хочет подключился к БД. На базе читателей: " + dataBase.getCountReaders() + ", писателей: " + dataBase.getCountWriters());
            dataBase.read(this);
            try {
                Thread.sleep(new Random().nextInt(5000) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
