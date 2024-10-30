package src.main.java.org.lab1.ex1;

public class Country {

    //Атрибуты страны и столицы
    private String name;
    private String nameCapital;
    private int square;
    private int population;
    private int populationCapital;

    //Конструктор со всеми атрибутами
    public Country(String name, String nameCapital, int square, int population, int populationCapital) {
        this.name = name;
        this.nameCapital = nameCapital;
        this.square = square;
        this.population = population;
        this.populationCapital = populationCapital;
    }

    //Конструктор для городов-государств
    public Country(String name, int square, int population) {
        this.name = name;
        this.square = square;
        this.population = population;
    }

    //Конструктор если не известно население страны/столицы
    public Country(String name, String nameCapital, int square) {
        this.name = name;
        this.nameCapital = nameCapital;
        this.square = square;
    }

    //методы  возврата основных атрибутов страны
    public String getName() {
        return this.name;
    }

    public String getNameCapital() {
        return this.nameCapital;
    }

    public int getSquare() {
        return this.square;
    }

    public int getPopulation() {
        return this.population;
    }

    public int getPopulationCapital() {
        return this.populationCapital;
    }

    //Расчёт плотности населения страны
        public int getPopulationDensityCountry() {
        return population/square;
    }

    //Присвоение значений атрибутов объекта
    public void setName(String name) throws Exception {
        if(name==null || name.isEmpty()) throw new Exception("Передано некорректное имя страны!");
        this.name = name;
    }

    public void setNameCapital(String name) throws Exception {
        if(name==null || name.isEmpty()) throw new Exception("Передано некорректное имя столицы!");
        this.nameCapital = name;
    }

    public void setSquare(int square) throws Exception {
        if(square < 0.0) throw new Exception("Передана некорректная площадь страны!");
        this.square = square;
    }

    public void setPopulation(int number) throws Exception {
        if(number < 0) throw new Exception("Передана некорректная численность населения страны!");
        this.population = number;
    }

    public void setPopulationCapital(int number) throws Exception{
        if(number < 0) throw new Exception("Передана некорректная численность населения столицы!");
        this.populationCapital = number;
    }

    //Установка параметров столицы
    //Если передано null, то сбрасываем данные
    public void setAttributesCapital(String name, int number) {
        this.nameCapital = name;
        this.populationCapital = number;
    }

    //метод возвращающий информацию о стране
    public void print() {
        if (this.nameCapital == null)
            System.out.println(this.getName() + ", " + this.getSquare() + ".0 кв. км., " + this.getPopulation() + " чел., " + "-");
        else if(this.population <= 0 || this.populationCapital <= 0)
            System.out.println(this.getName() + ", " + this.getSquare() + ".0 кв. км., " + this.getNameCapital());
        else
            System.out.println(this.getName() + ", " + this.getSquare() + ".0 кв. км., " + this.getPopulation() + " чел., " + this.getNameCapital() + ", " + this.getPopulationCapital() + " чел.");
    }

    //метод, возвращающий информацию в пределах заданного массива
    public static void printAll(Country[] countryArray, int min, int max) {
        for (int i = min; i < max; i++) {
            countryArray[i].print();
        }
    }

}
