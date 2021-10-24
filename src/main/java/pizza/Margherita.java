package pizza;

public class Margherita extends Pizza {

    public Margherita() {
        super("Margherita");
    }

    @Override
    public double getCena() {
        return 16.00d;
    }
}
