package src.main.java.org.j120.lab3.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Application extends JFrame {

    private final JLabel nameFile;
    private JTable table;
    /*
    Сделать их приватными, чтобы данные начитывать сразу???
     */
    private String[] columnNames = {"1", "2"};
    private String[][] data = {{"3", "4"}, {"5", "6"}};

    public Application() {
        //Зададим размер окна и поведение при закрытии
        setBounds(100, 100, 1200, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Создадим диалоговое окно с выбором файла
        JPanel panel = new JPanel();
        //Добавим вызов окна для выбора csv-файла
        JButton button = new JButton("Выбрать файл");
        nameFile = new JLabel("Выбранный файл");
        panel.add(button);
        panel.add(nameFile);
        //Выбор файла
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser openFile = new JFileChooser();
                int choosedFile = openFile.showDialog(null, "Открыть файл");
                if (choosedFile == JFileChooser.APPROVE_OPTION) {
                    File file = openFile.getSelectedFile();
                    nameFile.setText(file.getName());
                    setTitle(file.getAbsolutePath());
                    printText(file);
                    //Создаём таблицу и передаём массивы
                    table = new JTable(data, columnNames);
                    getContentPane().add(panel);
                    //Разделим список файлов и текст выбранного файла
                    JSplitPane sp = new JSplitPane(
                            //Разделение по вертикали
                            JSplitPane.VERTICAL_SPLIT,
                            //Добавим разделённую полосу
                            new JScrollPane(panel),
                            new JScrollPane(table));
                    //Добавим расположение списка и текста в окне
                    add(sp, BorderLayout.CENTER);
                    //Указываем ширину делителя на указанное кол-во пикселей
                    sp.setDividerLocation(50);
                    setVisible(true);
                }
            }
        });
        //Разделим список файлов и текст выбранного файла
        JSplitPane sp = new JSplitPane(
                //Разделение по вертикали
                JSplitPane.VERTICAL_SPLIT,
                //Добавим разделённую полосу
                new JScrollPane(panel),
                new JScrollPane(table));
        //Добавим расположение списка и текста в окне
        add(sp, BorderLayout.CENTER);
        //Указываем ширину делителя на указанное кол-во пикселей
        sp.setDividerLocation(50);
        setVisible(true);
    }



    /*
    Выделить отдельные методы на получение шапки
    И на заполнение данных
    Включить их в конструктор приложения
    */
    private void printText(File selectedFile) {
        //Выводим текст файла в приложение
        StringBuilder sb = new StringBuilder();
        //BufferedReader быстрый, т.к. выводит информацию построчно. Идём через него
        try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
            //Получаем шапку таблицы
            String firstLine = br.readLine();
            //Разбиваем на массив и убираем пробелы
            columnNames = firstLine.split(",");
            data = new String[1000][columnNames.length];
            for (int i = 0; i < columnNames.length; i++) {
                columnNames[i] = columnNames[i].trim();
            }
            //Читаем все строки файла, разбивая на массив значений
            String line;
            int countLine = 0;
            while((line = br.readLine()) != null) {
                //Получаем массив строки и убираем пробелы
                String[] temp = line.split(",");
                //Проверяем одинаковой ли длины массив с шапкой
                if(temp.length != columnNames.length) {
                    nameFile.setText("Файл не может быть прочитан!");
                    break;
                }
                for (int i = 0; i < temp.length; i++) {
                    data[countLine][i] = temp[i].trim();
                }
                countLine++;
            }
        } catch (IOException e) {
            System.out.println("Не был прочитан файл!" + e.getMessage());
        }
    }
}
