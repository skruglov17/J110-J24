package org.j130.lab4.tcp.client;

import org.j130.lab4.tcp.ApplicationProperties;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * Класс взаимодействия клиента с сервером
 */
public class ClientMessenger {

    private ApplicationProperties properties;

    /**
     * Конструктор класса с получением настроек из файла
     */
    public ClientMessenger() {
        properties = ApplicationProperties.getInstance();
    }

    /**
     * Отправка сообщения на сервер
     * @param message Сообщение для отправки
     * @param host Адрес сервера
     */
    public void sendMessage(String message, String host){
        if(host.isEmpty()) host = properties.getHost();
        try(
                Socket socket = new Socket(host, properties.getServerPort());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            writer.write(message);
            writer.flush();
            socket.shutdownOutput();

            while((message = reader.readLine()) != null) {
                System.out.println(LocalDateTime.now() + ". Отправлено сообщение на сервер: " + message);
            }
            socket.shutdownInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Получение сообщения от сервера
     * @return Сообщение от сервера
     */
    public String getMessage(){
        try(
                ServerSocket serverSocket = new ServerSocket(properties.getClientPort());
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
        ) {
                Reader reader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(reader);
                return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
