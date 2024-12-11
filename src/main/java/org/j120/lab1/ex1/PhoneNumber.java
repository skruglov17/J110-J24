package src.main.java.org.j120.lab1.ex1;

import java.util.Objects;

/**
 * Номер телефона
 */
public class PhoneNumber {

    private final String areaCode;
    private final String localNumber;

    /**
     * Конструктор номера
     * @param areaCode - Код региона
     * @param localNumber - Местный номер
     * @throws Exception - исключение в случае некорректного значения
     */
    public PhoneNumber(String areaCode, String localNumber) throws Exception{
        checkCorrectValue(areaCode, 1);
        checkCorrectValue(localNumber, 2);
        this.areaCode = areaCode;
        this.localNumber = localNumber;
    }

    /**
     * Метод проверки переданного номера на корректные значения
     * @param value - Номер для проверки
     * @param type - Тип номера:
     *             1 - Код региона
     *             2 - Местный номер
     * @throws Exception
     */
    private void checkCorrectValue(String value, int type)  throws Exception{
        //Используем в выводе исключения
        String str = "кода региона";
        if(type == 2) str = "местного номера";
        //Добавляем проверку на пустое значение и отсутствие нечисловых символов
        if(value == null || value.isEmpty()) throw new Exception("Введено пустое значение " + str + "!");
        for (int i = 0; i < value.length(); i++) {
            if(!Character.isDigit(value.charAt(i))) throw new Exception("Введено нечисловое значение " + str + "!");
        }
    }

    /**
     * Метод вывода информации по номеру телефона
     * @return строковое представление номера телефона.
     * Код региона заключается в скобки.
     * Местный номер разделяется дефисами.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //Заполним код региона
        sb.append('(').append(areaCode).append(')');
        //Разбиваем местный номер на дефисы
        //2 или 3 символа вначале
        int plus = (localNumber.length() % 2) + 2;
        sb.append(localNumber, 0, plus).append('-');
        //Далее цикл в зависимости от оставшихся символов
        while(plus < localNumber.length()) {
            if (plus + 2 < localNumber.length()) sb.append(localNumber, plus, plus+2).append('-');
            if ((plus + 2 >= localNumber.length())) sb.append(localNumber, plus, plus+2);
            plus += 2;
        }
        return sb.toString();
        }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PhoneNumber)) return false;
        PhoneNumber otherObj = (PhoneNumber) obj;
        return  this.areaCode.equals(otherObj.getAreaCode()) &&
                this.localNumber.equals(otherObj.getLocalNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, localNumber);
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getLocalNumber() {
        return localNumber;
    }
}
