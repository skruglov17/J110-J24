package org.lab2.ex2;

public class Picture extends File {

    private int height;
    private int weight;

    //конструктор
    public Picture(String name, int size, FileFormat format, int height, int weight) {
        super(name, size, format);
        this.height = height;
        this.weight = weight;
    }

    //геттеры и сеттеры
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws Exception {
        if(height <= 0) throw new Exception("Передан некорректный размер картинки!");
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws Exception{
        if(weight <= 0)throw new Exception("Передан некорректный размер картинки!");
        this.weight = weight;
    }

    @Override
    public void getDetails() {
        System.out.println(super.getFormat() + ", " + this.getHeight() + "x" + this.getWeight());
    }
}
