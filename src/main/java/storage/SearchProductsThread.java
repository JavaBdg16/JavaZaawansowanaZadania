package storage;

import java.util.Map;
import java.util.stream.Collectors;

public class SearchProductsThread extends Thread {

    private final Map<Long, Product> products;
    private final String searchText;
    private Map<Long, Product> result;

    public SearchProductsThread(Map<Long, Product> products, String searchText) {
        this.products = products;
        this.searchText = searchText;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = products.values().stream()
                .filter(pp -> pp.getName().contains(searchText))
                .collect(Collectors.toMap(a -> a.getId(), a -> a));
    }

    public Map<Long, Product> getResult() {
        return result;
    }
}
