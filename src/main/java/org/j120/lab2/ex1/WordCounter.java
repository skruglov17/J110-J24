package src.main.java.org.j120.lab2.ex1;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * Метод для работы с файлами
 */
public class WordCounter extends File {

    /**
     * Конструктор с указанием названия файла
     * @param pathname - Название файла. Пример: "j120-lab2_Ex1_InputFile.txt"
     */
    public WordCounter(String pathname) {
        super(pathname);
    }

    /**
     * Метод деления файла на отдельные слова с исключением пунктуации
     * @return Коллекция строк файла
     * @throws Exception - Исключение в случае недоступности файла для чтения
     */
    public List<String> splitFile() throws Exception {
        if (!this.canRead()) throw new Exception("Файл не доступен для чтения!");
        List<String> words = Files.lines(this.toPath())
                .map(e -> e.replaceAll("[?!()I,.:;*{—}«»…]", ""))
                .map(String::toLowerCase)
                .flatMap(e -> Arrays.stream(e.split(" ")))
                .map(e -> e.trim())
                .filter(e -> !e.equals("-") && !e.isEmpty())
                .toList();
        return new ArrayList<String>(words);
    }

        /**
         * Метод вывода в консоль всех слов в листе
         * @param words - Лист слов
         * */
    public static void print(List<String> words) {
        words.forEach(System.out::println);
    }

    /**
     * Генерация файла по переданному списку
     * @param name - Название файла
     * @param list - Лист слов
     */
    public void saveReports(String name, List<String> list){
        File file = new File(name);
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        if (file.canWrite()){
            try (FileWriter writer = new FileWriter(file, false)){
                for (String s:list){
                    writer.write(s+"\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Генерация файла с подсчётом частоты встречаемости слов и фильтрацией по наиболее встречающимся
     * @param list - Список слов
     */
    public void saveReportCounter(List<String> list) {
        //Посчитаем количество слов
        HashMap<String, Integer> hashMap = new HashMap<>();
        list.forEach(e -> {
            if(hashMap.containsKey(e)) {
                hashMap.put(e, hashMap.get(e) + 1);
            } else {
                hashMap.put(e, 1);
            }
        });
        //Отсортируем список по значению
        List<Map.Entry<String, Integer>> valuesList = new ArrayList<>(hashMap.entrySet());
        valuesList.sort(new MyComporator());
        System.out.println(valuesList);
        //Отформатируем весь текст
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> s : valuesList) {
            sb.append(s.getKey()).append(" - ").append(s.getValue()).append("\n");
        }
        //Сформируем файл
        File file = new File("report-by-freq.txt");
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        if (file.canWrite()){
            try (FileWriter writer = new FileWriter(file, false)){
                writer.write(sb.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
