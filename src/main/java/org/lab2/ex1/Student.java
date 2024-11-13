package src.main.java.org.lab2.ex1;

/**
 * Студент
 */
public class Student extends Person {

    private LevelingStudy levelingStudy;
    private String dissertationTopic;
    private int courseNumber;

    /**
     * Конструктор аспиранта.
     * @param firstName - Имя аспиранта.
     * @param secondName - Фамилия аспиранта.
     * @param sex - Пол аспиранта.
     * @param nameFaculty - Название факультета.
     * @param dissertationTopic - Название диссертации.
     */
    public Student(String firstName, String secondName, Sex sex, String nameFaculty, String dissertationTopic) throws Exception {
        super(firstName, secondName, sex, nameFaculty);
        setLevelingStudy(LevelingStudy.ASPIRANT);
        setDissertationTopic(dissertationTopic);
    }

    /**
     * Конструктор бакалавров и магистров.
     * @param firstName - Имя аспиранта.
     * @param secondName - Фамилия аспиранта.
     * @param sex - Пол аспиранта.
     * @param nameFaculty - Название факультета.
     * @param levelingStudy - Уровень обучения.
     * @param courseNumber - Номер курса.
     */
    public Student(String firstName, String secondName, Sex sex, String nameFaculty, LevelingStudy levelingStudy, int courseNumber) throws Exception {
        super(firstName, secondName, sex, nameFaculty);
        setLevelingStudy(levelingStudy);
        setCourseNumber(courseNumber);
    }

    /**
     * Получение уровня обучения.
     * @return levelingStudy - Уровень обучения.
     */
    public LevelingStudy getLevelingStudy() {
        return levelingStudy;
    }

    /**
     * Определение уровня обучения.
     * @param levelingStudy - Уровень обучения.
     */
    public void setLevelingStudy(LevelingStudy levelingStudy) throws Exception {
        if(levelingStudy==null) throw new Exception("Передана некооректная ступень обучения!");
        this.levelingStudy = levelingStudy;
    }

    /**
     * Получение темы диссертации.
     * @return dissertationTopic - Тема диссертации.
     */
    public String getDissertationTopic() {
        return dissertationTopic;
    }

    /**
     * Определение темы диссертации.
     * @param dissertationTopic - Тема диссертации.
     */
    public void setDissertationTopic(String dissertationTopic) throws Exception {
        if(dissertationTopic==null || dissertationTopic.equals("")) throw new Exception("Передана неккоректная тема диссертации!");
        if(this.levelingStudy != LevelingStudy.ASPIRANT) throw new Exception("Тема диссетрации может быть назначена только аспирантам!");
        this.dissertationTopic = dissertationTopic;
    }

    /**
     * Получение номера курса.
     * @return courseNumber - Номер курса.
     */
    public int getCourseNumber() {
        return courseNumber;
    }

    /**
     * Определение номера курса.
     * @param courseNumber - Номер курса.
     */
    public void setCourseNumber(int courseNumber) throws Exception {
        if(courseNumber<1 || courseNumber>5) throw new Exception("Передан некорректный курс!");
        if(this.levelingStudy == LevelingStudy.ASPIRANT) throw new Exception("Курс может быть назначен только бакалаврам, магистрам и специалистам!");
        this.courseNumber = courseNumber;
    }

    /**
     * Получение информации о студенте
     */
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

    /**
     * Получение информации о студентах в пределах заданного массива
     * @param students - Массив студентов
     * @param min - начальный индекс
     * @param max - заключительный индекс
     */
    public static void printAll(Student[] students, int min, int max) {
        for (int i = min; i <= max; i++) {
            students[i].print();
        }
    }
}
