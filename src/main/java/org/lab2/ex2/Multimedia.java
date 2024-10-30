package org.lab2.ex2;

import java.nio.file.Files;

public class Multimedia extends File {

    private Picture picture;
    private int duration;
    private String description;

    //конструктор для видеофайлов
    public Multimedia(String name, int size, FileFormat format, Picture picture, int duration, String description) {
        super(name, size, format);
        this.picture = picture;
        this.duration = duration;
        this.description = description;
    }

    //конструктор для прочих медиафайлов
    public Multimedia(String name, int size, FileFormat format, int duration, String description) {
        super(name, size, format);
        this.duration = duration;
        this.description = description;
    }

    //геттеры и сеттеры
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) throws Exception {
        if (picture == null) throw new Exception("Передана некорректная ссылка на картинку!");
        this.picture = picture;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) throws Exception {
        if (duration < 0) throw new Exception("Передана некорректная длительность видеофайла!");
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //вовзращает детали объекта
    @Override
    public void getDetails() {
        //приведём длительность в формат часы:минуты:секунды
        int hour = 0;
        int minute = 0;
        int seconds = this.getDuration();

        if (seconds > 60) {
            minute = seconds / 60;
            seconds = seconds % 60;
            if (minute > 60) {
                hour = minute / 60;
                minute = minute % 60;
            }
        }

        //если часы, минуты, секундны меньше 10, то добавим в начале 0
        String _hour = "";
        String _minute = "";
        String _seconds = "";
        if(hour<10 && hour > 0)
            _hour = "0" + hour;
        else
            _hour = String.valueOf(hour);
        if(minute<10 && minute > 0)
            _minute = "0" + minute;
        else
            _minute = String.valueOf(minute);
        if(seconds<10 && seconds > 0)
            _seconds = "0" + seconds;
        else
            _seconds = String.valueOf(seconds);


        //для видео-аудио разделяем вывод в зависимости от наличия часов в длительности
        if (hour > 0) {
            if (this.getFormat() == FileFormat.AUDIO)
                System.out.println(this.getFormat() + ", " + this.getDescription() + ", " + _hour + ":" + minute + ":" + _seconds);
            if (this.getFormat() == FileFormat.VIDEO)
                System.out.println(this.getFormat() + ", " + this.getDescription() + ", " + _hour + ":" + minute + ":" + _seconds + ", " + getPicture().getHeight() + "x" + getPicture().getWeight());
        } else {
            if (this.getFormat() == FileFormat.AUDIO)
                System.out.println(this.getFormat() + ", " + this.getDescription() + ", " + _minute + ":" + _seconds);
            if (this.getFormat() == FileFormat.VIDEO)
                System.out.println(this.getFormat() + ", " + this.getDescription() + ", " + _minute + ":" + _seconds + ", " + getPicture().getHeight() + "x" + getPicture().getWeight());
        }

    }
}
