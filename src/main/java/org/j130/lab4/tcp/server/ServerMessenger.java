package org.j130.lab4.tcp.server;

import org.j130.lab4.tcp.ApplicationProperties;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * Класс взаимодействия сервера с клиентом
 */
public class ServerMessenger {

    private ApplicationProperties properties;

    /**
     * Конструктор класса с получением настроек из файла
     */
    public ServerMessenger() {
        properties = ApplicationProperties.getInstance();
    }

    public void sendMessage(String message){
        try(
                Socket socket = new Socket(properties.getHost(), properties.getClientPort());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            writer.write(message);
            writer.flush();
            socket.shutdownOutput();

            while((message = reader.readLine()) != null) {
                System.out.println(LocalDateTime.now() + ". Сообщение: " + message);
            }
            socket.shutdownInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMessage() {
        try (
                ServerSocket serverSocket = new ServerSocket(properties.getServerPort());
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
        ) {
            //Получим адрес клиента
            String address = getAddress(socket);
            //Получим сообщение
            Reader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);
            return br.readLine() + " " + address;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAddress(Socket socket) {
           return String.valueOf(socket.getRemoteSocketAddress());
    }
}
