package pizza;

public class Cardinale extends Pizza {

    public Cardinale() {
        super("Cardinale");
    }

    @Override
    public double getCena() {
        return 18.00d;
    }
}
