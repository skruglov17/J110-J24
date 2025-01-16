package org.j110.lab2.ex1;

/**
 * Преподаватель.
 */
public class Teacher extends Person {

    private AcademicDegree academicDegree;
    private String specialty;


    /**
     * Конструктор преподавателя.
     * @param firstName - Имя аспиранта.
     * @param secondName - Фамилия аспиранта.
     * @param sex - Пол аспиранта.
     * @param nameFaculty - Название факультета.
     * @param academicDegree - Академическая ступень.
     * @param specialty - Специальность.
     */
    public Teacher(String firstName, String secondName, Sex sex, String nameFaculty, AcademicDegree academicDegree, String specialty) throws Exception {
        super(firstName, secondName, sex, nameFaculty);
        setAcademicDegree(academicDegree);
        setSpecialty(specialty);
    }

    /**
     * Получение академической ступени.
     * @return academicDegree - Академическая ступень.
     */
    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    /**
     * Определение академической ступени.
     * @param academicDegree - Академическая ступень.
     */
    public void setAcademicDegree(AcademicDegree academicDegree) throws Exception {
        if(academicDegree==null) throw new Exception("Передана некорректная учёная степень!");
        this.academicDegree = academicDegree;
    }

    /**
     * Получение специальности.
     * @return specialty - Специальность.
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Определение специальности.
     * @param specialty - Специальность.
     */
    public void setSpecialty(String specialty) throws Exception {
        if(specialty == null || specialty.equals("")) throw new Exception("Передано некорректное название специальности!");
        this.specialty = specialty;
    }

    /**
     * Получение информации о преподавателе.
     */
    public void print() {

        String sex = this.getSex() == Sex.MALE ? "He" : "She";

        super.print();
        System.out.println(" " + sex + " teaches " + this.getNameFaculty() + ". "
                           + sex + " has " + this.getAcademicDegree() + " degree in " + this.getSpecialty() + ".");
    }

    /**
     * Получение информации о преподавателях в пределах заданного массива
     * @param teachers - Массив студентов
     * @param min - начальный индекс
     * @param max - заключительный индекс
     */
    public static void printAll(Teacher[] teachers, int min, int max) {
        for (int i = min; i <= max; i++) {
            teachers[i].print();
        }
    }
}
