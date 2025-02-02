package org.j130.lab4.tcp.client;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Создадим объект передачи сообщения
        ClientMessenger clientMessenger = new ClientMessenger();

        boolean exit = false;
        while(!exit) {
            //Ввод сообщения и адреса подключения через консоль
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите \"0\" для выхода из приложения!");
            System.out.println(" Введите сообщение для сервера:");
            String message = scanner.nextLine();
            if(message.equals("0")) {
                exit = true;
                continue;
            }
            System.out.println("Для использования адреса по-умолчанию нажмите \"Enter\" или введите адрес подключения к серверу: ");
            String host = scanner.nextLine();
            if(host.equals("0")) {
                exit = true;
                continue;
            }
            //Передача сообщения серверу
            clientMessenger.sendMessage(message, host);
            //Получение сообщения от сервера
            message = clientMessenger.getMessage();
            System.out.println("Время приёма сообщения от сервера: " + message);
        }
    }
}
