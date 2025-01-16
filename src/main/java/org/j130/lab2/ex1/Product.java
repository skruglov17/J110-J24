package org.j130.lab2.ex1;

import java.util.Objects;

/**
 * Класс моделей товаров
 */
public class Product {

    private int article;
    private String name;
    private String color;
    private int price;
    private int reminder;

    /**
     * Метод получения артикля товара
     * @return артикля товара
     */
    public int getArticle() {
        return article;
    }

    /**
     * Метод опеределения артикля товара
     * @param article - артиклю товара. 7 числовых знаков
     */
    public void setArticle(int article) {
        this.article = article;
    }

    /**
     * Метод получения наименования товара
     * @return наименование товара
     */
    public String getName() {
        return name;
    }

    /**
     * Метод определения наименование товара
     * @param name - наименование товара
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод получения цвета товара
     * @return - цвет товара
     */
    public String getColor() {
        return color;
    }

    /**
     * Метод определения цвета товара
     * @param color - цвет товара
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Метод получения стоимости товара
     * @return - стоимость товара
     */
    public int getPrice() {
        return price;
    }

    /**
     * Метод определения стоимости товара
     * @param price - стоимость товара в рублях
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Метод получения остатка товара на складе
     * @return - Остаток товара на складе
     */
    public int getReminder() {
        return reminder;
    }

    /**
     * Метод определения остатка товара на складе
     * @param reminder - Остаток товара на складе
     */
    public void setReminder(int reminder) {
        this.reminder = reminder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return article == product.article && price == product.price && reminder == product.reminder && Objects.equals(name, product.name) && Objects.equals(color, product.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, name, color, price, reminder);
    }
}
