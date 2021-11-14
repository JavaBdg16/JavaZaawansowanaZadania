package storage;

import java.util.*;

public class StorageStateService {

    public static final String PRODUCT_DB = "files/product.csv";
    public static final String STORAGE_DB = "files/storage.csv";

    private Map<Long, Product> products;
    private Map<Long, StorageState> storage;

    public StorageStateService() {
        loadProducts();
        loadStorageState();
    }

    private void loadProducts() {
        products = new TreeMap<>();

        List<String> productsRaw = FileHelper.read(PRODUCT_DB);
        productsRaw.stream().forEach(s -> {
            String[] parts = s.split(";");

            Product product = new Product();
            product.setId(Long.parseLong(parts[0]));
            product.setName(parts[1]);
            product.setProductCategory(ProductCategory.valueOf(parts[2]));
            product.setDescription(parts[3]);

            products.put(product.getId(), product);
        });
    }

    private void loadStorageState() {
        storage = new TreeMap<>();

        List<String> storageStateRaw = FileHelper.read(STORAGE_DB);
        storageStateRaw.stream().forEach(s -> {
            String[] parts = s.split(";");

            StorageState storageState = new StorageState();
            storageState.setId(Long.parseLong(parts[0]));
            storageState.setProductId(Long.parseLong(parts[1]));
            storageState.setCount(Integer.parseInt(parts[2]));
            storageState.setPrice(Double.parseDouble(parts[3]));

            storage.put(storageState.getId(), storageState);
        });
    }

    public void addProduct(Product product) {
        System.out.println(product);

        Optional<Long> id = products.keySet().stream().max(Comparator.naturalOrder());
        if (id.isPresent()) {
            product.setId(id.get() + 1);
        } else {
            product.setId(1);
        }

        products.put(product.getId(), product);
        FileHelper.writeProductDb(products);
    }

    public Map<Long, Product> searchProduct(String searchText) {
        SearchProductsThread runnable = new SearchProductsThread(products, searchText);
        Thread thread = new Thread(runnable);
        System.out.print("Rozpoczynam szukanie produktów: " + searchText +  " ");

        thread.start();

        while (thread.isAlive()) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        return runnable.getResult();
    }

    public Map<Long, Product> getProducts() {
        return products;
    }

    public Map<Long, StorageState> getStorage() {
        return storage;
    }
}
