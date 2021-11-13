package wordlcup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WorldCup {

    public static void main(String[] args) {

        Map<Integer, String> winners = read("files/worldcup.txt");

//        Map<String, Integer> summary = new TreeMap<>();
//        winners.forEach((k, v) -> {
//            int i = summary.getOrDefault(v, 0);
//            // [Włochy, 2], [Urugwaj, 1]
//            summary.put(v, i + 1);
//        });

        Map<String, Long> summary =
                winners.values().stream().collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        System.out.println(winners);
        System.out.println(summary);

        String line;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Podaj rok");
            line = scanner.nextLine();

            if (line.equals("")) {
                System.out.println("Koniec");
                break;
            }

            try {
                System.out.println(showWinner(line, winners));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static String showWinner(String year, Map<Integer, String> winners) throws Exception {
        int i;

        try {
            i = Integer.parseInt(year);
        } catch (NumberFormatException ex) {
            throw new Exception("Podano niepoprawny rok: " + year);
        }

        String winner = winners.get(i);

        if (winner == null) {
            throw new Exception("W roku " + year + " nie było mistrzostw");
        }

        return winner;
    }

    private static Map<Integer, String> read(String file) {

        Map<Integer, String> result;

        try (Reader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] parts = line.split(":");
//                result.put(Integer.parseInt(parts[0]), parts[1]);
//            }

//            bufferedReader.lines().forEach(s -> {
//                String[] parts = s.split(":");
//                result.put(Integer.parseInt(parts[0]), parts[1]);
//            });

            // map: rok:kraj -> [rok, kraj]
            result = bufferedReader.lines()
                    .map(s -> s.split(":"))
                    .collect(Collectors.toMap(a -> Integer.parseInt(a[0]), a -> a[1])
            );

            return result;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
