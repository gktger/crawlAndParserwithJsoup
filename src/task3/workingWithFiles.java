package task3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class workingWithFiles {

    public static void writeFiles(String filePath,String text) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.newLine();
            writer.write(text);
            System.out.println("Dosya Yazıldı.");
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(Task3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readFiles(String filePath) {
        File file = new File(filePath);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Task3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getFileInfos(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Dosya adı: " + file.getName());
            System.out.println("Dosya yolu: " + file.getAbsolutePath());
            System.out.println("Dosya yazılabilir mi?: " + file.canWrite());
            System.out.println("Dosya okunabilir mi?: " + file.canRead());
            System.out.println("Dosya boyutu: " + file.length());
        }
    }

    public static void creatFiles(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("Dosya olusturuldu");
            } else {
                System.out.println("Dosya zaten mevcut");
            }
        } catch (IOException ex) {
            Logger.getLogger(Task3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
