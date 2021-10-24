package translator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Translator {

    private final Map<String, String> dictionary;

    public Translator() {
        this.dictionary = new HashMap<>();
    }

    public void load(String dictionaryPath) {
        try (Reader reader = new FileReader(dictionaryPath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(":");
                dictionary.put(parts[1].toLowerCase(), parts[0].toLowerCase());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void printDictionary() {
        System.out.println(dictionary);
    }

    public String translate(String file) {
        try (Reader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            StringBuilder stringBuilder = new StringBuilder();
            boolean newLine = false;

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (newLine) {
                     stringBuilder.append("\n");
                }

                String[] parts = line.split("\\s+");

                boolean addSpace = false;

                for (String word : parts) {
                    if (addSpace) {
                         stringBuilder.append(" ");
                    }

                    String t = dictionary.getOrDefault(word.toLowerCase(), word);
                    stringBuilder.append(t);

                    addSpace = true;
                }

                newLine = true;
            }

            return stringBuilder.toString();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
