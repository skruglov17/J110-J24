package src.main.java.org.j110.lab4;

/**
 * Целочисленный массив
 */
public class IntegerLogic implements LogicInterface{

    private int[] array = new int[SIZE/2];


    /**
     * Получение значения индекса массива
     * @param index - Индекс массива
     * @return true/false - Значение массива по переданному индексу
     */
    @Override
    public boolean get(int index) {
        int arrayIndex = index / 32;
        int bitIndex = index % 32;
        int mask = 1 << bitIndex;
        return (mask & array[arrayIndex]) == mask;
    }

    /**
     * Определение (в true) элемента с заданным индексом.
     * @param index - Индекс массива, который станет true
     */
    @Override
    public void setTrue(int index) {
        int arrayIndex = index / 32;
        int bitIndex = index % 32;
        int mask = 1 << bitIndex;
        array[arrayIndex] = mask | array[arrayIndex];
    }

    /**
     * Определение (в false) элемента с заданным индексом.
     * @param index - Индекс массива, который станет false
     */
    @Override
    public void setFalse(int index) {
        int arrayIndex = index / 32;
        int bitIndex = index % 32;
        int mask = -(1 << bitIndex);
        array[arrayIndex] = mask & array[arrayIndex];
    }

    /**
     * Установка элемента с заданным индексом заданным логическим значением.
     * @param index - Индекс массива.
     * @param bool - Значение индекса массива.
     */
    @Override
    public void setIndex(int index, boolean bool) {
        if(bool) setTrue(index);
        else setFalse(index);
    }

    /**
     * Инвертирование элемента с заданным индексом.
     * @param index - Индекс массива.
     */
    @Override
    public void reverse(int index) {
        int arrayIndex = index / 32;
        int bitIndex = index % 32;
        int mask = 1 << bitIndex;
        array[arrayIndex] = mask ^ array[arrayIndex];
    }

    /**
     * Количество элементов, установленных в true.
     * @return count - Количество элементов в true.
     */
    @Override
    public int countTrue() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if(get(i)) count++;
        }
        return count;
    }

    /**
     * Последовательность нулей и единиц, где каждый символ представляет значение соответствующего элемента массива.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            result.append(" ").append(get(i) ? 1 : 0);
        }
        return result.toString();
    }
}