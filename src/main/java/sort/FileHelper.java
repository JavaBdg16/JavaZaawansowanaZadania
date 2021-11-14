package sort;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileHelper {

    public static int[] read(String path) {

        int[] result;
        try (Reader reader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            result = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                result[i] = Integer.parseInt(parts[i]);
            }

            return result;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void write(int[] tab, String path) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path));
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            for (int i = 0; i < tab.length - 1; i++) {
                printWriter.write(tab[i] + " ");
            }
            printWriter.write(tab[tab.length - 1] + "");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
