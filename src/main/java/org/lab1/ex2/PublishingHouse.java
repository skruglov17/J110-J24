package org.main;

public class PublishingHouse {

    private String name;
    private String city;

    //get-методы
    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public PublishingHouse(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }



}
