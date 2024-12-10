package src.main.java.org.j110.lab2.ex2;

/**
 * Картинка
 */
public class Picture extends File {

    private int height;
    private int weight;

    /**
     * Конструктор картинки
     * @param name - Название картинки.
     * @param size - Размер картинки.
     * @param format - Формат картинки.
     * @param height - Высота картинки.
     * @param weight - Ширина картинки.
     */
    public Picture(String name, int size, FileFormat format, int height, int weight) {
        super(name, size, format);
        this.height = height;
        this.weight = weight;
    }

    /**
     * Получение высоты картинки.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Определение высоты картинки.
     * @param height - Высота картинки.
     */
    public void setHeight(int height) throws Exception {
        if(height <= 0) throw new Exception("Передан некорректный размер картинки!");
        this.height = height;
    }

    /**
     * Получение ширины картинки.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Определение ширины картинки.
     * @param weight - Ширина картинки.
     */
    public void setWeight(int weight) throws Exception{
        if(weight <= 0)throw new Exception("Передан некорректный размер картинки!");
        this.weight = weight;
    }

    /**
     * Получение информации о картинке.
     */
    @Override
    public void getDetails() {
        System.out.println(super.getFormat() + ", " + this.getHeight() + "x" + this.getWeight());
    }
}
