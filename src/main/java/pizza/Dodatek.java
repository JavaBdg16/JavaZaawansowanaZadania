package pizza;

public abstract class Dodatek extends Pizza {

    private final Pizza pizza;

    public Dodatek(Pizza pizza, String name) {
        super(pizza.getName() + ", " + name);
        this.pizza = pizza;
    }

    public Pizza getPizza() {
        return pizza;
    }
}
