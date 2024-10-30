package src.main.java.org.lab2.ex2;

public class Exercise {
    public static void startEx() throws Exception {


        File[] arrayFiles = new File[4];
        arrayFiles[0] = new Document("j110-lab2-hiers.docx", 23212, FileFormat.DOCX, 2);
        arrayFiles[1] = new Picture("spb-map.png", 1703527, FileFormat.IMAGE, 1024, 3072);
        arrayFiles[2] = new Multimedia("06-PrettyGirl.mp3", 7893454, FileFormat.AUDIO, 328, "Eric Clapton, Pretty Girl");
        arrayFiles[3] = new Multimedia("BackToTheFuture1.avi", 1470984192, FileFormat.VIDEO, new Picture("Pic", 100, FileFormat.IMAGE, 640, 352),6488, "Back to the future I, 1985");

        //Отрисуем таблицу
        //При вызове PrintAll() мы вызываем методы getDetails(), реализованные в каждой из субклассов
        File.printAll(arrayFiles, 0, 3);
    }
}