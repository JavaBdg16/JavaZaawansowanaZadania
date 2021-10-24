package pizza;

public class Vegetariana extends Pizza {

    public Vegetariana() {
        super("Vegetariana");
    }

    @Override
    public double getCena() {
        return 26.00d;
    }
}
