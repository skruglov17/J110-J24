package org.main;

public class Document extends File {

    private int pageNumbers;

    //конструктор
    public Document(String name, int size, FileFormat format, int pageNumbers) {
        super(name, size, format);
        this.pageNumbers = pageNumbers;
    }

    //геттеры и сеттеры

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) throws Exception {
        if(pageNumbers < 1) throw new Exception("Введено неккоректное количество страниц документа!");
        this.pageNumbers = pageNumbers;
    }

    @Override
    public void getDetails() {
        System.out.println(super.getFormat() + ", " + this.getPageNumbers() + " pages");
    }

}
