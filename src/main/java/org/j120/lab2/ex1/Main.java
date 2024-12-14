package src.main.java.org.j120.lab2.ex1;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        //Определим файл с исходным текстом
        String inputFile = "j120-lab2_InputFile.txt";

        //Получаем весь список слов из текста
        WordCounter file = new WordCounter(inputFile);
        List<String> list = file.splitFile();

        //Выведем в консоль все слова по отдельности
        WordCounter.print(list);

        //Делаем отчет со списком слов отсортированным по алфавиту:
        Collections.sort(list);
        file.saveReports("report-by-alph.txt", list);

        //Создаем отчет со списком слов с обратной сортировкой:
        Collections.reverse(list);
        file.saveReports("report-by-alph-rev.txt", list);

        //Создаем отчёт с сортировкой по убыванию
        file.saveReportCounter(list);
    }
}
