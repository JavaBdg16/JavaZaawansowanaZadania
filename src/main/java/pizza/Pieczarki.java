package pizza;

public class Pieczarki extends Dodatek {

    public static final double CENA = 1.99d;

    public Pieczarki(Pizza pizza) {
        super(pizza, "Pieczarki");
    }

    @Override
    public double getCena() {
        return getPizza().getCena() + CENA;
    }
}
