package org.main;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{

        Teacher[] teachers = new Teacher[2];
        teachers[0] = new Teacher("Ronald", "Turner", Sex.MALE, "Computer Science", AcademicDegree.PhD, "Programming paradigms");
        teachers[1] = new Teacher("Ruth", "Hollings", Sex.FEMALE, "Jurisprudence", AcademicDegree.MSc, "Domestic arbitration");

        Student[] students = new Student[4];
        students[0] = new Student("Leo", "Wilkinson", Sex.MALE, "Computer Science", LevelingStudy.BACHELOR, 3);
        students[1] = new Student("Anna", "Cunningham", Sex.FEMALE, "World economy", LevelingStudy.BACHELOR, 1);
        students[2] = new Student("Jill", "Lundqvist", Sex.FEMALE, "Jurisprudence", LevelingStudy.MASTER, 1);
        students[3] = new Student("Ronald", "Correa", Sex.MALE, "Computer Science", LevelingStudy.ASPIRANT, "Design of a functional programming language");

        Teacher.printAll(teachers, 0, 1);
        Student.printAll(students, 0, 3);
    }
}