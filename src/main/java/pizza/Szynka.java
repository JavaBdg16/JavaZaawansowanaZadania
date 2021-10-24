package pizza;

public class Szynka extends Dodatek {

    public static final double CENA = 1.99d;

    public Szynka(Pizza pizza) {
        super(pizza, "Szynka");
    }

    @Override
    public double getCena() {
        return getPizza().getCena() + CENA;
    }
}
