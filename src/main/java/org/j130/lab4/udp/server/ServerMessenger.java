package org.j130.lab4.udp.server;

import org.j130.lab4.udp.ApplicationProperties;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

public class ServerMessenger {

    private ApplicationProperties properties;
    DatagramSocket socket;

    /**
     * Конструктор класса с получением настроек из файла
     */
    public ServerMessenger() {
        properties = ApplicationProperties.getInstance();
        try{
            this.socket = new DatagramSocket(properties.getServerPort());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод отправки клиенту времени приёма сообщения от клиента
     * @param dateTime - время приема сообщения от клиента
     * @param address - адрес клиента
     * @param port - порт клиента
     */
    public void sendMessage(String dateTime, InetAddress address, int port){
        try{
            //Сформируем пакет с сообщением клиенту
            byte[] outData = dateTime.getBytes();
            DatagramPacket packet = new DatagramPacket(outData, outData.length, address,port);
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод приема сообщения от клиента
     */
    public void getMessage() {
        try{
            //Сформируем пакет для получения сообщения от клиента
            byte[] inData = new byte[1024];
            DatagramPacket packet = new DatagramPacket(inData, inData.length);
            //Получим сообщение от клиента
            socket.receive(packet);
            String message = new String(packet.getData(),0,packet.getLength());
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println(localDateTime + " | Принято сообщение от клиента: " + message);
            sendMessage(localDateTime.toString(), packet.getAddress(), packet.getPort());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
