package src.main.java.org.j110.lab1.ex1;

/**
 * Страна.
 */
public class Country {

    /**
     * Атрибуты страны и столицы
     */
    private String name;
    private String nameCapital;
    private int square;
    private int population;
    private int populationCapital;

    /**
     * Конструктор со всеми атрибутами
     * @param name - Название страны.
     * @param nameCapital - Название столицы.
     * @param square - Площадь страны.
     * @param population - Кол-во жителей страны.
     * @param populationCapital - Кол-во жителей столицы.
     */
    public Country(String name, String nameCapital, int square, int population, int populationCapital) throws Exception {
        this(name, square, population);
        setPopulation(population);
        setNameCapital(nameCapital);
        setPopulationCapital(populationCapital);
    }

    /**
     * Конструктор для городов-государств
     * @param name - Название страны.
     * @param square - Площадь страны.
     * @param population - Кол-во жителей страны.
     */
    public Country(String name, int square, int population) throws Exception {
        setName(name);
        setSquare(square);
        setPopulation(population);
    }

    /**
     * Конструктор если не известно население страны/столицы
     * @param name - Название страны.
     * @param nameCapital - Название столицы.
     * @param square - Площадь страны.
     */
    public Country(String name, String nameCapital, int square) throws Exception{
        setName(name);
        setNameCapital(nameCapital);
        setSquare(square);
    }

    /**
     * Получение названия страны.
     * @return name - Название страны.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Получение названия столицы.
     * @return nameCapital - Название столицы.
     */
    public String getNameCapital() {
        return this.nameCapital;
    }

    /**
     * Получение площади страны
     * @return square - Площадь страны, м2.
     */
    public int getSquare() {
        return this.square;
    }

    /**
     * Получение численности страны.
     * @return population - Численность страны.
     */
    public int getPopulation() {
        return this.population;
    }

    /**
     * Получение численности столицы.
     * @return populationCapital - Численность столицы.
     */
    public int getPopulationCapital() {
        return this.populationCapital;
    }

    /**
     * Расчёт плотности населения страны.
     * @return - Плотность населения страны (Численность/Площадь, чел./м2).
     */
        public int getPopulationDensityCountry() {
        return population/square;
    }

    /**
     * Определение названия страны.
     * @param name - Название страны.
     */
    public void setName(String name) throws Exception {
        if(name==null || name.isEmpty()) throw new Exception("Передано некорректное имя страны!");
        this.name = name;
    }

    /**
     * Определение названия столицы.
     * @param name - Название столицы.
     */
    public void setNameCapital(String name) throws Exception {
        if(name==null || name.isEmpty()) throw new Exception("Передано некорректное имя столицы!");
        this.nameCapital = name;
    }

    /**
     * Определение площади страны.
     * @param square - Площадь страны.
     */
    public void setSquare(int square) throws Exception {
        if(square < 0.0) throw new Exception("Передана некорректная площадь страны!");
        this.square = square;
    }

    /**
     * Определение численности страны.
     * @param number - Численность страны.
     */
    public void setPopulation(int number) throws Exception {
        if(number < 0) throw new Exception("Передана некорректная численность населения страны!");
        this.population = number;
    }

    /**
     * Определение численности столицы.
     * @param number - Численность столицы.
     */
    public void setPopulationCapital(int number) throws Exception{
        if(number < 0) throw new Exception("Передана некорректная численность населения столицы!");
        this.populationCapital = number;
    }

    /**
     * Установка параметров столицы.
     * @param name - Имя столицы. Если передано null, то сбрасываем данные.
     * @param number - Численность столицы. Если передано null, то сбрасываем данные.
     */
    //
    public void setAttributesCapital(String name, int number) throws Exception {
        setNameCapital(name);
        setPopulationCapital(number);
    }

    /**
     * Информация о стране. Вывод в консоль.
     */
    public void print() {
        if (getNameCapital() == null)
            System.out.println(getName() + ", " + getSquare() + ".0 кв. км., " + getPopulation() + " чел., " + "-");
        else if(getPopulation() <= 0 || getPopulationCapital() <= 0)
            System.out.println(getName() + ", " + getSquare() + ".0 кв. км., " + getNameCapital());
        else
            System.out.println(getName() + ", " + getSquare() + ".0 кв. км., " + getPopulation() + " чел., " + getNameCapital() + ", " + getPopulationCapital() + " чел.");
    }

    /**
     * Информация о странах в пределах заданного массива
     * @param countryArray - массив стран
     * @param min - начальный индекс
     * @param max - заключительный индекс
     */
    public static void printAll(Country[] countryArray, int min, int max) {
        for (int i = min; i < max; i++) {
            countryArray[i].print();
        }
    }

}
