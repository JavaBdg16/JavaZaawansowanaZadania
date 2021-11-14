package storage;

public class StorageState {
    private long id;
    private long productId;
    private int count;
    private double price;

    public StorageState(long id, long productId, int count, double price) {
        this.id = id;
        this.productId = productId;
        this.count = count;
        this.price = price;
    }

    public StorageState() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
