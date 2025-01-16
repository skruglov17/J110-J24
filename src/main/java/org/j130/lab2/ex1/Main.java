package org.j130.lab2.ex1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            //Выполним соединение с базой данных
            Connection connection = DbConnection.getConnection();
            //Создадим стейтмент для выполнения запроса
            Statement statement = connection.createStatement();
            //Получим результат запроса
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");




        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к БД! " + e);
        }
    }

}
