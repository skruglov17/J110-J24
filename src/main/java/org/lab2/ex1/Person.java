package org.lab2.ex1;

public abstract class Person {

    private String firstName;
    private String secondName;
    private Sex sex;
    private String nameFaculty;


    //конструктор
    public Person(String firstName, String secondName, Sex sex, String nameFaculty) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.sex = sex;
        this.nameFaculty = nameFaculty;
    }


    //геттеры и сеттеры
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        if(firstName==null || firstName.equals("")) throw new Exception("Введено некорректное имя!");
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) throws Exception {
        if(firstName==null || firstName.equals("")) throw new Exception("Введена некорректная фамилия!");
        this.secondName = secondName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) throws Exception {
        if(sex==null || sex.equals("")) throw new Exception("Введен некорретный пол человека!");
        this.sex = sex;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) throws Exception {
        if(nameFaculty == null || nameFaculty.equals("")) throw new Exception("Введён некорректный факультет!");
        this.nameFaculty = nameFaculty;
    }

    public void print() {
        System.out.print("This is " + this.getFirstName() + " " + this.getSecondName() + ".");
    }

}
