package org.main;

import java.util.Arrays;

public class Book {

    private String name;
    private PublishingHouse publishingHouse;
    private int yearPublication;
    private String authorsBookArray[];

    //конструктор если автора нет
    public Book(String name, int yearPublication, PublishingHouse publishingHouse) {
        this.name = name;
        this.yearPublication = yearPublication;
        this.publishingHouse = publishingHouse;
    }

    //конструктор с массивом авторов
    public Book(String name, int yearPublication, PublishingHouse publishingHouse, String[] authorsArray) {
        this.name = name;
        this.yearPublication = yearPublication;
        this.publishingHouse = publishingHouse;

        String[] authorsBookArray = new String[authorsArray.length];
        this.authorsBookArray = authorsArray;
    }

    //get-методы
    public String getName() {
        return this.name;
    }

    public String getNamePublishingHouse() {
        return publishingHouse.getName();
    }

    public String getCityPublishingHouse() {
        return publishingHouse.getCity();
    }

    public int getYearPublication() {
        return this.yearPublication;
    }

    public String getAuthorsArray() {
       return Arrays.toString(this.authorsBookArray).replaceAll("\\]|\\[", "");
    }

    //Количество авторов книги
    public int getNumbersAuthors() {
        return authorsBookArray.length;
    }

    //Автор по конкретному индексу
    public String getAuthorOfIndex(int index) throws Exception {
        if(index > authorsBookArray.length || index < 0) throw new Exception("Передано некорректное значение индекса!");
        return authorsBookArray[index];
    }

    //set-методы
    public void setName(String name) throws Exception {
        if(name==null || name.equals("")) throw new Exception("Передано некорректное имя книги!");
        this.name = name;
    }

    public void setNamePublishingHouse(String name) throws Exception {
        if(name==null || name.equals("")) throw new Exception("Передано некорректное имя издательства!");
        this.publishingHouse.setName(name);
    }

    public void setYearPublication(int year) throws Exception {
        if(year < 0) throw new Exception("Передано некорректный год издательства!");
        this.yearPublication = year;
    }

    public void setAuthorsArray(String[] authorsArray) throws Exception {
        for (int i = 0; i < authorsArray.length; i++) {
            if(authorsArray[i] == null || authorsArray[i].equals("")) new Exception("Передана пустая строка!");
        }
        this.authorsBookArray = authorsArray;
    }

    //добавление новых авторов книги
    public void addAuthor(String author) throws Exception {
        if(author == null || author.equals("")) throw new Exception("Передан некорректный автор книги!");
        //проверим, что массив целиком заполнен
        for (int i = 0; i < authorsBookArray.length; i++) {
            if(authorsBookArray[i] == null) authorsBookArray[i] = author;
        }
        //создаём новый массив авторов + 1
        String[] temp = new String[authorsBookArray.length+1];
        for (int i = 0; i < authorsBookArray.length; i++) {
            temp[i] = authorsBookArray[i];
        }
        //сохраняем нового автора
        temp[temp.length-1] = author;
        authorsBookArray = temp;
    }

    //Информация по книге
    public void print() {
        if(authorsBookArray != null)
            System.out.println(this.getName() + ", " + this.getAuthorsArray() + ", " + this.getNamePublishingHouse() + ", " + this.getCityPublishingHouse() + ", " + this.getYearPublication());
        else
            System.out.println(this.getName() + ", " + this.getNamePublishingHouse() + ", " + this.getCityPublishingHouse() + ", " + this.getYearPublication());
    }

    //метод, возвращающий информацию в пределах заданного массива
    public static void printAll(Book[] booksArray, int min, int max) {
        for (int i = min; i < max; i++) {
            booksArray[i].print();
        }
    }

}
