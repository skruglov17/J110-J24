package org.j130.lab2.ex1;

import java.util.LinkedList;
import java.util.Objects;

public class Order {

    private int id;
    private String customerName;
    private String customerNumber;
    private String customerEmail;
    private String deliveryAddress;
    private LinkedList<OrderPosition> orderPositions;


    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public LinkedList<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(OrderPosition orderPosition) {
        if(this.orderPositions==null) {
            this.orderPositions = new LinkedList<>();
            this.orderPositions.add(orderPosition);
        } else {
            this.orderPositions.add(orderPosition);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(customerName, order.customerName) && Objects.equals(orderPositions, order.orderPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, orderPositions);
    }
}
