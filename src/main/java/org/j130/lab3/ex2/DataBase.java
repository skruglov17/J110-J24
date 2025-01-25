package org.j130.lab3.ex2;

public class DataBase {

    private int countReaders;
    private int countWriters;
    private boolean lock;
     

    public int getCountReaders() {
        return countReaders;
    }

    public void setCountReaders(int countReaders) {
        this.countReaders = countReaders;
    }

    public int getCountWriters() {
        return countWriters;
    }

    public void setCountWriters(int countWriters) {
        this.countWriters = countWriters;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public void writing() {}

    public void reading() {}


}
