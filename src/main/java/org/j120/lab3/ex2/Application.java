package src.main.java.org.j120.lab3.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Приложение чтения csv-файлов
 */
public class Application extends JFrame {

    private static JLabel nameFile;
    private JTable table;
    private static String[] columnNames;
    private static String[][] data;

    /**
     * Конструктор класса. В нём задаются основные параметры по управлению окном приложения
     */
    public Application() {
        // Создаем окно
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Создаём панель
        JPanel panel = new JPanel(new BorderLayout());
        //Cоздаём кнопку и название файла последовательно
        Container container = getContentPane();
        container.setLayout (new FlowLayout(FlowLayout.LEFT));
        JButton button = new JButton("Выбрать файл");
        container.add(button);
        nameFile = new JLabel("Выбранный файл");
        container.add(nameFile);
        //Добавляем компоненты на панель
        panel.add(container, BorderLayout.NORTH);
        frame.setContentPane(panel);
        frame.setVisible(true);
        //Выбор файла
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser openFile = new JFileChooser();
                int choosedFile = openFile.showDialog(null, "Открыть файл");
                if (choosedFile == JFileChooser.APPROVE_OPTION) {
                    File file = openFile.getSelectedFile();
                    nameFile.setText(file.getName());
                    frame.setTitle(file.getAbsolutePath());
                    setTableData(file);
                    //Создаём таблицу и передаём массивы
                    table = new JTable(data, columnNames);
                    JScrollPane scrollPane = new JScrollPane(table);
                    panel.add(scrollPane, BorderLayout.CENTER);
                }
            }
        });
    }

    /**
     * Метод для получения всех данных таблицы из переданного csv-файла
     * @param selectedFile - csv-файл для чтения
     */
    private void setTableData(File selectedFile) {
        //Выводим текст файла в приложение
        StringBuilder sb = new StringBuilder();
        //BufferedReader быстрый, т.к. выводит информацию построчно. Идём через него
        try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
            //Получаем шапку таблицы
            String firstLine = br.readLine();
            columnNames = getColumnNames(firstLine);
            data = getData(br);
        } catch (IOException e) {
            System.out.println("Не был прочитан файл!" + e.getMessage());
        }
    }

    /**
     * Метод для получения шапки таблицы
     * @param line - строка с шапкой таблицы
     * @return - массив имен колонок таблицы
     */
    private static String[] getColumnNames(String line) {
        //Разбиваем на массив и убираем пробелы
        String[] resultCNames = line.split(",");
        resultCNames[0] = resultCNames[0].replaceAll("\uFEFF", "");
        for (int i = 0; i < resultCNames.length; i++) {
            resultCNames[i] = resultCNames[i].trim();
        }
        return resultCNames;
    }

    /**
     * Метод с получением данных таблицы
     * @param br - буфер строк
     * @return - массив данных таблицы
     * @throws IOException
     */
    private static String[][] getData(BufferedReader br) throws IOException {
        //Читаем все строки файла, разбивая на массив значений
        String[][] resultData = new String[1][columnNames.length];
        String line;
        int countLine = 0;
        while((line = br.readLine()) != null) {
            //Разбиваем строку на массив. Не учитываем запятые внутри кавычек,
            //Заменяем сдвоенные кавычки на одиночные,
            //Если значение целиком завёрнуто в кавычки, то убираем их
            String[] temp = line.split(",(?=(?:[^\"]*\\\"[^\"]*\\\")*[^\"]*$)");
            for (int i = 0; i < temp.length; i++) {
                temp[i] = temp[i].trim().replaceAll("\"\"", "\"");
                if(temp[i].startsWith("\"")) {
                    temp[i] = temp[i].substring(1, temp[i].length() - 1);
                }
            }
            //Проверяем одинаковой ли длины массив с шапкой
            if(temp.length != columnNames.length) {
                nameFile.setText("Ошибка чтения файла! Строки файла содержат разное количество колонок!");
                throw new IOException("Ошибка чтения файла! Строки файла содержат разное количество колонок!");
            }
            //Делаем копию текущего и создаём массив + 1
            String[][] copyData = resultData;
            resultData = new String[countLine+1][temp.length];
            for (int i = 0; i < countLine; i++) {
                for (int j = 0; j < temp.length; j++) {
                    resultData[i][j] = copyData[i][j];
                }
            }
            for (int i = 0; i < temp.length; i++) {
                resultData[countLine][i] = temp[i].trim();
            }
            countLine++;
        }
        return resultData;
    }
}
