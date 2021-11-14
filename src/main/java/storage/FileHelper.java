package storage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileHelper {

    public static List<String> read(String path) {
        try (Reader reader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            return bufferedReader.lines().collect(Collectors.toList());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void writeProductDb(Map<Long, Product> products) {

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(StorageStateService.PRODUCT_DB));
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            products.forEach((k, v) -> {
                printWriter.write(k + ";" + v.getName() + ";" + v.getProductCategory() + ";" + v.getDescription() + "\n");
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
