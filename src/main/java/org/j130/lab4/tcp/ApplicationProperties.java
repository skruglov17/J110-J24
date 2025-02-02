package org.j130.lab4.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс настроек приложения
 */
public class ApplicationProperties {

    private Properties properties;
    private static ApplicationProperties applicationProperties;

    /**
     * Конструктор класса настроек, реализованный через Singleton
     * Получим настройки из файла applicationTCP
     */
    public ApplicationProperties() {
        properties = new Properties();
        File propertiesFile = new File("applicationTCP.properties");
        try {
            if(!propertiesFile.exists()) propertiesFile.createNewFile();
            properties.load(new FileInputStream(propertiesFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Получаем единичный экземпляр класса (Singleton)
     * @return экземпляр класса
     */
    public static ApplicationProperties getInstance(){
        if(applicationProperties==null) applicationProperties = new ApplicationProperties();
        return applicationProperties;
    }

    /**
     * Получим адрес подключения к серверу
     * @return
     */
    public String getHost() {
        if(properties != null){
            return properties.getProperty("server_host");
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Получим порт подключения к серверу
     * @return
     */
    public int getServerPort() {
        if(properties != null){
            return Integer.parseInt(properties.getProperty("server_port"));
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Получим порт подключения к серверу
     * @return
     */
    public int getClientPort() {
        if(properties != null){
            return Integer.parseInt(properties.getProperty("client_port"));
        } else {
            throw new NullPointerException();
        }
    }
}
