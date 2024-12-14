package src.main.java.org.j120.lab2.ex1;

import java.io.BufferedReader;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        //Определим файл с исходным текстом
        String inputFile = "j120-lab2_Ex1_InputFile.txt";

        //Если файл не задан
        if(inputFile.equals("")) {
            System.out.println("Введите полный путь к файлу:");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            inputFile = name;
        }

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
