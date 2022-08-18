package com.example.transaction.model.statics;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilesManager {
    public static List<String> readFromFile(String fileName) {
        BufferedReader br = null;
        List<String> lines = new ArrayList<>();
        File newFile = new File(fileName);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            return null;
        }
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
                return lines;
            } catch (IOException e) {
                return null;
            }
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            return null;
        }
    }

    public static int writeToFile(String path, String s) {
        File newFile = new File(path);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            return 1;
        }
        FileWriter fileWriter = null;
        try {
            FileWriter wr = new FileWriter(new File(path), true);
            wr.write(s + "\n");
            wr.close();
            return 0;
        } catch (IOException e) {
            return 1;
        }
    }
}
