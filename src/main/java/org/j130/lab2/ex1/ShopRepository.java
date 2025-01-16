package org.j130.lab2.ex1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * Класс товара из БД
 */
public class ShopRepository {

    /**
     * Метод для печати всех товаров из БД
     *
     * @return - Связанный список всех товаров из БД
     */
    public static void printProducts() {
        Connection connection = DbConnection.getConnection();
        LinkedList<Product> products = new LinkedList<>();
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM products")
        ) {
            while (resultSet.next()) {
                products.add(mapRowProduct(resultSet));
            }
            for (Product product : products) {
                StringBuilder builder = new StringBuilder();
                builder.append(
                        product.getArticle() + ", " +
                                product.getName() + ", " +
                                product.getColor() + ", " +
                                product.getPrice() + ", " +
                                product.getReminder()
                );
                System.out.println(builder);
            }
            //System.out.println(products + "\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод для печати продуктов из заказа по переданному идентификатору
     *
     * @param orderId - идентификатор заказа
     */
    public static void printProductsByOrderId(int orderId) {
        Connection connection = DbConnection.getConnection();
        LinkedList<Order> orders = new LinkedList<>();
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT *\n" +
                        "FROM products \n" +
                        "RIGHT JOIN order_position ON products.product_article = order_position.product_article\n" +
                        "RIGHT JOIN orders ON orders.order_id = order_position.order_id\n" +
                        "WHERE orders.order_id =" + orderId)
        ) {
            while (resultSet.next()) {
                orders = mapRowOrder(orders, resultSet);
            }
            StringBuilder builder = new StringBuilder();
            for (Order order : orders) {
                for (OrderPosition orderPosition : order.getOrderPositions()) {
                    Product product = orderPosition.getProduct();
                    builder.append(
                            product.getName()
                    );
                    if (product.getColor() != null) builder.append(
                            ", " + product.getColor()
                    );
                    builder.append("\n");
                }
            }
            System.out.println(builder);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод, предназначенный для создания объекта Order при чтении из БД
     * @param orders    - Список заказов
     * @param resultSet - Строка с параметрами заказа из БД
     * @return - список заказов
     * @throws SQLException
     */
    private static LinkedList<Order> mapRowOrder(LinkedList<Order> orders, ResultSet resultSet) throws SQLException {
        //Считываем заказ
        Order order = new Order();
        order.setId(resultSet.getInt("order_id"));
        order.setCustomerName(resultSet.getString("customer_name"));
        order.setCustomerNumber(resultSet.getString("customer_number"));
        order.setCustomerEmail(resultSet.getString("customer_email"));
        order.setDeliveryAddress(resultSet.getString("delivery_address"));
        order.setOrderPositions(mapRowOrderPosition(resultSet));
//        order.getOrderPositions().setProducts(mapRowProduct(resultSet));
        //Если заказа нет в списке, то добавь
        if (!orders.contains(order)) orders.add(order);
            //Если заказ есть, то добавлять не надо. Добавляем продукт
        else orders.get(orders.indexOf(order)).setOrderPositions(mapRowOrderPosition(resultSet));
        return orders;
    }

    /**
     * Метод, предназначенный для создания объекта OrderPosition при чтении из БД
     * @param resultSet - Строка с параметрами заказа из БД
     * @return - объект Позиция товара
     * @throws SQLException
     */
    private static OrderPosition mapRowOrderPosition(ResultSet resultSet) throws SQLException {
        OrderPosition orderPosition = new OrderPosition();
        orderPosition.setId(resultSet.getInt("order_id"));
        orderPosition.setProductArticle(resultSet.getInt("product_article"));
        orderPosition.setPrice(resultSet.getInt("price"));
        orderPosition.setProduct(mapRowProduct(resultSet));
        return orderPosition;
    }

    /**
     * Метод, предназначенный для создания объекта Product при чтении из БД
     * @param resultSet - Строка с параметрами товара из БД
     * @return - объект Товар
     * @throws SQLException
     */
    private static Product mapRowProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setArticle(resultSet.getInt("product_article"));
        product.setName(resultSet.getString("product_name"));
        product.setColor(resultSet.getString("color"));
        product.setPrice(resultSet.getInt("price"));
        product.setReminder(resultSet.getInt("remainder"));
        return product;
    }
}
