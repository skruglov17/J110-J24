package org.j130.lab3.ex2;

import java.util.Random;

public class DataBase {

    private int countReaders;
    private int countWriters;

    public int getCountReaders() {return countReaders;}

    public int getCountWriters() {return countWriters;}

    public void read(Reader reader) {
        if(countWriters == 0){
            countReaders++;
            System.out.println("Читатель " + reader.getName() + " подключился к БД. На базе читателей: " + countReaders + ", писателей: " + countWriters);
            try {
                Thread.sleep(new Random().nextInt(1000) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countReaders--;
            System.out.println("Читатель " + reader.getName() + " отключился от БД. На базе читателей: " + countReaders + ", писателей: " + countWriters);
        } else
            System.out.println("Читатель " + reader.getName() + " ждёт подключения. На базе читателей: " + countReaders + ", писателей: " + countWriters);
    }

    public synchronized void write(Writer writer) {
        if(countWriters == 0 && countReaders == 0){
            countWriters++;
            System.out.println("Писатель " + writer.getName() + " подключился к БД. На базе читателей: " + countReaders + ", писателей: " + countWriters);
            try {
                Thread.sleep(new Random().nextInt(5000) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countWriters--;
            System.out.println("Писатель " + writer.getName() + " отключился от БД. На базе читателей: " + countReaders + ", писателей: " + countWriters);
        } else
            System.out.println("Писатель " + writer.getName() + " ждёт подключения. На базе читателей: " + countReaders + ", писателей: " + countWriters);
    }
}
