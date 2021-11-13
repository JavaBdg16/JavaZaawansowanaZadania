package pizza;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Pizza margherita = new Margherita();
        Pizza funghi = new Funghi();
        Pizza vegetariana = new Vegetariana();
        Pizza cardinale = new Cardinale();
        Pizza hawaii = new Hawaii();

        System.out.println("Menu");
        System.out.println(margherita.getName() + " - " + margherita.getCena() + " zł");
        System.out.println(funghi.getName() + " - " + funghi.getCena() + " zł");
        System.out.println(vegetariana.getName() + " - " + vegetariana.getCena() + " zł");
        System.out.println(cardinale.getName() + " - " + cardinale.getCena() + " zł");
        System.out.println(hawaii.getName() + " - " + hawaii.getCena() + " zł");

        System.out.println();
        System.out.println("Dodatki");
        System.out.println("Cebula - " + Cebula.CENA);
        System.out.println("Pieczarki - " + Pieczarki.CENA);
        System.out.println("Szynka - " + Szynka.CENA);

        Scanner scanner = new Scanner(System.in);
        String rodzaj = scanner.nextLine();

        Pizza pizza = null;

        if ("Margherita".equals(rodzaj)) {
            pizza = margherita;
        } else if ("Funghi".equals(rodzaj)) {
            pizza = funghi;
        }
        // TODO

        System.out.println("Wybierz dodatki");
        String dodatek = scanner.nextLine();
        while (!dodatek.isEmpty()) {
            if (dodatek.equals("Cebula")) {
                pizza = new Cebula(pizza);
            } else if (dodatek.equals("Pieczarki")) {
                pizza = new Pieczarki(pizza);
            } else if (dodatek.equals("Szynka")) {
                pizza = new Szynka(pizza);
            }

            dodatek = scanner.nextLine();
        }

        System.out.println(pizza);
    }
}
