package src.main.java.org.lab4;

import java.util.Arrays;

/**
 * Булевский массив
 */
public class BooleanLogic implements LogicInterface{

    private boolean[] array = new boolean[SIZE];

    /**
     * Получение значения индекса массива
     * @param index - Индекс массива
     * @return true/false - Значение массива по переданному индексу
     */
    @Override
    public boolean get(int index) {
        return array[index];
    }

    /**
     * Определение (в true) элемента с заданным индексом.
     * @param index - Индекс массива, который станет true
     */
    @Override
    public void setTrue(int index) {
        array[index] = true;
    }

    /**
     * Определение (в false) элемента с заданным индексом.
     * @param index - Индекс массива, который станет false
     */
    @Override
    public void setFalse(int index) {
        array[index] = false;
    }

    /**
     * Установка элемента с заданным индексом заданным логическим значением.
     * @param index - Индекс массива.
     * @param bool - Значение индекса массива.
     */
    @Override
    public void setIndex(int index, boolean bool) {
        array[index] = bool;
    }

    /**
     * Инвертирование элемента с заданным индексом.
     * @param index - Индекс массива.
     */
    @Override
    public void reverse(int index) {
        array[index] = !(array[index]);
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
        for(boolean bol : array){
            result.append(" ").append(bol ? 1 : 0);
        }
        return result.toString();
    }
}
