package org.j130.lab2.ex1;

import java.sql.Date;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class Order {

    private int id;
    private String customerName;
    private String customerNumber;
    private String customerEmail;
    private String deliveryAddress;
    private LinkedList<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        if(this.products==null) {
            this.products = new LinkedList<>();
            this.products.add(product);
        } else {
            this.products.add(product);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(customerName, order.customerName) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, products);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", products=" + products +
                '}';
    }
}
