package org.j130.lab2.ex1;

import java.util.Objects;

/**
 * Класс позиций заказов
 */
public class OrderPosition {

    private int id;
    private int productArticle;
    private int price;
    private int quantity;
    private Product product;

    /**
     * Геттеры и сеттеры
     */

    public void setId(int id) {
        this.id = id;
    }

    public void setProductArticle(int productArticle) {
        this.productArticle = productArticle;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPosition that = (OrderPosition) o;
        return id == that.id && productArticle == that.productArticle && price == that.price && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productArticle, price, quantity);
    }
}
