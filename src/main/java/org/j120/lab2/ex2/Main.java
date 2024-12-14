package src.main.java.org.j120.lab2.ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        //Определим файл с исходным текстом
        String inputFile = "j120-lab2_Ex2_InputFile.txt";

        //Если файл не задан
        if(inputFile.equals("")) {
            System.out.println("Введите полный путь к файлу:");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            inputFile = name;
        }

        ScriptingLanguage file = new ScriptingLanguage(inputFile);
        ArrayList<String> list = file.splitFile();
        //System.out.println(list);
        file.printFile(list);
        //System.out.println(file.getHashMap());
    }
}
