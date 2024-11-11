package src.main.java.org.lab1.ex2;

public class PublishingHouse {

    private String name;
    private String city;

    /**
     * Получение названия издательства.
     * @return name - Название издательства.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Получение города издательства.
     * @return city - Город издательства.
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Конструктор издательства.
     * @param name - Название издательства.
     * @param city - Город издательства.
     */
    public PublishingHouse(String name, String city) {
        this.name = name;
        this.city = city;
    }

    /**
     * Определение названия издательства
     * @param name - Название издательства.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Определение города издательства
     * @param city - Город издательства.
     */
    public void setCity(String city) {
        this.city = city;
    }



}
