package pizza;

public abstract class Pizza {

    private final String name;

    public Pizza(String name) {
        this.name = name;
    }

    public abstract double getCena();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                "cena=" + getCena() +
                '}';
    }
}
