package org.j130.lab4.udp.client;

import org.j130.lab4.tcp.ApplicationProperties;

import java.io.*;
import java.net.*;

/**
 * Класс взаимодействия клиента с сервером
 */
public class ClientMessenger {

    private ApplicationProperties properties;
    DatagramSocket socket;

    /**
     * Конструктор класса с получением настроек из файла
     */
    public ClientMessenger() {
        properties = ApplicationProperties.getInstance();
        try{
            this.socket = new DatagramSocket(properties.getClientPort());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Отправка сообщения на сервер
     * @param message Сообщение для отправки
     * @param host Адрес сервера
     */
    public void sendMessage(String message, String host){
        if(host.isEmpty()) host = properties.getHost();
        try{
            byte[] outData = message.getBytes();
            DatagramPacket packet = new DatagramPacket(outData,outData.length, InetAddress.getByName(host), properties.getServerPort());
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Получение сообщения от сервера
     * @return Сообщение от сервера
     */
    public String getMessage(){
        try{
            byte[] inData = new byte[1024];
            DatagramPacket packet = new DatagramPacket(inData, inData.length);
            //Получим сообщение от клиента
            socket.receive(packet);
            String message = new String(packet.getData(),0,packet.getLength());
            return message;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
