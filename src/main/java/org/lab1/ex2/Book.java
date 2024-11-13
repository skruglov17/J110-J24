package src.main.java.org.lab1.ex2;

import java.util.Arrays;

/**
 * Книга
 */
public class Book {

    private String name;
    private PublishingHouse publishingHouse;
    private int yearPublication;
    private String authorsBookArray[];

    /**
     * Конструктор если автора нет.
     * @param name - Название книги.
     * @param yearPublication - Год публикации.
     * @param publishingHouse - Издательство.
     */
    public Book(String name, int yearPublication, PublishingHouse publishingHouse) throws Exception {
        setName(name);
        setYearPublication(yearPublication);
        setPublishingHouse(publishingHouse);
    }

    /**
     * Конструктор с массивом авторов.
     * @param name - Название книги.
     * @param yearPublication - Год публикации.
     * @param publishingHouse - Издательство.
     * @param authorsArray - массив авторов книги.
     */
    public Book(String name, int yearPublication, PublishingHouse publishingHouse, String[] authorsArray) throws Exception {
        this(name, yearPublication, publishingHouse);
        setAuthorsArray(authorsArray);
    }

    /**
     * Получение имени.
     * @return Название книги.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Получение названия издательства.
     * @return Название издательства.
     */
    public String getNamePublishingHouse() {
        return publishingHouse.getName();
    }

    /**
     * Получение города издательства.
     * @return Название города издательства.
     */
    public String getCityPublishingHouse() {
        return publishingHouse.getCity();
    }

    /**
     * Получение года издания книги.
     * @return Год издания.
     */
    public int getYearPublication() {
        return this.yearPublication;
    }

    /**
     * Получение авторов книги.
     * @return Все авторы книги.
     */
    public String getAuthorsArray() {
       return Arrays.toString(this.authorsBookArray).replaceAll("\\]|\\[", "");
    }

    /**
     * Получение количества авторов книги.
     * @return Количество авторов книги.
     */
    public int getNumbersAuthors() {
        return authorsBookArray.length;
    }

    /**
     * Получение автора по индексу.
     * @param index - Индекс для поиска автора.
     * @return Автор по искомому индексу.
     */
    public String getAuthorOfIndex(int index) throws Exception {
        if(index > authorsBookArray.length || index < 0) throw new Exception("Передано некорректное значение индекса!");
        return authorsBookArray[index];
    }

    /**
     * Определение названия книги.
     * @param name - Название книги.
     */
    public void setName(String name) throws Exception {
        if(name==null || name.equals("")) throw new Exception("Передано некорректное имя книги!");
        this.name = name;
    }

    /**
     * Определение издательства.
     * @param publishingHouse - Издательство.
     */
    public void setPublishingHouse(PublishingHouse publishingHouse) throws Exception {
        if(publishingHouse==null) throw new Exception("Передано некорректное издательство!");
        this.publishingHouse = publishingHouse;
    }

    /**
     * Определение года издания книги.
     * @param year - Год издания книги.
     */
    public void setYearPublication(int year) throws Exception {
        if(year < 0) throw new Exception("Передано некорректный год издательства!");
        this.yearPublication = year;
    }

    /**
     * Определение авторов книги.
     * @param authorsArray - Массив авторов книги.
     */
    public void setAuthorsArray(String[] authorsArray) throws Exception {
        for (int i = 0; i < authorsArray.length; i++) {
            if(authorsArray[i] == null || authorsArray[i].equals("")) throw new Exception("Передана пустая строка!");
        }
        this.authorsBookArray = new String[authorsArray.length];
    }

    /**
     * Добавление новых авторов книги
     * @param author - Автор книги для добавления.
     */
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

    /**
     * Получение информации о книге
     */
    public void print() {
        if(authorsBookArray != null)
            System.out.println(this.getName() + ", " + this.getAuthorsArray() + ", " + this.getNamePublishingHouse() + ", " + this.getCityPublishingHouse() + ", " + this.getYearPublication());
        else
            System.out.println(this.getName() + ", " + this.getNamePublishingHouse() + ", " + this.getCityPublishingHouse() + ", " + this.getYearPublication());
    }

    /**
     * Информация о книгах в пределах заданного массива
     * @param booksArray - массив книг
     * @param min - начальный индекс
     * @param max - заключительный индекс
     */
    public static void printAll(Book[] booksArray, int min, int max) {
        for (int i = min; i < max; i++) {
            booksArray[i].print();
        }
    }

}
