package org.j120.lab2.ex2;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

/**
 * Интерпретатор языка
 */
public class ScriptingLanguage extends File {

    private Map<String, Integer> hashMap;

    public Map<String, Integer> getHashMap() {
        return hashMap;
    }

    /**
     * Конструктор интерпретатора
     */
    public ScriptingLanguage(String inputFile) {
        super(inputFile);
        hashMap = new HashMap<>();
    }

        /**
     * Метод для разбивки файла на строки
     * @return Лист строк
     * @throws Exception
     */
    private ArrayList<String> splitFile() throws Exception {
        if (!this.canRead()) throw new Exception("Файл не доступен для чтения!");
        List<String> strings = Files.lines(this.toPath())
                .flatMap(e -> Arrays.stream(e.split("\n")))
                .map(e -> e.trim())
                .filter(e -> !e.equals("-") && !e.isEmpty())
                .toList();
        return new ArrayList<String>(strings);
    }

    /**
     * Метод для печати в консоль всей информации из файла после преобразования.
     * Выполняем построчно, так как вывести информацию надо в определённый момент времени (текущее значение переменной)
     */
    public void printFile() throws Exception {
        ArrayList<String> list = splitFile();
        for (String s : list) {
            //Получим отдельную строку
            s = s.trim();
//          s.replace((char) 65279, ' ');
            // Пропустим пустые или комментарии
            if (s.isEmpty() | s.startsWith(" #") | s.startsWith("#") | s.startsWith("\uFEFF")) {
                continue;
            }
            //Найдём действие (всегда в начале строки)
            String[] substrings = s.split(" ", 2);
            String action = substrings[0];
            //Смотрим, что за действие
            switch (action) {
                //Для печати
                case "print":
                    //Печатаем вторую часть строки
                    printValues(substrings[1]);
                    continue;
                //Для сложения, вычитания и присвоения
                case "set":
                    String st = substrings[1];
                    //Ищем название переменной
                    int indexNameFirst = st.indexOf("$");
                    int indexNameLast = st.indexOf(" ", indexNameFirst);
                    String varSum = st.substring(indexNameFirst + 1, indexNameLast);
                    int valueSum = 0;
                    //Если нет минусов и/или плюсов, значит это присвоение переменной
                    if(!(st.contains("-") | st.contains("+"))) {
                        //Ищем значение переменной
                        int indexValueFirst = st.indexOf("=") + 2;
                        int indexValueLast = st.length();
                        String value = st.substring(indexValueFirst, indexValueLast);
                        valueSum = Integer.valueOf(value);
                        hashMap.put(varSum, valueSum);
                        break;
                    //Иначе это операции сложения и/или вычитания
                    } else {
                        //Найдем первое значение после знака равенства
                        int indexValueFirst = st.indexOf("$", st.indexOf("=") + 1);
                        int indexValueLast = st.indexOf(" ", indexValueFirst);
                        valueSum = hashMap.get(st.substring(indexValueFirst+1, indexValueLast));
                        //Находим все сложения
                        int hasPlus = st.indexOf("+", indexNameLast);
                        //Пока мы находим плюсы, то складываем значения за ним
                        while(hasPlus != -1) {
                            indexValueFirst = st.indexOf("$", hasPlus + 1);
                            indexValueLast = st.indexOf(" ", indexValueFirst);
                            int valueVar = hashMap.get(st.substring(indexValueFirst+1, indexValueLast));
                            valueSum += valueVar;
                            hasPlus = st.indexOf("+", hasPlus+1);
                        }
                        //Находим все вычитания
                        int hasMinus = st.indexOf("-", indexNameLast);
                        //Пока мы находим минусы, то вычитаем значения за ним
                        while(hasMinus != -1) {
                            //Если это переменная, то найдём значение
                            if(st.indexOf("$", hasMinus + 1) != -1) {
                                indexValueFirst = st.indexOf("$", hasMinus + 1);
                                indexValueLast = st.indexOf(" ", indexValueFirst);
                                int valueVar = hashMap.get(st.substring(indexValueFirst+1, indexValueLast));
                                valueSum -= valueVar;
                                hasMinus = st.indexOf("-", indexValueLast);
                            //Если это число, то берём его
                            } else {
                                indexValueFirst = st.indexOf(" ", hasMinus + 1) + 1;
                                indexValueLast = st.indexOf(" ", indexValueFirst + 1);
                                if(indexValueLast == -1) indexValueLast = st.length();
                                String value = st.substring(indexValueFirst, indexValueLast);
                                int valueVar = Integer.valueOf(value);
                                valueSum -= valueVar;
                                hasMinus = st.indexOf("-", indexValueLast);
                            }
                        }
                        //Кладём значение в мапу
                        hashMap.put(varSum, valueSum);
                        break;
                    }
                default:
                    System.out.print("Не смогли определить действие: ");
                    printValues(s);
            }
        }
    }

    private void printValues(String s) {
        //Разделим строку на подстроки по запятым
        String[] substrings = s.split(",");
        StringBuilder sb = new StringBuilder();
        //Дальше пойдём по каждой строке. Если кавычки, то печатаем полностью и без кавычек
        for (int i = 0; i < substrings.length; i++) {
            if(substrings[i].contains("\"")) {
                sb.append(substrings[i].replaceAll("\"", ""));
            //Если кавычки отсутствуют заменяем значение, затем печатаем
            } else {
                int hasNextVar = 0;
                while(hasNextVar != -1) {
                    int indexNameFirst = substrings[i].indexOf("$", hasNextVar);
                    int indexNameLast = substrings[i].indexOf(" ", indexNameFirst);
                    if(indexNameLast == -1) indexNameLast = substrings[i].length();
                    String varName = substrings[i].substring(indexNameFirst + 1, indexNameLast);
                    int valueVar = hashMap.get(varName);
                    substrings[i] = substrings[i].replaceAll(("\\$" + varName), String.valueOf(valueVar)).replaceAll(" ", "");
                    sb.append(substrings[i]);
                    hasNextVar = substrings[i].indexOf("$", indexNameLast);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
