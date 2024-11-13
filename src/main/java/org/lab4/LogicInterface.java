package src.main.java.org.lab4;

/**
 * Интерфейс логических значений
 */
public interface LogicInterface {

    /**
     * Размер массивов
     */
    int SIZE = 64;

    /**
     * Получение значения индекса массива
     * @param index - Индекс массива
     * @return true/false - Значение массива по переданному индексу
     */
    boolean get(int index);

    /**
     * Определение (в true) элемента с заданным индексом.
     * @param index - Индекс массива, который станет true
     */
    void setTrue(int index);

    /**
     * Определение (в false) элемента с заданным индексом.
     * @param index - Индекс массива, который станет false
     */
    void setFalse(int index);

    /**
     * Установка элемента с заданным индексом заданным логическим значением.
     * @param index - Индекс массива.
     * @param bool - Значение индекса массива.
     */
    void setIndex(int index, boolean bool);

    /**
     * Инвертирование элемента с заданным индексом.
     * @param index - Индекс массива.
     */
    void reverse(int index);

    /**
     * Количество элементов, установленных в true.
     * @return count - Количество элементов в true.
     */
    int countTrue();



}
