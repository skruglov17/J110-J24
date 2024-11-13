package src.main.java.org.lab2.ex1;

/**
 * Человек (абстрактный класс)
 */
public abstract class Person {

    private String firstName;
    private String secondName;
    private Sex sex;
    private String nameFaculty;

    /**
     * Конструктор человека.
     * @param firstName - Имя человека.
     * @param secondName - Фамилия человека.
     * @param sex - Пол человека.
     * @param nameFaculty - Факультет, на котором числится человек.
     */
    public Person(String firstName, String secondName, Sex sex, String nameFaculty) throws Exception {
        setFirstName(firstName);
        setSecondName(secondName);
        setSex(sex);
        setNameFaculty(nameFaculty);
    }

    /**
     * Получение имени человека.
     * @return name - Имя человека.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Определение имени человека.
     * @param firstName - Имя человека.
     */
    public void setFirstName(String firstName) throws Exception {
        if(firstName==null || firstName.equals("")) throw new Exception("Введено некорректное имя!");
        this.firstName = firstName;
    }

    /**
     * Получение фамилии человека.
     * @return secondName - Фамилия человека.
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Определение фамилии человека.
     * @param secondName - Фамилия человека.
     */
    public void setSecondName(String secondName) throws Exception {
        if(firstName==null || firstName.equals("")) throw new Exception("Введена некорректная фамилия!");
        this.secondName = secondName;
    }

    /**
     * Получение пола человека.
     * @return sex - Пол человека.
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Определение пола человека.
     * @param sex - Пол человека.
     */
    public void setSex(Sex sex) throws Exception {
        if(sex==null) throw new Exception("Введен некорретный пол человека!");
        this.sex = sex;
    }

    /**
     * Получение факультета, на котором числится человек.
     * @return nameFaculty - Название факультета.
     */
    public String getNameFaculty() {
        return nameFaculty;
    }

    /**
     * Определение факультета, на котором числится человек.
     * @param nameFaculty - Название факультета.
     */
    public void setNameFaculty(String nameFaculty) throws Exception {
        if(nameFaculty == null || nameFaculty.equals("")) throw new Exception("Введён некорректный факультет!");
        this.nameFaculty = nameFaculty;
    }

    /**
     * Вывод в консоль параметров человека в формате "This is {firstName} {secondName}."
     */
    public void print() {
        System.out.print("This is " + this.getFirstName() + " " + this.getSecondName() + ".");
    }
}
