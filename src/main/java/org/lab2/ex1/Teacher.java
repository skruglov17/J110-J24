package org.lab2.ex1;

public class Teacher extends Person {

    private AcademicDegree academicDegree;
    private String specialty;


    //конструктор
    public Teacher(String firstName, String secondName, Sex sex, String nameFaculty, AcademicDegree academicDegree, String specialty) {
        super(firstName, secondName, sex, nameFaculty);
        this.academicDegree = academicDegree;
        this.specialty = specialty;
    }


    //геттеры и сеттеры
    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) throws Exception {
        if(academicDegree==null) throw new Exception("Передана некорректная учёная степень!");
        this.academicDegree = academicDegree;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) throws Exception {
        if(specialty == null || specialty.equals("")) throw new Exception("Передано некорректное название специальности!");
        this.specialty = specialty;
    }

    public void print() {

        String sex = this.getSex() == Sex.MALE ? "He" : "She";

        super.print();
        System.out.println(" " + sex + " teaches " + this.getNameFaculty() + ". "
                           + sex + " has " + this.getAcademicDegree() + " degree in " + this.getSpecialty() + ".");
    }

    public static void printAll(Teacher[] teachers, int min, int max) {
        for (int i = min; i <= max; i++) {
            teachers[i].print();
        }
    }
}
