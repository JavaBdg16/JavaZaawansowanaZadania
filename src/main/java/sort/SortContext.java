package sort;

public class SortContext {

    private SortStrategy sortStrategy;

    public SortContext() {
    }

    public SortContext(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sort(int[] tab) throws SortStrategyException {
        if (sortStrategy == null) {
            throw new SortStrategyException();
        }

        Thread thread = new SortThread(sortStrategy, tab);
        thread.start();

        System.out.print("Sortuję ");

        while (thread.isAlive()) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }
}
