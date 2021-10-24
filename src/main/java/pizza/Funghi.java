package pizza;

public class Funghi extends Pizza {

    public Funghi() {
        super("Funghi");
    }

    @Override
    public double getCena() {
        return 18.00d;
    }
}
