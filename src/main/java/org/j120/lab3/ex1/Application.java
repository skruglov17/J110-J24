package org.j120.lab3.ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Arrays;

/**
 * Приложение по просмотру текстовых файлов
 */
public class Application extends JFrame {

    private final JList filesList;
    private final JTextArea fileText;
    private File[] files;

    /**
     * Конструктор класса. В нём задаются основные параметры по управлению окном приложения
     */
    public Application() {
        //Зададим размер окна и поведение при закрытии
        setBounds(100, 100, 1200, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Определим поведение списка
        filesList = new JList();
        //Зададим одиночный выбор
        filesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Добавим прослушиватель списка для отслеживания изменений
        filesList.addListSelectionListener(e -> printText());
        //Добавим реакцию на клавишу - Enter для перехода в подкаталог
        filesList.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER)
                    action();
            }
        });
        //Добавим реакцию на мышь - одинарный щелчок ЛКМ
        filesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1)
                    action();
            }
        });
        //Определим поведение текста файла
        fileText = new JTextArea();
        //Сделаем его не редактируемым.
        fileText.setEditable(false);
        //Разделим список файлов и текст выбранного файла
        JSplitPane sp = new JSplitPane(
                //Разделение по вертикали
                JSplitPane.HORIZONTAL_SPLIT,
                //Добавим разделённую полосу
                new JScrollPane(filesList),
                new JScrollPane(fileText));
        //Добавим расположение списка и текста в окне
        add(sp, BorderLayout.CENTER);
        //Указываем ширину делителя на указанное кол-во пикселей
        sp.setDividerLocation(300);
        //Зададим начальный каталог, откуда открываем приложение
        selectList(new File(System.getProperty("user.dir")));
        setVisible(true);
    }

    /**
     *Проверка действия на выбор. Если выбран, то это каталог или файл
     */
    private void action() {
        //Найдем индекс выбранного файла
        int index = filesList.getSelectedIndex();
        //Проверим, что файл был выбран (не -1)
        if (index == -1) return;
        //Проверим, что это файл, а не каталог
        if (!files[index].isDirectory()) return;
        //Если файл, то идём к нему
        selectList(files[index]);
    }

    /**
     * Метод для начитки списка по переданному файлу
     * @param file - файл каталога
     */
    private void selectList(File file) {
        //Обновим путь в шапке приложения
        setTitle(file.getAbsolutePath());
        //Получим массив файлов каталога и поменяем в приложении список файлов
        this.files = file.listFiles();
        //Отсортируем его по типу и алфавиту
        Arrays.sort(files, Application::compare);
        //Получим каталог выше для возможности перехода в него по "..."
        File preFile = file.getParentFile();
        //Ели существует, добавим его в наш массив нулевым
        if (preFile != null) {
            //Создадим новый массив + 1 от текущего
            File[] preFiles = new File[files.length+1];
            //Положим первый значением каталог выше
            preFiles[0] = preFile;
            //Скопируем каталог и сохраним его в приложении
            System.arraycopy(files, 0, preFiles,1, files.length);
            files = preFiles;
        }
        //Сохраним названия файлов в массив
        String[] names = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            names[i] = files[i].getName();
        }
        //Заменим название каталога выше на "..."
        if (preFile != null) names[0] = "...";
        //Выведем на экран список
        filesList.setListData(names);
    }

    /**
     * Метод сравнения списка по типу объекта (файл или каталог)
     */
    static int compare(File f1, File f2) {
        if(f1.isDirectory() && f2.isFile()) return -1;
        if (f1.isFile() && f2.isDirectory()) return 1;
        return f1.getName().compareTo(f2.getName());
    }

    /**
     * Метод вывода текста файла
     */
    private void printText() {
        //Найдем индекс выбранного файла
        int index = filesList.getSelectedIndex();
        //Проверим, что файл был выбран (не -1)
        if (index == -1) return;
        //Если был выбран каталог, то пропускаем
        if(files[index].isDirectory()) {
            fileText.setText("");
            return;
        }
        //Выводим текст файла в приложение
        StringBuilder sb = new StringBuilder();
        //BufferedReader быстрый, т.к. выводит информацию построчно. Идём через него
        try (BufferedReader br = new BufferedReader(new FileReader(files[index]))) {
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
            //Наполняем текст приложения из буфера
            fileText.setText(sb.toString());
            //Ставим курсор всегда в начало
            fileText.setCaretPosition(0);
        } catch (IOException e) {
            fileText.setText("Не был прочитан файл!" + e.getMessage());
        }
    }
}
