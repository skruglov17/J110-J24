package org.j130.lab2.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для подключения к БД
 */
public class DbConnection {

    private static Connection connection;

    /**
     * Метод, предназначенный для получения соединения с БД, указанной в настройках приложения
     * @return соединение с БД
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        ApplicationProperties properties = ApplicationProperties.getInstance();
        if(connection==null || connection.isClosed()){
            connection = DriverManager.getConnection(properties.getValue("database_url"),
                                                     properties.getValue("database_user"),
                                                     properties.getValue("database_password"));
        }
        return connection;
    }
}
