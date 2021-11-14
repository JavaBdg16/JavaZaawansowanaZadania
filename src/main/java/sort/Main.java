package sort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Program sortuje tablicę liczb zapisaną w pliku");
        System.out.println("Podaj nazwę pliku");

        Scanner scanner = new Scanner(System.in);

        String filePath = scanner.nextLine();
        int[] tab = FileHelper.read(filePath);

        System.out.println("Wybierz algorytm sortujący:");
        System.out.println("  1. Sortowanie bąbelkowe");
        System.out.println("  2. Sortowanie przez wstawianie");
        System.out.println("  3. Sortowanie przez scalanie");
        System.out.println("  4. Sortowanie szybkie (QuickSort)");

        int option = Integer.parseInt(scanner.nextLine());

        SortContext context = new SortContext();
        switch (option) {
            case 1:
                context.setSortStrategy(new BubbleSortStrategy());
                break;
            case 2:
                context.setSortStrategy(new InsertSortStrategy());
                break;
            case 3:
                context.setSortStrategy(new MergeSortStrategy());
                break;
            case 4:
                context.setSortStrategy(new QuickSortStrategy());
                break;
            default:
                System.out.println("Wybrano niepoprawą opcję");
        }

        try {
            context.sort(tab);
        } catch (SortStrategyException e) {
            e.printStackTrace();
        }

        System.out.println("Podaj ścieżkę do pliku, do którego zostanie zapisany rezultat sortowania");
        String fileOutPath = scanner.nextLine();
        FileHelper.write(tab, fileOutPath);
    }
}
