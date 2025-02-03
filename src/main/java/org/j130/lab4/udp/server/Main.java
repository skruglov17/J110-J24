package org.j130.lab4.udp.server;

public class Main {

    public static void main(String[] args) {

        //Создадим объект приёма сообщений
        ServerMessenger serverMessenger = new ServerMessenger();

        while (true){
            serverMessenger.getMessage();
        }
    }
}
