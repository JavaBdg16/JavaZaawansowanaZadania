package translator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Translator translator = new Translator();
        translator.load("files/dictionary.txt");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz ścieżkę do pliku, który chcesz przetłumaczyć");
        String file = scanner.nextLine();

        String translated = translator.translate(file);
        System.out.println(translated);

        translator.printDictionary();

        System.out.println("Wpisz ścieżkę do pliku, do którego chcesz zapisać rezultat");
        file = scanner.nextLine();

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(file));
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            printWriter.print(translated);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
