import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("C://Users//kater//Games"),
                new File("C://Users//kater//Games//src"),
                new File("C://Users//kater//Games//res"),
                new File("C://Users//kater//Games//savegames"),
                new File("C://Users//kater//Games//temp"),
                new File("C://Users//kater//Games//src//main"),
                new File("C://Users//kater//Games//src//test"),
                new File("C://Users//kater//Games//res//drawables"),
                new File("C://Users//kater//Games//res//vectors"),
                new File("C://Users//kater//Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("C://Users//kater//Games//src//main//Main.java"),
                new File("C://Users//kater//Games//src//main//Utils.java"),
                new File("C://Users//kater//Games//temp//temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir())
                System.out.println("Каталог " + folder + " создан\n");
            else System.out.println("Каталог " + folder + " не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile())
                    System.out.println("Файл" + file + " был создан\n");
                else System.out.println("Файл" + file + " не был создан\n");
            } catch (IOException ex) {
                System.out.println(ex.getMessage() + '\n');
            }
        });

        try (FileWriter writer = new FileWriter("C://Users//kater//Games//temp//temp.txt", false)) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }

        try (FileReader reader = new FileReader("C://Users//kater//Games//temp//temp.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}