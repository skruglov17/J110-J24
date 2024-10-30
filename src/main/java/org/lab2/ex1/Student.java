package org.lab2.ex1;

public class Student extends Person {

    private LevelingStudy levelingStudy;
    private String dissertationTopic;
    private int courseNumber;


    //конструктор для аспирантов
    public Student(String firstName, String secondName, Sex sex, String nameFaculty, LevelingStudy levelingStudy, String dissertationTopic) {
        super(firstName, secondName, sex, nameFaculty);
        this.dissertationTopic = dissertationTopic;
        this.levelingStudy = levelingStudy;
    }

    //конструктор для бакалавров и магистров
    public Student(String firstName, String secondName, Sex sex, String nameFaculty, LevelingStudy levelingStudy, int courseNumber) {
        super(firstName, secondName, sex, nameFaculty);
        this.levelingStudy = levelingStudy;
        this.courseNumber = courseNumber;
    }

    //геттеры и сеттеры
    public LevelingStudy getLevelingStudy() {
        return levelingStudy;
    }

    public void setLevelingStudy(LevelingStudy levelingStudy) throws Exception {
        if(levelingStudy==null) throw new Exception("Передана некооректная ступень обучения!");
        this.levelingStudy = levelingStudy;
    }

    public String getDissertationTopic() {
        return dissertationTopic;
    }

    public void setDissertationTopic(String dissertationTopic) throws Exception {
        if(dissertationTopic==null || dissertationTopic.equals("")) throw new Exception("Передана неккоректная тема диссертации!");
        if(this.levelingStudy != LevelingStudy.ASPIRANT) throw new Exception("Тема диссетрации может быть назначена только аспирантам!");
        this.dissertationTopic = dissertationTopic;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) throws Exception {
        if(courseNumber<1 || courseNumber>5) throw new Exception("Передан некорректный курс!");
        if(this.levelingStudy == LevelingStudy.ASPIRANT) throw new Exception("Курс может быть назначен только бакалаврам, магистрам и специалистам!");
        this.courseNumber = courseNumber;
    }

    public void print() {
        String sex = this.getSex() == Sex.MALE ? "He" : "She";

        super.print();
        System.out.print(" " + sex + " studies " + this.getNameFaculty() + ". ");
        if(this.getLevelingStudy() == LevelingStudy.BACHELOR || this.getLevelingStudy() == LevelingStudy.MASTER)
            System.out.println(sex + " is " + this.getCourseNumber() + "'th year " + this.getLevelingStudy() + " student.");
        if(this.getLevelingStudy() == LevelingStudy.ASPIRANT) {
            sex = this.getSex() == Sex.MALE ? "His" : "Her";
            System.out.println(sex + " thesis title is " + this.getDissertationTopic() + ".");
        }
    }

    public static void printAll(Student[] students, int min, int max) {
        for (int i = min; i <= max; i++) {
            students[i].print();
        }
    }
}
