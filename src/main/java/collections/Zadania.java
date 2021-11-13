package collections;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Zadania {

    public static void main(String[] args) {

        // zadanie1();
        // zadanie2();
//        zadanie3();
//        zadanie3a();
//        zadanie4();
//        zadanie5();
        zadanie6();
    }

    private static void zadanie1() {
        // Korzystając z właściwości kolekcji ArrayList,
        // napisz program, który do kolekcji tego typu dodaje 6 różnych liczb,
        // a następnie je sortuje. Po wykonaniu tej operacji należy usunąć
        // drugi element z listy, dodać nowy element do listy i wykonać ponowne sortowanie.

        ArrayList<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            integers.add(random.nextInt(10));
        }

        System.out.println(integers);

        Collections.sort(integers);

        System.out.println(integers);

        integers.remove(1);

        integers.add(random.nextInt(10));

        System.out.println(integers);

        Collections.sort(integers);

        System.out.println(integers);
    }

    private static void zadanie2() {

        //Korzystając z właściwości kolekcji ArrayList,
        // napisz program, który do kolekcji tego typu dodaje 6 różnych imion,
        // a następnie je sortuje.

        List<String> names = new ArrayList<>();

        names.add("Jan");
        names.add("Maria");
        names.add("Edyta");
        names.add("Zbigniew");
        names.add("Roman");
        names.add("Agnieszka");

        System.out.println(names);

        Collections.sort(names, (s1, s2) -> -1 * s1.compareTo(s2));

        System.out.println(names);

        Collections.sort(names);

        System.out.println(names);
    }

    private static void zadanie3() {

        // Napisz program, który korzystając z właściwości kolekcji ArrayList,
        // umieszcza w tej kolekcji liczby od 1 do 100, a następnie je wyświetla,
        // oraz wyświetla sumę wszyskich liczb. Do wyświetlenia użyj strumieni.

//        List<Integer> integers = new ArrayList<>();
//        for (int i = 1; i <= 100; i++) {
//            integers.add(i);
//        }

        List<Integer> integers =
                IntStream.rangeClosed(1, 100)
                        .boxed()
                        .collect(Collectors.toList());

        AtomicInteger sum1 = new AtomicInteger();
        integers.forEach(i -> {
            System.out.println(i);
            sum1.addAndGet(i);
        });

        System.out.println(sum1.intValue());

        int sum = integers.stream()
                .reduce(0, (i1, i2) -> i1 + i2);
        System.out.println(sum);

        Integer suma = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(suma);
    }

    private static void zadanie3a() {

        int bound = 1000000;
        int iterations = 10;
        List<Long> classics = new ArrayList<>();
        List<Long> streams = new ArrayList<>();

        System.out.println("CLASSIC:");

        for (int i = 0; i < iterations; i++) {

            final long startTime = System.currentTimeMillis();

            List<Integer> integers = new ArrayList<>();
            for (int j = 1; j <= bound; j++) {
                integers.add(j);
            }

            long t = System.currentTimeMillis() - startTime;
            classics.add(t);

            System.out.println(t + "ms");
        }

        System.out.println("STREAMS:");

        for (int i = 0; i < iterations; i++) {

            final long startTime = System.currentTimeMillis();

            List<Integer> integers =
                    IntStream.rangeClosed(1, bound)
                            .boxed()
                            .parallel()
                            .collect(Collectors.toList());

            long t = System.currentTimeMillis() - startTime;
            streams.add(t);

            System.out.println(t + "ms");

        }

        System.out.println("CLASSIC: " + calculateAverage(classics));
        System.out.println("STREAMS: " + calculateAverage(streams));
    }

    private static void zadanie4() {

        // Napisz program, który korzystając z właściwości kolekcji
        // LinkedList umieszcza w tej kolekcji litery alfabetu od A do Z,
        // a następnie wyświetla je w porządku od A do Z i od Z do A.

        List<Character> characters = new LinkedList<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            characters.add(c);
        }

        Collections.sort(characters, (character, t1) -> character.compareTo(t1));
        System.out.println(characters);

        // Collections.sort(characters, (character, t1) -> -1 * character.compareTo(t1));
        // System.out.println(characters);

        characters = characters.stream().
                sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(characters);
    }

    private static void zadanie5() {

        Set<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Black");
        colors.add("White");
        colors.add("Pink");
        colors.add("Red");
        colors.add("Yellow");

        System.out.println(colors.size());
        colors.stream().forEach(System.out::println);
        System.out.println("Wszystkie na literę B");
        colors.stream().filter(s -> s.startsWith("B")).forEach(System.out::println);
        colors.clear();
        System.out.println(colors.isEmpty() ? "Kolekcja jest pusta" : "Kolekcje nie jest pusta");
    }

    private static void zadanie6() {

        Set<String> treeSet1 = new TreeSet<>();
        treeSet1.add("Red");
        treeSet1.add("Green");
        treeSet1.add("Blue");
        treeSet1.add("Black");
        treeSet1.add("White");
        treeSet1.add("Pink");
        treeSet1.add("Red");
        treeSet1.add("Yellow");

        System.out.println(treeSet1.size());
        treeSet1.stream().forEach(System.out::println);

        Set<String> treeSet2 = new TreeSet<>((s, t1) -> -1 * s.compareTo(t1));
        treeSet2.addAll(treeSet1);

        System.out.println(treeSet2.size());
        treeSet2.stream().forEach(System.out::println);

        System.out.println("Wszystkie na literę B");
        treeSet2.stream().filter(s -> s.startsWith("B")).forEach(System.out::println);
        treeSet2.clear();
        System.out.println(treeSet2.isEmpty() ? "Kolekcja jest pusta" : "Kolekcje nie jest pusta");
    }

    private static double calculateAverage(List <Long> marks) {
        return marks.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }
}
