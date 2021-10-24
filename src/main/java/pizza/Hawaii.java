package pizza;

public class Hawaii extends Pizza {

    public Hawaii() {
        super("Hawaii");
    }

    @Override
    public double getCena() {
        return 22.00d;
    }
}
