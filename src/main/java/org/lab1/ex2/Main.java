package org.lab1.ex2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    public static void main(String[] args) throws Exception {

        //Создаём массив издательств
        PublishingHouse publishingHouseArray[] = new PublishingHouse[4];
        publishingHouseArray[0] = new PublishingHouse("Проспект", "Москва");
        publishingHouseArray[1] = new PublishingHouse("Питер", "Санкт-Петербург");
        publishingHouseArray[2] = new PublishingHouse("БХВ", "Санкт-Петебург");
        publishingHouseArray[3] = new PublishingHouse("Диалектика", "Киев");


        //Создаём массив книг
        Book bookArray[] = new Book[5];
        bookArray[0] = new Book("Computer Science: основы программирования на Java, ООП, алгоритмы и структуры данных", 2018, publishingHouseArray[1], new String[]{"Седжевик Роберт", "Уэйн Кевин"});
        bookArray[1] = new Book("Разработка требований к программному обеспечению. 3-е издание, дополненное", 2019, publishingHouseArray[2], new String[]{"Вигерс Карл"});
        bookArray[2] = new Book("Java. Полное руководствоб 10-е издание", 2018, publishingHouseArray[3], new String[]{"Шилдт Герберт"});
        bookArray[3] = new Book("C/C++. Процедурное программирование", 2017, publishingHouseArray[2], new String[]{"Полубенцева М.И."});
        bookArray[4] = new Book("Конституция РФ", 2020, publishingHouseArray[0]);

        //выведем все книги на экран в первый раз
        Book.printAll(bookArray, 0, 5);

        //исправим ошибку в названии города
        publishingHouseArray[2].setCity("Санкт-Петербург");


        //выведем все книги на экран после исправления ошибки.
        // Ошибка будет исправлена у всех книг издательства "БХВ", т.к. в книгах мы храним ссылку на один и тот же издательсткий дом,
        // а ошибку исправили имеено в нём
        System.out.println();
        Book.printAll(bookArray, 0, 5);

    }
}