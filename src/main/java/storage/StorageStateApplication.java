package storage;

import java.util.Map;
import java.util.Scanner;

public class StorageStateApplication {



    public static void main(String[] args) {

        StorageStateService service = new StorageStateService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Widaj w naszej aplikacji prezentującej stan Twojego magazynu");
        System.out.println("Co chcesz zrobić?");

        System.out.println("  1. Pokaż listę produktów");
        System.out.println("  2. Pokaż magazyn");
        System.out.println("  3. Dodaj produkt");
        System.out.println("  4. Dodaj stan magazynowy (TODO)");
        System.out.println("  5. Szukaj produkt");

        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                System.out.println("-----------------------------------------------------------------------------");
                System.out.printf("%10s %10s %20s %20s", "ID Produktu", "Nazwa", "Kategoria", "Opis");
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------");

                service.getProducts().forEach((k, v) -> {
                    System.out.printf("%10s %10s %20s %20s", k, v.getName(), v.getProductCategory(), v.getDescription());
                    System.out.println();
                });
                break;
            case 2:
                System.out.println("-----------------------------------------------------------------------------");
                System.out.printf("%10s %20s %20s %20s", "ID Stanu", "Nazwa produktu", "Ilość", "Cena");
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------");

                service.getStorage().forEach((k, v) -> {
                    Product product = service.getProducts().get(v.getProductId());
                    System.out.printf("%10s %20s %20s %20s", k, product.getName(), v.getCount(), v.getPrice());
                    System.out.println();
                });
                break;
            case 3:
                Product p = new Product();

                System.out.println("Podaj nazwę");
                p.setName(scanner.nextLine());

                System.out.println("Wybierz kategotię: 1 - pożywienie, 2 - środki czystości, 3 - narzędzia");
                p.setProductCategory(ProductCategory.fromInteger(scanner.nextInt()));
                scanner.nextLine();

                System.out.println("Podaj opis");
                String desc = scanner.nextLine();
                p.setDescription(desc);

                service.addProduct(p);
            case 4:
                System.out.println("TODO!!!!!!");
                break;
            case 5:
                System.out.println("Wprowadź szukany tekst");
                String searchText = scanner.nextLine();

                Map<Long, Product> filter = service.searchProduct(searchText);

                System.out.println("-----------------------------------------------------------------------------");
                System.out.printf("%10s %10s %20s %20s", "ID Produktu", "Nazwa", "Kategoria", "Opis");
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------");

                filter.forEach((k, v) -> {
                    System.out.printf("%10s %10s %20s %20s", k, v.getName(), v.getProductCategory(), v.getDescription());
                    System.out.println();
                });
            default:
        }
    }
}