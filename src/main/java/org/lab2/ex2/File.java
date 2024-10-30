package org.main;

public abstract class File {

    private String name;
    private int size;
    private FileFormat format;

    //конструктор
    public File(String name, int size, FileFormat format) {
        this.name = name;
        this.size = size;
        this.format = format;
    }

    //геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name==null || name.equals("")) throw new Exception("Введено некорректное имя файла!");
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) throws Exception {
        if(size<0) throw new Exception("Введен некорректный размер файла!");
        this.size = size;
    }

    public FileFormat getFormat() {
        return format;
    }

    public void setFormat(FileFormat format) throws Exception {
        if(format == null) throw new Exception("Введен некорретный формат файла!");
        this.format = format;
    }

    public void getDetails() {

    }

    @Override
    public String toString() {
        return this.getName() + "." + this.getFormat();
    }

    //отрисовка таблицы с данными по объектам
    public static void printAll(File[] files, int min, int max) {
        int countName = 0;
        int countSize = 0;

        //посчитаем наиболее количество символов в Name и Size
        for (int i = min; i <= max; i++) {
            if(countName < files[i].getName().length())
                countName = files[i].getName().length();
            if(countSize < String.valueOf(files[i].getSize()).length())
                countSize = String.valueOf(files[i].getSize()).length();
        }

        //отрисуем шапку таблицы
        //первая горизонтальная линия
        String longLine = "_";
        for (int i = 0; i < countName + countSize + 100; i++) {
            longLine = longLine + "_";
        }
        System.out.println(longLine);

        //заполняем шапку данными
            //пробелы перед и после File name
            String spaceFileName = "";
            for (int i = 0; i < (countName-9)/2; i++) {
                spaceFileName = spaceFileName + " ";
            }
            //если количество симовлов в имени нечётное, то нужно добавить пробел
            if((countName-9)%2==1) {
                spaceFileName = spaceFileName + " ";
                countName++;
            }
            //пробелы перед и после Size
            String spaceSize = "";
            for (int i = 0; i < (countSize-4)/2; i++) {
                spaceSize = spaceSize + " ";
            }
            System.out.println(spaceFileName + "File name" + spaceFileName + "|" + spaceSize + "Size" + spaceSize + "|" + spaceSize + "Details");

        //вторая горизонтальная линия
            //минусы на длину имени
            String _countName = "";
            for (int i = 0; i < countName; i++) {
                _countName = _countName + "-";
            }
            //минусы на длину размера
            String _countSize = "";
            for (int i = 0; i < countSize; i++) {
                _countSize = _countSize + "-";
            }
            System.out.println(_countName + "+" + _countSize + "+" + "----------");

        //заполняем таблицу данными
        for (int i = min; i <= max; i++) {
            //пробелы после имени
            String _spaceFileName = "";
            for (int j = 0; j < countName - files[i].getName().length(); j++) {
                _spaceFileName = _spaceFileName + " ";
            }

            //пробелы перед размером
            String _spaceSize = "";
            for (int j = 0; j < countSize - String.valueOf(files[i].getSize()).length(); j++) {
                _spaceSize = _spaceSize + " ";
            }
            System.out.print(files[i].getName() + _spaceFileName + "|" + _spaceSize + files[i].getSize() + "|");
            files[i].getDetails();
        }

        //закрывающая горизонтальная линия
        System.out.println(longLine);




    }
}
