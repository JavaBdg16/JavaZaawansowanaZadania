package storage;

public class Product {

    private long id;
    private String name;
    private ProductCategory productCategory;
    private String description;

    public Product(long id, String name, ProductCategory productCategory, String description) {
        this.id = id;
        this.name = name;
        this.productCategory = productCategory;
        this.description = description;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productCategory=" + productCategory +
                ", description='" + description + '\'' +
                '}';
    }
}
