package pizza;

public class Cebula extends Dodatek {

    public static final double CENA = 1.89d;

    public Cebula(Pizza pizza) {
        super(pizza, "Cebula");
    }

    @Override
    public double getCena() {
        return getPizza().getCena() + CENA;
    }
}
