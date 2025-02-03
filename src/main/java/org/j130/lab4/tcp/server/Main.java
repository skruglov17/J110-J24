package org.j130.lab4.tcp.server;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        //Создадим объект приёма сообщений
        ServerMessenger serverMessenger = new ServerMessenger();

        while (true){
            String message = serverMessenger.getMessage();
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println(localDateTime + " | Принято сообщение от клиента: " + message);
            serverMessenger.sendMessage(localDateTime.toString());
        }
    }
}
