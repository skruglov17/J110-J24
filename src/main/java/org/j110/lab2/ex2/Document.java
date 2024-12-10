package src.main.java.org.j110.lab2.ex2;

/**
 * Документ.
 */
public class Document extends File {

    private int pageNumbers;

    /**
     * Конструктор документа.
     * @param name - Название документа.
     * @param size - Размер документа в байтах.
     * @param format - Формат документа.
     * @param pageNumbers - Количество страниц документа.
     */
    public Document(String name, int size, FileFormat format, int pageNumbers) {
        super(name, size, format);
        this.pageNumbers = pageNumbers;
    }

    /**
     * Получение количества страниц.
     * @return
     */
    public int getPageNumbers() {
        return pageNumbers;
    }

    /**
     * Определение количества страниц.
     * @param pageNumbers - Количество страниц.
     * @throws Exception
     */
    public void setPageNumbers(int pageNumbers) throws Exception {
        if(pageNumbers < 1) throw new Exception("Введено неккоректное количество страниц документа!");
        this.pageNumbers = pageNumbers;
    }

    /**
     * Вывод в консоль детали по документу.
     */
    @Override
    public void getDetails() {
        System.out.println(super.getFormat() + ", " + this.getPageNumbers() + " pages");
    }

}
